package com.user.manage.interceptor;

import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dc.penguinMVC.handle.RequestHandle;
import org.dc.penguinMVC.interceptor.HandlerInterceptor;
import org.dc.penguinMVC.web.WebContext;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UrlApiLogInterceptor implements HandlerInterceptor{
	private static Log logger = LogFactory.getLog(UrlApiLogInterceptor.class);
	private static ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void before(RequestHandle requestHandle) throws Exception{
		long timeBegin = System.nanoTime();
		WebContext.getRequest().setAttribute("timeBegin", timeBegin);
	}

	@Override
	public void after(RequestHandle requestHandle) throws Exception {
		long timeBegin = Long.valueOf(WebContext.getRequest().getAttribute("timeBegin").toString());
		long timeEnd = System.nanoTime();
		String uri = WebContext.getRequest().getRequestURI();
		Map<String,String[]> map = WebContext.getRequest().getParameterMap();
		StringBuilder sb = new StringBuilder();
		int mapSize = map.size();
		int j = 0;
		for (String key : map.keySet()) {
			String[] strs = map.get(key);
			for (int i = 0; i < strs.length; i++) {
				sb.append(key).append("=").append(strs[i]);
				if(strs.length-1!=i){
					sb.append("&");
				}
			}
			if(j!=mapSize-1){
				sb.append("&");
			}
			j++;
		}
		TreeMap<String,Object> m_json = new TreeMap<String, Object>();
		if(requestHandle!=null){
			m_json.put("action", requestHandle.getClazz().getName());
			m_json.put("methodName", requestHandle.getMethodName());
		}else{
			m_json.put("action", null);
			m_json.put("methodName", null);
		}
		m_json.put("URI:", uri+(!sb.toString().equals("")?"?"+sb.toString():""));
		m_json.put("timeCost:", ((timeEnd - timeBegin) / 1000000) + "ms");
		logger.info(objectMapper.writeValueAsString(m_json));
	}
}
