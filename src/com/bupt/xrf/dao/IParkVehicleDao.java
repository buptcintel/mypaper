package com.bupt.xrf.dao;

import java.util.List;
import java.util.Map;

import com.bupt.xrf.entity.ParkVehicle;

public interface IParkVehicleDao {

	public List<ParkVehicle> findvehiclebypk(int page, int rows, String pid);

	public int countfindvehiclebypk(String pid);

	public List<ParkVehicle> findvehiclebypkandtool(int page, int rows, String pid, String tool);

	public int countfindvehiclebypkandtool(String pid, String tool);

	public void adjustuse(Map<String, Object> params);

	public List<ParkVehicle> findusedvehiclebypk(int page, int rows, String pid);

	public int countfindusedvehiclebypk(String pid);

	public void clearpkvh();

}
