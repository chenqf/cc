package com.cc.shopCard.dao;

import java.util.List;

import com.cc.shopCard.dto.ShopCard;

public interface ShopCardMapper {
	
	List<ShopCard> queryByUserId(Long userId);
	
	void add (ShopCard shopCard);
	
	void updateNum(Long id,Integer num);
	
	ShopCard getById(Long id);
	
	ShopCard getByInfo(Long userId,Long dishId);
	
	void delete(Long id);
	
	void batchDelete(String ids);
}
