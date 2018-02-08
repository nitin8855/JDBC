package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) throws Exception{
		// read input
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no::");
		int sno=sc.nextInt();
		System.out.println("Enter name::");
		String name=sc.next();
		System.out.println("ENter address::");
		String sadd=sc.next();
		
		name="'"+name+"'";
		sadd="'"+sadd+"'";
		//register driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","nitin8855");
		//create statement
		Statement st=con.createStatement();
		//prepare sql qi=uery
		String query="insert into student values("+sno+","+name+","+sadd+")";
		System.out.println(query);
		//send and execute the query
		int result=st.executeUpdate(query);
		//process the result
		if(result==0)
			System.out.println("record not inserted");
		else
			System.out.println("record is inserted");
		//close jdbc objects
		st.close();
		con.close();
		sc.close();

	}//main
}//class
