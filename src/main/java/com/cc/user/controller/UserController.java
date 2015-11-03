package com.cc.user.controller;

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
import com.cc.user.dto.User;
import com.cc.user.service.UserService;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject query() throws Exception {
		
		return new JsonData(this.userService.query());
	}
	
	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject getById(@RequestParam(value = "id") Long id) throws Exception {
		
		return new JsonData(this.userService.getById(id));
	}
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public JsonObject login(@Validated User user) throws Exception {
		String name = user.getUsername();
		String password = user.getPassword();
		User u = this.userService.getByName(name);
		if(u != null && u.getPassword().equals(password)){
			return new JsonData(u);
		}else{
			throw new Exception("用户信息有误，请重试");
		}
	}
	
	@RequestMapping(value = "/regist")
	@ResponseBody
	public JsonObject regist(@Validated User user) throws Exception {
		String username = user.getUsername();
		User u = this.userService.getByName(username);
		if(u != null){
			throw new Exception("用户名已存在");
		}
		this.userService.regist(user);
		return new JsonData(user);
	}
	
	@RequestMapping(value = "/edit")
	@ResponseBody
	public JsonObject edit(@Validated User user) throws Exception {
		
		this.userService.edit(user);
		return new JsonData(user);
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public JsonObject delete(@RequestParam(value = "id") Long id) throws Exception {
		
		this.userService.delete(id);
		return new JsonSuccess();
	}
	
}