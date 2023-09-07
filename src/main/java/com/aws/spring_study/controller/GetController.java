package com.aws.spring_study.controller;

import com.aws.spring_study.dto.ParamsTestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

    @GetMapping("/get/params/1")
    public Object paramsTest1(String name, Integer age) { // Integer을 쓰면 null값을 받을 수 있다.
        // @RequestParam을 넣으면 필수 값이 된다.
        // 변수명과 파라미터명이 동일하면 @RequestParam 뒤에 ()안에 변수명을 선언안해줘도 된다.
        System.out.println(name);
        System.out.println(age);
        return null;


    }

    @GetMapping("/get/params/2")
    public Object paramsTest2(ParamsTestDto paramsTestDto) {
        System.out.println(paramsTestDto);
        return null;

    }

    @GetMapping("/get/{id}")
    public  Object pathVariable(@PathVariable("id") int id) {
        System.out.println(id);
        return null;
    }
}
