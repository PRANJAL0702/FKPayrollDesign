import java.io.*;
import java.sql.*;  
import java.util.Scanner;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat; 
class HR {
	
	public static void payforday() throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("Who Do You Want To Pay! 1 for Hourly 2 for Monthly");
		int check1= Integer.parseInt(br.readLine());

		if(check1==1) {

				if(dayOfWeek==1) {

					System.out.println("Hurray Payment Time");
					try{  
		    				Class.forName("com.mysql.jdbc.Driver");  
		    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
						    //here sonoo is database name, root is username and password 
						    //long millis=System.currentTimeMillis();  
							//java.sql.Date date=new java.sql.Date(millis);  
						    Statement stmt=con.createStatement(); 
						    String query="Select id,sum(wageforday) as thisweek from HourlyEmployeeDaily group by id order by id asc";
						    ResultSet rs=stmt.executeQuery(query);  
						    while(rs.next())  {
						    	int id=rs.getInt(1);
						    	double payment=rs.getInt(2);
						    	//System.out.println(payment);
						    	payment=payment+getCommission(id,"Hourly");
						    	//System.out.println(payment);
						    	Statement stmt2=con.createStatement();
						    	//System.out.println(id+"will get"+payment);
						    	String query1="Delete from HourlyEmployeeDaily where id="+id;
						    	stmt2.executeUpdate(query1);
						    	Statement stmt1=con.createStatement(); 
						    	String query2="Update HourlyEmployee Set LastPayment="+payment+"where id="+id;
						    	stmt1.executeUpdate(query2);
						    	Statement stmt3=con.createStatement(); 
						    	String query3="Update HourlyEmployee Set LastSalaryDate='"+java.time.LocalDate.now()+"' where id="+id;
						    	stmt3.executeUpdate(query3);
						    }
						      
						    con.close();  
						}
						catch(Exception e){ System.out.println(e);}


					}
					else {
						if(dayOfWeek<6)
						System.out.println("Wait for"+(6-dayOfWeek)+"days to make a Hourly Payment");
						else
							System.out.println("Wait for"+(6-dayOfWeek+7)+"days to make a Hourly Payment");
					}

				}

		if(check1==2) {

			int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
			if(dayOfMonth==10) {
				System.out.println("Monthly Salary Time");
				try{  
    				Class.forName("com.mysql.jdbc.Driver");  
    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
				    //here sonoo is database name, root is username and password 
				    //long millis=System.currentTimeMillis();  
					//java.sql.Date date=new java.sql.Date(millis);  
				    Statement stmt=con.createStatement();
				    String query="Select id,MonthlySalary from MonthlyEmployee";
				    ResultSet rs=stmt.executeQuery(query);  
				    while(rs.next())  {
				    	int id=rs.getInt(1);
				    	double Payment=rs.getDouble(2);
				    	Statement stmt3=con.createStatement(); 
				    	String query3="Update MonthlyEmployee Set LastPayment='"+java.time.LocalDate.now()+"'";
				    	stmt3.executeUpdate(query3);
				    	Payment=Payment+getCommission(id,"Monthly");
				    	Statement stmt4=con.createStatement(); 
				    	String query4="Update MonthlyEmployee Set LastPaymentMade="+Payment+" where id="+id;
				    	stmt4.executeUpdate(query4);
				    }
				      
				    con.close();  
				}
				catch(Exception e){ System.out.println(e);}





			}
			else {
				System.out.println("Wait  a few Days to pay Monthly Employees");
			}
		}
		


			

	}



	public static double getCommission(int i,String type) {

		double commission=0;
		try{  
		    Class.forName("com.mysql.jdbc.Driver");  
		    Connection con=DriverManager.getConnection(  
		    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
		    //here sonoo is database name, root is username and password  
		    Statement stmt=con.createStatement();
		    String query="Select sum(commission) as Sum from CommissionTable where id="+i+" and type='"+type+"' and (DATEDIFF(date,CURDATE())=14)";
		    //String query="Select (DATEDIFF(date,CURDATE())) as Days from CommissionTable";
		    ResultSet rs=stmt.executeQuery(query);  
		    while(rs.next())  {
		    	System.out.println("Checking"+rs.getDouble(1));
		    	commission+=rs.getDouble("Sum"); 

		    }
		    //commission=rs.getDouble("Sum");  
		    Statement stmt2=con.createStatement();
		    String query1="Delete from CommissionTable where id="+i;
		    int t1=stmt2.executeUpdate(query1);
		    con.close();  
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		} 
		//System.out.println("Giving commission"+commission);
		return commission;
	}
}