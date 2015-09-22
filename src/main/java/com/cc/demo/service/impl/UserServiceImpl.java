package com.cc.demo.service.impl;
import org.springframework.stereotype.Service;
import com.cc.demo.dao.UserMapper;
import com.cc.demo.dto.UserDto;
import com.cc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2015/9/22.
 */
@Service
@Transactional
public class UserServiceImpl  implements UserService{
    @Autowired
    private UserMapper userMapper;

    public List<UserDto> queryUsers(){
        return userMapper.queryUsers();
    }

    public UserDto getUserById(long id){

        return userMapper.getById(id);
    }

    public void transactionalTest(long id) {
        userMapper.edit(id);
        userMapper.add();

    }
}
