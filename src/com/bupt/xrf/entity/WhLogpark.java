package com.bupt.xrf.entity;

public class WhLogpark {

	private String wpid;
	private Logpark logpark;
	private Warehouse warehouse;
	private int usepower;
	
	public String getWpid() {
		return wpid;
	}
	public void setWpid(String wpid) {
		this.wpid = wpid;
	}
	public Logpark getLogpark() {
		return logpark;
	}
	public void setLogpark(Logpark logpark) {
		this.logpark = logpark;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	public int getUsepower() {
		return usepower;
	}
	public void setUsepower(int usepower) {
		this.usepower = usepower;
	}
	
	@Override
	public String toString() {
		return "WhLogpark [wpid=" + wpid + ", logpark=" + logpark + ", warehouse=" + warehouse + ", usepower="
				+ usepower + "]";
	}
}
