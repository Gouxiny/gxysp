package com.gouxy.sys.entity;

import lombok.Data;

@Data
public class SysUserToken {

	private String sysUserId;
	private String token;
	//过期时间
	private String exipretime;
	//更新时间
	private String updatetime;
}
