package com.bch.app.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.bch.app.services.LoginService;
import com.opensymphony.xwork2.ActionSupport;

@Results({ @Result(name = "success", location = "/content/pages/home.jsp"),
		@Result(name = "denied", location = "/content/pages/login.jsp"),
		@Result(name = "error", location = "/content/pages/login.jsp") })
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 4013495998703689944L;

	@Autowired
	public LoginService loginService;

	private String securityOne;
	private String securityTwo;

	@Action("gotoLogin")
	public String gotoLogin() {
		return "denied";
	}

	@Action("login")
	public String login() {
		String result = loginService.login(securityOne, securityTwo);
		if (result == null || result.isEmpty()) {
			result =  ERROR;
		}
		if(!result.equals(SUCCESS)){
			addActionError("Login Failed");
			securityOne = "";
			securityTwo = "";
		}
		return result;
	}

	public String getSecurityOne() {
		return securityOne;
	}

	public void setSecurityOne(String securityOne) {
		this.securityOne = securityOne;
	}

	public String getSecurityTwo() {
		return securityTwo;
	}

	public void setSecurityTwo(String securityTwo) {
		this.securityTwo = securityTwo;
	}

}
