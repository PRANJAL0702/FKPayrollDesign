import java.io.*;
import java.sql.*;  
import java.util.Scanner;
import java.sql.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 


class MonthlyEmployee implements Employee {

	public void modeofpayment(int i) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your ModeofPayment");
		String new2=sc.nextLine();

		try{  
		    Class.forName("com.mysql.jdbc.Driver");  
		    Connection con=DriverManager.getConnection(  
		    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
		    //here sonoo is database name, root is username and password  
		    Statement stmt=con.createStatement();  
		    String query="UPDATE MonthlyEmployee set modeofpayment='"+new2+"' where id="+i;
		    int rs=stmt.executeUpdate(query); 
		 }
		 catch(Exception e){ 
		 	System.out.println(e);
		 }


	}


	public void setMonthlySalary(int i) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Salary");
		double new1=sc.nextDouble();

		try{  
		    Class.forName("com.mysql.jdbc.Driver");  
		    Connection con=DriverManager.getConnection(  
		    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
		    //here sonoo is database name, root is username and password  
		    Statement stmt=con.createStatement();  
		    String query="UPDATE MonthlyEmployee set MonthlySalary="+new1+" where id="+i;
		    int rs=stmt.executeUpdate(query); 
		 }
		 catch(Exception e){ 
		 	System.out.println(e);
		 }


	}

	public void setCommission(int i) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your New Commission Rate");
		Double new2=sc.nextDouble();

		try{  
		    Class.forName("com.mysql.jdbc.Driver");  
		    Connection con=DriverManager.getConnection(  
		    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
		    //here sonoo is database name, root is username and password  
		    Statement stmt=con.createStatement();  
		    String query="UPDATE MonthlyEmployee set Commission='"+new2+"' where id="+i;
		    int rs=stmt.executeUpdate(query); 
		 }
		 catch(Exception e){ 
		 	System.out.println(e);
		 }

	}

	public void submitCommission(int i) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Commission for Today!");
		Double new2=sc.nextDouble();

		try{  
		    Class.forName("com.mysql.jdbc.Driver");  
		    Connection con=DriverManager.getConnection(  
		    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
		    //here sonoo is database name, root is username and password  
		    Statement stmt=con.createStatement();  
		    String query="insert into CommissionTable values("+i+",'Hourly',"+new2+",'"+java.time.LocalDate.now()+"')";
		    int rs=stmt.executeUpdate(query); 
		 }
		 catch(Exception e){ 
		 	System.out.println(e);
		 }

	}

}