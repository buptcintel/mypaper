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

import com.bupt.xrf.dao.IWarehouseDao;
import com.bupt.xrf.entity.Warehouse;

@Repository("warehouseDao")
public class WarehouseDaoImpl implements IWarehouseDao {

	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Override
	public List<Warehouse> findbypage(int page, int rows) {
		SqlSession session = sessionFactory.openSession();
		List<Warehouse> warehouses = new ArrayList<>();
		RowBounds rowBounds = new RowBounds((page-1)*rows, rows);
		try {
			warehouses = session.selectList("warehouseModule.findbypage", 0, rowBounds);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return warehouses;
	}
	
	@Override
	public List<Warehouse> selectedwh(int page, int rows) {
		SqlSession session = sessionFactory.openSession();
		List<Warehouse> warehouses = new ArrayList<>();
		RowBounds rowBounds = new RowBounds((page-1)*rows, rows);
		try {
			warehouses = session.selectList("warehouseModule.selectedwh", 0, rowBounds);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return warehouses;
	}
	
	@Override
	public List<Warehouse> findall() {
		SqlSession session = sessionFactory.openSession();
		List<Warehouse> warehouses = new ArrayList<>();
		try {
			warehouses = session.selectList("warehouseModule.findbypage");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return warehouses;
	}
	
	@Override
	public int countall() {
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("warehouseModule.countall");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}
	
	@Override
	public int countselectedwh() {
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("warehouseModule.countselectedwh");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public void adjustwarehouse(Map<String, Object> params) {
		SqlSession session = sessionFactory.openSession();	
		try {
			session.update("warehouseModule.adjustwarehouse", params);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}
	
	@Override
	public Warehouse findbywid(String wid) {
		SqlSession session = sessionFactory.openSession();
		Warehouse warehouse = new Warehouse();
		try {
			warehouse = session.selectOne("warehouseModule.findbywid", wid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return warehouse;
	}

	@Override
	public List<Warehouse> selectedallwh() {
		SqlSession session = sessionFactory.openSession();
		List<Warehouse> warehouses = new ArrayList<>();
		try {
			warehouses = session.selectList("warehouseModule.selectedwh");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return warehouses;
	}

	@Override
	public double gettasktime() {
		SqlSession session = sessionFactory.openSession();
		double result = 0;
		try {
			result = session.selectOne("warehouseModule.gettasktime");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public double gettaskcost() {
		SqlSession session = sessionFactory.openSession();
		double result = 0;
		try {
			result = session.selectOne("warehouseModule.gettaskcost");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

}
