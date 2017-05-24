package com.bupt.xrf.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bupt.xrf.dao.IReqGoodDao;
import com.bupt.xrf.entity.ReqGood;

@Repository("reqgoodDao")
public class ReqGoodDaoImpl implements IReqGoodDao {

	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Override
	public List<ReqGood> findbypage(int page, int rows) {
		SqlSession session = sessionFactory.openSession();
		List<ReqGood> reqGoods = new ArrayList<>();
		RowBounds rowBounds = new RowBounds((page-1)*rows, rows);
		try {
			reqGoods = session.selectList("reqgoodModule.findbypage", 0, rowBounds);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return reqGoods;
	}
	
	@Override
	public List<ReqGood> findall() {
		SqlSession session = sessionFactory.openSession();
		List<ReqGood> reqGoods = new ArrayList<>();
		try {
			reqGoods = session.selectList("reqgoodModule.findbypage");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return reqGoods;
	}

	@Override
	public int countall() {
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("reqgoodModule.countall");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public void addreqgood(HashMap<String, Object> map) {
		SqlSession session = sessionFactory.openSession();
		try {
			session.insert("reqgoodModule.addreqgood", map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

	@Override
	public void emptyreqgood() {
		SqlSession session = sessionFactory.openSession();
		try {
			session.delete("reqgoodModule.emptyreqgood");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

	@Override
	public void setamount() {
		SqlSession session = sessionFactory.openSession();
		try {
			session.delete("reqgoodModule.setamount");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

}
