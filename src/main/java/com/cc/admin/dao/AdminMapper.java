package com.cc.admin.dao;

import com.cc.admin.dto.Admin;

public interface AdminMapper {
	Admin getByName(String username);
}
