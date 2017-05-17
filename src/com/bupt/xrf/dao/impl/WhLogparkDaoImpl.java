package com.bupt.xrf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bupt.xrf.dao.IWhLogparkDao;
import com.bupt.xrf.entity.WhLogpark;

@Repository("whlogparkDao")
public class WhLogparkDaoImpl implements IWhLogparkDao {
	
	@Autowired
	private SqlSessionFactory sessionFactory;

	@Override
	public List<WhLogpark> findlogbywh(int page, int rows, String wid) {
		SqlSession session = sessionFactory.openSession();
		List<WhLogpark> whLogparks = new ArrayList<>();
		RowBounds rowBounds = new RowBounds((page-1)*rows, rows);
		try {
			whLogparks = session.selectList("whlogparkModule.findlogbywh", wid, rowBounds);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return whLogparks;
	}

	@Override
	public int countfindlogbywh(String wid) {
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("whlogparkModule.countfindlogbywh", wid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<WhLogpark> findalllogbywh(String wid) {
		SqlSession session = sessionFactory.openSession();
		List<WhLogpark> whLogparks = new ArrayList<>();
		try {
			whLogparks = session.selectList("whlogparkModule.findlogbywh", wid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return whLogparks;
	}

}
