package com.bupt.xrf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.xrf.dao.IWhLogparkDao;
import com.bupt.xrf.entity.WhLogpark;
import com.bupt.xrf.service.IWhLogparkService;

@Service("whlogparkService")
public class WhLogparkServiceImpl implements IWhLogparkService {

	@Autowired
	private IWhLogparkDao whlogparkDao;

	@Override
	public Map<String, Object> findlogbywh(int page, int rows, String wid) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
		List<WhLogpark> whLogparks = whlogparkDao.findlogbywh(page, rows, wid);
		for (WhLogpark tmp : whLogparks) {
			Map<String, Object> resulttmp = new HashMap<String, Object>();
			resulttmp.put("pid", tmp.getLogpark().getPid());
			resulttmp.put("p_name", tmp.getLogpark().getP_name());
			resulttmp.put("usecount", tmp.getUsepower()+"kg");
			resulttmp.put("p_master", tmp.getLogpark().getP_master());
			resulttmp.put("p_contact", tmp.getLogpark().getP_contact());
			resulttmp.put("tool", tmp.getWarehouse().getTool());
			res.add(resulttmp);
		}
		
		result.put("total", whlogparkDao.countfindlogbywh(wid));
		result.put("rows", res);
		return result;
	}

	@Override
	public List<WhLogpark> findalllogbywh(String wid) {
		// TODO Auto-generated method stub
		return whlogparkDao.findalllogbywh(wid);
	}
	
}
