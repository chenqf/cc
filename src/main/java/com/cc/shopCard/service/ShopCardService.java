package com.cc.shopCard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.shopCard.dao.ShopCardMapper;
import com.cc.shopCard.dto.ShopCard;

@Service
public class ShopCardService {

	@Autowired
	ShopCardMapper shopCardMapper;
	
	public List<ShopCard> queryByUserId(Long userId){
		return this.shopCardMapper.queryByUserId(userId);
	};
	
	public ShopCard add(Long userId,Long dishId,Long diningId,Integer num){
		return this.shopCardMapper.add(userId,dishId,diningId,num);
	};
	
	public ShopCard updateNum(Long id,Integer num){
		return this.shopCardMapper.updateNum(id,num);
	};
	
	public ShopCard getById(Long id){
		return this.shopCardMapper.getById(id);
	}
	
	public ShopCard getByInfo(Long userId,Long dishId){
		return this.shopCardMapper.getByInfo(userId,dishId);
	};
	
	public void delete(Long id){
		this.shopCardMapper.delete(id);
	};
	
	public void batchDelete(String ids){
		this.shopCardMapper.batchDelete(ids);
	};
}
