package com.cc.order.dao;

import java.util.List;

import com.cc.order.dto.Order;

public interface OrderMapper {
	
	List<Order> queryByUserId(Long userId);
	
	Order add(Order order);
}
