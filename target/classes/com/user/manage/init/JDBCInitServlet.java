package com.user.manage.init;

import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dc.jdbc.config.JDBCConfig;
import org.dc.jdbc.init.LoadSqlUtil;

public class JDBCInitServlet extends HttpServlet {
	private static final long serialVersionUID = 5614203424844235765L;
	private static Log logger = LogFactory.getLog(JDBCInitServlet.class);
	@Override  
    public void init() throws ServletException {
		//初始化是否打印sql日志
		JDBCConfig.isPrintSqlLog = true;
		try {
			String basePath = null;
			URL resource =  this.getClass().getResource(".");
			if(resource==null){
				basePath = this.getClass().getResource("/").getPath();
			}else{
				basePath = resource.getPath();
				basePath = basePath.substring(0,basePath.indexOf("/WEB-INF/classes/")+17);
			}
			
			String readPath = basePath + "com.user.manage.modules.manage.sql".replace(".", "/");
			
			logger.info("sqlUrl:"+readPath);
			
			LoadSqlUtil.loadSql(readPath);
			logger.info("sql初始化完成");
		} catch (Exception e) {
			logger.error("",e);
		}
    }
}
