package com.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import com.dbconnect.DBConnect;

 public class StudentInformation {
	Scanner sc=new Scanner(System.in);
	DBConnect db=new DBConnect();
	
	public void display(String admin)
	{
		if(admin.equals("student")) {
		System.out.println("1) Student Registration:\n"+
		"2) Please Login:\n"+
				"3) Log out");
		}
		else if(admin.equals("admin"))
		{
			System.out.println("please log in to admin account:");
			
		}
		else
		{
			System.err.println("Please enter a valid name");
		    display(admin);
	    }

    }
	
	public void studRegistration()
	{
		System.out.println("-------------------------------------------");
		 System.out.println("Enter your First Name>>");
		 String fname=sc.next();
		 System.out.println("Enter your last Name>>");
		 String lname=sc.next();
		 System.out.println("Enter your Username>>");
		 String uname= sc.next();
		 System.out.println("Enter your Password>>");
		 System.err.println("Please enter password with minimum 8 letters/use mix charactors");
		 String pass=sc.next();
		 if(pass.length()>=8)
		  {
			 System.out.println("Enter your City>>");
			 String city=sc.next();
			 System.out.println("Enter your MailId>>");
			 String  mail=sc.next();
			 System.out.println("Enter your Mobile No>>");
			 String Mobile=sc.next();
			 if( Mobile.length()<=10)
			 {
				  try {
						 db.setStudentData(fname, lname, uname, pass, city, mail, Mobile);
						 runApplication("student");
				     }
				  catch(Exception e)
				   {
					   e.printStackTrace();
				   }
			  }
			 else
			 {
				 System.err.println("Please enter a valid Mobile Number");
				 studRegistration();
			 }
		  }
		 else
		 {
			 System.err.println("Please enter a valid Password:");
			 studRegistration();
		 }
		 
	}
	
		  public void quiz()
		  {
			  System.out.println("Please select options 1,2,3 or 4 for below questions");
			  db.getQuestions();
			  System.out.println("Thank You for visiting Quiz application");
			  showData("student");
		  }

			public void login()
			{
				System.out.println("Enter Username>>");
				String username=sc.next();
				System.out.println("Enter password>>");
				String password=sc.next();
				boolean value= db.getloginDetails(username, password);
				if(value==true)
				{
					System.out.println(DBConnect.Username+" Sucessfully logged in");
				    showData("student");	  
				}
				else
				{
					System.err.println("Wrong Username and Password\n"+"User not found");
					runApplication("student");
				}
				
				
			}
		
			public void startApplication()
			{
				try {
				System.out.println("*********Welcome to Quiz Application********\n"+
					    "Are you a student or admin?(student/admin)");
						String aname=sc.next();
					if(aname.equals("student"))
						runApplication(aname);
				    else if(aname.equals("admin"))
				    	runApplication(aname);
				    else {
				    	System.err.println("Please Enter a valid name");
				    	startApplication();
				    }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
	     
			public void displayStudResult()
			{
				System.out.println("Enter student id>>");
				int id1=sc.nextInt();
				
				db.getDataById(id1);
				
			   showData("admin");
			}
			
			
			public void adminLogin()
			{
				System.out.println("Enter Username>>");
				String username=sc.next();
				System.out.println("Enter password>>");
				String password=sc.next();
				
				if(username.equals("admin") && password.equals("admin"))
				{
					System.out.println("Admin Succesfully logeed in");
					showData("admin");
				}
				else
				{
					System.err.println("Please enter correct user name or password");
					adminLogin();
				}
			}
			
			 public void displayAllStudResult()
			 {
			     	db.getResult();
			     	showData("admin");
						 
			 }
			 
			void  checkResult()
			 {
				
				System.out.println("Congratulations!! You got "+db.getMark()+" Marks");
				showData("student");
				 
			 }
			
			public void addQuestion()
			{
				 sc.nextLine();
				 System.out.println("Enter the Question>>");
				 String Que=sc.nextLine(); 
				 
				 System.out.println("Enter 1st Option>>");
				 String opt1=sc.nextLine();
				 
				 System.out.println("Enter 2nd Option>>");
				 String opt2= sc.nextLine();
				
				 System.out.println("Enter 3rd Option>>");
				 String opt3= sc.nextLine();
				
				 System.out.println("Enter 4th Option>>");
				 String opt4=sc.nextLine();
				 
				 System.out.println("Enter the correct option>>");
				 int Ans=sc.nextInt();
				 
				 try {
				 db.setQuestions(Que, opt1, opt2, opt3, opt4, Ans);
				 }
				 catch(Exception e){
					 e.printStackTrace();
				 }
				 
				 showData("admin");
				 
			}
			
			public void runApplication(String name)
			{
				
				display(name);
				if(name.equals("admin"))
				{
					adminLogin();
				}
				else
				{
				System.out.println("Enter your choice:");
				int choice=sc.nextInt();
			    if(choice<4) {
				switch(choice)
				{
				case 1:
					if(name.equals("student"))
					  studRegistration();
					else
						adminLogin();
				break;
				
				case 2:
					 login();
				break;
				
				case 3:
					System.out.println("Are you sure(yes/no)?");
					String logout=sc.next();
					if(logout.equals("yes")) {
						System.out.println("User has been logged out");
						startApplication();
					}
					else
					{
						display("student");
					}
				
				default:
					System.out.println("Thank You for Visiting us!");
				break;
				}
			   }
			   else
			    {
			    	System.err.println("Please enter a valid choice:");
			    	runApplication(name);
			    }
		    }
		}
			
			void dataDisplay(String name)
			{
			System.out.println("Enter your choice:");
			int no=sc.nextInt();
			if(no>=2 && no<6) {
			switch(no) {
			case 2:
				if(name.equals("admin"))
					displayAllStudResult();
			
			case 3:
				if(name.equals("student"))
				  quiz();
				else
				  displayStudResult();
			break;
			
			case 4:
				if(name.equals("student"))
				  checkResult();
				else
				  addQuestion();
			break;
			
			case 5:
				if(name.equals("student"))
					  runApplication("student");
					else
					  startApplication();
				
			break;
			
			default:
				startApplication();
			break;
			}
		  }	
			else
			{
				System.err.println("Please enter a valid choice");
				dataDisplay(name);
			}
		}
	
	
			public void showData(String admin)
			{
				if(admin.equals("student")) {
					System.out.println("------------------------------------\n"+
					"3) take a quiz:\n"+
					"4) Check Result :\n"+
							"5) Want to go back?");
					dataDisplay(admin);
					
					}
				   
					else if(admin.equals("admin"))
					{
						System.out.println("------------------------------------\n"+
					    "2) Display all student results:\n"+
					    "3) Want to access perticular student data?\n"+
						 "4) Add Question\n"
					    +"5) Want to go back?");
						dataDisplay(admin);
					}
					else
					{
						System.err.println("Please login first");
						display(admin);
					
				    }
			 }
	
	
}
