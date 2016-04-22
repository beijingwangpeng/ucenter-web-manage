package com.user.manage.common;

import com.alibaba.druid.pool.DruidDataSource;

public class Configure {
	public static DruidDataSource ucenter_user_manageSourceTest = new DruidDataSource();
	public static DruidDataSource ucenterSourceTest = new DruidDataSource();
	static{
		ucenter_user_manageSourceTest.setUrl("jdbc:mysql://192.168.12.229:3306/ucenter_userManage?useUnicode=true&characterEncoding=UTF-8");
		ucenter_user_manageSourceTest.setUsername("ucenter");
		ucenter_user_manageSourceTest.setPassword("srt123");
		/*try {
			testSource.setFilters("config");
		} catch (Exception e) {
			log.error("",e);
		}
		testSource.setConnectionProperties("config.decrypt=true");*/
		ucenter_user_manageSourceTest.setInitialSize(1);
		ucenter_user_manageSourceTest.setMaxActive(4);
		ucenter_user_manageSourceTest.setMinIdle(0);
		ucenter_user_manageSourceTest.setMaxWait(60000);
		ucenter_user_manageSourceTest.setValidationQuery("SELECT 1");
		ucenter_user_manageSourceTest.setTestOnBorrow(false);
		ucenter_user_manageSourceTest.setTestWhileIdle(true);
		ucenter_user_manageSourceTest.setPoolPreparedStatements(false);
		ucenter_user_manageSourceTest.setDriverClassName("com.mysql.jdbc.Driver");
	}
	static{
		ucenterSourceTest.setUrl("jdbc:mysql://192.168.12.229:3306/ucenter?useUnicode=true&characterEncoding=UTF-8");
		ucenterSourceTest.setUsername("ucenter");
		ucenterSourceTest.setPassword("srt123");
		/*try {
			testSource.setFilters("config");
		} catch (Exception e) {
			log.error("",e);
		}
		testSource.setConnectionProperties("config.decrypt=true");*/
		ucenterSourceTest.setInitialSize(1);
		ucenterSourceTest.setMaxActive(4);
		ucenterSourceTest.setMinIdle(0);
		ucenterSourceTest.setMaxWait(60000);
		ucenterSourceTest.setValidationQuery("SELECT 1");
		ucenterSourceTest.setTestOnBorrow(false);
		ucenterSourceTest.setTestWhileIdle(true);
		ucenterSourceTest.setPoolPreparedStatements(false);
		ucenterSourceTest.setDriverClassName("com.mysql.jdbc.Driver");
	}
}
