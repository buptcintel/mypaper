package com.bupt.xrf.entity;

public class Vehicle {

	private String vid;
	private String v_name;
	private int v_power;
	private int v_cost;
	
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
	
	@Override
	public String toString() {
		return "Vehicle [vid=" + vid + ", v_name=" + v_name + ", v_power=" + v_power + ", v_cost=" + v_cost + "]";
	}
	
}
