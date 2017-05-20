/**
 * 
 */

$(document).ready(function(){
	//初始化物资表
	$('#whgoodstable').datagrid({
		url:'/mypaper/whgood/selectgoods?wid=' + staticwid,
		title:'出救物资表',
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
		{field:'gname',title:'物资名称',width:'18%',align:'center'},
		{field:'code',title:'物资编号',width:'21%',align:'center'},
		{field:'kind',title:'物资类型',width:'23%',align:'center'},
		//{field:'amount',title:'',width:'16%',align:'center'},
		{field:'usecount',title:'出救量',width:'19%',align:'center'},
		{field:'weight',title:'单位重量',width:'17%',align:'center'},
		]],
	});
	
	$('#logtable').datagrid({
		url:'/mypaper/whparkvehicle/findlogbywh?wid=' + staticwid,
		title:'物流园区表',
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
		{field:'p_name',title:'园区名称',width:'30%',align:'center'},
		{field:'tool',title:'出救方式',width:'15%',align:'center'},
		{field:'useamount',title:'出救运力',width:'18%',align:'center'},
		{field:'p_master',title:'联系人',width:'15%',align:'center'},
		{field:'p_contact',title:'联系方式',width:'20%',align:'center'}
		]],
	});
});

function closewindow(){
	$('#whinfo').window('close', true);
}
