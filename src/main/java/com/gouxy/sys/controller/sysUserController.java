package com.gouxy.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gouxy.sys.service.SysUserService;

@RestController
public class sysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/login")
	public void showSysUSer() {
		System.out.println("++++");
		System.out.println(sysUserService.showSysUser());
	}
}
