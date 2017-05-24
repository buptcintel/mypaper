package com.bupt.xrf.service.impl;

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

}
