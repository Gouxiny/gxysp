package com.gouxy.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gouxy.sys.entity.SysUser;
import com.gouxy.sys.form.SysForm;
import com.gouxy.sys.service.SysUserService;

@RestController
public class sysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public void showSysUSer() {
		System.out.println("++++");
		System.out.println(sysUserService.showSysUser());
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public void addUser(@RequestBody SysForm form) {
		sysUserService.addSysUser(form);
	}
}
