package com.youlu.step;

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

public class QB0003 {
    Map<String,Object> requset_param = new HashMap<>();
    String result;
    @Given("当我们的cidS是{string}")
    public void 当我们的cids是(String arg0) {
        requset_param.put("cid",arg0);
    }

    @And("我们的apiS是{string}")
    public void 我们的apis是(String arg0) {
        requset_param.put("api",arg0);
    }

    @And("我们的参数是scene")
    public void 我们的参数是scene() {
        Map<String,Object> param_login = new HashMap<>();
        Map<String,Object> param_captcha = new HashMap<>();
        Jedis jedis = RedisUtils.getJedis();
        param_captcha.put("captchaToken",jedis.get("captchaToken"));
        param_captcha.put("captchaValue",jedis.get("captchaValue"));
        param_login.put("userLoginname","YL037755");
        param_login.put("userLoginpwd","840428wtWT");
        param_login.put("userMobile","");
        param_login.put("userEmail","");
        param_login.put("verify","");
        param_login.put("captcha",param_captcha);
        requset_param.put("params",param_login);

    }


    @When("we go use the {string} method")
    public void weGoUseTheMethod(String method) throws IOException {
        String ctype = "ADMIN.WEB";
        List<NameValuePair> params = RequestUtils.getParamsWithOutToken(requset_param,ctype);
        if(params!=null){
            Map<String,String> content = RequestUtils.getContent(params,method);
            System.out.println(content);
            result=content.get("result");
        }
    }

    @Then("we assert the login result={string}")
    public void weAssertTheLoginResult(String arg0) {
        assert result.equals(arg0);
    }
}
