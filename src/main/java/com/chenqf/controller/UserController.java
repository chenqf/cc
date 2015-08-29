package com.chenqf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chenqf.dto.UserDto;
import com.chenqf.service.UserService;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;

import BaseController.BaseController;

@Controller
@RequestMapping("demo")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject getUserById(@RequestParam(value = "id") Long id){

		return new JsonData(this.userService.getUserById(id));
	}
	
	@RequestMapping(value = "/queryUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<UserDto> queryUsers() throws Exception {
		
		return this.userService.queryUsers();
	}
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	@ResponseBody
	public UserDto test1(String name,String sex,
			@RequestParam(value = "age", defaultValue = "18") int age) {
		return this.userService.test1(name,sex,age);
	}
	
	@RequestMapping(value = "/test2/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public String test2(HttpServletRequest request,@PathVariable("userId") String userId) {
		return userId;
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView test3()throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");
		return mav;
	}
}






