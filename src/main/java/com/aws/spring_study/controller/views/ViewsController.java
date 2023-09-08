package com.aws.spring_study.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewsController{

    // 'body' 라는 것은 데이터라고 생각하면 편함
    @ResponseBody // 데이터를 바로 응답 ,  @ResponseBody 없어야지만 return이 일어난다.
    @GetMapping("/student/register")
    public String studentRegister(Model model) {
        model.addAttribute("title", "학생 등록");
        return "student_register"; // ← html 파일명을 기입
    }
}
