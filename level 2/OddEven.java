package com.dailylearning;

public class OddEven {
	public static void main(String args[]) {
		new OddEven().init();
	}

	private void init() {
         int []array= {13,2,4,15,12,10,5};
         for(int i=1;i<array.length;i++) {
        	 for(int j=i+2;j<array.length;j=j+2) {
        		 if(array[i]>=array[j]) {
        			 int temp = array[i];
        			 array[i]=array[j];
        			 array[j]=temp;		 
        		 }
        	 }
         }
         for(int i=2;i<array.length;i=i+2) {
        	 for(int j=i+2;j<array.length;j=j+2) {
        		 if(array[i]<=array[j]) {
        			int temp=array[i];
        			array[i]=array[j];
        			array[j]=temp;
        		 }
        	 }
         }
         for(int i:array) {
        	 System.out.print(i+", ");
         }
	}
}
