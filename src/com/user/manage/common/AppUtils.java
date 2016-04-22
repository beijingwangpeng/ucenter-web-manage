package com.user.manage.common;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dc.penguinMVC.web.WebContext;
import org.dc.utils.ClassesUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * app请求相关处理
 * @author 北京-企鹅
 * @time 2016-01-17 01:05
 */
public class AppUtils {
	private static Log logger = LogFactory.getLog(AppUtils.class);
	private static ObjectMapper objectMapper = new ObjectMapper();
	public static void outJsonData(Object data){
		PrintWriter out = null;;
		try {
			String jsonStr = objectMapper.writeValueAsString(data);
			HttpServletResponse response = WebContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			out.print(jsonStr);
		} catch (Exception e) {
			logger.error("",e);
		}finally{
			if(out!=null){
				try{
					out.flush();
				} catch (Exception e) {
					logger.error("",e);
				}
				try{
					out.close();
				} catch (Exception e) {
					logger.error("",e);
				}
			}
		}
	}
	public static void outData(String data){
		PrintWriter out = null;;
		try {
			HttpServletResponse response = WebContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			out.print(data);
		} catch (Exception e) {
			logger.error("",e);
		}finally{
			if(out!=null){
				try{
					out.flush();
				} catch (Exception e) {
					logger.error("",e);
				}
				try{
					out.close();
				} catch (Exception e) {
					logger.error("",e);
				}
			}
		}
	}

	public static void outInter(String code,String text,Object data){
		PrintWriter out = null;;
		try {
			Map<String, Object> jsonMap=new HashMap<String, Object>();
			jsonMap.put("code", code);
			jsonMap.put("desc", text);
			if(data==null){
				data = "";
			}
			jsonMap.put("data", data);
			String jsonStr = objectMapper.writeValueAsString(jsonMap);
			HttpServletResponse response = WebContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			out.print(jsonStr);
		} catch (Exception e) {
			logger.error("",e);
		}finally{
			if(out!=null){
				try{
					out.flush();
				} catch (Exception e) {
					logger.error("",e);
				}
				try{
					out.close();
				} catch (Exception e) {
					logger.error("",e);
				}
			}
		}
	}
	@SuppressWarnings("unchecked")
	public static <T> T parseObj(HttpServletRequest request,Class<T> cls) throws Exception{
		Object obj_newInsten = cls.newInstance();
		Map<String,String[]> map = request.getParameterMap();
		Field[] fields = cls.getDeclaredFields();
		for (int j = 0,j_len=fields.length; j <j_len; j++) {
			Field fd = fields[j];
			Class<?> classType = fd.getType();
			if(map.containsKey(fd.getName())){
				String[] values = map.get(fd.getName());
				fd.setAccessible(true); //
				fd.set(obj_newInsten,ClassesUtils.convert(classType, values));
			}
		}
		return (T) obj_newInsten;
	}
}
