package com.cc.dish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.dish.dao.DishMapper;
import com.cc.dish.dto.Dish;

@Service
public class DishService {

	@Autowired
	private DishMapper dishMapper;
	
	public List<Dish> query(Long diningId){
		return this.dishMapper.query(diningId);
	}
}
