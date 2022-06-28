package com.web.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web.app.entity.Role;

public interface RoleDAO {
	
	public Role getFirstRole(Long id);
	

}
