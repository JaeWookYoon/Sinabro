package com.sinabro.util;

import java.util.Random;

public class MakeCode {

	private static final int CODELENG=6; 
	public static String makeCode() {
		Random ran=new Random();
		StringBuilder code=new StringBuilder();
		for(int i=0;i<CODELENG;i++) {
			
			code.append(String.valueOf(ran.nextInt(9)+1));
		}
		
		return code.toString();
	}
}
