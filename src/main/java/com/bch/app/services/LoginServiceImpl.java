package com.bch.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bch.app.beans.UserBean;
import com.bch.app.dao.LoginDao;
import com.bch.app.models.User;
import com.opensymphony.xwork2.Action;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private UserBean userBean;

	public String login(String sec1, String sec2) {
		User user = loginDao.login(sec1, sec2);
		if(user == null){
			return Action.ERROR;
		}
		userBean.setUser(user);
		return Action.SUCCESS;
	}

	public String logout(int id) {
		return Action.SUCCESS;
	}

}
