package com.bupt.xrf.service;

import java.util.List;
import java.util.Map;

import com.bupt.xrf.entity.Warehouse;

public interface IWarehouseService {

	public Map<String, Object> findbypage(int page, int rows);
	
	public List<Warehouse> findall();

	public void adjustwarehouse(String wid, String flag, String tool, double timetoarrive);

	public Map<String, Object> selectedwh(int page, int rows);
	
	public List<Warehouse> selectedallwh();

	public void setneedpower(String wid, int needpower);

	public Map<String, Object> findbywid(String wid);
	
}
