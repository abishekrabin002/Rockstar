package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="email")
	private WebElement  email;
	
	@FindBy(id="pass")
	private WebElement  pass;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement  login;

	

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getLogin() {
		return login;
	}



}
