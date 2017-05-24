package com.bupt.xrf.entity;

public class ReqGood {

	private String rgid;
	private Good good;
	private Requirement requirement;
	private int amount;
	private int totalamount;
	
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}
	@Override
	public String toString() {
		return "ReqGood [rgid=" + rgid + ", good=" + good + ", requirement=" + requirement + ", amount=" + amount
				+ ", totalamount=" + totalamount + "]";
	}
}
