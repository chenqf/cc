package com.cc.demo.service;

import com.cc.demo.dto.UserDto;

import java.util.List;

/**
 * Created by Administrator on 2015/9/22.
 */
public interface UserService {
    List<UserDto> queryUsers();

    UserDto getUserById(long id);

    void transactionalTest(long id);
}
