package com.youlu.step;

import com.google.gson.Gson;
import com.youlu.model.userLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

public class QBStepDefinitions {
    userLogin userLogin = new userLogin();
    String result ;
    @Given("假装这个地方有参数")
    public void before() {
        Map<String,Object> params = new HashMap<>();
        params.put("cid","c93xvjvd9bw0n66ecerb802");
        params.put("api","uc/user/loginway");
        userLogin.setCtype("ADMIN.WEB");
        userLogin.setMap(params);

    }

    @When("执行测试")
    public void doUrl() throws IOException {
        String url = "http://umsatest.niceloo.com/api/";
        Gson gson = new Gson();
        JSONArray obj = JSONArray.fromObject(userLogin.getMap());
        String value = gson.toJson(obj);
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("apis",value));
        params.add(new BasicNameValuePair("ctype",userLogin.getCtype()));
  /*      Content content = Request.post("http://umsatest.niceloo.com/api/")
                .bodyForm(params).execute().returnContent();
        System.out.print(content);*/
        // 返回来是一个字符串，但是 是数组格式的
        String str = Request.post(url).bodyForm(params)
                .execute().returnContent().asString();
        Map<String,String> content = new HashMap<>();
        //把返回的字符串数组去掉[]，转化为map对象
        content = gson.fromJson(StringUtils.strip(str,"[]"),content.getClass());
        result = content.get("result");
    }

    @Then("返回状态码{string}={string}")
    public void reCode(String arg0, String arg1) {
        assert result.equals(arg1);
    }
}
