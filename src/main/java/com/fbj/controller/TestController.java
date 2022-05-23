package com.fbj.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.fbj.pojo.Answer;
import com.fbj.service.impl.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/code",produces = "application/json;charset=UTF-8")
public class  TestController {

    TestService service;
    @Autowired
    public void setService(TestService service) {
        this.service = service;
    }
    @RequestMapping(value = "/run")

    public String run(@RequestBody JSONObject json){


        Answer answer=service.run(json.getString("code"));
        System.out.println(answer.getReason());
        if(answer==null)
            return "{\"error\":\"IO错误\"}";
        else
            System.out.println(JSONObject.toJSONString(answer));
        System.out.println(answer);
           // return JSONObject.toJSONString(answer);

        return JSON.toJSONString(answer);
    }



}
