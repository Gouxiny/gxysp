package com.gouxy.sys.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gouxy.sys.entity.SysUser;
import com.gouxy.sys.entity.SysUserToken;

@Mapper
public interface SysUserTokenDao {

	void addToken(SysUserToken sysUserToken);
	void save(SysUserToken sysUserToken);
	void edit(SysUserToken sysUserToken);
	SysUserToken queryByToken(String token);
	SysUser findById(String userId);
	Map<String,Object> queryById(String userId);
}
