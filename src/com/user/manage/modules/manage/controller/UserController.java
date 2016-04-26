package com.user.manage.modules.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dc.penguinMVC.annotation.Controller;
import org.dc.penguinMVC.annotation.RequestMapping;

import com.user.manage.common.AppUtils;
import com.user.manage.common.Common;
import com.user.manage.common.ObjectFactory;
import com.user.manage.entity.LocalUser;
import com.user.manage.entity.Page;
import com.user.manage.entity.User;
import com.user.manage.modules.manage.service.UserDataService;

@Controller
@RequestMapping("/manage")
public class UserController {
	/*private String text = Message.Text.SUCCESS();
	private String code = Message.Code.SUCCESS;*/

	private static Log logger = LogFactory.getLog(UserController.class);
	private UserDataService userDataService = ObjectFactory.getSingletonByProxy(UserDataService.class);
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			LocalUser user = userDataService.login(username,password);
			if(user!=null){
				return "/WEB-INF/index.jsp";
			}
		} catch (Exception e) {
			logger.error("",e);
		}
		return "/WEB-INF/user/login.jsp";
	}
	@RequestMapping("/userQuery")
	public String userQuery(HttpServletRequest request){
		try {
			String myurl = request.getParameter("myurl");
			if(myurl!=null){
				HttpSession session = request.getSession();
				session.setAttribute(Common.myurl_key, request.getParameter("myurl"));
				session.setAttribute(Common.tId_key, request.getParameter("tId"));
			}
			User u = AppUtils.parseObj(request, User.class);
			String pno = request.getParameter("pageNo");
			long pageNo = 0;
			if(pno==null){
				pageNo = 1;
			}else{
				pageNo = Long.parseLong(request.getParameter("pageNo"));
			}
			
			Page page = userDataService.userQuery(u,pageNo);
			request.setAttribute("page", page);
		} catch (Exception e) {
			logger.error("",e);
		}
		return "/WEB-INF/index.jsp";
	}
	@RequestMapping("/userDetails")
	public String userDetails(HttpServletRequest request){
		try{
			long UID =Long.parseLong(request.getParameter("UID"));
			User user = userDataService.userDetails(UID);
			request.setAttribute("user", user);
		}catch(Exception e){
			logger.error("",e);
		}
		return "/WEB-INF/user/userQuery/userDetails.jsp";
	}
	@RequestMapping("/userUpdate")
	public String userUpdate(HttpServletRequest request){
		User u =null;
		boolean flag = false;
		try{
			u = AppUtils.parseObj(request, User.class);
			flag = userDataService.userUpdate(u);
		}catch(Exception e){
			logger.error("",e);
		}
		request.setAttribute("flag", flag);
		return "/manage/userDetails?UID="+u.getUID();
	}
	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request){
		boolean flag = false;
		try{
			flag = userDataService.deleteUser(request.getParameter("idlist"));
			request.setAttribute("flag", flag);
			this.userQuery(request);
		}catch(Exception e){
			logger.error("",e);
		}
		return "/WEB-INF/index.jsp";
	}
	@RequestMapping("/userImport")
	public String userImport(HttpServletRequest request){
		String myurl = request.getParameter("myurl");
		if(myurl!=null){
			HttpSession session = request.getSession();
			session.setAttribute(Common.myurl_key, request.getParameter("myurl"));
			session.setAttribute(Common.tId_key, request.getParameter("tId"));
		}
		return "/WEB-INF/index.jsp";
	}
}
