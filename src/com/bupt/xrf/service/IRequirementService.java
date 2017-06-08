package com.bupt.xrf.service;

import java.util.List;
import java.util.Map;

import com.bupt.xrf.entity.Requirement;

public interface IRequirementService {

	public void addreq(Requirement requirement);

	public void emptyreq();

	public List<Map<String, Object>> getallbatch();

	public List<Map<String, Object>> getddlbybatch(String batch);

}
