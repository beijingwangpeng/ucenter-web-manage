package com.user.manage.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 时间工具类
 * @author 北京-企鹅
 * @time 2015-03-05
 * @version 1.0
 */
public class DateUtils{
	/** 将日期精确到天 yyyy-MM-dd*/
	public static final String DATE = "yyyy-MM-dd";
	/** 将日期精确到秒 yyyy-MM-dd HH:mm:ss */
	public static final String DATE_SECOND = "yyyy-MM-dd HH:mm:ss";
	/** 将日期精确到秒 MM-dd */
	public static final String MONTH_DAY = "MM-dd";
	/** 将日期精确到毫秒yyyy-MM-dd HH:mm:ss:SSS */
	public static final String DATE_MILLISECOND = "yyyy-MM-dd HH:mm:ss:SSS";
	
	/**
	 * 传入时间格式，得到当前时间
	 * @param format
	 * @return 时间字符串
	 */
	public static String getNow(String format){
		return DateUtils.parseString(format, new Date());
	}
	
	/**
	 * 格式化
	 * @param format 格式类型
	 * @param param 传入参数要么是Date类型，要么是自1970 年 1 月 1 日 00:00:00 GMT 以来的毫秒数
	 * @return
	 */
	public static String parseString(String format,Date param){
		SimpleDateFormat sFormat = null;
		String strDate = "";
		try{
			sFormat = new SimpleDateFormat(format);
			strDate = sFormat.format(param);
		}catch(Exception e){
			e.printStackTrace();
		}
		return strDate;
	}
	/**
	 * 格式化
	 * @param format 格式类型
	 * @param param 传入参数要么是Date类型，要么是自1970 年 1 月 1 日 00:00:00 GMT 以来的毫秒数
	 * @return
	 */
	public static String parseString(String format,long param){
		SimpleDateFormat sFormat = null;
		String strDate = "";
		try{
			sFormat = new SimpleDateFormat(format);
			strDate = sFormat.format(param);
		}catch(Exception e){
			e.printStackTrace();
		}
		return strDate;
	}
	/**
	 * 将2015-01-02 11:11:10转化为long类型
	 * @param format
	 * @param param
	 * @return
	 */
	public static long parseLong(String format,String param){
		SimpleDateFormat sFormat = null;
		try{
			sFormat = new SimpleDateFormat(format);
			Date strDate = sFormat.parse(param);
			return strDate.getTime();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) throws ParseException {
		/*Date d = new Date();
		System.out.println("当前时间是"+d.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd"); 
		System.out.println(sdf.format(1419824028000L));
		String date ="2014-12-08 23:59:59";
		System.out.println(((Date)sdf.parse(date)).getTime()/1000);
		String date2 ="2014-12-08 00:00:00";
		System.out.println(((Date)sdf.parse(date2)).getTime()/1000);*/
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format("2011-11-11"));*/
	}
}
