<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/util/comUtil.jsp"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div style="height: 83%; margin-top: 10px;margin-left: 5px;margin-right: 5px;">
  		<table id="goodstable" class="easyui-datagrid"></table>
  	</div>
  	<div style="height: 7%; margin-top: 8px;" align="center">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="width:150px" onclick="closewindow()">确定</a>
  		<!-- <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" style="width:150px" onclick="">取消</a> -->
  	</div>
  	<script type="text/javascript" src="<%=path%>/public/js/goodsinfo.js"></script>
</body>
</html>