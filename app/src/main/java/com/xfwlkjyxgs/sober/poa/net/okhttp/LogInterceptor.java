package com.xfwlkjyxgs.sober.poa.net.okhttp;

import android.util.Log;



import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2018/1/15.
 * 你能我就能****
 */
public class LogInterceptor implements Interceptor {

    private static final String TAG = "LogInterceptor";
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request=chain.request();
        long startTime=System.currentTimeMillis();
        Response response=chain.proceed(chain.request());
        long endTime=System.currentTimeMillis();
        long duration=endTime=startTime;
        MediaType mediaType=response.body().contentType();
        String content=response.body().string();
        Log.d(TAG, "\n");
        Log.d(TAG, "intercept: ---------------Start---------------");
        Log.d(TAG, "intercept: "+request.toString());
        String method=request.method();
        if ("POST".equals(method)) {
            StringBuffer stringBuffer=new StringBuffer();
            if (request.body() instanceof FormBody) {
                FormBody formBody= (FormBody) request.body();
                Log.d(TAG, "-----------size "+formBody.size());
                for (int i = 0; i < formBody.size(); i++) {
                    stringBuffer.append(formBody.encodedName(i)+"="+formBody.encodedValue(i)+"&");
                    Log.d(TAG, i+"intercept: "+formBody.encodedName(i)+"="+formBody.encodedValue(i)+"&");
                }
                stringBuffer.delete(stringBuffer.length()-1,stringBuffer.length());
                Log.d(TAG, "intercept: "+stringBuffer.toString());
                
            }
        }
        Log.d(TAG, "Response: "+content);
        Log.d(TAG,"----------End:"+duration+"毫秒----------");
        
        return response.newBuilder().body(ResponseBody.create(mediaType,content)).build();
    }
}
