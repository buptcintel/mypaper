package com.bupt.xrf.entity;

public class WhParkVehicle {

	private String wpvid;
	private Logpark logpark;
	private Warehouse warehouse;
	private Vehicle vehicle;
	private int useamount;
	
	public String getWpvid() {
		return wpvid;
	}
	public void setWpvid(String wpvid) {
		this.wpvid = wpvid;
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
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public int getUseamount() {
		return useamount;
	}
	public void setUseamount(int useamount) {
		this.useamount = useamount;
	}
	@Override
	public String toString() {
		return "WhLogpark [wpvid=" + wpvid + ", logpark=" + logpark + ", warehouse=" + warehouse + ", vehicle=" + vehicle
				+ ", useamount=" + useamount + "]";
	}
}
