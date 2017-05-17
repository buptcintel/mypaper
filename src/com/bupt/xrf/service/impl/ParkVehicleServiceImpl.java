package com.bupt.xrf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.xrf.dao.IParkVehicleDao;
import com.bupt.xrf.entity.ParkVehicle;
import com.bupt.xrf.service.IParkVehicleService;

@Service("parkVehicleService")
public class ParkVehicleServiceImpl implements IParkVehicleService {

	@Autowired
	private IParkVehicleDao parkVehicleDao;
	
	@Override
	public Map<String, Object> findvehiclebypk(int page, int rows, String pid) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
		List<ParkVehicle> parkVehicles = parkVehicleDao.findvehiclebypk(page, rows, pid);
		for (ParkVehicle tmp : parkVehicles) {

			Map<String, Object> resulttmp = new HashMap<String, Object>();
			resulttmp.put("pvid", tmp.getPvid());
			resulttmp.put("pid", tmp.getLogpark().getPid());
			resulttmp.put("vid", tmp.getVehicle().getVid());
			resulttmp.put("v_power", tmp.getVehicle().getV_power());
			resulttmp.put("v_name", tmp.getVehicle().getV_name());
			resulttmp.put("vamount", tmp.getVamount()+tmp.getVehicle().getV_unit());
			resulttmp.put("useamount", tmp.getUseamount()+tmp.getVehicle().getV_unit());
			resulttmp.put("v_cost", tmp.getVehicle().getV_cost());
			resulttmp.put("ifuse", tmp.getIfuse());
			res.add(resulttmp);
		}
		
		result.put("total", parkVehicleDao.countfindvehiclebypk(pid));
		result.put("rows", res);
		return result;
	}

}
