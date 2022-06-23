package com.web.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.app.dao.UserInfoDAO;
import com.web.app.entity.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDAO userDAO;
	
@Override
@Transactional
public List<UserInfo> getAllUserInfo() {
	
	return userDAO.getAllUserInfo();
}


@Override
@Transactional
public void saveUserInfo(UserInfo userInfo) {
	userDAO.saveUserInfo(userInfo);
	
}

@Override
@Transactional
public UserInfo getUserInfoById(int id) {

	return userDAO.getUserInfoById(id);
}



}
