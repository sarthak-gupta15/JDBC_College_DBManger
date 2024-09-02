package com.college.sarthak;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

public class Service {

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		Scanner scN = new Scanner(System.in); // number
		Scanner scS = new Scanner(System.in); // String
		Properties prop = new Properties();
		prop.load(new FileInputStream("connection.properties"));
		Connection conn = null;
		try {
			 conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
			 if(conn!=null)System.out.println("Connection with server Established");
			 
		} catch (SQLException e) {
			System.err.println("failed to connect with server");
//			e.printStackTrace();
		}
		
		Controller ser = new Controller();
		ser.createTable(conn);
		String user = "Admin";
		String pass = "1234";
		String choice = "y";
		System.out.println("LOGIN PLEASE");
		System.out.print("USERNAME: ");
		String tempu = scS.next();
		System.out.print("\nPASSWORD: ");
		String tempp = scS.next();
		if(!(tempu.equals(user) && tempp.equals(pass)))
		{
			System.err.println("You have Entered wrong password");
			 System.exit(0);
		}
		do {
			System.out.println("\nWELCOME TO RCOEM COLLEGE DATABASE");
//			System.out.println("PASSWORD: ");
			System.out.println("1. CREATE ENTER FOR NEW STUDENT");
			System.out.println("2. SEARCH FOR STUDENT (ENROLLMENT NUMBER REQUIRED)");
			System.out.println("3. CHECK THE GRADE OF STUDENT (NAME REQUIRED)");
			System.out.println("4. LIST STUDENT ACCORDING TO GENDER");
			System.out.println("5. ADD BONUS MARKS FOR SPECIFIC STUDENT (ENROLLMENT NUMBER REQUIRED)");
			System.out.println("6. CHANGE DIVISION (NAME REQUIRED)");
			System.out.println("7. LIST STUDENT ACCORDING TO MARKS RANGE");
			System.out.println("8. PRINT DATABASE");
			System.out.println("9. LOGOUT DATABASE");
			System.out.println("Enter the associated input from the menu option:");
			
			int input=0;
			
			input = scN.nextInt();
			Controller cont = new Controller();
			
			switch (input) {
			case 1 -> 
			{
			cont.insertTable(conn);
			}
			case 2 -> 
			{
			cont.searchStudent(conn);
			}
			case 3 -> 
			{
			cont.calGrade(conn);
			}
			case 4 -> 
			{
			cont.listGender(conn);
			}
			case 5 -> 
			{
			cont.addBonus(conn);
			}
			case 6 -> 
			{
			cont.changeDiv(conn);
			}
			case 7 -> 
			{
			cont.printRange(conn);
			}
			case 8 -> 
			{
			cont.printDB(conn);
			}
			case 9 -> 
			{
				System.out.println("LogOut......");
			System.exit(0);
			}
//			default:
//				throw new IllegalArgumentException("Unexpected value: " + key);
			}
			System.out.println("Do you want to continue? Y/N");
            choice = scS.next().toUpperCase();
			
		} while (choice.equalsIgnoreCase("Y"));
		
		
	   
	}
}
