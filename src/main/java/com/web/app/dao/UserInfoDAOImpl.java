package com.web.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.web.app.entity.UserInfo;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
@Override
public List<UserInfo> getAllUserInfo() {
	
	Session session = sessionFactory.getCurrentSession();
	
	List<UserInfo> infos = session.createQuery("FROM UserInfo", UserInfo.class).getResultList();
	
	return infos;
}



@Override
public void saveUserInfo(UserInfo userInfo) {
	
	Session session = sessionFactory.getCurrentSession();
	
	session.saveOrUpdate(userInfo);
	
}

@Override
public UserInfo getUserInfoById(int id) {
	
	Session session = sessionFactory.getCurrentSession();
	
	UserInfo userInfo = session.get(UserInfo.class, id);
	
	
	return userInfo;
}


}
