package com.dailylearning;



public class InBetween {
public static void main(String args[]) {
	new InBetween().init();
}

private void init() {
	int n=11,x=50,y=100;
	int[]array= { 21, 63, 54, 67, 13, 88, 43, 57, 604, 1, 100};
	for(int i=0;i<n;i++) {
		if(array[i]>x&&array[i]<y) {
			System.out.print(array[i]+" ");
		}
	}
}
}
