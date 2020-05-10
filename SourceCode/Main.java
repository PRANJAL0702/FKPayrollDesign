import java.io.*;
import java.sql.*;  
import java.util.Scanner;
public class Main {
	public static void main(String args[]) throws IOException{
		Scanner sc=new Scanner(System.in);

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Hey! Welcome to Payroll System");
		System.out.println("\tPress 1 for Admin Rights \n \t Press 2 for Employee \n \t Press 3 to Enter as A Union");
		int a=sc.nextInt();
		if(a==1) {
			//Administrator a1=new Administrator();
			//System.out.println("\n \n");
			int q=1;
			String name;
			String password;
			System.out.println("Enter Your Credentials");
			System.out.println("Username: ");
			name=br.readLine();
			System.out.println("Password: ");
			password=br.readLine();
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


		if(a==2) {

			System.out.println("Hey! \n Press 1 for Hourly Employee \n Press 2 for Monthly Employee");
			int t=Integer.parseInt(br.readLine());

			if(t==1) {

				System.out.println("Hey! Please Enter Your ID");
				int empidhr=Integer.parseInt(br.readLine());
				System.out.println("Please Enter Your Password");
				String pass1=br.readLine();
				passwordcheckforemployee p1=new passwordcheckforemployee();
				int val=p1.passcheck(empidhr,pass1,"HourlyEmployee");
				if(val==1) {
					HourlyEmployee e1=new HourlyEmployee();
					System.out.println("Do you want to punch your Card? Press 1 \n Press 2 for Changing Hourly Rate \n Press 3 for Changing Mode Of Payment \n Press 4 for Setting Commission \n Press 5 for Submitting Commission");
					int a2=Integer.parseInt(br.readLine());
					if(a2==1) {
						e1.submitdailycard(empidhr);
					}

					if(a2==2) {
						e1.hourlyrate(empidhr);
					}

					if(a2==3) {
						e1.modeofpayment(empidhr);
					}

					if(a2==4) {
						e1.setCommission(empidhr);
					}
					if(a2==5) {
						e1.submitCommission(empidhr);
					}
				}
				else {
					System.out.println("Login Failure!");
				}
				
			}

			if(t==2) {
				System.out.println("Hey! Please Enter Your ID");
				
				int empidmo=Integer.parseInt(br.readLine());
				System.out.println("Please Enter Your Password");
				String pass1=br.readLine();
				passwordcheckforemployee p1=new passwordcheckforemployee();
				int val=p1.passcheck(empidmo,pass1,"MonthlyEmployee");
				if(val==1) {
					MonthlyEmployee m1=new MonthlyEmployee();
					System.out.println("Press 1 to Change Mode of Payment \n Press 2 for Setting Your Salary \n Press 3 for Setting Commission \n Press 4 for Submitting Commission");

					int a2=Integer.parseInt(br.readLine());
					if(a2==1) {
						m1.modeofpayment(empidmo);
					}
					if(a2==2) {
						m1.setMonthlySalary(empidmo);
					}
					if(a2==3) {
						m1.setCommission(empidmo);
					}
					if(a2==4) {
						m1.submitCommission(empidmo);
					}
				}
			}
		}

		if(a==3) {
			Union u1=new Union();
			u1.addtax();
		}


		else {
			System.out.println("Login Again");
		}
	}
}


