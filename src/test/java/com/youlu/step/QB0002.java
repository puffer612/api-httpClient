package com.youlu.step;

import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import com.youlu.util.Redis;
import com.youlu.util.RedisUtils;
import com.youlu.util.RequestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.core5.http.NameValuePair;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QB0002 {
    Map<String,Object> param_request = new HashMap<>();
    String result;
    @Given("当我们的cid是{string}")
    public void 当我们的cid是(String cid) {
        param_request.put("cid",cid);
    }

    @And("我们的api是{string}")
    public void 我们的api是(String api) {
        param_request.put("api",api);
    }

    @And("我们的参数是scene{string}")
    public void 我们的参数是paramsSceneUc_login(String scene) {
        Map<String,Object> param_scene = new HashMap<>();
        param_scene.put("scene",scene);
        param_request.put("params",param_scene);
    }

    @When("we go the {string} method")
    public void weGoTheMethod(String method) throws IOException {
        String ctype = "ADMIN.WEB";
        List<NameValuePair> params = RequestUtils.getParamsWithOutToken(param_request,ctype);
        if(params!=null){
            Map<String,String> content = RequestUtils.getContent(params,method);
            System.out.println(content);
            if(content.get("result").equals("000000")){
                Map<String,Object> map = JsonPath.parse(content).read("$.data",Map.class);
                boolean flag = RedisUtils.addValue("captchaToken",map.get("captchaToken").toString());
                boolean flags = RedisUtils.addValue("captchaValue",map.get("captchaValue").toString());
                if(flag && flags){
                    System.out.println("数据添加redis成功");
                }

            /*    Map<String,Object> map = new HashMap<>();
                Gson gson = new Gson();
                String data = content.get("data");
                System.out.println(data);
                map = gson.fromJson(content.get("data"),map.getClass());
                boolean flag = RedisUtils.addValue("captchaToken",map.get("captchaToken").toString());
                boolean flags = RedisUtils.addValue("captchaValue",map.get("captchaValue").toString());
                if(flag && flags){
                    System.out.println("数据添加成功");
                }*/
            }

            result=content.get("result");
        }

    }

    @Then("we assert the result={string}")
    public void weAssertTheResult(String arg0) {
        assert result.equals(arg0);
    }
}
