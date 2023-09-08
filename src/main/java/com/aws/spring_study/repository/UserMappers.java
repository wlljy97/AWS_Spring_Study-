package com.aws.spring_study.repository;

import com.aws.spring_study.dto.ModifyUserReqDto;
import com.aws.spring_study.dto.RegisterUserReqDto;
import com.aws.spring_study.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMappers {
    public Integer saveUser(RegisterUserReqDto registerUserReqDto); // 추상메소드
    // interface는 구현을 해야하는데 이 구현을 xml에서 한다
    // 매개변수 parameter
    public List<User> getUserListAll();
    public Integer updateUser(ModifyUserReqDto modifyUserReqDto);
    public Integer deleteUser(int userId);
}
