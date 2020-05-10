import java.io.*;
import java.sql.*;  
import java.util.Scanner;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat; 

class Union implements UnionSet {

	public void addtax() throws IOException  {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the User ID to Enter Tax");
		int id=Integer.parseInt(br.readLine());
		System.out.println("Enter the Type of Tax");
		String type=br.readLine();
		System.out.println("Enter the amount");
		int amt=Integer.parseInt(br.readLine());
		System.out.println("Enter the Employee Type");
		String emptype=br.readLine();
		try{  
		    Class.forName("com.mysql.jdbc.Driver");  
		    Connection con=DriverManager.getConnection(  
		    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
		    //here sonoo is database name, root is username and password  
		    Statement stmt=con.createStatement();
		    String query="insert into membership values("+id+",'"+type+"',"+amt+",'"+java.time.LocalDate.now()+"','"+emptype+"')";  
		    stmt.executeUpdate(query);  
		    
		    con.close();  
		    }
		    catch(Exception e)
		    { System.out.println(e);
		    }
	}


	public double deduction(int i,String type) {

			double amount=0;
		try{  
				
			    Class.forName("com.mysql.jdbc.Driver");  
			    Connection con=DriverManager.getConnection(  
			    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
			    //here sonoo is database name, root is username and password  
			    Statement stmt=con.createStatement();
			    String query="select sum(amount) as amt from membership where id="+i+" and Emptype='"+type+"'";  
			    ResultSet rs=stmt.executeQuery(query);  
			    while(rs.next())  {
			    	amount+=rs.getDouble(1);
			    }

			    Statement stmt1=con.createStatement();
			    String query1="delete from membership where id="+i+" and Emptype='"+type+"'";  
			    stmt1.executeUpdate(query1);
			    //System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
			    con.close();  
			    }
			    catch(Exception e)
			    { System.out.println(e);
			    }  
			    return amount;
	}
}