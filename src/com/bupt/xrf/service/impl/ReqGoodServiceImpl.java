package com.bupt.xrf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.xrf.dao.IGoodDao;
import com.bupt.xrf.dao.IReqGoodDao;
import com.bupt.xrf.entity.ReqGood;
import com.bupt.xrf.service.IReqGoodService;

@Service("reqgoodService")
public class ReqGoodServiceImpl implements IReqGoodService {

	@Autowired
	private IReqGoodDao reqgoodDao;
	
	@Autowired
	private IGoodDao goodDao;
	
	@Override
	public Map<String, Object> findbypage(int page, int rows) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
		List<ReqGood> reqGoods = reqgoodDao.findbypage(page, rows);
		for (ReqGood tmp : reqGoods) {

			Map<String, Object> resulttmp = new HashMap<String, Object>();
			resulttmp.put("gid", tmp.getGood().getGid());
			resulttmp.put("gname", tmp.getGood().getGname());
			resulttmp.put("kind", tmp.getGood().getKind());
			resulttmp.put("code", tmp.getGood().getCode());
			resulttmp.put("amount", tmp.getAmount() + tmp.getGood().getUnit());
			resulttmp.put("totalamount", tmp.getTotalamount() + tmp.getGood().getUnit());
			resulttmp.put("deadline", tmp.getRequirement().getDeadline()+"小时");
			resulttmp.put("batch", "第" + tmp.getRequirement().getBatch() +"批次");
			res.add(resulttmp);
		}
		
		result.put("total", reqgoodDao.countall());
		result.put("rows", res);
		return result;
	}

	@Override
	public List<ReqGood> findall() {
		// TODO Auto-generated method stub
		return reqgoodDao.findall();
	}

	@Override
	public void addreqgood(HashMap<String, Object> rg) {
		String gcode = (String)rg.get("gcode");
		String gid = goodDao.findidbycode(gcode);
		HashMap<String, Object> map = new HashMap<>();
		map.put("gid", gid);
		map.put("rid", rg.get("rid"));
		map.put("rgid", rg.get("rid")+gid);
		map.put("totalamount", rg.get("amount"));
		reqgoodDao.addreqgood(map);
	}

	@Override
	public void emptyreqgood() {
		reqgoodDao.emptyreqgood();
	}

	@Override
	public void setamount() {
		reqgoodDao.setamount();
	}

	@Override
	public Map<String, Object> findbyrid(int page, int rows, String rid) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
		List<ReqGood> reqGoods = reqgoodDao.findbyrid(page, rows, rid);
		for (ReqGood tmp : reqGoods) {

			Map<String, Object> resulttmp = new HashMap<String, Object>();
			resulttmp.put("gid", tmp.getGood().getGid());
			resulttmp.put("gname", tmp.getGood().getGname());
			resulttmp.put("kind", tmp.getGood().getKind());
			resulttmp.put("code", tmp.getGood().getCode());
			resulttmp.put("amount", tmp.getAmount() + tmp.getGood().getUnit());
			resulttmp.put("totalamount", tmp.getTotalamount() + tmp.getGood().getUnit());
			resulttmp.put("deadline", tmp.getRequirement().getDeadline()+"小时");
			resulttmp.put("batch", "第" + tmp.getRequirement().getBatch() +"批次");
			res.add(resulttmp);
		}
		
		result.put("total", reqgoodDao.countallbyrid(rid));
		result.put("rows", res);
		return result;
	}
	
	
}
