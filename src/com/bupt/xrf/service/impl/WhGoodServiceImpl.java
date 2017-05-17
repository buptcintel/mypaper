package com.bupt.xrf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.xrf.dao.IWhGoodDao;
import com.bupt.xrf.entity.WhGood;
import com.bupt.xrf.service.IWhGoodService;

@Service("whgoodService")
public class WhGoodServiceImpl implements IWhGoodService {

	@Autowired
	private IWhGoodDao whgoodDao;
	
	@Override
	public Map<String, Object> findbypage(int page, int rows, String wid) {	
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
		List<WhGood> whGoods = whgoodDao.findbypage(page, rows, wid);
		for (WhGood tmp : whGoods) {

			Map<String, Object> resulttmp = new HashMap<String, Object>();
			resulttmp.put("gwid", tmp.getGwid());
			resulttmp.put("gid", tmp.getGood().getGid());
			resulttmp.put("gname", tmp.getGood().getGname());
			resulttmp.put("kind", tmp.getGood().getKind());
			resulttmp.put("code", tmp.getGood().getCode());
			resulttmp.put("amount", tmp.getAmount() + tmp.getGood().getUnit());
			resulttmp.put("usecount", tmp.getUsecount() + tmp.getGood().getUnit() );
			resulttmp.put("weight", tmp.getGood().getWeight() + "kg");
			resulttmp.put("ifuse", tmp.getIfuse());
			res.add(resulttmp);
		}
		
		result.put("total", whgoodDao.countall(wid));
		result.put("rows", res);
		return result;
	}

	@Override
	public void adjustuse(String gwid, String wid, String gid, int usecount, String ifuse) {
		Map<String, Object> params = new HashMap<>();
		params.put("gwid", gwid);
		params.put("wid", wid);
		params.put("gid", gid);
		params.put("usecount", usecount);
		params.put("ifuse", ifuse);
		whgoodDao.adjustuse(params);
	}

	@Override
	public Boolean ifusewh(String wid) {
		String ifusewh = whgoodDao.ifusewh(wid);
		if(ifusewh.equals("1"))
			return true;
		return false;
	}

	@Override
	public Map<String, Object> selectgoods(int page, int rows, String wid) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
		List<WhGood> whGoods = whgoodDao.selectgoods(page, rows, wid);
		for (WhGood tmp : whGoods) {

			Map<String, Object> resulttmp = new HashMap<String, Object>();
			resulttmp.put("gwid", tmp.getGwid());
			resulttmp.put("gid", tmp.getGood().getGid());
			resulttmp.put("gname", tmp.getGood().getGname());
			resulttmp.put("kind", tmp.getGood().getKind());
			resulttmp.put("code", tmp.getGood().getCode());
			resulttmp.put("amount", tmp.getAmount() + tmp.getGood().getUnit());
			resulttmp.put("usecount", tmp.getUsecount() + tmp.getGood().getUnit() );
			resulttmp.put("weight", tmp.getGood().getWeight() + "kg");
			res.add(resulttmp);
		}
		
		result.put("total", whgoodDao.countselectgoods(wid));
		result.put("rows", res);
		return result;
	}

	@Override
	public int calneedpower(String wid) {
		// TODO Auto-generated method stub
		return whgoodDao.calneedpower(wid);
	}

	@Override
	public Map<String, Object> findwhbygoods(int page, int rows, String gid) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
		List<WhGood> whGoods = whgoodDao.findwhbygoods(page, rows, gid);
		for (WhGood tmp : whGoods) {
			Map<String, Object> resulttmp = new HashMap<String, Object>();
			resulttmp.put("wid", tmp.getGood().getGid());
			resulttmp.put("wname", tmp.getWarehouse().getWname());
			resulttmp.put("usecount", tmp.getUsecount() + tmp.getGood().getUnit());
			resulttmp.put("tool", tmp.getWarehouse().getTool());
			resulttmp.put("wtype", tmp.getWarehouse().getType());
			resulttmp.put("number", tmp.getWarehouse().getNumber());
			resulttmp.put("contact", tmp.getWarehouse().getContact());
			resulttmp.put("timetoarrive", String.format("%.2f", tmp.getWarehouse().getTimetoarrive()));
			res.add(resulttmp);
		}
		
		result.put("total", whgoodDao.countfindwhbygoods(gid));
		result.put("rows", res);
		return result;
	}

	@Override
	public List<WhGood> findallwhbygoods(String gid) {
		// TODO Auto-generated method stub
		return whgoodDao.findallwhbygoods(gid);
	}

	@Override
	public List<WhGood> findall() {
		// TODO Auto-generated method stub
		return whgoodDao.findall();
	}

}
