package com.bupt.xrf.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.xrf.service.ILogparkService;
import com.bupt.xrf.service.IParkVehicleService;
import com.bupt.xrf.service.IWhParkVehicleService;

@Controller("logparkController")
@RequestMapping("/logpark")
public class LogparkController {

	@Autowired
	private ILogparkService logparkService;
	
	@Autowired 
	private IParkVehicleService parkVehicleService;
	
	@Autowired
	private IWhParkVehicleService whParkVehicleService;
	
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> findbypage(@RequestParam Map<String,Object> params){		
		String page = (String) params.get("page");
		String rows = (String) params.get("rows");
		
		Map<String, Object> resultmap = new HashMap<>();		

		resultmap = logparkService.findbypage(Integer.valueOf(page), Integer.valueOf(rows));
		
		return resultmap;
	}
	
	@RequestMapping("/selectedpk")
	@ResponseBody
	public Map<String, Object> selectedpk(@RequestParam Map<String,Object> params){		
		String page = (String) params.get("page");
		String rows = (String) params.get("rows");
		
		Map<String, Object> resultmap = new HashMap<>();		

		resultmap = logparkService.selectedpk(Integer.valueOf(page), Integer.valueOf(rows));
		
		return resultmap;
	}
	
	@RequestMapping("/findbypid")
	@ResponseBody
	public Map<String, Object> findbypid(@RequestParam Map<String,Object> params){		
		String pid = (String) params.get("pid");
		
		return logparkService.findbypid(pid);
	}
	
	@RequestMapping("/clearpark")
	@ResponseBody
	public Map<String, Object> clearpark(){		
		logparkService.clearpark();
		parkVehicleService.clearpkvh();
		whParkVehicleService.clearall();
		
		Map<String, Object> resultmap = new HashMap<>();		
		return resultmap;
	}
	
	
}
