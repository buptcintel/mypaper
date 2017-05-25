package com.bupt.xrf.dao;

import java.util.List;
import java.util.Map;

import com.bupt.xrf.entity.Warehouse;

public interface IWarehouseDao {

	public List<Warehouse> findbypage(int page, int rows);
	
	public int countall();
	
	public List<Warehouse> findall();

	public void adjustwarehouse(Map<String, Object> params);

	public List<Warehouse> selectedwh(int page, int rows);

	public int countselectedwh();

	public Warehouse findbywid(String wid);

	public List<Warehouse> selectedallwh();

	public double gettasktime();

	public double gettaskcost();
	
}
