package com.chenqf.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.chenqf.dao.UserDao;
import com.chenqf.dao.UserMapper;
import com.chenqf.dto.UserDto;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserMapper userMapper;
	
	public UserDto getUserById(Long id){
		return userMapper.getById(id);
	}
	
	public List<UserDto> queryUsers(){
		return userMapper.queryUsers();
	}
	
	public UserDto test1(String name,String sex,
			@RequestParam("age") int age){
		UserDto user = new UserDto();
		
		return user;
	}
}
