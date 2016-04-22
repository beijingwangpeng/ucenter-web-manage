package com.user.manage.common.message;


public class ResultCode {
	// 成功
	public static final int SUCCESS = 0;
	// 参数错误
	public static final int PARAM_ERROR = 1;
	// appKey错误
	public static final int APP_KEY_ERROR = 2;
	// UID已存在
	public static final int UID_EXISTS = 11;
	// passport 已存在
	public static final int PASSPORT_EXISTS = 12;
	// mobile 已存在
	public static final int MOBILE_EXISTS = 13;
	// idCard 已存在
	public static final int IDCARD_EXISTS = 14;
	// email 已存在
	public static final int EMAIL_EXISTS = 15;
	// 用户不存在
	public static final int USER_NOT_EXISTS = 16;
	// 密码错误
	public static final int PASSWORD_ERROR = 17;
	// 域名错误
	public static final int DOMAIN_ERROR = 18;
	// 服务异常
	public static final int ERROR = 500;
}
