package com.bupt.xrf.service;

import java.util.Map;

public interface IParkVehicleService {

	public Map<String, Object> findvehiclebypk(int page, int rows, String pid);

	public Map<String, Object> findvehiclebypkandtool(int page, int rows, String pid, String tool);

	public void adjustuse(String pvid, String pid, String vid, int count, String ifuse);

	public Map<String, Object> findusedvehiclebypk(int page, int rows, String pid);

}
