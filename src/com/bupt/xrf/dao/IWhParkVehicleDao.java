package com.bupt.xrf.dao;

import java.util.List;

import com.bupt.xrf.entity.WhParkVehicle;

public interface IWhParkVehicleDao {

	public List<WhParkVehicle> findlogbywh(int page, int rows, String wid);

	public int countfindlogbywh(String wid);

	public List<WhParkVehicle> findalllogbywh(String wid);

	
}
