package com.bupt.xrf.service;

import java.util.List;
import java.util.Map;

import com.bupt.xrf.entity.WhParkVehicle;

public interface IWhParkVehicleService {

	public Map<String, Object> findlogbywh(int page, int rows, String wid);

	public boolean ifexistwpv(String wid, String pid, String vid);

	public void updateuseamount(String wid, String pid, String vid, int count);

	public void insertnewwpv(String wid, String pid, String vid, int count);

	public void deletewpv(String wid, String pid, String vid);

	List<WhParkVehicle> findalllogbywh(String wid);

	public int ifwhusepark(String wid, String pid);

	public Map<String, Object> findwhbypk(int page, int rows, String pid);

	public List<WhParkVehicle> findallwhbypk(String pid);

}
