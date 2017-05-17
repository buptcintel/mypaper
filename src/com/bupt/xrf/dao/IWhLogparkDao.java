package com.bupt.xrf.dao;

import java.util.List;

import com.bupt.xrf.entity.WhLogpark;

public interface IWhLogparkDao {

	public List<WhLogpark> findlogbywh(int page, int rows, String wid);

	public int countfindlogbywh(String wid);

	public List<WhLogpark> findalllogbywh(String wid);

	
}
