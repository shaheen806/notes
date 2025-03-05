package com.secure.notes.util;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
 interface Test{
	
	public int add(int i, int j);
}



public class JavaPractice {
	public static void main (String[] args) {
		
		List<Integer> num=  Arrays.asList(1,5,2,8,4);
	
		num.forEach(n->System.out.println(n));
		
		System.out.println("in main method");
		Test test =  ( i, j)-> i+j;
		
		int result = test.add(5,3);
		System.out.println("add"+result);
	}

}



