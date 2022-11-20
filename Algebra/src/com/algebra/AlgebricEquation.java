package com.algebra;

import java.util.*;

public class AlgebricEquation {

	boolean multiply;
	boolean subract;
	boolean add;
	int power = 1;
	String variable = "";
	int powerTemp = 1;
	String temp = "";
	int value = 0;
	String[] arr;

	public void findSign(String val) {
		for (int i = 1; i < val.length(); i++) {
			if (val.charAt(i - 1) == ')' && (val.charAt(i) == '+' || val.charAt(i) == '-')) {
				add = true;
				multiply = false;
				break;
			}
			if (val.charAt(i - 1) == ')' && val.charAt(i) == '*') {
				multiply = true;
				break;
			}
		}
	}
	
	public boolean numCheck(char ch) {
		boolean isnum = false;
		if ((ch >= 48 && ch <= 57)) {
			isnum = true;
		}
		return isnum;
	}
	
	public boolean albhabetCheck(char ch) {
		boolean isletter = false;
		if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
			isletter = true;
		}
		return isletter;
	}
	
	public void ExpressionSplit(char[] term) {
		arr = new String[2];
		arr[0] = "";
		arr[1] = "";
		if (term[0] == 45) {
			if (subract) {
				power *= 1;
			} else {
				power *= -1;
			}
		} else {
			if (numCheck(term[0])) {
				if (subract) {
					arr[0] += "-" + term[0];
				} else {
					arr[0] += "" + term[0];
				}
			} else {
				arr[1] += "" + term[0];
			}
		}

		for (int i = 1; i < term.length; i++) {
			if (numCheck(term[i])) {
				if (term[i - 1] == 94) {
					arr[1] += "" + term[i];
				} else {
					arr[0] += "" + term[i];
				}
			} else {
				arr[1] += "" + term[i];
			}
		}
		if (arr[0].length() > 0) {
			power *= Integer.parseInt(arr[0]);
		}
		variable += arr[1];

		if ((subract || add) && (variable.length() == 0)) {
			value += power;
		}
	}

	public void multiply() {
		HashMap<Character, Integer> power = new HashMap<Character, Integer>();
		char previouskey = '0';
		for (char ch : variable.toCharArray()) {
			if (ch == 94) {
				continue;
			}
			if (power.containsKey(ch)) {
				int val = power.get(ch);
				power.replace(ch, val + 1);
			} else if (numCheck(ch)) {
				int val = power.get(previouskey);
				val--;
				power.replace(previouskey, val + ch - 48);
			} else {
				power.put(ch, 1);
			}
			previouskey = ch;
		}
		setVaribale(power);
	}
	
	private void setVaribale(HashMap<Character, Integer> map) {
		variable = "";
		Set<Character> keys = map.keySet();
		for (char ch : keys) {
			int val = map.get(ch);
			if (val > 1) {
				variable += ch + "^" + val;
			} else {
				variable += ch;
			}
		}
	}


	public void setTemp(int operation, String val2) {
		this.powerTemp = operation;
		this.temp = val2;
	}

	public void useTemp(int operation, String val2) {
		this.power = operation;
		this.variable = val2;
	}
	}

