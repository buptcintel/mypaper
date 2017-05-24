package com.bupt.xrf.service;

import java.util.Map;

public interface ILogparkService {

	public Map<String, Object> findbypage(int page, int rows);

	public Map<String, Object> selectedpk(int page, int rows);

	public void settotaluse(String pid);

	public Map<String, Object> findbypid(String pid);

	public void clearpark();

}
