package com.example.pms.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.pms.entity.Admin;

public class UserDetailImpl implements UserDetails {
	private final Admin admin;

	public UserDetailImpl(Admin admin) {
		super();
		this.admin = admin;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		return admin.getAdminEmail();
		
	}
	
	
	

	
	
	
	
	
}
