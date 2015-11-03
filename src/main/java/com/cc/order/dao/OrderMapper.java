package com.cc.order.dao;

import java.util.List;

import com.cc.order.dto.Order;

public interface OrderMapper {
	
	public List<Order> queryByUserId(Long userId);
	
	public List<Order> queryByDiningId(Long diningId);
	
	public Long add(Order order);
	
	public void edit(Order order);
	
	public void addOrderDish(Order order);
}
