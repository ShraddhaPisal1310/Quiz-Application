package com.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class DBConnect {
   
	 public Connection connection;
	 PreparedStatement ps,ps2;
	 ResultSet rs,rs2;
	 
	 Scanner sc=new Scanner(System.in);
	 static public String Username="";
	 public static int id;
	 public String acctype="";
	 
	 public void makeConnection(){
      try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","scity");
			//System.out.println("successful");
			//connection.close();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
		
    	   
		public void getResult() {
			makeConnection();
			String Query="select firstname,lastname,result from student order by firstname";
			try {
				ps=connection.prepareStatement(Query);
				rs=ps.executeQuery();
				while(rs.next())
				{
					System.out.println("FirstName>>"+rs.getString(1));
					System.out.println("LastName>>"+rs.getString(2));
					System.out.println("Score is>>"+rs.getInt(3));
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
			
			}
		    
		
      
      
     public void setStudentData(String fname, String lname, String uname, String Pass, String city, String Mailid, String Mobile)
      {
    	    makeConnection();
    	    String Query="insert into student"+"(firstname,lastname,username,password,city,mailid,mobileno)"+"values(?,?,?,?,?,?,?);";
    	 try {   
    		    ps= connection.prepareStatement(Query);
				ps.setString(1, fname);
				ps.setString(2, lname);
				ps.setString(3, uname);
				ps.setString(4, Pass);
				ps.setString(5, city);
				ps.setString(6, Mailid);
				ps.setString(7, Mobile);
				//ps.setString(8, "student");
				//ps.setString(9,null);
				int i=ps.executeUpdate();
				System.out.println("successfully reagistered");
				
				ps.close();
				connection.close();
				//connection.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 
      }
     
     public boolean getloginDetails(String User, String Pass)
     {
    	  makeConnection();
    	  String Query= "select * from student where username='"+User+"'and password='"+Pass+"';";
    	  try {
    		  ps=connection.prepareStatement(Query);
			 ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				//System.err.println(rs.getString(4));
				if(rs.getString(4).equals(User) && rs.getString(5).equals(Pass))
				{
				    Username=rs.getString(4);
				    id=rs.getInt(1);
				   // acctype=rs.getString(10);
					return true;
				}
				
            
			}	
			  rs.close();
	    	  ps.close();
	    	  connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return false;
     }
     
     public void setQuestions(String Que, String opt1, String opt2, String opt3, String opt4, int Ans)
     {
    	 makeConnection();
    	 String addQuery="INSERT INTO question (question,opt1,opt2,opt3,opt4,answer) VALUES (?,?,?,?,?,?);";
    	 try {
			ps=connection.prepareStatement(addQuery);
			ps.setString(1, Que);
			ps.setString(2, opt2);
			ps.setString(3, opt2);
			ps.setString(4, opt3);
			ps.setString(5, opt4);
			ps.setInt(6, Ans);
			ps.execute();
			System.out.println("Question added succesfully");
			ps.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	 
    	 
     }
     
	     public void getQuestions()
	     { 
	    	 int mark=0,ref=1;
	    	 makeConnection();
	    	 String Query1="select question, opt1,opt2,opt3,opt4,answer from user.question order by rand();";
	    	 try {
				ps=connection.prepareStatement(Query1);
				rs=ps.executeQuery();
				int ans;
				while(rs.next())
				{
					 System.out.println(ref+")"+rs.getString(1));
					 System.out.println("1 "+rs.getString(2));
					 System.out.println("2 "+rs.getString(3));
					 System.out.println("3 "+rs.getString(4));
					 System.out.println("4 "+rs.getString(5));
					 System.out.print("Please select option>>");
					 ans=sc.nextInt();
					 if(ans<5 && ans>0)
					 {
						  if( rs.getInt(6)==ans)
						  {
							  mark+=1;
						  }
					 }
					   
					 else {
						 System.err.println("Please choose valid option/Reattempt the Quiz");
						 getQuestions();
					 }
					 ref++;
					
				 }
				// rs.close();
				 ps.close();
				 connection.close();
				
	    	 } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
	    	 setMark(mark);
	    	 
     }      
      
	        void setMark(int mark)
	        {
	         makeConnection();
	        	try {
					ps2=connection.prepareStatement("update student set result=? where Id=?");
					ps2.setInt(1, mark);
					ps2.setInt(2, id);
					ps2.executeUpdate();
					System.out.println(Username+" your result has been successfully saved....");
					ps2.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        	
	        }
	        
	        public int getMark()
	        {
	        	int getResult=0;
	        	makeConnection();
	        	try {
					ps=connection.prepareStatement("select result from student where id=? and username=?");
					ps.setInt(1, id);
					ps.setString(2, Username);
					rs=ps.executeQuery();
					while(rs.next())
					{
					getResult=rs.getInt(1);
					}
					//rs.close();
					ps.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	return getResult;
	        }
	        
	       public void getDataById(int id1)
	        {
	    	       int score=0;
	    	       String grade="",firstname="";
	        	   makeConnection();
	        	 
	        		int total;
	        		int m=0;
					try {
						ps=connection.prepareStatement("select firstname, result from student where id=?");
					
					ps2=connection.prepareStatement("select count(Qid) from question");
					ps.setInt(1, id1);
					rs=ps.executeQuery();
					rs2=ps2.executeQuery();
					while(rs2.next())
					{
						m=rs2.getInt(1);
					}
					rs2.close();
					
					while(rs.next())
					{
						score=rs.getInt(2);
						firstname=rs.getString(1);
					}
					
					 rs.close();
						ps.close();
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	 
						 
						 total=(score*100/m);
						 if(total>=75)
							 grade="Distinction";
						 else if(total<75 && total>=60)
						     grade="Firstclass";
						 else if(total<60 && total>=32)
							 grade="Pass";
						 else
							 grade="Fail";
						 
						 if(score>0)
							{
								System.out.println("Firstname>>"+firstname);
								System.out.println("Score is>>"+score);
								System.out.println("Grade>>"+grade);
							}
						 else
						 {
							 System.out.println("Please enter valid ID:");
						 }
						 
						
						
	                 }
					
				
					

	          }
	 

