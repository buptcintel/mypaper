package com.bupt.xrf.dao;

import java.util.List;
import java.util.Map;

import com.bupt.xrf.entity.WhGood;

public interface IWhGoodDao {

	public List<WhGood> findbypage(int page, int rows, String wid);
	
	public int countall(String wid);

	public void adjustuse(Map<String, Object> params);

	public String ifusewh(String wid);

	public List<WhGood> selectgoods(int page, int rows, String wid);

	public int countselectgoods(String wid);

	public int calneedpower(String wid);

	public List<WhGood> findwhbygoods(int page, int rows, String gid);

	public int countfindwhbygoods(String gid);

	List<WhGood> findallwhbygoods(String gid);

	public List<WhGood> findall();
	
}
