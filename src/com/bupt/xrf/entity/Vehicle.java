package com.bupt.xrf.entity;

public class Vehicle {

	private String vid;
	private String v_name;
	private int v_power;
	private int v_cost;
	private String v_unit;
	private String v_type;
	
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public int getV_power() {
		return v_power;
	}
	public void setV_power(int v_power) {
		this.v_power = v_power;
	}
	public int getV_cost() {
		return v_cost;
	}
	public void setV_cost(int v_cost) {
		this.v_cost = v_cost;
	}
	public String getV_unit() {
		return v_unit;
	}
	public void setV_unit(String v_unit) {
		this.v_unit = v_unit;
	}
	public String getV_type() {
		return v_type;
	}
	public void setV_type(String v_type) {
		this.v_type = v_type;
	}
	
	@Override
	public String toString() {
		return "Vehicle [vid=" + vid + ", v_name=" + v_name + ", v_power=" + v_power + ", v_cost=" + v_cost
				+ ", v_unit=" + v_unit + ", v_type=" + v_type + "]";
	}
}
