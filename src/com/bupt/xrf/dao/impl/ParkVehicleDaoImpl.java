package com.bupt.xrf.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bupt.xrf.dao.IParkVehicleDao;
import com.bupt.xrf.entity.ParkVehicle;

@Repository("parkVehicleDao")
public class ParkVehicleDaoImpl implements IParkVehicleDao {
	
	@Autowired
	private SqlSessionFactory sessionFactory;

	@Override
	public List<ParkVehicle> findvehiclebypk(int page, int rows, String pid) {
		SqlSession session = sessionFactory.openSession();
		List<ParkVehicle> parkVehicles = new ArrayList<>();
		RowBounds rowBounds = new RowBounds((page-1)*rows, rows);
		try {
			parkVehicles = session.selectList("parkvehicleModule.findvehiclebypk", pid, rowBounds);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return parkVehicles;
	}

	@Override
	public int countfindvehiclebypk(String pid) {
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("parkvehicleModule.countfindvehiclebypk", pid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<ParkVehicle> findvehiclebypkandtool(int page, int rows, String pid, String tool) {
		Map<String, Object> params = new HashMap<>();
		params.put("pid", pid);
		params.put("tool", tool);
		SqlSession session = sessionFactory.openSession();
		List<ParkVehicle> parkVehicles = new ArrayList<>();
		RowBounds rowBounds = new RowBounds((page-1)*rows, rows);
		try {
			parkVehicles = session.selectList("parkvehicleModule.findvehiclebypkandtool", params, rowBounds);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return parkVehicles;
	}

	@Override
	public int countfindvehiclebypkandtool(String pid, String tool) {
		Map<String, Object> params = new HashMap<>();
		params.put("pid", pid);
		params.put("tool", tool);
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("parkvehicleModule.countfindvehiclebypkandtool", params);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public void adjustuse(Map<String, Object> params) {
		SqlSession session = sessionFactory.openSession();	
		try {
			session.update("parkvehicleModule.adjustuse", params);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

}
