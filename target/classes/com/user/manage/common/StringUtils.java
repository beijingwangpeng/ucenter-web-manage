package com.user.manage.common;

public class StringUtils {
	public static boolean isEmpty(Object obj){
		return obj==null || obj.toString().length()==0;
	}
	public static boolean isNotEmpty(Object obj){
		return obj!=null && obj.toString().length()>0;
	}
}
