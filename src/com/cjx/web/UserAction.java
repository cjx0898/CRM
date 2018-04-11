package com.cjx.web;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.cjx.bean.User;
import com.cjx.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private String viCode;

	public void setViCode(String viCode) {
		this.viCode = viCode;
	}



	public String login(){
		System.out.println(viCode + " ....");
		HttpSession session = ServletActionContext.getRequest().getSession();
		String str = (String) session.getAttribute("validateCode");
		System.out.println(str +" .... ");
		if(viCode.equalsIgnoreCase(str)){
			User user = userService.login(this.user);
			System.out.println(user);
			return "index";
		}
		
		
		
		session.setAttribute("msg", "您输入错误！！！");
		return "login";	
		
	}
	
	
	public String registerName(){
		String user_code = user.getUser_code();
		User user = userService.registerName(user_code);
		
		return "";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
