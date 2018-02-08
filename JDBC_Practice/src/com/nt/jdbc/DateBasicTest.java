package com.nt.jdbc;

import java.text.SimpleDateFormat;

public class DateBasicTest {

	public static void main(String[] args) throws Exception{
		String s1="20-11-1990";//dd-MM-YYY
		String s2="1990-11-20";//yyyy-MM-dd
		SimpleDateFormat sdf=null, sdf1=null;
		java.util.Date ud1=null,ud2=null;
		java.sql.Date sqd1=null,sqd2=null;
		long ms=0;
		String s3=null;
		
		//converting string date value to java.util.Date class
		sdf=new SimpleDateFormat("dd-MM-yyyy");
		ud1=sdf.parse(s1);
		System.out.println("util date::"+ud1);
		ms=ud1.getTime();
		sqd1=new java.sql.Date(ms);
		System.out.println("sql date::"+sqd1);
		//we can convert string date value directly to java.sql.Date
		//String date pattern is in "yyyy-MM-dd";
		sqd2=java.sql.Date.valueOf(s2);
		System.out.println("sql date::"+sqd2);
		//converting java.sql.Date class object to java.util.Date
		ud2=(java.util.Date)sqd2;
		System.out.println("util date::"+ud2);
		
		//create SimpleDateFormate class object
		sdf1=new SimpleDateFormat("MMM-dd-yyyy");
		s3=sdf1.format(ud2);
		System.out.println("String date::"+s3);
	}

}
