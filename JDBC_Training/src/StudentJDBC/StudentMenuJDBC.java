package StudentJDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

public class StudentMenuJDBC {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc1 = new Scanner(System.in);  // For string values
        Scanner sc2 = new Scanner(System.in);  // For numeric values

        String str = "y";
        int rno, choice ;
        String name;
        double marks;

        Properties prop = new Properties();
        prop.load(new FileInputStream("connection.properties"));
        Connection conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
        PreparedStatement prepStat;

        do {
            System.out.println("Enter your choice :");
            System.out.println("Enter 1 for create :");
            System.out.println("Enter 2 for insert :");
            System.out.println("Enter 3 for delete :");
            System.out.println("Enter 4 for update :");
            System.out.println("Enter 5 for select :");
            System.out.println("Enter 6 for specific select :");
            System.out.println("Enter 7 for exit:");
            choice = sc1.nextInt();

            switch (choice){
                case 1 -> {
                    prepStat = conn.prepareStatement("create table student (rno int, name varchar(50), marks double precision)");
                    prepStat.executeUpdate();
                    System.out.println("Table created.");
                }

                case 2 -> {
                    prepStat = conn.prepareStatement("insert into student (rno, name, marks) values(?, ?, ?)");
                    System.out.println("Enter roll number of student : ");
                    rno = sc2.nextInt();
                    System.out.println("Enter name of student : ");
                    name = sc1.next();
                    System.out.println("Enter marks of student : ");
                    marks = sc2.nextDouble();
                    prepStat.setInt(1, rno);
                    prepStat.setString(2, name);
                    prepStat.setDouble(3, marks);
                    prepStat.executeUpdate();
                    System.out.println("Row inserted in student table.");
                }

                case 5 -> {
                    prepStat = conn.prepareStatement("select * from student");
                    ResultSet resultSet = prepStat.executeQuery();
                    while (resultSet.next()){
                        System.out.println(resultSet.getInt("rno") + " " + resultSet.getString("name") + " " + resultSet.getDouble("marks"));
                    }
                    System.out.println("All rows are retrieved.");
                }

            }
            System.out.println("Do you want to continue ? ? ?");
            str = sc1.next();

        }while (Objects.equals(str, "y") || Objects.equals(str, "Y"));

    }
}
