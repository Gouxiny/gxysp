package com.gouxy.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gouxy.sys.dao.SysUserDao;
import com.gouxy.sys.entity.SysUser;

@Service
public class SysUserService{
	
	@Autowired
	private SysUserDao sysUserDao;

	
	public SysUser showSysUser() {
		// TODO Auto-generated method stub
		return sysUserDao.showSysUser();
	}

}
