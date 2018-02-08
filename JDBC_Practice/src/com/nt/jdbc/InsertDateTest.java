package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InsertDateTest {
	private static  final String INSERT_QUERY="INSERT INTO PERSON_TAB VALUES(?,?,?,?)";

	public static void main(String[] args) {
		Scanner sc=null;
		int pnumber=0;
		String pname=null,dob=null,doj=null;
		Connection con=null;
		SimpleDateFormat sdf1=null,sdf2=null;
		java.util.Date udob=null,udoj=null;
		java.sql.Date sqdob=null,sqdoj=null;
		PreparedStatement ps=null;
		int result=0;
		try {
			//input required date
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter person number::");
				pnumber=sc.nextInt();
				System.out.println("Enter persone name::");
				pname=sc.next();
				System.out.println("Enter DOB::");
				dob=sc.next();
				System.out.println("Enter DOJ::");
				doj=sc.next();
			}
			
			//register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "nitin8855");
			//convert date values to java.sql.Date class objects
			
			//=>for dob(dd-MM-yyyy)
			sdf1=new SimpleDateFormat("dd-MM-yyyy");
			//gives java.util.Date class object
			udob=sdf1.parse(dob);
			//gives java.sql.Date class Object
			sqdob=new java.sql.Date(udob.getTime());
			
			//=>for doj (dd-MM-yyyy)
			sdf2=new SimpleDateFormat("dd-MM-yyyy");
			//gives java.util.Date class object
			udoj=sdf2.parse(doj);
			//gives java.sql.Date object class
			sqdoj=new java.sql.Date(udoj.getTime());
			
			//create preparedStatement object
			if(con!=null) {
				ps=con.prepareStatement(INSERT_QUERY);
			}
			//set value to query param
			if(ps!=null) {
				ps.setInt(1, pnumber);
				ps.setString(2, pname);
				ps.setDate(3, sqdob);
				ps.setDate(4, sqdoj);
			}
			//execute the query
			if(ps!=null) {
				result=ps.executeUpdate();
			}
			//process the result
			if(result==0) {
				System.out.println("record not inserted");
			}
			else {
				System.out.println("record is inserted");
			}
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally

	}//main

}//class
