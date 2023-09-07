package com.aws.spring_study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterUserReqDto {
    private  String username;
    private  String name;
    private  String phone;
}
