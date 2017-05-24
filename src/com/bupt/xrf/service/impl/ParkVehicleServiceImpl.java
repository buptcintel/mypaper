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
			resulttmp.put("availableamount", tmp.getAvailableamount()+tmp.getVehicle().getV_unit());
			resulttmp.put("v_cost", tmp.getVehicle().getV_cost());
			resulttmp.put("ifuse", tmp.getIfuse());
			res.add(resulttmp);
		}
		
		result.put("total", parkVehicleDao.countfindvehiclebypk(pid));
		result.put("rows", res);
		return result;
	}

	@Override
	public Map<String, Object> findvehiclebypkandtool(int page, int rows, String pid, String tool) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
		if(tool.equals("0"))
			tool = "汽车";
		if(tool.equals("1"))
			tool = "火车";
		if(tool.equals("2"))
			tool = "飞机";
		List<ParkVehicle> parkVehicles = parkVehicleDao.findvehiclebypkandtool(page, rows, pid, tool);
		for (ParkVehicle tmp : parkVehicles) {

			Map<String, Object> resulttmp = new HashMap<String, Object>();
			resulttmp.put("pvid", tmp.getPvid());
			resulttmp.put("pid", tmp.getLogpark().getPid());
			resulttmp.put("vid", tmp.getVehicle().getVid());
			resulttmp.put("v_power", tmp.getVehicle().getV_power());
			resulttmp.put("v_name", tmp.getVehicle().getV_name());
			resulttmp.put("vamount", tmp.getVamount()+tmp.getVehicle().getV_unit());
			resulttmp.put("useamount", tmp.getUseamount()+tmp.getVehicle().getV_unit());
			resulttmp.put("availableamount", tmp.getAvailableamount()+tmp.getVehicle().getV_unit());
			resulttmp.put("v_cost", tmp.getVehicle().getV_cost());
			resulttmp.put("ifuse", tmp.getIfuse());
			res.add(resulttmp);
		}
		
		result.put("total", parkVehicleDao.countfindvehiclebypkandtool(pid,tool));
		result.put("rows", res);
		return result;
	}

	@Override
	public void adjustuse(String pvid, String pid, String vid, int count, String ifuse) {
		Map<String, Object> params = new HashMap<>();
		params.put("pvid", pvid);
		params.put("pid", pid);
		params.put("vid", vid);
		params.put("useamount", count);
		params.put("ifuse", ifuse);
		parkVehicleDao.adjustuse(params);
	}

	@Override
	public Map<String, Object> findusedvehiclebypk(int page, int rows, String pid) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
		List<ParkVehicle> parkVehicles = parkVehicleDao.findusedvehiclebypk(page, rows, pid);
		for (ParkVehicle tmp : parkVehicles) {

			Map<String, Object> resulttmp = new HashMap<String, Object>();
			resulttmp.put("pvid", tmp.getPvid());
			resulttmp.put("pid", tmp.getLogpark().getPid());
			resulttmp.put("vid", tmp.getVehicle().getVid());
			resulttmp.put("v_power", tmp.getVehicle().getV_power());
			resulttmp.put("v_name", tmp.getVehicle().getV_name());
			resulttmp.put("useamount", tmp.getUseamount()+tmp.getVehicle().getV_unit());
			resulttmp.put("v_cost", tmp.getVehicle().getV_cost());
			res.add(resulttmp);
		}
		
		result.put("total", parkVehicleDao.countfindusedvehiclebypk(pid));
		result.put("rows", res);
		return result;
	}

	@Override
	public void clearpkvh() {
		parkVehicleDao.clearpkvh();
	}

}
