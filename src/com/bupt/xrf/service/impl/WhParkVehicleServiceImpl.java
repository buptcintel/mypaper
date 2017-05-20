package com.bupt.xrf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.xrf.dao.IWhParkVehicleDao;
import com.bupt.xrf.entity.WhParkVehicle;
import com.bupt.xrf.service.IWhParkVehicleService;

@Service("whParkVehicleService")
public class WhParkVehicleServiceImpl implements IWhParkVehicleService {

	@Autowired
	private IWhParkVehicleDao whParkVehicleDao;

	@Override
	public Map<String, Object> findlogbywh(int page, int rows, String wid) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
		List<WhParkVehicle> whLogparks = whParkVehicleDao.findlogbywh(page, rows, wid);
		for (WhParkVehicle tmp : whLogparks) {
			Map<String, Object> resulttmp = new HashMap<String, Object>();
			resulttmp.put("pid", tmp.getLogpark().getPid());
			resulttmp.put("p_name", tmp.getLogpark().getP_name());
			resulttmp.put("p_master", tmp.getLogpark().getP_master());
			resulttmp.put("p_contact", tmp.getLogpark().getP_contact());
			resulttmp.put("tool", tmp.getWarehouse().getTool());
			int useamount = whParkVehicleDao.caluseamountbywhandpark(wid, tmp.getLogpark().getPid());
			resulttmp.put("useamount", useamount+"kg");
			res.add(resulttmp);
		}
		
		result.put("total", whParkVehicleDao.countfindlogbywh(wid));
		result.put("rows", res);
		return result;
	}

	@Override
	public List<WhParkVehicle> findalllogbywh(String wid) {
		// TODO Auto-generated method stub
		return whParkVehicleDao.findalllogbywh(wid);
	}

	@Override
	public boolean ifexistwpv(String wid, String pid, String vid) {
		Map<String, Object> params = new HashMap<>();
		params.put("wid", wid);
		params.put("pid", pid);
		params.put("vid", vid);
		int number = whParkVehicleDao.ifexistwpv(params);
		if(number == 0)
			return false;
		return true;
	}

	@Override
	public void updateuseamount(String wid, String pid, String vid, int count) {
		Map<String, Object> params = new HashMap<>();
		params.put("wid", wid);
		params.put("pid", pid);
		params.put("vid", vid);
		params.put("count", count);
		whParkVehicleDao.updateuseamount(params);
	}

	@Override
	public void insertnewwpv(String wid, String pid, String vid, int count) {
		Map<String, Object> params = new HashMap<>();
		String wpvid = "w"+wid+"p"+pid+"v"+vid;
		params.put("wpvid", wpvid);
		params.put("wid", wid);
		params.put("pid", pid);
		params.put("vid", vid);
		params.put("count", count);
		whParkVehicleDao.insertnewwpv(params);
	}

	@Override
	public void deletewpv(String wid, String pid, String vid) {
		Map<String, Object> params = new HashMap<>();
		params.put("wid", wid);
		params.put("pid", pid);
		params.put("vid", vid);
		whParkVehicleDao.deletewpv(params);
	}

	@Override
	public int ifwhusepark(String wid, String pid) {
		return whParkVehicleDao.ifwhusepark(wid, pid);
	}
	
}
