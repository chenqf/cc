package com.cc.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.base.BaseController;
import com.chenqf.dto.UserDto;
import com.chenqf.service.UserService;

@Controller
@RequestMapping("demo")
public class DemoController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/queryUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<UserDto> queryUsers() throws Exception {
		
		logger.info("测试 log4j info");
		logger.debug("测试 log4j debug");
		System.getProperty("catalina.home");
		return this.userService.queryUsers();
	}
	
	
	
}






