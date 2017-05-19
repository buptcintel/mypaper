package com.bupt.xrf.entity;

public class ParkVehicle {
	
	private String pvid;
	private Vehicle vehicle;
	private Logpark logpark;
	private String ifuse;
	private int vamount;
	private int useamount;
	private int availableamount;
	
	public String getPvid() {
		return pvid;
	}
	public void setPvid(String pvid) {
		this.pvid = pvid;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Logpark getLogpark() {
		return logpark;
	}
	public void setLogpark(Logpark logpark) {
		this.logpark = logpark;
	}
	public String getIfuse() {
		return ifuse;
	}
	public void setIfuse(String ifuse) {
		this.ifuse = ifuse;
	}
	public int getVamount() {
		return vamount;
	}
	public void setVamount(int vamount) {
		this.vamount = vamount;
	}
	public int getUseamount() {
		return useamount;
	}
	public void setUseamount(int useamount) {
		this.useamount = useamount;
	}
	public int getAvailableamount() {
		return availableamount;
	}
	public void setAvailableamount(int availableamount) {
		this.availableamount = availableamount;
	}
	@Override
	public String toString() {
		return "ParkVehicle [pvid=" + pvid + ", vehicle=" + vehicle + ", logpark=" + logpark + ", ifuse=" + ifuse
				+ ", vamount=" + vamount + ", useamount=" + useamount + ", availableamount=" + availableamount + "]";
	}
}
