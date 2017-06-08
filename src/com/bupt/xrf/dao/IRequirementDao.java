package com.bupt.xrf.dao;

import java.util.List;

import com.bupt.xrf.entity.Requirement;

public interface IRequirementDao {

	public void addreq(Requirement requirement);

	public int exsit(String rid);

	public void emptyreq();

	public List<Requirement> getallbatch();

	public List<Requirement> getddlbybatch(String batch);

}
