package com.sinabro.util;

import java.util.Random;

public class Product_CodeMake {

	private static final int CODESIZE=6;
	
	public static String makeCode() {
		StringBuilder str=new StringBuilder();
		String[]code= {"1","2","3","4","5","6","7","8","9","0","a","b","c","d","e","f","g","h","i","j","k","l","n","m","o","p","s","q","r","s","x","y","w","z"};
		Random ran=new Random();
		for(int i=0;i<CODESIZE;i++) {
			str.append(code[ran.nextInt(code.length)]);
		}
		return str.toString();
		
		
	}
}
