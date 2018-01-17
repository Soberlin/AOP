package com.xfwlkjyxgs.sober.poa.net.okhttp;

import java.io.IOException;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2018/1/15.
 * 你能我就能****
 */
public interface MyCallBack<T> {
    /**
     * 网络请求失败的回调
     * @param msg
     * @param e
     */
    void onFail(String msg, IOException e);

    /**
     *  网络请求成功的回调
     * @param t
     */
    void onSucceed(T t);
}
