package com.bupt.xrf.dao;

import java.util.HashMap;
import java.util.List;

import com.bupt.xrf.entity.ReqGood;

public interface IReqGoodDao {

	public List<ReqGood> findbypage(int page, int rows);
	
	public int countall();

	public List<ReqGood> findall();

	public void addreqgood(HashMap<String, Object> map);

	public void emptyreqgood();

	public void setamount();
	
}
