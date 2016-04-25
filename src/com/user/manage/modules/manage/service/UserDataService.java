package com.user.manage.modules.manage.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dc.jdbc.anno.Transactional;
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
	
	public User userDetails(long UID) throws Exception{
		
		return ucenterHelper.selectOne("$user.getUserDetails", User.class,UID);
	}
	@Transactional
	public boolean userUpdate(User u) throws Exception {
		u.setMODIFY_TIME(new Date());
		int rowNum = ucenterHelper.update("$user.updateUser", u);
		
		if(rowNum==1){
			int rNum = ucenterHelper.update("$user.updateUserInfo", u);
			if(rNum==0){
				ucenterHelper.insert("$user.insertUserInfo", u);
			}
		}else{//回滚之前的所有操作
			ucenterHelper.rollback();
		}
		return true;
	}

	public boolean deleteUser(String idList) throws Exception {
		Object[] ids = idList.split(",");
		StringBuilder sb = new StringBuilder("update user set STATUS = -1 where UID in (");
		for (int i = 0; i < ids.length; i++) {
			if(i==ids.length-1){
				sb.append("?").append(")");
			}else{
				sb.append("?,");
			}
			
		}
		int rowNum = ucenterHelper.update(sb.toString(), ids);
		return rowNum>0;
	}
}
