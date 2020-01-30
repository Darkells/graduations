package com.dark.graduations.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 获取openId类
 */
public class Openid {
    private static String appid = "wx09edb0c29c996863";
    private static String secret = "ad115b5dc41b59ba14e74ec639f9932b";
    public static String[] getopenid(String code) {
        String params = "appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        JSONObject jsonObject = JSON.parseObject(sr);
        //获取会话密钥（session_key）
        String session_key = jsonObject.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) jsonObject.get("openid");
        return new String[]{session_key,openid};
    }
}
