package com.bupt.xrf.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.xrf.service.IParkVehicleService;

@Controller("parkvehicleController")
@RequestMapping("parkvehicle")
public class ParkVehicleController {
	
	@Autowired
	private IParkVehicleService parkVehicleService;
	
	@RequestMapping("/findvehiclebypk")
	@ResponseBody
	public Map<String, Object> findbypage(@RequestParam Map<String,Object> params){		
		String page = (String) params.get("page");
		String rows = (String) params.get("rows");
		String pid = (String) params.get("pid");
		String tool = (String)params.get("tool");
		
		Map<String, Object> resultmap = new HashMap<>();
		if(tool.equals("undefined"))
			resultmap = parkVehicleService.findvehiclebypk(Integer.valueOf(page), Integer.valueOf(rows), pid);
		else
			resultmap = parkVehicleService.findvehiclebypkandtool(Integer.valueOf(page), Integer.valueOf(rows), pid, tool);
		return resultmap;
	}

}
