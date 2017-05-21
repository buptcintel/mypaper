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
	public void updateuseamount(Map<String, Object> params) {
		SqlSession session = sessionFactory.openSession();	
		try {
			session.update("whparkvehicleModule.updateuseamount", params);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

	@Override
	public void insertnewwpv(Map<String, Object> params) {
		SqlSession session = sessionFactory.openSession();	
		try {
			session.insert("whparkvehicleModule.insertnewwpv", params);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

	@Override
	public void deletewpv(Map<String, Object> params) {
		SqlSession session = sessionFactory.openSession();	
		try {
			session.delete("whparkvehicleModule.deletewpv", params);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

	@Override
	public int ifexistwpv(Map<String, Object> params) {
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("whparkvehicleModule.ifexistwpv", params);
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

	@Override
	public int ifwhusepark(String wid, String pid) {
		SqlSession session = sessionFactory.openSession();
		Map<String, Object> params = new HashMap<>();
		params.put("wid", wid);
		params.put("pid", pid);
		int result = 0;
		try {
			result = session.selectOne("whparkvehicleModule.ifwhusepark", params);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int caluseamountbywhandpark(String wid, String pid) {
		SqlSession session = sessionFactory.openSession();
		Map<String, Object> params = new HashMap<>();
		params.put("wid", wid);
		params.put("pid", pid);
		int result = 0;
		try {
			result = session.selectOne("whparkvehicleModule.caluseamountbywhandpark", params);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<WhParkVehicle> findwhbypk(int page, int rows, String pid) {
		SqlSession session = sessionFactory.openSession();
		List<WhParkVehicle> whParkVehicles = new ArrayList<>();
		RowBounds rowBounds = new RowBounds((page-1)*rows, rows);
		try {
			whParkVehicles = session.selectList("whparkvehicleModule.findwhbypk", pid, rowBounds);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return whParkVehicles;
	}

	@Override
	public int countfindwhbypk(String pid) {
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("whparkvehicleModule.countfindwhbypk", pid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<WhParkVehicle> findallwhbypk(String pid) {
		SqlSession session = sessionFactory.openSession();
		List<WhParkVehicle> whParkVehicles = new ArrayList<>();
		try {
			whParkVehicles = session.selectList("whparkvehicleModule.findwhbypk", pid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return whParkVehicles;
	}

}
