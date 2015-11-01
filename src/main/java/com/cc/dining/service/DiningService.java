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
}
