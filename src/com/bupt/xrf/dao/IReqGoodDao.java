package com.bupt.xrf.dao;

import java.util.List;

import com.bupt.xrf.entity.ReqGood;

public interface IReqGoodDao {

	public List<ReqGood> findbypage(int page, int rows);
	
	public int countall();

	public List<ReqGood> findall();
	
}
