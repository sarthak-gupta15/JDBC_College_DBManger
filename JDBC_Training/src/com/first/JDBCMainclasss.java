package com.first;

import java.sql.Connection;
import java.util.Scanner;

public class JDBCMainclasss {

	public static void main(String[] args) {
		String add = "jdbc:postgresql://localhost:5432/mcasem1";
		String user = "postgres";
		String pass = "sarthak";
		MethodClass rohit = new MethodClass();
		Scanner sc = new Scanner(System.in);
		Connection conn = rohit.connect(add, user, pass);
//		System.out.println("enter table Name: ");
//		rohit.create_table(conn, sc.next());
		System.out.println("enter table name,roll, name ,branch, marks : ");
		
		rohit.insert(conn, sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.nextInt());
		
		
	}
}
