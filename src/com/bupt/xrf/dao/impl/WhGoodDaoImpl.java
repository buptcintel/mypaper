package com.bupt.xrf.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bupt.xrf.dao.IWhGoodDao;
import com.bupt.xrf.entity.WhGood;

@Repository("whgoodDao")
public class WhGoodDaoImpl implements IWhGoodDao {

	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Override
	public List<WhGood> findbypage(int page, int rows, String wid) {
		SqlSession session = sessionFactory.openSession();
		List<WhGood> whGoods = new ArrayList<>();
		RowBounds rowBounds = new RowBounds((page-1)*rows, rows);
		try {
			whGoods = session.selectList("whgoodModule.findbypage", wid, rowBounds);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return whGoods;
	}

	@Override
	public int countall(String wid) {
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("whgoodModule.countall", wid);
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
			session.update("whgoodModule.adjustuse", params);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

	@Override
	public String ifusewh(String wid) {
		SqlSession session = sessionFactory.openSession();
		String result = "";
		try {
			result = session.selectOne("whgoodModule.ifusewh", wid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<WhGood> selectgoods(int page, int rows, String wid) {
		SqlSession session = sessionFactory.openSession();
		List<WhGood> whGoods = new ArrayList<>();
		RowBounds rowBounds = new RowBounds((page-1)*rows, rows);
		try {
			whGoods = session.selectList("whgoodModule.selectgoods", wid, rowBounds);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return whGoods;
	}

	@Override
	public int countselectgoods(String wid) {
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("whgoodModule.countselectgoods", wid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int calneedpower(String wid) {
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("whgoodModule.calneedpower", wid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<WhGood> findwhbygoods(int page, int rows, String gid) {
		SqlSession session = sessionFactory.openSession();
		List<WhGood> whGoods = new ArrayList<>();
		RowBounds rowBounds = new RowBounds((page-1)*rows, rows);
		try {
			whGoods = session.selectList("whgoodModule.findwhbygoods", gid, rowBounds);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return whGoods;
	}

	@Override
	public int countfindwhbygoods(String gid) {
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("whgoodModule.countfindwhbygoods", gid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<WhGood> findallwhbygoods(String gid) {
		SqlSession session = sessionFactory.openSession();
		List<WhGood> whGoods = new ArrayList<>();
		try {
			whGoods = session.selectList("whgoodModule.findwhbygoods", gid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return whGoods;
	}

	@Override
	public List<WhGood> findall() {
		SqlSession session = sessionFactory.openSession();
		List<WhGood> whGoods = new ArrayList<>();
		try {
			whGoods = session.selectList("whgoodModule.findall");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return whGoods;
	}
}
