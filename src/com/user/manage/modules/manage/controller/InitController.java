package com.user.manage.modules.manage.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dc.penguinMVC.annotation.Controller;
import org.dc.penguinMVC.annotation.RequestMapping;

import com.user.manage.common.AppUtils;
import com.user.manage.common.ObjectFactory;
import com.user.manage.entity.NavTree;
import com.user.manage.modules.manage.service.CommonService;

@Controller
@RequestMapping("/manage")
public class InitController {
	private static Log logger = LogFactory.getLog(InitController.class);
	private CommonService commonService = ObjectFactory.getSingletonByProxy(CommonService.class);
	@RequestMapping("/initTree")
	public void initTree(){
		List<NavTree> navList = null;
		try {
			navList = commonService.initTree();
		} catch (Exception e) {
			logger.error("",e);
		}finally{
			AppUtils.outJsonData(navList);
		}
	}
}
