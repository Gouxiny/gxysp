package com.gouxy.sys.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gouxy.sys.dao.SysUserDao;
import com.gouxy.sys.entity.SysUser;
import com.gouxy.sys.entity.SysUserToken;
import com.gouxy.sys.form.SysForm;

@Service
public class SysUserService{
	
	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	private SysUserTokenService sysUserTokenService;
	
	public SysUser showSysUser() {
		// TODO Auto-generated method stub
		return sysUserDao.showSysUser();
	}

	public Boolean addSysUser(SysForm sysUser) {
		sysUser.setPassword(new Sha256Hash(sysUser.getPassword()).toHex());
		sysUserTokenService.createToken(sysUser.getPassword());
		try {
			sysUserDao.addSysUser(sysUser);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
		return true;
	}
}
