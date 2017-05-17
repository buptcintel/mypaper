<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/util/comUtil.jsp"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div style="height: 80%; margin-top: 10px;margin-left: 5px;margin-right: 5px;">
		<span style="color: red;">*双击可修改物资出救数目，回车键保存</span>
  		<table id="goodstable" class="easyui-datagrid"></table>
  	</div>
  	<div style="margin-left: 5px;margin-top: 5px;">
  		<label >请选择运输工具：</label>
		<input type="radio" style="display: none;" name="tool" onclick="choosetool();" value="汽车"/>
		<label id="tool1" style="display: none;">汽车</label>
		<input type="radio" style="display: none;" name="tool" onclick="choosetool();" value="火车"/>
		<label id="tool2" style="display: none;">火车</label>
		<input type="radio" style="display: none;" name="tool" onclick="choosetool();" value="飞机"/>
		<label id="tool3" style="display: none;">飞机</label>
  	</div>
  	<div style="height: 5%; margin-top: 8px;" align="center">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="width:150px" onclick="closewindow()">确定</a>
  		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" style="width:150px" onclick="cancel()">取消</a>
  	</div>
  	<script type="text/javascript" src="<%=path%>/public/js/selectgoods.js"></script>
</body>
</html>