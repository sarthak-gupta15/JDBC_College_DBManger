package com.college.sarthak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
	
//	public Controller(int eno, String name, int div, String gender, double marks) {
//		super(eno, name, div, gender, marks);
//		// TODO Auto-generated constructor stub
//	}
	PreparedStatement prep;
	Scanner scS = new Scanner(System.in);
	Scanner scN = new Scanner(System.in);
	 Scanner scStr = new Scanner(System.in); // to take input after int 
	PojoClass pj = new PojoClass();

	public void createTable(Connection conn)
	{
		try {
			prep = conn.prepareStatement("create table College( Enrollment_no SERIAL, Name varchar(50), Division int, Gender varchar(100), Marks int, Bonus_marks int, primary key(Enrollment_no));");
//			prep = conn.prepareStatement("drop table College;");
			prep.executeUpdate();
			System.out.println("Database is Created");
		} 
		catch (SQLException e) 
		{
			System.err.println("database for college is already created");
//			e.printStackTrace();
		}
	}
	public void insertTable(Connection conn)
	{
		try {
			prep = conn.prepareStatement("insert into College (Name, Division, Gender, Marks) values(?, ?, ?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
       try {
		
    	   System.out.println("Enter name of student : ");
           pj.setName(scS.next());
           System.out.println("Enter the Division: ");
           pj.setDiv(scN.nextInt());
           System.out.println("Enter Gender: M/F");
           pj.setGender(scStr.next().toUpperCase());
           System.out.println("Enter the marks of the student: ");
           pj.setMarks(scN.nextInt());
           
           prep.setString(1, pj.getName());
           prep.setInt(2, pj.getDiv()); 
           
           if(pj.getGender().equals("M"))prep.setString(3, "Male");
           else prep.setString(3, "Female");
           prep.setInt(4,pj.getMarks());
           prep.executeUpdate();
           System.out.println("Row inserted in student table.");
	} catch (SQLException e) {
		System.err.println("the error occur at the time of insertion of student");
		e.printStackTrace();
	}
	}
	
	public void printDB (Connection conn) throws SQLException
	{
		try {
			prep = conn.prepareStatement("select * from College;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("_____________________________________________________________________________________________");
		System.out.println("| Enrollment_no     | Name        |  Division  | Gender       |   Marks   |   Bonus Marks   |");
		System.out.println("_____________________________________________________________________________________________");
		ResultSet rs = prep.executeQuery();
		while(rs.next())
		{
			System.out.println("|     "+rs.getInt("Enrollment_no") +"               " + rs.getString("Name")+"              "+rs.getInt("Division")+"        "+rs.getString(4)+"           "+rs.getInt(5)+"           "+rs.getInt(6));
		}
		System.out.println("All rows are retrieved.");
	}
	
	public void searchStudent(Connection conn) throws SQLException
	{
		prep = conn.prepareStatement("select * from College where Enrollment_no = ?");
		System.out.println("Enter the Enrollment no. of Student: ");
		prep.setInt(1, scN.nextInt());
		ResultSet rs = prep.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("Enrollment_no") +" " + rs.getString("Name")+" "+rs.getInt("Division")+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getInt(6));
		}
	}
	
	public void listGender(Connection conn) throws SQLException 
	{
		prep = conn.prepareStatement("select * from College where Gender like ?");
		System.out.println("Enter the Gender(M/F): ");
		 if(scStr.next().equalsIgnoreCase("M"))prep.setString(1, "Male");
         else prep.setString(1, "Female");
		 ResultSet rs = prep.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt("Enrollment_no") +" " + rs.getString("Name")+" "+rs.getInt("Division")+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getInt(6));
			}
	}
	
	public void addBonus(Connection conn) throws SQLException
	{
		prep = conn.prepareStatement("update College set Bonus_marks = ? where Enrollment_no = ?");
		
		System.out.println("Enter the Enrollment no. of Student: ");
		prep.setInt(2, scN.nextInt());
		System.out.println("Enter Bonus marks: ");
		prep.setInt(1, scN.nextInt());
	    prep.executeUpdate();
	    
	}
	public void changeDiv(Connection conn) throws SQLException
	{
		prep = conn.prepareStatement("update College set Division = ? where Name = ?");
		
		System.out.println("Enter Name of Student: ");
		prep.setString(2, scStr.next());
		System.out.println("Enter Division : ");
		prep.setInt(1, scN.nextInt());
	    prep.executeUpdate();
	    
	}
	
	public void printRange (Connection conn) throws SQLException
	{
		try {
			prep = conn.prepareStatement("select * from College where Marks between ? and ?;");
			System.out.println("Please enter the minimum marks of range: ");
			prep.setInt(1, scN.nextInt());
			System.out.println("Please enter the Maximum marks of range: ");
			prep.setInt(2, scN.nextInt());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = prep.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("Enrollment_no") +" " + rs.getString("Name")+" "+rs.getInt("Division")+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getInt(6));
		}
		System.out.println("All rows are retrieved.");
	}
	
	public void calGrade(Connection conn) throws SQLException
	{
		prep = conn.prepareStatement("select * from College where Name = ?");
		System.out.println("Enter Name of Student: ");
		prep.setString(1, scS.next());
		ResultSet rs = prep.executeQuery();
		
		rs.next();
//		System.out.println("marks "+rs.getInt("Marks"));
//		System.out.println("marks "+rs.getInt("Bonus_marks"));
	    if((rs.getInt("Marks")+rs.getInt("Bonus_marks"))>=75) System.out.println("Grade A");
	    else if((rs.getInt("Marks")+rs.getInt("Bonus_marks"))>=60) System.out.println("Grade B");
	    else if((rs.getInt("Marks")+rs.getInt("Bonus_marks"))>=40) System.out.println("Grade C");
	    else if((rs.getInt("Marks")+rs.getInt("Bonus_marks"))<=39 && (rs.getInt("Marks")+rs.getInt("Bonus_marks"))>=0) System.out.println("Grade B");


	}
}
