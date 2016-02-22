package com.utils.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailUtil {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(MailBean mailBean){ 
		
		SimpleMailMessage mail = new SimpleMailMessage();
		try {
			mail.setTo(mailBean.getTo());// 接受者
			mail.setFrom(mailBean.getFrom());// 发送者
			mail.setSubject(mailBean.getSubject());// 主题
			mail.setText(mailBean.getText());// 邮件内容
			mailSender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
