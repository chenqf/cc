package com.cc.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.user.dao.UserMapper;
import com.cc.user.dto.User;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public List<User> query(){
		return this.userMapper.query();
	}
	
	public void regist(User user){
		this.userMapper.regist(user);
	}
	
	public User login(User user){
		return this.userMapper.login(user);
	}
	
	public User getById(Long id){
		return this.userMapper.getById(id);
	}
	
	public User getByName(String name){
		return this.userMapper.getByName(name);
	}
}
