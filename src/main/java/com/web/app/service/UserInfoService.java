package com.web.app.service;

import java.util.List;

import com.web.app.entity.UserInfo;

public interface UserInfoService {
	
	public List<UserInfo> getAllUserInfo();
	public void saveUserInfo (UserInfo userInfo);
	public UserInfo getUserInfoById(int id);
}
