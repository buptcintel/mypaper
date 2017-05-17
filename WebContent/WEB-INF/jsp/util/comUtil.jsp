<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!--easyui 的主样式文件...-->  
<link rel="stylesheet" href="<%=path %>/UI/jquery-easyui-v1.4.4/themes/default/easyui.css">  

<!--easyui 的主样式文件...-->  
<link rel="stylesheet" href="<%=path %>/UI/jquery-easyui-v1.4.4/themes/icon.css"> 

<!-- easyui 支持 -->
<script src="<%=path %>/UI/jquery-easyui-v1.4.4/jquery.min.js"></script>
<script src="<%=path %>/UI/jquery-easyui-v1.4.4/jquery.easyui.min.js"></script>
<script src="<%=path %>/UI/jquery-easyui-v1.4.4/easyui-lang-zh_CN.js"></script>

<script src="<%=path %>/UI/highCharts/highcharts.js"></script>

