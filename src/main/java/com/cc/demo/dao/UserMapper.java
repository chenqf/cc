package com.cc.demo.dao;

import com.cc.demo.dto.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
	 * @return: UserService
	 */
	UserDto getById(@Param(value = "id") Long id);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	List<UserDto> queryUsers();

	void edit(@Param(value = "id") Long id);

	void add();

}