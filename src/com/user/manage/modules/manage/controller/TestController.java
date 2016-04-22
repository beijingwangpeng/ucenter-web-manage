package com.user.manage.modules.manage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dc.penguinMVC.annotation.Controller;
import org.dc.penguinMVC.annotation.RequestMapping;


@Controller
@RequestMapping("/manage")
public class TestController {
	@RequestMapping("/testApi")
	public void test(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//System.out.println(uid[0]+""+uid[1]);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(request.getParameter("uid"));
		out.flush();
		out.close();
	}
}
