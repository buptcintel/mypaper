package com.bupt.xrf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bupt.xrf.dao.ILogparkDao;
import com.bupt.xrf.entity.Logpark;

@Repository("logparkDao")
public class LogparkDaoImpl implements ILogparkDao {
	
	@Autowired
	private SqlSessionFactory sessionFactory;

	@Override
	public List<Logpark> findbypage(int page, int rows) {
		SqlSession session = sessionFactory.openSession();
		List<Logpark> logparks = new ArrayList<>();
		RowBounds rowBounds = new RowBounds((page-1)*rows, rows);
		try {
			logparks = session.selectList("logparkModule.findbypage", 0, rowBounds);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return logparks;
	}

	@Override
	public int countall() {
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("logparkModule.countall");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<Logpark> selectedpk(int page, int rows) {
		SqlSession session = sessionFactory.openSession();
		List<Logpark> logparks = new ArrayList<>();
		RowBounds rowBounds = new RowBounds((page-1)*rows, rows);
		try {
			logparks = session.selectList("logparkModule.selectedpk", 0, rowBounds);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return logparks;
	}

	@Override
	public int countselectedpk() {
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("logparkModule.countselectedpk");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public void settotaluse(String pid) {
		SqlSession session = sessionFactory.openSession();	
		try {
			session.update("logparkModule.settotaluse", pid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

	@Override
	public Logpark findbypid(String pid) {
		SqlSession session = sessionFactory.openSession();
		Logpark logpark = new Logpark();
		try {
			logpark = session.selectOne("logparkModule.findbypid", pid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return logpark;
	}

}
