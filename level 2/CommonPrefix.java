package com.dailylearning;

import java.util.Arrays;

public class CommonPrefix {
public static void main(String args[]) {
	new CommonPrefix().init();
}

private void init() {
	String array[]= {"fower","flow","flight"};
	int n = array.length;
    String r ="";
    Arrays.sort(array);
    String s =array[0];
    String h =array[n-1];
    for(int i = 0;i<s.length();i++){
        if(s.charAt(i)!=h.charAt(i))
            break;
        r+=s.charAt(i);
    }
    
System.out.println(r);
}
}
