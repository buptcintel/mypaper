package com.bupt.xrf.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.xrf.service.ILogparkService;
import com.bupt.xrf.service.IParkVehicleService;
import com.bupt.xrf.service.IWhParkVehicleService;

@Controller("parkvehicleController")
@RequestMapping("parkvehicle")
public class ParkVehicleController {
	
	@Autowired
	private IParkVehicleService parkVehicleService;
	
	@Autowired
	private ILogparkService logparkService;
	
	@Autowired
	private IWhParkVehicleService whParkVehicleService;
	
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
	
	@RequestMapping("/adjustuse")
	@ResponseBody
	public Map<String, Object> adjustuse(@RequestParam Map<String,Object> params){		
		String wid = (String) params.get("wid");
		String pid = (String) params.get("pid");
		String pvid = (String) params.get("pvid");
		String vid = (String) params.get("vid");
		String useamount = (String) params.get("useamount");
		String ifuse;

		String regEx="[^0-9]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(useamount);   
		int count = Integer.valueOf(m.replaceAll("").trim());
		
		if(count > 0){
			if(whParkVehicleService.ifexistwpv(wid, pid, vid)){
				whParkVehicleService.updateuseamount(wid, pid, vid, count);
			}
			else{
				whParkVehicleService.insertnewwpv(wid, pid, vid, count);
			}
			ifuse = "1";
		}
		else{
			if(whParkVehicleService.ifexistwpv(wid, pid, vid)){
				whParkVehicleService.deletewpv(wid, pid, vid);
			}
			ifuse = "0";
		}
		
		parkVehicleService.adjustuse(pvid, pid, vid, count, ifuse);
		logparkService.settotaluse(pid);

		Map<String, Object> resultmap = new HashMap<>();
		return resultmap;
	}
	
	@RequestMapping("/findusedvehiclebypk")
	@ResponseBody
	public Map<String, Object> findusedvehiclebypk(@RequestParam Map<String,Object> params){		
		String page = (String) params.get("page");
		String rows = (String) params.get("rows");
		String pid = (String) params.get("pid");
		
		Map<String, Object> resultmap = new HashMap<>();
		
		resultmap = parkVehicleService.findusedvehiclebypk(Integer.valueOf(page), Integer.valueOf(rows), pid);
		
		return resultmap;
	}

}
