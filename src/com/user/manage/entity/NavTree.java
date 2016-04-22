package com.user.manage.entity;

public class NavTree {
	private int id;
	private int pId;
	private String name;
	private String myurl;
	
	private boolean open;
	
	
	public String getMyurl() {
		return myurl;
	}
	public void setMyurl(String myurl) {
		this.myurl = myurl;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
