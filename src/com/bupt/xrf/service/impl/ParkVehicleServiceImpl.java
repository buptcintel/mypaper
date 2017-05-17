package com.bupt.xrf.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.xrf.dao.IParkVehicleDao;
import com.bupt.xrf.service.IParkVehicleService;

@Service("parkVehicleService")
public class ParkVehicleServiceImpl implements IParkVehicleService {

	@Autowired
	private IParkVehicleDao parkVehicleDao;
	
	@Override
	public Map<String, Object> findvehiclebypk(int page, int rows, String pid) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		result.put("rows", parkVehicleDao.findvehiclebypk(page, rows, pid));
		result.put("total", parkVehicleDao.countfindvehiclebypk(pid));
		return result;
	}

}
