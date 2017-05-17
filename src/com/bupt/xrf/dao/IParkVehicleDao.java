package com.bupt.xrf.dao;

import java.util.List;

import com.bupt.xrf.entity.ParkVehicle;

public interface IParkVehicleDao {

	public List<ParkVehicle> findvehiclebypk(int page, int rows, String pid);

	public int countfindvehiclebypk(String pid);

}
