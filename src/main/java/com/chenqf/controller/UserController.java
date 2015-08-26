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

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
	@ResponseBody
	public UserDto getUserById(Long id)throws Exception {
		
		return this.userService.getUserById(id);
	}
	
	@RequestMapping(value = "/queryUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<UserDto> getUserById()throws Exception {
		
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






