package com.bupt.xrf.dao;

import java.util.List;

import com.bupt.xrf.entity.Logpark;

public interface ILogparkDao {

	public List<Logpark> findbypage(int page, int rows);

	public int countall();

	public List<Logpark> selectedpk(int page, int rows);

	public int countselectedpk();

	public void settotaluse(String pid);

	public Logpark findbypid(String pid);

	public void clearpark();

}
