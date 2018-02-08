package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteTest {

	public static void main(String[] args) throws Exception {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		// read input
		sc=new Scanner(System.in);
		System.out.println("Delete the student no::");
		int sno=sc.nextInt();
		
		
		//register driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//make connection 
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "nitin8855");
		//query
		String query="delete from student where sno=?";
		System.out.println(query);
		//prepareStatement
		ps=con.prepareStatement(query);
		ps.setInt(1, sno);
		result=ps.executeUpdate();
		if(result==0) {
			System.out.println("record not deleted");
		}
		else {
			System.out.println("record is deleted");
		}
		
		//close object
		ps.close();
		con.close();
		sc.close();

	}

}
