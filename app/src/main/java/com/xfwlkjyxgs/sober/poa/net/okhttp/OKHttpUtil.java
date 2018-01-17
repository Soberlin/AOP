package com.xfwlkjyxgs.sober.poa.net.okhttp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.xfwlkjyxgs.sober.poa.utils.CommonUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2018/1/15.
 * 你能我就能****
 */
public class OKHttpUtil {

    private static final String TAG = "OKHttpUtil";

    /**
     * 单例模式，只允许当前工具类有一个实例
     */
    public static volatile OKHttpUtil newHttpUtil;

    /**
     * 创建OkHttp的客户管理对象，也只有一个实例
     */
    private OkHttpClient client;

    /**
     * 处理网络请求得到的数据
     */
    private static Handler handler;

    /**
     * 初始化
     */
    private OKHttpUtil() {
        this.client = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .cookieJar(new CookieManager())
                .build();
        handler = new Handler(Looper.getMainLooper());
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static OKHttpUtil getInstance() {
        if (newHttpUtil == null) {
            synchronized (OKHttpUtil.class) {
                if (newHttpUtil == null) {
                    newHttpUtil = new OKHttpUtil();
                }
            }
        }
        return newHttpUtil;
    }

    /**
     * 不解析的Get请求
     * @param url
     * @param myCallBack
     */
    public  void httpGet(String url, final MyCallBack myCallBack)
    {
        final Request request=new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        myCallBack.onFail("请求失败", e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final Message message = Message.obtain();
                message.obj = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (message.obj != null) {
                            myCallBack.onSucceed(message.obj);
                        }
                    }
                });
            }
        });
    }

    /**
     * 解析的get 请求
     *
     * @param url        接口
     * @param clazz      正常数据的解析类
     * @param errorClazz error错误信息的解析类
     * @param myCallBack 回调
     * @param <T>
     */
    public <T> void httpGsonGet(String url, final Class<T> clazz, final Class<T> errorClazz, final MyCallBack myCallBack) {
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        myCallBack.onFail("请求失败", e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                String json = response.body().string();
                Log.d(TAG, "onResponse: "+json);
                T t;
                try {
                    t = CommonUtil.parseResult(json, clazz);
                } catch (Exception e) {
                    t = CommonUtil.parseResult(json, errorClazz);
                }
                final Message message = Message.obtain();
                message.obj = t;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (message.obj != null) {
                            myCallBack.onSucceed(message.obj);
                        } else {
                            myCallBack.onSucceed("您请求的数据为空");
                        }
                    }
                });

            }
        });
    }

    /**
     * 解析的post请求
     *
     * @param url        接口
     * @param clazz      正常数据的解析类
     * @param errorClazz error错误信息的解析类
     * @param params       表单参数
     * @param myCallBack 回调
     * @param <T>
     */
    public <T> void httpGsonPost(String url, Map<String,String> params, final Class<T> clazz, final Class<T> errorClazz, final MyCallBack myCallBack) {

        RequestBody body;

        if (params==null) {
            params=new HashMap<>();
        }
        FormBody.Builder builder=new FormBody.Builder();

        //添加的参数进行遍历
        for (Map.Entry<String, String> map : params.entrySet()) {
            String key=map.getKey().toString();
            String value;
            //判断值是否是空的
            if (map.getValue() == null) {
                value = "";
            } else {
                value=map.getValue();
            }
            //把key和value添加到formbody中
            builder.add(key,value);
        }
        body=builder.build();


        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        myCallBack.onFail("请求失败", e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                T t;
                try {
                    t = CommonUtil.parseResult(json, clazz);
                } catch (Exception e) {
                    t = CommonUtil.parseResult(json, errorClazz);
                }
                final Message message = Message.obtain();
                message.obj = t;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (message.obj != null) {
                            myCallBack.onSucceed(message.obj);
                        } else {
                            myCallBack.onSucceed("您请求的数据为空");
                        }
                    }
                });
            }
        });
    }

    /**
     * 清空消息队列
     */
    public void claerHandlerMsg()
    {
        handler.removeCallbacksAndMessages(null);
    }


}
