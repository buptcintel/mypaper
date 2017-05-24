package com.bupt.xrf.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bupt.xrf.dao.IGoodDao;

@Repository("goodDao")
public class GoodDaoImpl implements IGoodDao {
	
	@Autowired
	private SqlSessionFactory sessionFactory;

	@Override
	public String findidbycode(String gcode) {
		SqlSession session = sessionFactory.openSession();
		String gid = "";
		Map<String, String> map = new HashMap<>();
		map.put("gcode", gcode);
		try {
			
			gid = session.selectOne("goodModule.findidbycode", map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return gid;
	}

}
