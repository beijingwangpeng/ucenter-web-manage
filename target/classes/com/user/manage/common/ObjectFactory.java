package com.user.manage.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dc.jdbc.core.JDBCProxy;
import org.dc.jdbc.helper.DBHelper;


/**
 * 对象实例工厂
 * @author 北京-企鹅
 * @time 2016-01-17 01:05
 */
public class ObjectFactory {
	private static Log logger = LogFactory.getLog(ObjectFactory.class);
    private static Lock lock = new ReentrantLock();
    private static Map<Object,Object> objMap = new HashMap<Object,Object>();

    public static DBHelper getUCenterDBHelper(){
        DBHelper db = new DBHelper(Configure.ucenter_user_manageSourceTest);
        return db;
    }
    @SuppressWarnings("unchecked")
    public static <T> T getSingleton(Class<?> clazz){
        Object obj = objMap.get(clazz);
        if(obj!=null){
            return (T) obj;
        }
        try {
            lock.lock();
            Object o = objMap.get(clazz);
            if(o!=null){
                return (T) o;
            }
            Object proxyInstance = clazz.newInstance();
            objMap.put(clazz, proxyInstance);
            return (T) proxyInstance;
        } catch (Exception e) {
        	logger.error("",e);
        }finally{
            lock.unlock();
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    public static <T> T getSingletonByProxy(Class<?> clazz){
        Object obj = objMap.get(clazz);
        if(obj!=null){
            return (T) obj;
        }
        try {
            lock.lock();
            Object o = objMap.get(clazz);
            if(o!=null){
                return (T) o;
            }
            Object class_obj = ObjectFactory.getSingleton(clazz);
            Object proxyInstance =JDBCProxy.getInstance().getTarget(class_obj);
            objMap.put(clazz, proxyInstance);
            return (T) proxyInstance;
        } catch (Exception e) {
        	logger.error("",e);
        }finally{
            lock.unlock();
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    public static <T> T getPrototype(Class<?> clazz){
        try {
            return (T) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
