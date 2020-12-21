package com.youlu.test;

import com.google.gson.Gson;
import com.youlu.model.userLogin;
import net.sf.json.JSONArray;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testHttpClientFluent {
    @Test
    public void test1() throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        userLogin userLogin = new userLogin();
        Map<String,Object> params = new HashMap<>();
        params.put("cid","c93xvjvd9bw0n66ecerb802");
        params.put("api","uc/user/loginway");
        userLogin.setCtype("ADMIN.WEB");
        userLogin.setMap(params);


        Gson gson = new Gson();
        JSONArray obj = JSONArray.fromObject(userLogin.getMap());
        String value = gson.toJson(obj);
        List<NameValuePair> param = new ArrayList<>();
        param.add(new BasicNameValuePair("apis",value));
        param.add(new BasicNameValuePair("ctype",userLogin.getCtype()));

        System.out.println(param);
        HttpPost post = new HttpPost("http://umsatest.niceloo.com/api/");
        post.setEntity(new UrlEncodedFormEntity(param,"utf-8"));
        post.setHeader("Content-Type","application/json;charset=UTF-8");
        CloseableHttpResponse response = httpClient.execute(post);
        HttpEntity entity = response.getEntity();
        System.out.println(EntityUtils.toString(entity));
        System.out.println(response.getStatusLine());

    }
}
