package com.bupt.xrf.entity;

public class ReqGood {

	private String rgid;
	private Good good;
	private Requirement requirement;
	private String amount;
	
	public String getRgid() {
		return rgid;
	}
	public void setRgid(String rgid) {
		this.rgid = rgid;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public Requirement getRequirement() {
		return requirement;
	}
	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "ReqGood [rgid=" + rgid + ", good=" + good + ", requirement=" + requirement + ", amount=" + amount + "]";
	}
}
