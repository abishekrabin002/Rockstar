package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseClass {
	
	 public RegistrationPage() {
		 PageFactory.initElements(driver, this);
	 }
@FindBy(xpath="//a[text()='Create new account']")
private WebElement click;

@FindBy(name="firstname")
private WebElement fname;

public void setClick(WebElement click) {
	this.click = click;
}


public void setFname(WebElement fname) {
	this.fname = fname;
}


public void setLname(WebElement lname) {
	Lname = lname;
}


public void setSignup(WebElement signup) {
	this.signup = signup;
}
@FindBy (name="lastname")
private WebElement Lname;


@FindBy(xpath="//button[@name='websubmit']")
private WebElement signup;


public WebElement getClick() {
	return click;
}


public WebElement getFname() {
	return fname;
}


public WebElement getLname() {
	return Lname;
}


public WebElement getSignup() {
	return signup;
}

	 
}
