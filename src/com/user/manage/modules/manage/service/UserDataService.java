package com.user.manage.modules.manage.service;

import java.util.ArrayList;
import java.util.List;

import org.dc.jdbc.helper.DBHelper;

import com.user.manage.common.Configure;
import com.user.manage.common.StringUtils;
import com.user.manage.entity.LocalUser;
import com.user.manage.entity.Page;
import com.user.manage.entity.User;

public class UserDataService {
	private DBHelper manageHelper = new DBHelper(Configure.ucenter_user_manageSourceTest);
	private DBHelper ucenterHelper = new DBHelper(Configure.ucenterSourceTest);
	
	public LocalUser login(String username,String password) throws Exception {
		LocalUser user = manageHelper.selectOne("$user.getOneUserInfo",LocalUser.class, username,password);
		return user;
	}

	public Page userQuery(User u,long pageNo) throws Exception {
		Page page = new Page();
		String sql = "select * from user where 1=1 ";
		StringBuilder whereSql =new StringBuilder();
		List<Object> paramlist =new ArrayList<Object>();
		if(StringUtils.isNotEmpty(u.getUID())){
			whereSql.append(" and UID =? ");
			paramlist.add(u.getUID());
		}
		if(StringUtils.isNotEmpty(u.getPASSPORT())){
			whereSql.append(" and PASSPORT =? ");
			paramlist.add(u.getPASSPORT());
		}
		if(StringUtils.isNotEmpty(u.getREAL_NAME())){
			whereSql.append(" and REAL_NAME like ? ");
			paramlist.add("%"+u.getREAL_NAME()+"%");
		}
		if(StringUtils.isNotEmpty(u.getMOBILE())){
			whereSql.append(" and MOBILE like ? ");
			paramlist.add("%"+u.getMOBILE()+"%");
		}
		//计算页面总数
		page.setRecordCount(ucenterHelper.selectOne("select count(*) from user where 1=1 "+whereSql.toString(), Long.class,paramlist));
		page.setPageNo(pageNo);
		whereSql.append(" limit ?,?");
		paramlist.add(page.getFirstIndex());
		paramlist.add(page.getPageSize());
		
		
		page.setDataList(ucenterHelper.selectList(sql+whereSql.toString(),User.class,paramlist));
		return page;
	}

	public User userDetails(long uID) throws Exception{
		
		return null;
	}
}
