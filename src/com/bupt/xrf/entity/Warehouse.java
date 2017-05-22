package com.bupt.xrf.entity;

public class Warehouse {
	
	private String wid;
	private String wname;
	private String coordinate;
	private String location;
	private String type;
	private String ascription;
	private String contact;
	private String number;
	private String transportation;	//第0位代表汽车，第1为代表火车，第2位代表飞机
	private String flag;	//标示仓储是否被选中
	private String needpower;
	private String tool;
	private double unitcost;
	private double totalunitcost;
	private double timetoarrive;
	
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAscription() {
		return ascription;
	}
	public void setAscription(String ascription) {
		this.ascription = ascription;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getNeedpower() {
		return needpower;
	}
	public void setNeedpower(String needpower) {
		this.needpower = needpower;
	}
	public String getTool() {
		return tool;
	}
	public void setTool(String tool) {
		this.tool = tool;
	}
	public double getTimetoarrive() {
		return timetoarrive;
	}
	public void setTimetoarrive(double timetoarrive) {
		this.timetoarrive = timetoarrive;
	}
	public double getUnitcost() {
		return unitcost;
	}
	public void setUnitcost(double unitcost) {
		this.unitcost = unitcost;
	}
	public double getTotalunitcost() {
		return totalunitcost;
	}
	public void setTotalunitcost(double totalunitcost) {
		this.totalunitcost = totalunitcost;
	}
	@Override
	public String toString() {
		return "Warehouse [wid=" + wid + ", wname=" + wname + ", coordinate=" + coordinate + ", location=" + location
				+ ", type=" + type + ", ascription=" + ascription + ", contact=" + contact + ", number=" + number
				+ ", transportation=" + transportation + ", flag=" + flag + ", needpower=" + needpower + ", tool="
				+ tool + ", unitcost=" + unitcost + ", totalunitcost=" + totalunitcost + ", timetoarrive="
				+ timetoarrive + "]";
	}
}
