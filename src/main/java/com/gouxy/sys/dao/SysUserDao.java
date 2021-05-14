package com.gouxy.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.gouxy.sys.entity.SysUser;

@Mapper
public interface SysUserDao {

	SysUser showSysUser();
	
}
