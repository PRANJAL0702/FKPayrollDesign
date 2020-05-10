import java.io.*;
import java.sql.*;  
import java.util.Scanner;
public class Main {
	public static void main(String args[]) throws IOException{
		Scanner sc=new Scanner(System.in);

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Hey! Welcome to Payroll System");
		System.out.println("Press 1 for Admin Rights \b");
		int a=sc.nextInt();
		if(a==1) {
			//Administrator a1=new Administrator();
			//System.out.println("\n \n");
			int q=1;
			System.out.println("Enter Your Credentials");
			System.out.println("Username: ");
			String name=br.readLine();
			System.out.println("Password: ");
			String password=br.readLine();
			try{  
    				Class.forName("com.mysql.jdbc.Driver");  
				    Connection con=DriverManager.getConnection(  
				    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
				    //here Flipkart is database name, root is username and password  
				    Statement stmt=con.createStatement();  
				    ResultSet rs=stmt.executeQuery("select Password from AdminDatabase where Name='"+name+"'");  
				    
						    while(rs.next()){
						    	String pass=  rs.getString("Password");
						    	if((pass.compareTo(password))==0) {
						    	//System.out.println("Heyy u passed bro");
						    	Administrator a1=new Administrator(name);
						    	a1.Function();
						    	System.out.println("Successful Exit!");
						    	q=0;
								}
							}
				    con.close();  
				    if(q==1) {
				    	System.out.println("\n Login Failure");
				    }
				    }catch(Exception e){ System.out.println(e);} 


		}
		else {
			System.out.println("Login Again");
		}
	}
}


