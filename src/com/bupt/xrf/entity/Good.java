package com.bupt.xrf.entity;

public class Good {

	private String gid;
	private String code;
	private String unit;
	private String gname;
	private String kind;
	private String weight;	//单位为kg
	
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Good [gid=" + gid + ", code=" + code + ", unit=" + unit + ", gname=" + gname + ", kind=" + kind
				+ ", weight=" + weight + "]";
	}
}
