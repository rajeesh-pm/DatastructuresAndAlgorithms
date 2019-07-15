package com.learning.utils;

import java.util.regex.Pattern;

public class PatternMatch {
	//"yyyy-MM-dd HH:mm:ss.SSSSSS"
	
	
	public static void main(String args[]) throws Exception {
		String inputString = "1file_1988:03:29 01:30:20.extension";
		Pattern p = Pattern.compile("1file_\\d{4}[:]?\\d{1,2}[:]?\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}.extension");
		System.out.println(p.matcher(inputString).matches());
	}
}
