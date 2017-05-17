package com.bupt.xrf.service;

import java.util.Map;

public interface IParkVehicleService {

	public Map<String, Object> findvehiclebypk(int page, int rows, String pid);

	public Map<String, Object> findvehiclebypkandtool(int page, int rows, String pid, String tool);

}
