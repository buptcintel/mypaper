package com.bupt.xrf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.xrf.entity.ReqGood;
import com.bupt.xrf.entity.Warehouse;
import com.bupt.xrf.entity.WhGood;
import com.bupt.xrf.service.IReqGoodService;
import com.bupt.xrf.service.IWarehouseService;
import com.bupt.xrf.service.IWhGoodService;
import com.bupt.xrf.util.DistanceUtil;
import com.bupt.xrf.util.Idealpoints;

@Controller("warehouseController")
@RequestMapping("/warehouse")
public class WarehouseController {
	
	DistanceUtil distanceUtil = new DistanceUtil();

	@Autowired
	private IWarehouseService warehouseService;
	
	@Autowired
	private IWhGoodService whgoodService;
	
	@Autowired
	private IReqGoodService reqGoodService;
	
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> findbypage(@RequestParam Map<String,Object> params){	
		String plan = (String)params.get("plan");
		List<WhGood> whGoods = whgoodService.findall();
		List<Warehouse> warehouses = warehouseService.findall();
		List<ReqGood> reqGoods = reqGoodService.findall();
		
		//初始化数据库
		for (WhGood tmp : whGoods) {
			whgoodService.adjustuse(tmp.getGwid(), tmp.getWarehouse().getWid(), tmp.getGood().getGid(), 0, "0");
		}
		for(Warehouse warehouse : warehouses){
			warehouseService.adjustwarehouse(warehouse.getWid(), "0", "0", 0, 0);
			warehouseService.setneedpower(warehouse.getWid(), 0);
		}
		
		whGoods = whgoodService.findall();
		warehouses = warehouseService.findall();
		
		if(plan.equals("0")){
			Idealpoints idealpoints = new Idealpoints(warehouses, whGoods, reqGoods);
			idealpoints.algorithmformintime();
		}
		else if(plan.equals("1")){
			Idealpoints idealpoints = new Idealpoints(warehouses, whGoods, reqGoods);
			idealpoints.algorithmformincost();
		}
		else{
			Idealpoints idealpoints = new Idealpoints(warehouses, whGoods, reqGoods);
			idealpoints.algorithmformintime();
		}
		
		//将结果写入数据库
		for (WhGood tmp : whGoods) {
			if(tmp.getIfuse().equals("1"))
				whgoodService.adjustuse(tmp.getGwid(), tmp.getWarehouse().getWid(), tmp.getGood().getGid(), tmp.getUsecount(), "1");
		}
		for(Warehouse warehouse : warehouses){
			if(warehouse.getFlag().equals("1")){
				warehouseService.adjustwarehouse(warehouse.getWid(), "1", warehouse.getTool(), warehouse.getTimetoarrive(), warehouse.getTotalunitcost());
				int needpower = whgoodService.calneedpower(warehouse.getWid());
				warehouseService.setneedpower(warehouse.getWid(), needpower);
			}
			
		}
		//idealpoints.algorithmformincost();
		//idealpoints.bestalgorithm();
		
		String page = (String) params.get("page");
		String rows = (String) params.get("rows");
		
		Map<String, Object> resultmap = new HashMap<>();		

		resultmap = warehouseService.findbypage(Integer.valueOf(page), Integer.valueOf(rows));
		List<Warehouse> all = warehouseService.findall();
		
		resultmap.put("all", all);
		
		return resultmap;
	}
	
	@RequestMapping("/selectedwh")
	@ResponseBody
	public Map<String, Object> selectedwh(@RequestParam Map<String,Object> params){		
		String page = (String) params.get("page");
		String rows = (String) params.get("rows");
		
		Map<String, Object> resultmap = new HashMap<>();		

		resultmap = warehouseService.selectedwh(Integer.valueOf(page), Integer.valueOf(rows));
		
		List<Warehouse> all = warehouseService.selectedallwh();
		
		resultmap.put("all", all);
		
		return resultmap;
	}
	
	@RequestMapping("/adjustwarehouse")
	@ResponseBody
	public Map<String, Object> adjustwarehouse(@RequestParam Map<String,Object> params){		
		String wid = (String) params.get("wid");
		String tool = (String) params.get("tool");
		
		Boolean ifusewh = whgoodService.ifusewh(wid);
		if(ifusewh == true){
			int speed = 0;
			double vcost = 0;
			Warehouse warehouse = (Warehouse) warehouseService.findbywid(wid).get("warehouse");
			String[] tmp = warehouse.getCoordinate().split(",");
			double distance = distanceUtil.GetDistance(Double.valueOf(tmp[0]), Double.valueOf(tmp[1]), 103.048991, 30.016365);
			if(tool.equals("汽车")){
				speed = 60;
				vcost = 0.6;
			}
			if(tool.equals("火车")){
				speed = 80;
				vcost = 0.8;
			}
			if(tool.equals("飞机")){
				speed = 500;
				vcost = 1.5;
			}
			warehouseService.adjustwarehouse(wid, "1", tool, distance/speed, warehouse.getUnitcost());
		}
		else
			warehouseService.adjustwarehouse(wid, "0", "0", 0, 0);
		
		Map<String, Object> resultmap = new HashMap<>();	
		return resultmap;
	}
	
	@RequestMapping("/getifuse")
	@ResponseBody
	public Map<String, Object> getifuse(@RequestParam Map<String,Object> params){		
		String wid = (String) params.get("wid");
		
		Map<String, Object> resultmap = new HashMap<>();
		resultmap.put("ifuse", whgoodService.ifusewh(wid));
		return resultmap;
	}
	
	@RequestMapping("/findbywid")
	@ResponseBody
	public Map<String, Object> findbywid(@RequestParam Map<String,Object> params){		
		String wid = (String) params.get("wid");
		
		return warehouseService.findbywid(wid);
	}
}
