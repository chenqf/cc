package com.cc.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cc.order.dao.OrderMapper;
import com.cc.order.dto.Order;
import com.cc.order.enums.OrderState;
import com.cc.shopCard.dao.ShopCardMapper;
import com.cc.shopCard.dto.ShopCard;


@Service
public class OrderService {
	
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	ShopCardMapper shopCardMapper;
	
	public List<Order> queryByUserId(Long userId){
		return this.orderMapper.queryByUserId(userId);
	}
	
	@Transactional
	public Order add(Long userId,String ids){
		Order order = new Order();
		order.setFkUserId(userId);
		order.setState(OrderState.not.toString());
		String[] strs = ids.split(",");
		this.orderMapper.add(order);

		for(int i = 0; i<strs.length; i++){
			ShopCard shopCard = this.shopCardMapper.getById(Long.valueOf(strs[i]));
			order.setFkOrderId(order.getId());
			order.setFkDishId(shopCard.getFkDishId());
			order.setNum(shopCard.getNum());
			this.orderMapper.addOrderDish(order);
			this.shopCardMapper.delete(Long.valueOf(strs[i]));
		}
		
		
		return order;
	}
}