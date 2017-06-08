package com.bupt.xrf.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.xrf.entity.ReqGood;
import com.bupt.xrf.entity.Requirement;
import com.bupt.xrf.service.IReqGoodService;
import com.bupt.xrf.service.IRequirementService;

@Controller("reqgoodController")
@RequestMapping("/reqgood")
public class ReqGoodController {

	@Autowired
	private IReqGoodService reqGoodService;
	
	@Autowired
	private IRequirementService requirementService;
	
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> findbypage(@RequestParam Map<String,Object> params){		
		String page = (String) params.get("page");
		String rows = (String) params.get("rows");
		
		Map<String, Object> resultmap = new HashMap<>();
		resultmap = reqGoodService.findbypage(Integer.valueOf(page), Integer.valueOf(rows));
		
		return resultmap;
	}
	
	@RequestMapping("/findbyrid")
	@ResponseBody
	public Map<String, Object> findbyrid(@RequestParam Map<String,Object> params){		
		String page = (String) params.get("page");
		String rows = (String) params.get("rows");
		String rid = (String) params.get("rid");
		
		Map<String, Object> resultmap = new HashMap<>();
		resultmap = reqGoodService.findbyrid(Integer.valueOf(page), Integer.valueOf(rows), rid);
		
		return resultmap;
	}
	
	@RequestMapping("/receivereq")
	@ResponseBody
	public Map<String, Object> receivereq(@RequestParam Map<String,Object> params){	
		reqGoodService.emptyreqgood();
		requirementService.emptyreq();
		String pa = (String)params.get("gid");
		String[] req = pa.split("\\*");
		for(String tmp : req){
			Requirement requirement = new Requirement();
			String[] reqgood = tmp.split("_");
			String gcode = reqgood[0];
			String amount = reqgood[1];
			String rid = reqgood[3]+reqgood[2];
			String batch = reqgood[2];
			String deadline = reqgood[3];
			requirement.setRid(rid);
			requirement.setBatch(batch);
			requirement.setDeadline(deadline);
			HashMap<String, Object> rg = new HashMap<>();
			rg.put("rid", rid);
			rg.put("gcode", gcode);
			rg.put("amount", amount);
			requirementService.addreq(requirement);
			reqGoodService.addreqgood(rg);
		}
		
		Map<String, Object> resultmap = new HashMap<>();
		
		return resultmap;
	}
	
	@RequestMapping("/adjustreqgood")
	@ResponseBody
	public Map<String, Object> adjustreqgood(@RequestParam Map<String,Object> params){	
		reqGoodService.setamount();
		
		Map<String, Object> resultmap = new HashMap<>();
		return resultmap;
	}
	
}
