import java.io.*;
import java.sql.*;  
import java.util.Scanner;
import java.sql.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 


class HourlyEmployee implements Employee {

	public void hourlyrate(int i) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Hey! Do u want to reflect on your Hourly Rate? Press 1 to confirm Again, 0 to Exit:");
		int m=Integer.parseInt(br.readLine());

		if(m==1) {
			try {
			System.out.println("Enter Your Updated Hourly Rate");
			int new1= Integer.parseInt(br.readLine());
			Class.forName("com.mysql.jdbc.Driver");  
		    Connection con=DriverManager.getConnection(  
		    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
		    //here sonoo is database name, root is username and password  
		    Statement stmt=con.createStatement(); 
		    String query="UPDATE HourlyEmployee set hourlyrate="+new1+" where id="+i;
		    int rs=stmt.executeUpdate(query); 
		 }
		 	catch(Exception e){ 
		 		System.out.println(e);
		 	}
			
		}
		

	}

	public void submitdailycard(int i) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Work of Hours for Today");
		int z=Integer.parseInt(br.readLine());
		try{  
		    Class.forName("com.mysql.jdbc.Driver");  
		    Connection con=DriverManager.getConnection(  
		    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
		    //here sonoo is database name, root is username and password  
		    Statement stmt=con.createStatement();
		    
		    String query1="select hourlyrate from HourlyEmployee where id="+i;
		    int rate=0;
		    ResultSet rs1=stmt.executeQuery(query1);
		    while(rs1.next()) {
		    	rate=rs1.getInt("hourlyrate");
		}
		    //System.out.println(rate);
			double wageforday=0;
			if(z>8) {
				wageforday=(rate)*8+(z-8)*1.5*rate;
			}
			else {
				wageforday=rate*z;
			}
		    String query="insert into HourlyEmployeeDaily values("+i+",'"+java.time.LocalDate.now()+"',"+z+","+wageforday+")";
		    int rs=stmt.executeUpdate(query); 
		 }
		 catch(Exception e){ 
		 	System.out.println(e);
		 }

	}


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
		    String query="UPDATE HourlyEmployee set modeofpayment='"+new2+"' where id="+i;
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
		    String query="UPDATE HourlyEmployee set Commission='"+new2+"' where id="+i;
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