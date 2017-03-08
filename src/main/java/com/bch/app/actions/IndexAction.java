package com.bch.app.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = -2794712345546869801L;

	@Action(value="index", results={
		@Result(name="success", location="/index.jsp")	
	})
	public String gotoIndex() {
		return SUCCESS;
	}

}
