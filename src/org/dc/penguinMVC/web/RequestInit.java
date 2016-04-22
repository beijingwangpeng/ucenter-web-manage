package org.dc.penguinMVC.web;

import java.util.HashMap;
import java.util.Map;

import org.dc.penguinMVC.handle.RequestHandle;
/**
 * 初始化项目注解，并封装缓存请求映射的对象
 * @author 北京-企鹅
 * @time 2016-01-17 01:05
 */
public class RequestInit {

    private static Map<String, RequestHandle> objMap = new HashMap<String, RequestHandle>();

	public static RequestHandle get(String key) {
		return objMap.get(key);
	}

	public static void put(String key ,RequestHandle value) throws Exception {
		//检查请求路径是否有冲突
		for (String k : objMap.keySet()) {
			if(k.equals(key)){
				throw new Exception("requestMapping映射URL有重复，key="+key);
			}
		}
		objMap.put(key, value);
	}
}