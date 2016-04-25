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
	
	private String EMAIL;
	private String ID_CARD;
	
	private Integer ACTI_FLAG;//激活状态：0未激活；1已激活
	
	private Integer STATUS;//用户状态(-1删除；0正常)
	
	private Integer REG_APP_ID;
	
	private Date MODIFY_TIME;
	
	private Integer IS_MIGRATED;
	
	private Integer areaID;
	
	private Integer sex;
	private Integer age;
	private Integer schoolID;
	private String subject;
	private String stage;
	private String grade;
	private String qq;
	
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
	public Date getCREATE_TIME() {
		return CREATE_TIME;
	}
	public void setCREATE_TIME(Date cREATE_TIME) {
		CREATE_TIME = cREATE_TIME;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getID_CARD() {
		return ID_CARD;
	}
	public void setID_CARD(String iD_CARD) {
		ID_CARD = iD_CARD;
	}
	public Integer getACTI_FLAG() {
		return ACTI_FLAG;
	}
	public void setACTI_FLAG(Integer aCTI_FLAG) {
		ACTI_FLAG = aCTI_FLAG;
	}
	public Integer getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(Integer sTATUS) {
		STATUS = sTATUS;
	}
	public Integer getREG_APP_ID() {
		return REG_APP_ID;
	}
	public void setREG_APP_ID(Integer rEG_APP_ID) {
		REG_APP_ID = rEG_APP_ID;
	}
	public Date getMODIFY_TIME() {
		return MODIFY_TIME;
	}
	public void setMODIFY_TIME(Date mODIFY_TIME) {
		MODIFY_TIME = mODIFY_TIME;
	}
	public Integer getIS_MIGRATED() {
		return IS_MIGRATED;
	}
	public void setIS_MIGRATED(Integer iS_MIGRATED) {
		IS_MIGRATED = iS_MIGRATED;
	}
	public Integer getAreaID() {
		return areaID;
	}
	public void setAreaID(Integer areaID) {
		this.areaID = areaID;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(Integer schoolID) {
		this.schoolID = schoolID;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
}
