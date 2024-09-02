package com.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MethodClass {

	public Connection connect(String add, String user , String pass)
	{
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(add,user,pass);
			if(conn!=null)
			{
				System.out.println("connection established successfully");
			}
			else
			{
				System.out.println("connection not established");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
		
	}
	
	public void create_table(Connection conn, String tablename) {
		Statement statement;
		
		try {
			String query = "create table "+ tablename+"( Roll_no int, Name varchar(50), Branch varchar(100), marks int, primary key(Roll_no));" ;
			statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table " + tablename + " is created.");
			
		} catch (Exception e) {
			 System.out.println("Error : " + e.getMessage());
		}
		
	}
	public void insert(Connection conn, String tablename,int Roll_no , String Name,String Branch,int marks) {
		Statement statement;
		
		try {
            String query = String.format("insert into %s (Roll_no,Name,Branch,marks ) values('%d', '%s','%s','%d');", tablename, Roll_no, Name,Branch,marks);
			statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("data is successfully inserted in " + tablename);
			
		} catch (Exception e) {
			 System.out.println("Error : " + e.getMessage());
		}
		
	}
	
	public void update(Connection conn, String tablename,int Roll_no , String Name,String Branch,int marks) {
		Statement statement;
		
		try {
            String query = String.format("update %s set Branch = %s where Roll_no equals ;", tablename, Roll_no, Name,Branch,marks);
			statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("data is successfully inserted in " + tablename);
			
		} catch (Exception e) {
			 System.out.println("Error : " + e.getMessage());
		}
		
	}
}
