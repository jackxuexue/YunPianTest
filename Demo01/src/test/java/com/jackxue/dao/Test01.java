package com.jackxue.dao;

import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;
import com.yunpian.sdk.model.Template;
import org.junit.Test;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

public class Test01 {
    @Test
    public void testYunpian(){
        //05bf77fcadcec4e3c555d2f07c414b3b
        String key = "05bf77fcadcec4e3c555d2f07c414b3b";
        YunpianClient clnt = new YunpianClient(key).init();

//发送短信API
//        Map<String, String> param = clnt.newParam(2);
//        param.put(YunpianClient.MOBILE, "13750050499");
//        param.put(YunpianClient.TEXT, "\t\n" + "【深圳佳力拓科技有限公司】您的验证码是123456");
//        Result<SmsSingleSend> r = clnt.sms().single_send(param);
//        获取摸板
        Map<String, String> param = clnt.newParam(1);
        // param.put(tpl_id, "1");
        Result<List<Template>> r = clnt.tpl().get(param);
        System.out.println(r);
//获取返回结果，返回码:r.getCode(),返回码描述:r.getMsg(),API结果:r.getData(),其他说明:r.getDetail(),调用异常:r.getThrowable()

//账户:clnt.user().* 签名:clnt.sign().* 模版:clnt.tpl().* 短信:clnt.sms().* 语音:clnt.voice().* 流量:clnt.flow().* 隐私通话:clnt.call().*

//释放clnt
        clnt.close();
    }
}
