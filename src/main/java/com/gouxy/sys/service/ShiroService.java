package com.gouxy.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gouxy.sys.entity.SysUser;
import com.gouxy.sys.entity.SysUserToken;

@Service
public class ShiroService {

	

	public SysUserToken queryByToken(String token) {
		// TODO Auto-generated method stub
//		return appUserDao.queryByToken(token);
		return null;
	}

	public SysUser queryUser(String userId) {
		// TODO Auto-generated method stub
//		return sysUserDao.findById(userId);
		return null;
	}
}
