package com.cc.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.order.dao.OrderMapper;
import com.cc.order.dto.Order;


@Service
public class OrderService {
	
	@Autowired
	OrderMapper orderMapper;
	
	public List<Order> queryByUserId(Long userId){
		return this.orderMapper.queryByUserId(userId);
	}
}
