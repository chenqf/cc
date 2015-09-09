package com.cc.demo.controller;

import java.util.List;

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
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/queryUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<UserDto> queryUsers() throws Exception {
		
		return this.userService.queryUsers();
	}
	
	
	
}






