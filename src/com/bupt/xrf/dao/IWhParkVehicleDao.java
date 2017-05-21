package com.bupt.xrf.dao;

import java.util.List;
import java.util.Map;

import com.bupt.xrf.entity.WhParkVehicle;

public interface IWhParkVehicleDao {

	public List<WhParkVehicle> findlogbywh(int page, int rows, String wid);

	public int countfindlogbywh(String wid);

	public void updateuseamount(Map<String, Object> params);

	public void insertnewwpv(Map<String, Object> params);

	public void deletewpv(Map<String, Object> params);

	public int ifexistwpv(Map<String, Object> params);

	public List<WhParkVehicle> findalllogbywh(String wid);

	public int ifwhusepark(String wid, String pid);

	public int caluseamountbywhandpark(String wid, String pid);

	public List<WhParkVehicle> findwhbypk(int page, int rows, String pid);

	public int countfindwhbypk(String pid);

	public List<WhParkVehicle> findallwhbypk(String pid);

	
}
