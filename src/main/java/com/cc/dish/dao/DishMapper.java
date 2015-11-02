package com.cc.dish.dao;

import java.util.List;

import com.cc.dish.dto.Dish;

public interface DishMapper {

	/**
	 * 查询所有用户
	 * @return
	 */
	List<Dish> query(Long diningId);
	
	Dish getById(Long id);
}
