package com.gouxy.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.gouxy.sys.entity.SysUser;
import com.gouxy.sys.form.SysForm;

@Mapper
public interface SysUserDao {

	void addSysUser(SysForm sysUser);
	SysUser showSysUser();
	
}
