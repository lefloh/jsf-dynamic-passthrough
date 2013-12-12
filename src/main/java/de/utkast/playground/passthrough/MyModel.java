package de.utkast.playground.passthrough;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class MyModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String telephone;
	
	private String mobile;
	
	private boolean mobileRequired = true;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public boolean isMobileRequired() {
		return mobileRequired;
	}

	public void setMobileRequired(boolean mobileRequired) {
		this.mobileRequired = mobileRequired;
	}

}

