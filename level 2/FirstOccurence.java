package com.dailylearning;

public class FirstOccurence {
	public static void main(String args[]) {
		new FirstOccurence().init();
	}

	private void init() {
       String str1="test123string";
       String str2="12353";
       if(str1.contains(str2)) {
    	   for(int i=0;i<str1.length();i++) {
    		   if(str1.charAt(i)==str2.charAt(0)) {
    			   System.out.println(i);
    			   break;
    		   }
    	   }
       }else
    	   System.out.println("-1");
	}
}
