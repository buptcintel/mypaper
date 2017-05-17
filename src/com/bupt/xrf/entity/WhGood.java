package com.bupt.xrf.entity;

public class WhGood {

	private String gwid;
	private Warehouse warehouse;
	private Good good;
	private int amount;
	private String ifuse;	//选中仓储中的物资是否被选用
	private int usecount;	//选用多少
	
	public String getIfuse() {
		return ifuse;
	}
	public void setIfuse(String ifuse) {
		this.ifuse = ifuse;
	}
	public int getUsecount() {
		return usecount;
	}
	public void setUsecount(int usecount) {
		this.usecount = usecount;
	}
	public String getGwid() {
		return gwid;
	}
	public void setGwid(String gwid) {
		this.gwid = gwid;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "WhGood [gwid=" + gwid + ", warehouse=" + warehouse + ", good=" + good + ", amount=" + amount
				+ ", ifuse=" + ifuse + ", usecount=" + usecount + "]";
	}
}
