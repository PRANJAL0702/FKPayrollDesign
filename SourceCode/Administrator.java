import java.io.*;
import java.sql.*;  
import java.util.Scanner;
import java.sql.*;
class Administrator {

		private String Username;

		Administrator(String Username) {
			this.Username=Username;
		}

		public void Function() throws IOException{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Hey! You Have Sucessfully Entered Your Credentials");
			System.out.println("Can You Please Enter Your Desired Work: \n \t Press 1 to Enter a New Employee \n \t");

			int n=Integer.parseInt(br.readLine());


			if(n==1) {

					int loop=1;
					while(loop==1){
							System.out.println("Enter Username");
							String user=br.readLine();
							System.out.println("Enter ID");
							int id=Integer.parseInt(br.readLine());
							try{  
							    Class.forName("com.mysql.jdbc.Driver");  
							    Connection con=DriverManager.getConnection(  
							    "jdbc:mysql://localhost:3306/Flipkart?characterEncoding=latin1","root","178048");  
							    //here sonoo is database name, root is username and password  
							    Statement stmt=con.createStatement();  
							    int t=stmt.executeUpdate("insert into employee(id,user) values("+id+",'"+user+"')");  
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

			else {
				System.out.println("Shit ! Wrong Entry");
			}


		}
}