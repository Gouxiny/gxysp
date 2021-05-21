package com.gouxy.sys.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gouxy.oauth2.TokenGenerator;
import com.gouxy.sys.dao.SysUserTokenDao;
import com.gouxy.sys.entity.SysUserToken;


@Service
public class SysUserTokenService {

	@Autowired
	private SysUserTokenDao sysUserTokenDao;
	
	 //12小时后过期
    private final static int EXPIRE = 3600 * 12;
	
	public String createToken(String userId) {
		String token = TokenGenerator.generateValue();
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        
        Map<String,Object> usertokenmap = sysUserTokenDao.queryById(userId);
        
        if(usertokenmap == null){
        	SysUserToken usertoken = new SysUserToken();
        	usertoken.setToken(token);
        	usertoken.setUserId(userId);
        	usertoken.setExpireTime(expireTime);
        	usertoken.setUpdateTime(now);
            sysUserTokenDao.save(usertoken);
        }else {
        	SysUserToken sysUserToken = new SysUserToken();
        	sysUserToken.setToken(token);                                                                                      
        	sysUserToken.setUserId(userId);
        	sysUserToken.setExpireTime(expireTime);
        	sysUserToken.setUpdateTime(now);
            sysUserTokenDao.edit(sysUserToken);
        }
        return token;
	}
	 public String getuserName(String token) {
	    	SysUserToken userToken = sysUserTokenDao.queryByToken(token);
	    	String id;
	    	try {
	    		id = userToken.getUserId();
	    	}catch (Exception e) {
				// TODO: handle exception
	    		id ="0";
			}
	    	return id;
	    }
	    
    public void logout(String userId){
        //生成一个token
        String token = TokenGenerator.generateValue();
        SysUserToken userToken = new SysUserToken();
        userToken.setToken(token);
        userToken.setUserId(userId);
        sysUserTokenDao.edit(userToken);
    }
    
}
