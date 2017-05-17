package com.bupt.xrf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.xrf.entity.WhGood;
import com.bupt.xrf.service.IWarehouseService;
import com.bupt.xrf.service.IWhGoodService;

@Controller("whgoodController")
@RequestMapping("/whgood")
public class WhGoodController {

	@Autowired
	private IWhGoodService whGoodService;
	
	@Autowired
	private IWarehouseService warehouseService;
	
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> findbypage(@RequestParam Map<String,Object> params){		
		String page = (String) params.get("page");
		String rows = (String) params.get("rows");
		String wid = (String) params.get("wid");
		
		Map<String, Object> resultmap = new HashMap<>();
		resultmap = whGoodService.findbypage(Integer.valueOf(page), Integer.valueOf(rows), wid);
		
		return resultmap;
	}
	@RequestMapping("/selectgoods")
	@ResponseBody
	public Map<String, Object> selectgoods(@RequestParam Map<String,Object> params){		
		String page = (String) params.get("page");
		String rows = (String) params.get("rows");
		String wid = (String) params.get("wid");
		
		Map<String, Object> resultmap = new HashMap<>();
		resultmap = whGoodService.selectgoods(Integer.valueOf(page), Integer.valueOf(rows), wid);
		
		return resultmap;
	}
	
	@RequestMapping("/adjustuse")
	@ResponseBody
	public Map<String, Object> adjustuse(@RequestParam Map<String,Object> params){		
		String wid = (String) params.get("wid");
		String gid = (String) params.get("gid");
		String gwid = (String) params.get("gwid");
		String usecount = (String) params.get("usecount");
		String ifuse;
		
		String regEx="[^0-9]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(usecount);   
		int count = Integer.valueOf(m.replaceAll("").trim());
		
		if(count > 0)
			ifuse = "1";
		else
			ifuse = "0";
		
		whGoodService.adjustuse(gwid, wid, gid, count, ifuse);
		int needpower = whGoodService.calneedpower(wid);
		warehouseService.setneedpower(wid, needpower);
		
		Map<String, Object> resultmap = new HashMap<>();
		return resultmap;
	}
	
	@RequestMapping("/findwhbygoods")
	@ResponseBody
	public Map<String, Object> findwhbygoods(@RequestParam Map<String, Object> params){
		String page = (String) params.get("page");
		String rows = (String) params.get("rows");
		String gid = (String) params.get("gid");
		Map<String, Object> resultmap = new HashMap<>();
		
		resultmap = whGoodService.findwhbygoods(Integer.valueOf(page), Integer.valueOf(rows), gid);
		
		List<WhGood> whGoods = whGoodService.findallwhbygoods(gid);
		resultmap.put("all", whGoods);
		return resultmap;
	}
}
