package com.cc.dining.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.base.BaseController;
import com.cc.dining.service.DiningService;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;

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
	
}






