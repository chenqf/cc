package com.cc.dining.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.base.BaseController;
import com.cc.dining.dto.Dining;
import com.cc.dining.service.DiningService;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;

@Controller
@RequestMapping("dining")
public class DiningController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(DiningController.class);
	
	@Autowired
	private DiningService diningService;
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject queryUsers() throws Exception {
		
		return new JsonData(this.diningService.query());
	}
	
	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject getById(@RequestParam(value = "id") Long id) throws Exception {
		
		return new JsonData(this.diningService.getById(id));
	}
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public JsonObject add(@Validated Dining dining) throws Exception {
		this.diningService.add(dining);
		return new JsonSuccess();
	}
	
	@RequestMapping(value = "/edit")
	@ResponseBody
	public JsonObject edit(@Validated Dining dining) throws Exception {
		this.diningService.edit(dining);
		return new JsonSuccess();
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public JsonObject delete(@RequestParam(value = "id") Long id) throws Exception {
		this.diningService.delete(id);
		return new JsonSuccess();
	}
	
}






