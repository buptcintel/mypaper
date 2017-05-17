package com.bupt.xrf.service;

import java.util.Map;

public interface IParkVehicleService {

	public Map<String, Object> findvehiclebypk(int page, int rows, String pid);

}
