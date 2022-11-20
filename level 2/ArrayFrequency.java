package com.dailylearning;

import java.util.ArrayList;
import java.util.List;

public class ArrayFrequency {
public static void main(String args[]) {
	new ArrayFrequency().init();
}

private void init() {
	int arr[]= {1,1,1,2,2,2,2,5,5,3,3};
	freqArrange(arr);
}

private void freqArrange(int[] arr) {
	List<Integer>freq =new ArrayList<Integer>();
	List<Integer>elements=new ArrayList<Integer>();
	for(int n:arr) {
		if(elements.contains(n)) {
			freq.set(elements.indexOf(n), freq.get(elements.indexOf(n))+1);
		}else {
			elements.add(n);
			freq.add(elements.indexOf(n),1);
		}
	}
	int temp=0;
	for(int i=0;i<freq.size();i++) {
		for(int j=i+1;j<freq.size();j++) {
			if(freq.get(i)<freq.get(j)) {
			temp=freq.get(i);
			freq.set(i,freq.get(j));
			freq.set(j, temp);
			temp=elements.get(i);
			elements.set(i, elements.get(j));
			elements.set(j, temp);
			}
		}
	}
	for(int i=0;i<freq.size();i++) {
		for(int j=0;j<freq.get(i);j++) {
			System.out.print(elements.get(i));
		}
	}
}
}
