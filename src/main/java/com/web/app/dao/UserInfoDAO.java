package com.web.app.dao;

import java.util.List;

import com.web.app.entity.UserInfo;

public interface UserInfoDAO {
	
	public List<UserInfo> getAllUserInfo();
	public void saveUserInfo (UserInfo userInfo);
	public UserInfo getUserInfoById(int id);
	public void deleteUserInfo(int id);
}
