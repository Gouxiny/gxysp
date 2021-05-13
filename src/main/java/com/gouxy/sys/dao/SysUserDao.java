package com.gouxy.sys.dao;

import org.springframework.stereotype.Component;

import com.gouxy.sys.entity.SysUser;

@Component
public interface SysUserDao {

	SysUser showSysUser();
	
}
