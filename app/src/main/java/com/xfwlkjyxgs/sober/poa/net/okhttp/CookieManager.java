package com.xfwlkjyxgs.sober.poa.net.okhttp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2018/1/15.
 * 你能我就能****
 */
public class CookieManager implements CookieJar {
    private Map<String, List<Cookie>> cookJars = new HashMap<>();

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        cookJars.put(url.host(), cookies);
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        return cookJars.get(url.host()) == null ? new ArrayList<Cookie>() : cookJars.get(url.host());
    }
}
