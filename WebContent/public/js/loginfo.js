/**
 * 
 */

$(document).ready(function(){
	//初始化物资表
	$('#parkvhtable').datagrid({
		url:'/mypaper/parkvehicle/findusedvehiclebypk?pid=' + staticpid,
		title:'出救工具表',
		pageSize: 3,  
        pageList: [3, 6, 9],  
        height: '95%',
        width: '100%',
		iconCls:'icon-save',
		striped:true,
		rownumbers:true,
		pagination:true,
		singleSelect:false,
		loadMsg:'数据加载中......',
		columns:[[
		{field:'v_name',title:'工具名称',width:'25%',align:'center'},
		{field:'v_power',title:'工具运力(kg)',width:'25%',align:'center'},
		{field:'v_cost',title:'出救成本(元)',width:'25%',align:'center'},
		{field:'useamount',title:'出救量',width:'23%',align:'center'}
		]],
	});
	
	$('#logwhtable').datagrid({
		url:'/mypaper/whparkvehicle/findwhbypk?pid=' + staticpid,
		title:'服务仓储表',
		pageSize: 2,  
        pageList: [2, 4, 6],  
        height: '95%',
        width: '100%',
		iconCls:'icon-save',
		striped:true,
		rownumbers:true,
		pagination:true,
		singleSelect:false,
		loadMsg:'数据加载中......',
		columns:[[
		{field:'w_name',title:'园区名称',width:'25%',align:'center'},
		{field:'w_type',title:'仓储类型',width:'15%',align:'center'},
		{field:'usepower',title:'出救运力',width:'18%',align:'center'},
		{field:'w_contact',title:'联系人',width:'20%',align:'center'},
		{field:'w_number',title:'联系方式',width:'20%',align:'center'}
		]],
	});
});

function closewindow(){
	$('#loginfo').window('close', true);
}
