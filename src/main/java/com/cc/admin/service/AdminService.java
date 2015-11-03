package com.cc.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.admin.dao.AdminMapper;
import com.cc.admin.dto.Admin;

@Service
public class AdminService {
	@Autowired
	AdminMapper adminMapper;
	
	public Admin getByName(String username){
		return this.adminMapper.getByName(username);
	}
}
