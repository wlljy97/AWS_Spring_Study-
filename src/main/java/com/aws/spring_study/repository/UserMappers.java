package com.aws.spring_study.repository;

import com.aws.spring_study.dto.RegisterUserReqDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMappers {
    public Integer saveUser(RegisterUserReqDto registerUserReqDto); // 추상메소드
    // interface는 구현을 해야하는데 이 구현을 xml에서 한다
    // 매개변수 parameter
}
