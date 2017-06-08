package com.bupt.xrf.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.xrf.service.IRequirementService;

@Controller("requirementController")
@RequestMapping("/requirement")
public class RequirementController {
	
	@Autowired
	private IRequirementService requirementService;
	
	@RequestMapping("/ridinsession")
	@ResponseBody
	public Map<String, Object> ridinsession(@RequestParam Map<String, Object> params, HttpSession session){	
		Map<String, Object> map = new HashMap<>();
		String rid = params.get("rid")+"";
		session.setAttribute("rid", rid);
		return map;
	}
	
	@RequestMapping("/getallbatch")
	@ResponseBody
	public List<Map<String, Object>> getallbatch(){		
		List<Map<String, Object>> resultlist = new ArrayList<>();
		resultlist = requirementService.getallbatch();
		
		return resultlist;
	}
	
	@RequestMapping("/getddlbybatch")
	@ResponseBody
	public List<Map<String, Object>> getddlbybatch(@RequestParam Map<String, Object> params){
		String batch = params.get("batch")+"";
		List<Map<String, Object>> resultlist = new ArrayList<>();
		resultlist = requirementService.getddlbybatch(batch);
		
		return resultlist;
	}
}
