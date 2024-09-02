package com.first;

import java.util.Scanner;

public class Practice {
public static void main(String[] args) {
	System.out.println("hello please give first input as string and and second as integer");
	Scanner sc = new Scanner(System.in);
	for(int i = 0; i<5;i++)
	{
		
		int a = sc.nextInt();
		String str = sc.next();
		System.out.println("the string is "+str+ " the no.  is "+a);
	}
	
}
}
