import java.io.*;
import java.sql.*;  
import java.util.Scanner;
import java.sql.*;
class Administrator {

		private String Username;
		//static int id1=1;
		static int id2=1;
		Administrator(String Username) {
			this.Username=Username;
		}

		public void Function() throws IOException{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Hey! You Have Sucessfully Entered Your Credentials");
			System.out.println("Can You Please Enter Your Desired Work: \n \t Press 1 to Enter a New Employee \n Press 2 to Drop an Employee\n Press 3 to Enter HR Section for Payment Mode");

			int n=Integer.parseInt(br.readLine());


			if(n==1) {

					int loop=1;
					while(loop==1){
							System.out.println("Enter the Type Of Employee:\n \t Press 1 for Hourly Employee \n \t Press 2 for Monthly Employee");
							int check=Integer.parseInt(br.readLine());
							if(check==1){
								System.out.println("Enter Username");
								String user=br.readLine();
								System.out.println("Enter ID");
								int id1=Integer.parseInt(br.readLine());
								try{  
								    Class.forName("com.mysql.jdbc.Driver");  
								    Connection con=DriverManager.getConnection(  
								    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
								    //here sonoo is database name, root is username and password  
								    Statement stmt=con.createStatement();  
								    int t=stmt.executeUpdate("insert into HourlyEmployee(id,Name) values("+id1+",'"+user+"')");  
								    id1+=1;
								    //while(rs.next())  
								    //System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
								    System.out.println("Successfully Entered");
								    con.close();  

								    System.out.println("Enter 0 to exit Else any key to continue");
								    loop=Integer.parseInt(br.readLine());
								    }
								catch(Exception e)
								{
									 System.out.println(e);
								} 
							}


							if(check==2){
								System.out.println("Enter Username");
								String user=br.readLine();
								System.out.println("Enter ID");
								int id1=Integer.parseInt(br.readLine());
								try{  
								    Class.forName("com.mysql.jdbc.Driver");  
								    Connection con=DriverManager.getConnection(  
								    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
								    //here sonoo is database name, root is username and password  
								    Statement stmt=con.createStatement();  
								    int t=stmt.executeUpdate("insert into MonthlyEmployee(id,Name,MonthlySalary) values("+id1+",'"+user+"',0)");  
								    //id1+=1;
								    //while(rs.next())  
								    //System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
								    System.out.println("Successfully Entered");
								    con.close();  

								    System.out.println("Enter 0 to exit Else any key to continue");
								    loop=Integer.parseInt(br.readLine());
								    }
								catch(Exception e)
								{
									 System.out.println(e);
								} 
							}
							


					}
					
			}

			if(n==2) {
					try{  
								System.out.println("Enter ID for deletion");
								int iddel=Integer.parseInt(br.readLine());
								System.out.println("Enter the type of Employee");
								String str=br.readLine();
							    Class.forName("com.mysql.jdbc.Driver");  
							    Connection con=DriverManager.getConnection(  
							    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
							    //here sonoo is database name, root is username and password  
							    Statement stmt=con.createStatement();
							    int t=stmt.executeUpdate("delete from "+str+" where id="+iddel);
						}
										catch(Exception e)
										{
											 System.out.println(e);
										}  


			}

			if(n==3) {

				System.out.println("You're about to Enter HR Section!");
				HR H1=new HR();
				HR.payforday();
			}

			else {
				System.out.println("Shit ! Wrong Entry");
			}


		}
}