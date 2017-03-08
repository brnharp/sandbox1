package com.bch.app.dao;

import com.bch.app.models.User;

public interface LoginDao {

	public User login(String sec1, String sec2);

}
