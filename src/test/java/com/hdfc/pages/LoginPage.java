package com.hdfc.pages;

import org.springframework.stereotype.Component;

import com.microsoft.playwright.Page;

@Component
public class LoginPage {
	
	private final Page page;
	
	private final String username = "[name='username']";
	private final String password = "[name='password']";
	private final String loginButton = "//button[normalize-space()='Login']";
	
	public LoginPage(Page page)
	{
		this.page = page;
	}
	
	public void navigateTo(String url)
	{
		page.navigate(url);
	}
	
	public void login(String user, String pass)
	{
		page.fill(username, user);
		page.fill(password, pass);
		page.click(loginButton);
	}
	
	

}
