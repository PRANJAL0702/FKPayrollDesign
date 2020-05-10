import java.io.*;
import java.sql.*;  
import java.util.Scanner;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat; 
class LastPaymentWay {
	void SetPaymentWay(int i,String type) {
		String mode="";
		try {
		Class.forName("com.mysql.jdbc.Driver");  
	    Connection con=DriverManager.getConnection(  
	    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");
	    //System.out.println(i);  
	    //here sonoo is database name, root is username and password  
	    Statement stmt=con.createStatement();  
	    String query1="select modeofpayment from "+type+" where id="+i;
	    ResultSet rs=stmt.executeQuery(query1);  
	    while(rs.next())  {
	    		mode=rs.getString(1);
	    }
	    //System.out.println(mode);
	    //System.out.println(rs.getInt(1)+"  "+rs.getString(2));


	    //--------------------------------------------------------------------
	    Statement stmt1=con.createStatement(); 
	    String query= "Update "+type+" Set LastPaymentMadeWay= '"+mode+"' where id="+i;
	    stmt1.executeUpdate(query);  
	      
	    con.close();  
	    }
	    catch(Exception e){ System.out.println(e);}

	}
}