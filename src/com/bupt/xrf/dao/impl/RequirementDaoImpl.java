package com.bupt.xrf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bupt.xrf.dao.IRequirementDao;
import com.bupt.xrf.entity.Requirement;

@Repository("requirementDao")
public class RequirementDaoImpl implements IRequirementDao {

	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Override
	public void addreq(Requirement requirement) {
		SqlSession session = sessionFactory.openSession();
		try {
			session.insert("reqModule.addreq", requirement);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

	@Override
	public int exsit(String rid) {
		SqlSession session = sessionFactory.openSession();
		int result = 0;
		try {
			result = session.selectOne("reqModule.exsit", rid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public void emptyreq() {
		SqlSession session = sessionFactory.openSession();
		try {
			session.delete("reqModule.emptyreq");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

	@Override
	public List<Requirement> getallbatch() {
		SqlSession session = sessionFactory.openSession();
		List<Requirement> result = new ArrayList<>();
		try {
			result = session.selectList("reqModule.getallbatch");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<Requirement> getddlbybatch(String batch) {
		SqlSession session = sessionFactory.openSession();
		List<Requirement> result = new ArrayList<>();
		try {
			result = session.selectList("reqModule.getddlbybatch", batch);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

}
