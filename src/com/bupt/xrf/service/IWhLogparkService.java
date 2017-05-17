package com.bupt.xrf.service;

import java.util.List;
import java.util.Map;

import com.bupt.xrf.entity.WhLogpark;

public interface IWhLogparkService {

	public Map<String, Object> findlogbywh(int page, int rows, String wid);

	public List<WhLogpark> findalllogbywh(String wid);

}
