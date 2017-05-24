<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/util/comUtil.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=W2Ya62F5vA3lFaUdOwU16Sl2doGvLten"></script>
	<script type="text/javascript" src="<%=path%>/public/js/index.js"></script>
	<title>物资筹措</title>
</head>
<body class="easyui-layout">
	<div region="north" style="height:10%;overflow: hidden;">
  	  	<div align="center" style="overflow: hidden;height: 100%;background-color: #005392;">
  	  		<h1 style="margin-top: 20px;color: white;font-family: 微软雅黑;font-size: 36px;">应 急 物 流 平 台 物 资 筹 备 配 送 系 统</h1>
  	  	</div>
	</div>
	<div region="center" style="height: 90%; margin-top: 5px;">
  	  	<div style="width: 80%; height: 45%; margin: 5px auto;">
  	  		<table id="reqgoodtable" class="easyui-datagrid"></table>
  	  	</div>
  	  	<div style="height: 5%; margin-top: 5px;" align="center">
  	  		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" style="width:150px" onclick="distribute()">下发任务</a>
  	  	</div>
  	  	<div id="newtb" style="width: 80%; height: 45%; margin: 5px auto; display: none;">
  	  		<table id="newreqgoodtable" class="easyui-datagrid"></table>
  	  	</div>
  	</div>
  	<div region="south" style="height:5%;">
  		<div style="height: 5%; margin-top: 5px;" align="center">
  	  		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" style="width:150px" onclick="start()">开始调度</a>
  	  	</div>
  	</div>
</body>
</html>