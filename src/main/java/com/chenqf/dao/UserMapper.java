package com.chenqf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chenqf.dto.UserDto;

/**
 * 
 * @ClassName MemberAddressMapper
 * @Description TODO
 * @author 
 * @date 2014-10-09 11:07:30
 */
public interface UserMapper {

	/**
	 * @Title: getById
	 * @Description: 根据主键查询User
	 * @param id
	 * @return: User
	 */
	public UserDto getById(@Param(value = "id") Long id);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<UserDto> queryUsers();

}