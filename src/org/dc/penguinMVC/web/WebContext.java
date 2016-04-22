package org.dc.penguinMVC.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * web容器上下文
 * @author 北京-企鹅
 * @time 2016-01-17 01:05
 */
public class WebContext {
	public static ThreadLocal<HttpServletRequest> requestLocal= new ThreadLocal<HttpServletRequest>();   
	public static ThreadLocal<HttpServletResponse> responseLocal= new ThreadLocal<HttpServletResponse>();   
    public static HttpServletRequest getRequest(){
    	return requestLocal.get();
    }
    public static HttpServletResponse getResponse(){
    	return responseLocal.get();
    }
}
