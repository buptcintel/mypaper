package com.bupt.xrf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bupt.xrf.dao.IWhParkVehicleDao;
import com.bupt.xrf.entity.WhParkVehicle;

@Repository("whParkVehicleDao")
public class WhParkVehicleDaoImpl implements IWhParkVehicleDao {
	
	@Autowired
	private SqlSessionFactory sessionFactory;

	@Override
	public List<WhParkVehicle> findlogbywh(int page, int rows, String wid) {
		SqlSession session = sessionFactory.openSession();
		List<WhParkVehicle> whParkVehicles = new ArrayList<>();
		RowBounds rowBounds = new RowBounds((page-1)*rows, rows);
		try {
			whParkVehicles = session.selectList("whparkvehicleModule.findlogbywh", wid, rowBounds);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return whParkVehicles;
	}

	@Override
	public int countfindlogbywh(String wid) {
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("whparkvehicleModule.countfindlogbywh", wid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<WhParkVehicle> findalllogbywh(String wid) {
		SqlSession session = sessionFactory.openSession();
		List<WhParkVehicle> whParkVehicles = new ArrayList<>();
		try {
			whParkVehicles = session.selectList("whparkvehicleModule.findlogbywh", wid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return whParkVehicles;
	}

}
