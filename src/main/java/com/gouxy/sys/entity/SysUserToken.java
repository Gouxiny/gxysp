package com.gouxy.sys.entity;

import java.util.Date;

import lombok.Data;

@Data
public class SysUserToken {

	private String UserId;
	private String token;
	//过期时间
	private Date expireTime;
	//更新时间
	private Date updateTime;
	
}
