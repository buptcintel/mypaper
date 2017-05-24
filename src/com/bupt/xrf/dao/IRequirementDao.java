package com.bupt.xrf.dao;

import com.bupt.xrf.entity.Requirement;

public interface IRequirementDao {

	public void addreq(Requirement requirement);

	public int exsit(String rid);

	public void emptyreq();

}
