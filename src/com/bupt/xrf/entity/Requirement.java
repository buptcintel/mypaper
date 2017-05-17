package com.bupt.xrf.entity;

public class Requirement {

	private String rid;
	private String batch;
	private String deadline;
	
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	@Override
	public String toString() {
		return "Requirement [rid=" + rid + ", batch=" + batch + ", deadline=" + deadline + "]";
	}
}
