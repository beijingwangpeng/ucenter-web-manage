package com.user.manage.entity;

import java.util.Date;

public class User {
	private Long UID;
	private String PASSPORT;
	private String PASSWORD;
	private String NICKNAME;
	private String REAL_NAME;
	private String MOBILE;
	private Date CREATE_TIME;
	
	public Date getCREATE_TIME() {
		return CREATE_TIME;
	}
	public void setCREATE_TIME(Date cREATE_TIME) {
		CREATE_TIME = cREATE_TIME;
	}
	public Long getUID() {
		return UID;
	}
	public void setUID(Long uID) {
		UID = uID;
	}
	public String getPASSPORT() {
		return PASSPORT;
	}
	public void setPASSPORT(String pASSPORT) {
		PASSPORT = pASSPORT;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getNICKNAME() {
		return NICKNAME;
	}
	public void setNICKNAME(String nICKNAME) {
		NICKNAME = nICKNAME;
	}
	public String getREAL_NAME() {
		return REAL_NAME;
	}
	public void setREAL_NAME(String rEAL_NAME) {
		REAL_NAME = rEAL_NAME;
	}
	public String getMOBILE() {
		return MOBILE;
	}
	public void setMOBILE(String mOBILE) {
		MOBILE = mOBILE;
	}
}
