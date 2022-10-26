package com.contact.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

	public boolean checkName(String name) {
		String regex = "[a-zA-Z]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches())
			return true;
		else
			return false;
	}
	
	public boolean checkMobileNumber(String mobileNo) {
		String regex = "^[5-9][0-9]{9}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mobileNo);
		if (matcher.matches())
			return true;
		else
			return false;
	}
}
