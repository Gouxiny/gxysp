package com.gouxy.sys.entity;

import java.util.Date;

import lombok.Data;

@Data
public class SysUserToken {

	private String sysUserId;
	private String token;
	//过期时间
	private Date exipretime;
	//更新时间
	private Date updatetime;
	
}
