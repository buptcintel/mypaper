package com.bupt.xrf.entity;

public class Trancompany {
	
	private String cid;
	private String c_name;
	private String c_master;
	private String c_detail;
	private String c_contact;
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_master() {
		return c_master;
	}
	public void setC_master(String c_master) {
		this.c_master = c_master;
	}
	public String getC_detail() {
		return c_detail;
	}
	public void setC_detail(String c_detail) {
		this.c_detail = c_detail;
	}
	public String getC_contact() {
		return c_contact;
	}
	public void setC_contact(String c_contact) {
		this.c_contact = c_contact;
	}
	
	@Override
	public String toString() {
		return "Trancompany [cid=" + cid + ", c_name=" + c_name + ", c_master=" + c_master + ", c_detail=" + c_detail
				+ ", c_contact=" + c_contact + "]";
	}
	
}
