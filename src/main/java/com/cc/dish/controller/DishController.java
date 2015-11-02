package com.cc.dish.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.base.BaseController;
import com.cc.dish.service.DishService;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;

@Controller
@RequestMapping("dish")
public class DishController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(DishController.class);
	
	@Autowired
	private DishService dishService;
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject queryUsers(@RequestParam(value = "diningId") Long diningId) throws Exception {
		
		return new JsonData(this.dishService.query(diningId));
	}
	
	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject getById(@RequestParam(value = "id") Long id) throws Exception {
		
		return new JsonData(this.dishService.getById(id));
	}
	
}






