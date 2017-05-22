package com.bupt.xrf.service.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.xrf.dao.IWarehouseDao;
import com.bupt.xrf.entity.Warehouse;
import com.bupt.xrf.service.IWarehouseService;

@Service("warehouseService")
public class WarehouseServiceImpl implements IWarehouseService {

	@Autowired
	private IWarehouseDao warehouseDao;
	
	@Override
	public Map<String, Object> findbypage(int page, int rows) {
		Map<String, Object> result = new HashMap<>();
		result.put("rows", warehouseDao.findbypage(page, rows));
		result.put("total", warehouseDao.countall());
		return result;
	}

	@Override
	public List<Warehouse> findall() {
		return warehouseDao.findall();
	}

	@Override
	public void adjustwarehouse(String wid, String flag, String tool, double timttoarrive, double totalunitcost) {
		Map<String, Object> params = new HashMap<>();
		params.put("wid", wid);
		params.put("flag", flag);
		params.put("tool", tool);
		params.put("totalunitcost", totalunitcost);
		String tmp = String.format("%.2f", timttoarrive);
		params.put("timetoarrive", Double.valueOf(tmp));
		warehouseDao.adjustwarehouse(params);
	}

	@Override
	public Map<String, Object> selectedwh(int page, int rows) {
		Map<String, Object> result = new HashMap<>();
		result.put("rows", warehouseDao.selectedwh(page, rows));
		result.put("total", warehouseDao.countselectedwh());
		return result;
	}

	@Override
	public void setneedpower(String wid, int needpower) {
		Map<String, Object> params = new HashMap<>();
		params.put("wid", wid);
		params.put("needpower", needpower);
		warehouseDao.adjustwarehouse(params);
	}

	@Override
	public Map<String, Object> findbywid(String wid) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		result.put("warehouse", warehouseDao.findbywid(wid));
		return result;
	}

	@Override
	public List<Warehouse> selectedallwh() {
		return warehouseDao.selectedallwh();
	}
}
