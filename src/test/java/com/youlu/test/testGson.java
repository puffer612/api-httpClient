package com.youlu.test;

import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import com.youlu.util.RedisUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class testGson {
    @Test
    public void test1(){
       Gson gson = new Gson();
        Map<String,Object> map = new HashMap<>();
     /*    Map<String,Object> map1 = new HashMap<>();
        map1.put("scene","bbbb");
        map.put("cid","1111111");
        map.put("api","22222222");
        map.put("params",gson.toJson(map1));*/
   String str =  "[{\"api\":\"sc/captcha/captcha\",\"result\":\"000000\",\"msg\":\"\",\"data\":{\"captchaToken\":\"1DCB1DD5AC594660A6DEEDDDFF0A7B7B\",\"captchaValue\":\"3860\"},\"gid\":\"G2020122114214401000003\",\"seqno\":\"2020122114214401000003\",\"cid\":\"c47igvr25cgwvd4kxt2nb0d\",\"timestamp\":1608531704641}]]";

   Map<String,Object> a = JsonPath.parse(StringUtils.strip(str,"[]")).read("$.data",Map.class);
   String b = a.get("captchaToken").toString();
   boolean flag = RedisUtils.addValue("captchaToken",b);
   System.out.println(flag);
//        System.out.println(a.get("captchaToken"));
      /*  System.out.println(map);
        JSONArray obj = JSONArray.fromObject(map);
        System.out.println(obj);*/
    }
}
