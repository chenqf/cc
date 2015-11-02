package com.cc.user.dao;

import java.util.List;

import com.cc.user.dto.User;

public interface UserMapper {

	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> query();
	
	User getById(Long id);
	
	User getByName(String name);
	
	User login(User user);
	
	void regist(User user);
}
