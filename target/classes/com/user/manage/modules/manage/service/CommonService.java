package com.user.manage.modules.manage.service;

import java.util.List;

import org.dc.jdbc.helper.DBHelper;

import com.user.manage.common.Configure;
import com.user.manage.entity.NavTree;

public class CommonService {
	public static DBHelper manageHelper = new DBHelper(Configure.ucenter_user_manageSourceTest);
	public List<NavTree> initTree() throws Exception{
		return manageHelper.selectList("$common.getTreeInfo",NavTree.class);
	}
}
