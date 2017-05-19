package com.bupt.xrf.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.xrf.dao.ILogparkDao;
import com.bupt.xrf.service.ILogparkService;

@Service("logparkService")
public class LogparkServiceImpl implements ILogparkService {

	@Autowired
	private ILogparkDao logparkDao;
	
	@Override
	public Map<String, Object> findbypage(int page, int rows) {
		Map<String, Object> result = new HashMap<>();
		result.put("rows", logparkDao.findbypage(page, rows));
		result.put("total", logparkDao.countall());
		return result;
	}

	@Override
	public Map<String, Object> selectedpk(int page, int rows) {
		Map<String, Object> result = new HashMap<>();
		result.put("rows", logparkDao.selectedpk(page, rows));
		result.put("total", logparkDao.countselectedpk());
		return result;
	}

	@Override
	public void settotaluse(String pid) {
		logparkDao.settotaluse(pid);
	}

}
