package com.bupt.xrf.service;

import java.util.List;
import java.util.Map;

import com.bupt.xrf.entity.WhParkVehicle;

public interface IWhParkVehicleService {

	public Map<String, Object> findlogbywh(int page, int rows, String wid);

	public List<WhParkVehicle> findalllogbywh(String wid);

}
