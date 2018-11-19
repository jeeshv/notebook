package com.huawei.notebook.utils;



import java.util.Scanner;


public class DaNiu {
	
	@SuppressWarnings("resource")
	public static int getInt(){
		return new Scanner(System.in).nextInt();
	}
	
	@SuppressWarnings("resource")
	public static String getStr(){
		return new Scanner(System.in).next();
	}
    
}