package com.aws.spring_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// @RestController 데이터만 반환 해줌, '@Controller + @ResponseBody' 되있는것
// @Controller을 쓰면 @ResponseBody을 무조건 같이 써야 한다.
@RestController
public class ReqStudyController {


    @GetMapping("/test/get")
    public Object get() { //메소드 명은 마음대로
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("name", "김준일");
        dataMap.put("email", "aaa@gmail.com");
        return dataMap;
    }

    @PostMapping("/test/post")
    public Object post() {
        return "POST";
    }

    @PutMapping("/test/put")
    public Object put() {
        return "PUT";
    }

    @DeleteMapping("/test/delete")
    public  Object delete() {
        return "DELETE";
    }
}
