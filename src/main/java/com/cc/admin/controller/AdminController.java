package com.cc.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.admin.dto.Admin;
import com.cc.admin.service.AdminService;
import com.cc.base.BaseController;
import com.cc.user.dto.User;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;

@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public JsonObject login(@Validated Admin admin) throws Exception {
		String name = admin.getUsername();
		String password = admin.getPassword();
		Admin a = this.adminService.getByName(name);
		if(a != null && a.getPassword().equals(password)){
			return new JsonData(a);
		}else{
			throw new Exception("管理员信息有误，请重试");
		}
	}
	
}