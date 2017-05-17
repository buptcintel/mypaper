/**
 * 
 */

$(document).ready(function(){
	//初始化物资表
	$('#goodstable').datagrid({
		url:'/mypaper/whgood/findwhbygoods?gid=' + staticgid,
		title:'物资出救点',
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
		{field:'wname',title:'出救点名称',width:'22%',align:'center'},
		{field:'wtype',title:'出救点类型',width:'13%',align:'center'},
		{field:'usecount',title:'出救量',width:'12%',align:'center'},
		{field:'tool',title:'运输工具',width:'12%',align:'center'},
		{field:'arrivetime',title:'到达所需时间',width:'15%',align:'center'},
		{field:'contact',title:'联系人',width:'10%',align:'center'},
		{field:'number',title:'联系方式',width:'14%',align:'center'}
		]],
	});
});

function closewindow(){
	$('#goodsinfo').window('close', true);
}
