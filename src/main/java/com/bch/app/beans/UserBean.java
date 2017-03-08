package com.bch.app.beans;

import org.springframework.stereotype.Component;

import com.bch.app.models.User;

@Component("userBean")
public class UserBean {
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
