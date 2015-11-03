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
	
	public Dish getById(Long id){
		return this.dishMapper.getById(id);
	}
	
	public void add(Dish dish){
		this.dishMapper.add(dish);
	}
	
	public void edit(Dish dish){
		this.dishMapper.edit(dish);
	}
	
	public void delete(Long id){
		this.dishMapper.delete(id);
	}
}
