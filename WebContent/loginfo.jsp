<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/util/comUtil.jsp"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div style="height: 47%; margin-top: 5px;margin-left: 5px;margin-right: 5px;">
  		<table id="parkvhtable" class="easyui-datagrid"></table>
  	</div>
  	<div style="height: 40%; margin-top: 5px;margin-left: 5px;margin-right: 5px;">
  		<table id="logwhtable" class="easyui-datagrid"></table>
  	</div>
  	<div style="height: 4%; margin-top: 4px;" align="center">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="width:150px" onclick="closewindow()">确定</a>
  		<!-- <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" style="width:150px" onclick="">取消</a> -->
  	</div>
  	<script type="text/javascript" src="<%=path%>/public/js/loginfo.js"></script>
</body>
</html>