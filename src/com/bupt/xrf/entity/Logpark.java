package com.bupt.xrf.entity;

public class Logpark {
	
	private String pid;
	private String p_name;
	private String p_coordinate;
	private String p_location;
	private String p_master;
	private String p_contact;
	private Trancompany trancompany;
	private int p_power;
	private int totaluse;
	private String flag;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_coordinate() {
		return p_coordinate;
	}
	public void setP_coordinate(String p_coordinate) {
		this.p_coordinate = p_coordinate;
	}
	public String getP_location() {
		return p_location;
	}
	public void setP_location(String p_location) {
		this.p_location = p_location;
	}
	public String getP_master() {
		return p_master;
	}
	public void setP_master(String p_master) {
		this.p_master = p_master;
	}
	public String getP_contact() {
		return p_contact;
	}
	public void setP_contact(String p_contact) {
		this.p_contact = p_contact;
	}
	public Trancompany getTrancompany() {
		return trancompany;
	}
	public void setTrancompany(Trancompany trancompany) {
		this.trancompany = trancompany;
	}
	public int getP_power() {
		return p_power;
	}
	public void setP_power(int p_power) {
		this.p_power = p_power;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getTotaluse() {
		return totaluse;
	}
	public void setTotaluse(int totaluse) {
		this.totaluse = totaluse;
	}
	
	@Override
	public String toString() {
		return "Logpark [pid=" + pid + ", p_name=" + p_name + ", p_coordinate=" + p_coordinate + ", p_location="
				+ p_location + ", p_master=" + p_master + ", p_contact=" + p_contact + ", trancompany=" + trancompany
				+ ", p_power=" + p_power + ", totaluse=" + totaluse + ", flag=" + flag + "]";
	}
}
