package com.bupt.xrf.service;

import java.util.List;
import java.util.Map;

import com.bupt.xrf.entity.WhGood;

public interface IWhGoodService {

	public Map<String, Object> findbypage(int page, int rows, String wid);
	
	public void adjustuse(String gwid, String wid, String gid, int usecount, String ifuse);

	public Boolean ifusewh(String wid);

	public Map<String, Object> selectgoods(int page, int rows, String wid);

	public int calneedpower(String wid);

	public Map<String, Object> findwhbygoods(int page, int rows, String gid);
	
	public List<WhGood> findallwhbygoods(String gid);

	public List<WhGood> findall();
	
}
