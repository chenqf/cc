package com.cc.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void test(String username){
		System.out.println(username + "   : service test");
	}
	
	
	public void sendMail(String to,String from ,String subject,String text){ 
		SimpleMailMessage mail = new SimpleMailMessage();
		try {
			mail.setTo(to);// 接受者
			mail.setFrom(from);// 发送者
			mail.setSubject(subject);// 主题
			mail.setText(text);// 邮件内容
			mailSender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}