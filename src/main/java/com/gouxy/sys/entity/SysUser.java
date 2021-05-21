package com.gouxy.sys.entity;

import lombok.Data;

@Data
public class SysUser {

	private String username;
    private String password;
    private String departmentId;
    private String name;
	private String status;
	private String gender;
    private String desc;
    private String mail;
}
