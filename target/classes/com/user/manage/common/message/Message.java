package com.user.manage.common.message;

import java.util.HashMap;
import java.util.Map;

/**
 * 国际化后端消息及状态
 * @author 北京-企鹅
 * @time 2016-01-17 01:05
 */
public class Message {
	public static class Code{
		// 成功
		public static final String SUCCESS = "0";
		// 参数错误
		public static final String PARAM_ERROR = "1";
		// appKey错误
		public static final String APP_KEY_ERROR = "2";
		// 参数错误
		public static final String DATA_EMPTY = "3";
		// UID已存在
		public static final String UID_EXISTS = "11";
		// passport 已存在
		public static final String PASSPORT_EXISTS = "12";
		// mobile 已存在
		public static final String MOBILE_EXISTS = "13";
		// idCard 已存在
		public static final String IDCARD_EXISTS = "14";
		// email 已存在
		public static final String EMAIL_EXISTS = "15";
		// 用户不存在
		public static final String USER_NOT_EXISTS = "16";
		// 密码错误
		public static final String PASSWORD_ERROR = "17";
		// 域名错误
		public static final String DOMAIN_ERROR = "18";
		// 服务异常
		public static final String ERROR = "500";
	}
	public static class Text{
		public enum TextEnums{
			/** 中文  **/
			SUCCESS("success"),
			PARAM_ERROR("参数错误"),
			PARAM_EMPTY("参数不能为空"),
			SYS_EXCEPTION("系统异常"),
			DATA_EMPTY("数据为空"),
			/** 英文 **/
			LOGIN_SUCCESS_en("login success"),
			LOGIN_FAIL_en("login fail"),
			SYS_EXCEPTION_en("system exception")
			;
			private String value;
			TextEnums(String value){
				this.value = value;
			}
			public String getValue() {
				return value;
			}
			public void setValue(String value) {
				this.value = value;
			}
		}
		private static Map<String,String> msg_map = new HashMap<String, String>();
		static {
			for(TextEnums textEnum :TextEnums.values()){
				msg_map.put(textEnum.name(), textEnum.getValue());
			}
		}
		/**
		 * 数据为空
		 * @return
		 */
		public static String DATA_EMPTY(String...language){
			if(language.length==0){
				return msg_map.get(TextEnums.DATA_EMPTY.name());
			}else{
				return msg_map.get(TextEnums.DATA_EMPTY.name()+"_"+language[0]);
			}
		}

		/**
		 * 登录成功
		 * @return
		 */
		public static String SUCCESS(String...language){
			if(language.length==0){
				return msg_map.get(TextEnums.SUCCESS.name());
			}else{
				return msg_map.get(TextEnums.SUCCESS.name()+"_"+language[0]);
			}
		}

		public static String PARAM_ERROR(String...language){
			if(language.length==0){
				return msg_map.get(TextEnums.PARAM_ERROR.name());
			}else{
				return msg_map.get(TextEnums.PARAM_ERROR.name()+"_"+language[0]);
			}
		}

		public static String SYS_EXCEPTION(String...language){
			if(language.length==0){
				return msg_map.get(TextEnums.SYS_EXCEPTION.name());
			}else{
				return msg_map.get(TextEnums.SYS_EXCEPTION.name()+"_"+language[0]);
			}
		}
		public static String PARAM_EMPTY(String...language){
			if(language.length==0){
				return msg_map.get(TextEnums.PARAM_EMPTY.name());
			}else{
				return msg_map.get(TextEnums.PARAM_EMPTY.name()+"_"+language[0]);
			}
		}
	}
}