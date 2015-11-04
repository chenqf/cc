package com.cc.dining.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.dining.dao.DiningMapper;
import com.cc.dining.dto.Dining;

@Service
public class DiningService {
	
	@Autowired
	private DiningMapper diningMapper;
	
	public List<Dining> query(){
		return this.diningMapper.query();
	};
	
	public Dining getById(Long id){
		return this.diningMapper.getById(id);
	};
	
	public void edit(Dining dining){
		this.diningMapper.edit(dining);
	}
	
	public void add(Dining dining){
		this.diningMapper.add(dining);
	}
	
	public void delete(Long id){
		this.diningMapper.delete(id);
	}
	
	public Dining getByName(String username){
		return this.diningMapper.getByName(username);
	}
}
