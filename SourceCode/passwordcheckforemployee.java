import java.io.*;
import java.sql.*;  
import java.util.Scanner;
public class passwordcheckforemployee {

	public static int passcheck(int id,String pass1,String type) {
		int q=1;
		try{  
    				Class.forName("com.mysql.jdbc.Driver");  
				    Connection con=DriverManager.getConnection(  
				    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
				    //here Flipkart is database name, root is username and password  
				    Statement stmt=con.createStatement();  
				    ResultSet rs=stmt.executeQuery("select Password from "+type+" where id="+id);  
				    
						    while(rs.next()){
						    	String pass=  rs.getString("Password");
						    	if((pass.compareTo(pass1))==0) {
						    	//System.out.println("Heyy u passed bro");
						    	//Administrator a1=new Administrator(name);
						    	//a1.Function();
						    	return 1;
								}
							}
				    con.close();  
				    return 0;
				    }catch(Exception e){ System.out.println(e);}
				    return 0;
	}
}