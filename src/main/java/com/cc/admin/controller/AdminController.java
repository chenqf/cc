package com.cc.admin.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.admin.dto.Admin;
import com.cc.admin.service.AdminService;
import com.cc.base.BaseController;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.mail.MailBean;
import com.utils.mail.MailUtil;
import com.utils.token.CookieHandler;



@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {
	
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private AdminService adminService;
	@Autowired
	private MailUtil mailUtil;
	@Autowired
	private CookieHandler cookieHandler;
	

	@RequestMapping(value = "/login")
	@ResponseBody
	public JsonObject login(@Validated Admin admin,HttpServletRequest request,HttpServletResponse response) throws Exception {

		String name = admin.getUsername();
		String password = admin.getPassword();
		
		adminService.test(name);
		
		cookieHandler.addCookies(response, "nihao", "chenqf", 7,true);
		
		return new JsonData(admin);
		// throw new Exception("sdfsdfsdf");
	}
	
	@RequestMapping(value = "/mail")
	@ResponseBody
	public JsonObject mail() throws Exception {

		MailBean bean = new MailBean();
		bean.setTo("546710115@qq.com");
		bean.setFrom("chenqifeng@51tiangou.com");
		bean.setSubject("subject");
		bean.setText("text");
		mailUtil.sendMail(bean);
		
		return new JsonData();
	}
	
}