package com.koulgar.dao;

import com.koulgar.entitiy.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
