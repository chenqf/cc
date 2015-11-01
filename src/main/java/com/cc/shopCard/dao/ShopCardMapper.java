package com.cc.shopCard.dao;

import java.util.List;

import com.cc.shopCard.dto.ShopCard;

public interface ShopCardMapper {
	
	List<ShopCard> queryByUserId(Long userId);
	
	ShopCard add (Long userId,Long dishId,Long diningId,Integer num);
	
	ShopCard updateNum(Long id,Integer num);
	
	ShopCard getById(Long id);
	
	ShopCard getByInfo(Long userId,Long dishId);
	
	void delete(Long id);
	
	void batchDelete(String ids);
}
