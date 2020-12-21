package com.youlu.util;

import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestUtils {

    /*
    * 获取参数
    * 因为接口都是apis 接口参数
    * ctype 传递方式
    * Token 用户信息
    * */
    public static List<NameValuePair> getParamsWithToken(Map<String,Object> param,String ctype,String token){
        Gson gson = new Gson();
        List<NameValuePair> params = new ArrayList<>();
        JSONArray obj = JSONArray.fromObject(gson.toJson(param));
        params.add(new BasicNameValuePair("apis",gson.toJson(obj)));
        params.add(new BasicNameValuePair("ctype",ctype));
        params.add(new BasicNameValuePair("TOKEN",token));
        return params;
    }

/*
* 登录前的验证
* apis 接口参数
* ctype 传递方式 一般都是ADMIN.WEB
* */

    public static List<NameValuePair> getParamsWithOutToken(Map<String,Object> param,String ctype){
        Gson gson = new Gson();
        List<NameValuePair> params = new ArrayList<>();
        JSONArray obj = JSONArray.fromObject(param);
        params.add(new BasicNameValuePair("apis",gson.toJson(obj)));
        params.add(new BasicNameValuePair("ctype",ctype));
        return params;
    }


    /*
    * 获取返回信息
    * param 是参数
    * method 请求方式，get的请求方式暂时没有遇到，先放着
    * url,这个是全局的，我先写死，如果切换环境再配置，记录下来
    * */
    public static Map<String,String> getContent(List<NameValuePair> param,String method) throws IOException {
        String url = "http://umsatest.niceloo.com/api/";
        Gson gson = new Gson();
        Map<String,String> content = new HashMap<>();
        String str = "";
        if(!url.equals("") && url != ""){
            if(method.equals("get") ){
                str = Request.get(url)
                        .execute().returnContent().asString();
            }else if(method.equals("post") ){
                str = Request.post(url)
                        .bodyForm(param).execute().returnContent().asString();
            }
            System.out.println(str);
//            content = JsonPath.parse(StringUtils.strip(str,"[]")).read("$.result",Map.class);
            content = gson.fromJson(StringUtils.strip(str,"[]"),content.getClass());
        }else {
            content = null;
        }
        return content;
    }
}
