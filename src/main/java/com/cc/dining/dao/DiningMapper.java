package com.cc.dining.dao;

import java.util.List;

import com.cc.dining.dto.Dining;

/**
 * 
 * @ClassName MemberAddressMapper
 * @Description TODO
 * @author 
 * @date 2014-10-09 11:07:30
 */
public interface DiningMapper {

	/**
	 * 查询所有用户
	 * @return
	 */
	List<Dining> query();
	
	Dining getByName(String username);
	
	Dining getById(Long id);
	
	void add(Dining dining);
	
	void edit(Dining dining);
	
	void delete(Long id);

}