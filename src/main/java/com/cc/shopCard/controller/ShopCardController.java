package com.cc.shopCard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.base.BaseController;
import com.cc.shopCard.dto.ShopCard;
import com.cc.shopCard.service.ShopCardService;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;

@Controller
@RequestMapping("shopCard")
public class ShopCardController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(ShopCardController.class);
	
	@Autowired
	private ShopCardService shopCardService;
	
	@RequestMapping(value = "/queryByUserId", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject queryByUserId(@RequestParam(value = "userId") Long userId) throws Exception {
		
		return new JsonData(this.shopCardService.queryByUserId(userId));
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject add(
			@RequestParam(value = "userId") Long userId,
			@RequestParam(value = "dishId") Long dishId,
			@RequestParam(value = "diningId") Long diningId,
			@RequestParam(value = "num") Integer num) throws Exception {
		
		ShopCard shopCard = this.shopCardService.getByInfo(userId,dishId);
		if(shopCard == null){
			this.shopCardService.add(userId,dishId,diningId,num);
		}else{
			this.shopCardService.updateNum(shopCard.getId(), shopCard.getNum() + num);
		}	
		return new JsonSuccess();
	}
	
	@RequestMapping(value = "/updateNum", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject updateNum(
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "num") Integer num) throws Exception {
		if(num == 0){
			this.shopCardService.delete(id);
			
		}else{
			this.shopCardService.updateNum(id, num);
		}
		return new JsonSuccess();
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject delete(
			@RequestParam(value = "id") Long id) throws Exception {
		this.shopCardService.delete(id);
		return new JsonSuccess();
	}
	
	@RequestMapping(value = "/batchDelete", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject batchDelete(
			@RequestParam(value = "ids") String ids) throws Exception {
		this.shopCardService.batchDelete(ids);
		return new JsonSuccess();
	}
	
}






