package com.aws.spring_study.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewsController{

    @GetMapping("/student/register")
    public String studentRegister() {
        return "student_register"; // ← html 파일명을 기입
    }
}
