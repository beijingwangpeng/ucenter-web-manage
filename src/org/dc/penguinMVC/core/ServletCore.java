package org.dc.penguinMVC.core;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dc.penguinMVC.annotation.Controller;
import org.dc.penguinMVC.annotation.RequestMapping;
import org.dc.penguinMVC.handle.RequestHandle;
import org.dc.penguinMVC.interceptor.HandlerInterceptor;
import org.dc.penguinMVC.web.RequestInit;
import org.dc.penguinMVC.web.WebContext;
import org.dc.utils.ClassesUtils;
/**
 * servlet核心
 * @author 北京-企鹅
 * @time 2016-01-17 01:05
 */
public class ServletCore implements Servlet{
	private static String webName = null; 
	private static List<HandlerInterceptor> interceptorList = new ArrayList<HandlerInterceptor>();
	public static Log log = LogFactory.getLog(ServletCore.class);
	public void destroy() {
		System.out.println("ServletCore.destroy()");
	}

	public ServletConfig getServletConfig() {
		System.out.println("ServletCore.getServletConfig()");
		return null;
	}

	public String getServletInfo() {
		System.out.println("ServletCore.getServletInfo()");
		return null;
	}
	public void init(ServletConfig config) throws ServletException {
		try {
			log.info("服务名:"+config.getServletName());
			webName = config.getServletContext().getContextPath();
			log.info("应用web目录名称："+webName);
			
			String basePackage = config.getInitParameter("basePackage");

			//初始化拦截器
			this.initInterceptor(config);
			/*String[] interceptorArr = interceptor.split(",");
			for (int i = 0; i < interceptorArr.length; i++) {
				Class<?> clazz = Class.forName(interceptorArr[i]);
				HandlerInterceptor inter = (HandlerInterceptor) clazz.newInstance();
				interceptorList.add(inter);
			}*/


			String[] bases = basePackage.split(",");
			//绝对地址
			String basePath = null;
			URL resource =  this.getClass().getResource(".");
			if(resource==null){
				basePath = this.getClass().getResource("/").getPath();
			}else{
				basePath = resource.getPath();
				basePath = basePath.substring(0,basePath.indexOf("/WEB-INF/classes/")+17);
			}
			//String path = ServletCore.class.getResource("/").getPath();
			for (int k = 0; k < bases.length; k++){
				String packName = bases[k];//com.dc.controller
				String readPath = basePath+packName.replace(".", "/");
				log.info("controller层文件目录："+readPath);
				File file = new File(readPath);

				// 以.class结尾的文件(编译好的java类文件)
				File[] dirfiles = file.listFiles(new FileFilter() {
					public boolean accept(File file) {
						return file.getName().endsWith(".class");
					}
				});
				for (int i = 0; i < dirfiles.length; i++) {
					File f = dirfiles[i];
					String fileStr = f.getPath();//src/com/dc/Controller/UserController.class
					String classDir = packName+"."+fileStr.substring(fileStr.lastIndexOf(File.separator)+1,fileStr.lastIndexOf("."));
					log.info("正在初始化控制层注解配置:"+classDir+".class");
					//这里用forName有一些不好，会触发static方法，没有使用classLoader的load干净
					Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(classDir);
					Controller c = clazz.getAnnotation(Controller.class);
					if(c!=null){
						RequestMapping r = clazz.getAnnotation(RequestMapping.class);
						String requestSuperUrl = r.value();
						Method[] methods = clazz.getDeclaredMethods();

						for (int j = 0; j < methods.length; j++) {
							Method m = methods[j];
							RequestMapping  requestAnno = m.getAnnotation(RequestMapping.class);
							if(requestAnno!=null){
								String requestURL = requestSuperUrl + requestAnno.value();
								RequestHandle info = new RequestHandle();
								info.setClazz(clazz);
								info.setMethodName(m.getName());
								info.setParameterTypes(m.getParameterTypes());
								try{
									info.setParamName(ClassesUtils.getMethodParamNames(clazz.getName(),m.getName()));
								}catch(Exception e){
									log.error("反射获取方法名异常",e);
								}
								log.info("请求映射地址："+requestURL);
								RequestInit.put(webName+requestURL, info);
							}
						}
					}
				}

			}
		} catch (Exception e) {
			log.error("初始化异常",e);
		}  
	}

	public void service(ServletRequest request, ServletResponse response)throws ServletException, IOException {
		RequestHandle requestHandle = null;
		HttpServletRequest req = null;
		HttpServletResponse resp = null;
		try{
			req = (HttpServletRequest) request;
			resp = (HttpServletResponse) response;
			//设置线程上下文参数
			WebContext.requestLocal.set(req);
			WebContext.responseLocal.set(resp);

			//设置请求字符编码
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html; charset=utf-8");
			resp.setCharacterEncoding("utf-8");

			String servletPath = req.getRequestURI();
			//String urlKey = null;
			/*if(servletPath.endsWith(".jsp")){
				resp.sendRedirect(servletPath);
				//req.getRequestDispatcher(servletPath).forward(req, resp);
				return;
			}*/
			/*if(servletPath.indexOf(".")!=-1){
				urlKey = servletPath.substring(0, servletPath.indexOf("."));
			}else{
				urlKey = servletPath;
			}*/
			
			requestHandle = RequestInit.get(servletPath);
			for (int i = 0; i < interceptorList.size(); i++) {
				interceptorList.get(i).before(requestHandle);
			}
			if(requestHandle==null){//请求不到资源
				throw new ServletException("请求地址有误，未找到资源");
			}
			Object url = requestHandle.excute(req.getParameterMap(),request,response,req.getSession());
			if(url !=null ){
				String outUrl = url.toString();
				if(outUrl.startsWith("redirect://")){
					resp.sendRedirect(outUrl.substring(9,outUrl.length()));
				}else{
					req.getRequestDispatcher(outUrl).forward(req, resp);
				}
			}
		}catch(ServletException e){
			throw e;
		} catch (Exception e) {
			resp.setStatus(404);
			this.printException(e);
		}finally {
			for (int i = 0; i < interceptorList.size(); i++) {
				try {
					interceptorList.get(i).after(requestHandle);
				} catch (Exception e) {
					log.error("",e);
				}
			}
		}
	}
	public void initInterceptor(ServletConfig config){
		try{
			String interceptor = config.getInitParameter("interceptor");
			String[] interceptorArr = interceptor.split(",");
			for (int i = 0; i < interceptorArr.length; i++) {
				Class<?> clazz = Class.forName(interceptorArr[i]);
				HandlerInterceptor inter = (HandlerInterceptor) clazz.newInstance();
				interceptorList.add(inter);
			}
		}catch(Exception e){
			log.error("拦截器初始化失败",e);
		}
	}
	public void printException(Exception e){
		log.error("",e);
		String info = "";
		StackTraceElement[] trace = e.getStackTrace();
		info += "<pre>";
		for (StackTraceElement s : trace) {
			info += "\t " + s + "\r\n";
		}
		info = e.toString()+"\r\n"+info;
		info += "</pre>";
		PrintWriter out = null;
		try{
			out = WebContext.getResponse().getWriter();
			out.print(info);
			out.flush();
		}catch (Exception ex) {
			log.error("",ex);
		}finally{
			if(out!=null){
				out.close();
			}
		}

	}
}
