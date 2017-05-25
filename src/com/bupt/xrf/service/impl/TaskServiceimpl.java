package com.bupt.xrf.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.xrf.dao.IWarehouseDao;
import com.bupt.xrf.service.ITaskService;

@Service("taskService")
public class TaskServiceimpl implements ITaskService {
	
	@Autowired
	private IWarehouseDao warehouseDao;

	@Override
	public Map<String, Object> gettasktimeandcost() {
		Map<String, Object> map = new HashMap<>();
		map.put("time", warehouseDao.gettasktime());
		map.put("cost", warehouseDao.gettaskcost());
		return map;
	}

}
