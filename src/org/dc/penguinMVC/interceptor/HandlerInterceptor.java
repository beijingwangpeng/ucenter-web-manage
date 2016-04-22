package org.dc.penguinMVC.interceptor;

import org.dc.penguinMVC.handle.RequestHandle;

public interface HandlerInterceptor {
	public void before(RequestHandle requestHandle)throws Exception;
	public void after(RequestHandle requestHandle)throws Exception;
}
