<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/util/comUtil.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=W2Ya62F5vA3lFaUdOwU16Sl2doGvLten"></script>
	<script type="text/javascript" src="<%=path%>/public/js/map.js"></script>
	<title>物资筹措</title>
</head>
<body class="easyui-layout">
	<div region="north" style="height:10%;overflow: hidden;">
  	  	<div align="center" style="overflow: hidden;height: 100%;background-color: #005392;">
  	  		<h1 style="margin-top: 20px;color: white;font-family: 微软雅黑;font-size: 36px;">应 急 物 流 平 台 物 资 筹 备 配 送 系 统</h1>
  	  	</div>
	</div>
	<div region="center" style="height: 90%; width:70%; margin-top: 5px;">
  	  	<div id="allmap" style="width: 100%; height: 100%;"></div>
  	</div>
  	<div region="east" style="width:30%; margin-top: 5px;">
  		<div style="margin-left: 5px;margin-top: 5px;">
  			<label >请选择方案：</label>
			<input type="radio" name="plan" onclick="chooseplan();" value="0" checked="true"/>
			<label >时间最短</label>
			<input type="radio" name="plan" onclick="chooseplan();" value="1"/>
			<label >成本最低</label>
			<input type="radio" name="plan" onclick="chooseplan();" value="2"/>
			<label >系统推荐</label>
  		</div>
  		<div style="width: 98%;height: 45%;margin-left: 5px;margin-top: 5px;">
  			<table id="needgoods" class="easyui-datagrid"></table>
  		</div>
  		<div style="width: 98%;height: 46%;margin-left: 5px;margin-top: 10px;">
  			<table id="selectwarehouse" class="easyui-datagrid"></table>
  		</div>
  	</div>
  	<div region="south" style="height:5%;">
  		<div style="height: 5%; margin-top: 5px;" align="center">
  			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" style="width:150px" onclick="reset()">重新选择</a>
  	  		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" style="width:150px" onclick="next()">仓储选择确认</a>
  	  	</div>
  	</div>
  	
  	<div id="selectgoods" modal="true" shadow="false" minimizable="false" cache="false" maximizable="false" collapsible="false" resizable="false"  style="margin: 0px;padding: 0px;overflow: auto;"></div>
</body>
</html>

<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(103.048991,30.016365);
	map.centerAndZoom(point, 7);
	var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
	var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
	var top_right_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL}); //右上角，仅包含平移和缩放按钮
	map.addControl(top_left_control);        
	map.addControl(top_left_navigation);     
	map.addControl(top_right_navigation);
	map.enableScrollWheelZoom(true);
	var marker = new BMap.Marker(point);  // 创建标注
	map.addOverlay(marker);               // 将标注添加到地图中
	marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
</script>