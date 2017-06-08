package com.bupt.xrf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.xrf.dao.IRequirementDao;
import com.bupt.xrf.entity.Requirement;
import com.bupt.xrf.service.IRequirementService;

@Service("requirementService")
public class RequirementServiceImpl implements IRequirementService {

	@Autowired
	private IRequirementDao requirementDao;
	
	@Override
	public void addreq(Requirement requirement) {
		int result = requirementDao.exsit(requirement.getRid());
		if(result == 0)
			requirementDao.addreq(requirement);
	}

	@Override
	public void emptyreq() {
		requirementDao.emptyreq();
	}

	@Override
	public List<Map<String, Object>> getallbatch() {
		List<Map<String, Object>> list = new ArrayList<>();
		List<Requirement> requirements = new ArrayList<>();
		requirements = requirementDao.getallbatch();
		for(Requirement requirement : requirements){
			Map<String, Object> map = new HashMap<>();
			map.put("id", requirement.getBatch());
			map.put("text", "第"+requirement.getBatch()+"批次");
			list.add(map);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getddlbybatch(String batch) {
		List<Map<String, Object>> list = new ArrayList<>();
		List<Requirement> requirements = new ArrayList<>();
		requirements = requirementDao.getddlbybatch(batch);
		for(Requirement requirement : requirements){
			Map<String, Object> map = new HashMap<>();
			map.put("id", requirement.getDeadline());
			map.put("text", requirement.getDeadline()+"小时");
			list.add(map);
		}
		return list;
	}

}
