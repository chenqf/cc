package com.cc.demo.controller;

import com.cc.base.BaseController;
import com.cc.demo.dto.UserDto;
import com.cc.demo.service.UserService;
import com.cc.demo.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
		return this.userService.queryUsers();
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public void test(@RequestParam(value = "id") Long id) throws Exception {

		this.userService.transactionalTest(id);
	}
	
	
	
}






