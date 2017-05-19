package com.bupt.xrf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.xrf.entity.WhParkVehicle;
import com.bupt.xrf.service.IWhParkVehicleService;

@Controller("whParkVehicleController")
@RequestMapping("/whparkvehicle")
public class WhParkVehicleController {
	
	@Autowired
	private IWhParkVehicleService whParkVehicleService;
	
	@RequestMapping("/findlogbywh")
	@ResponseBody
	public Map<String, Object> findlogbywh(@RequestParam Map<String, Object> params){
		String page = (String) params.get("page");
		String rows = (String) params.get("rows");
		String wid = (String) params.get("wid");
		Map<String, Object> resultmap = new HashMap<>();
		
		resultmap = whParkVehicleService.findlogbywh(Integer.valueOf(page), Integer.valueOf(rows),wid);

		List<WhParkVehicle> whParkVehicles = whParkVehicleService.findalllogbywh(wid);
		resultmap.put("all", whParkVehicles);
		return resultmap;
	}

}
