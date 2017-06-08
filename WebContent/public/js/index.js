/**
 * 
 */

$(document).ready(function(){	
	
	$('#batch').combobox({
		url:'/mypaper/requirement/getallbatch',
		valueField:'id',
		textField:'text',
		onSelect: function (record) {
			initddlcombobox(record.id);
		},     
	});
	
	initfirsttable();
	
})

function initfirsttable(){
	$('#reqgoodtable').datagrid({
		url:'/mypaper/reqgood/list',
		title:'物资需求表',
		pageSize: 7,  
        pageList: [7, 14, 21],  
        height: '98%',
		iconCls:'icon-save',
		striped:true,
		rownumbers:true,
		pagination:true,
		singleSelect:false,
		loadMsg:'数据加载中......',
		columns:[[
		{field:'gname',title:'物资名称',width:'13%',align:'center'},
		{field:'code',title:'物资编号',width:'15%',align:'center'},
		{field:'kind',title:'物资类型',width:'15%',align:'center'},
		{field:'totalamount',title:'总数量',width:'15%',align:'center'},
		{field:'batch',title:'批次',width:'14%',align:'center'},
		{field:'deadline',title:'截止时间',width:'14%',align:'center'},
		]],
	});
}

function initddlcombobox(batch){
	$('#deadline').combobox({
		url:'/mypaper/requirement/getddlbybatch?batch='+batch,
		valueField:'id',
		textField:'text',  
		onSelect: function (record) {
			var rid = record.id + batch;
			$('#reqgoodtable').datagrid('reload', '/mypaper/reqgood/findbyrid?rid='+rid);
			document.getElementById("distribute").style.display="block";
		}, 
	});
}

function distribute(){
	$.ajax({  
        type: "POST",  
        url: "/mypaper/reqgood/adjustreqgood", 
        success: function(data){  
        	document.getElementById("newtb").style.display="block";
        	initnewtb();
        },  
        error: function(json){  
            alert("系统异常，请刷新后重试...");  
        }  
    });  
}

function initnewtb(){
	$('#newreqgoodtable').datagrid({
		url:'/mypaper/reqgood/list',
		title:'物资需求表',
		pageSize: 7,  
        pageList: [7, 14, 21],  
        height: '98%',
		iconCls:'icon-save',
		striped:true,
		rownumbers:true,
		pagination:true,
		singleSelect:false,
		loadMsg:'数据加载中......',
		columns:[[
		{field:'gname',title:'物资名称',width:'17%',align:'center'},
		{field:'code',title:'物资编号',width:'20%',align:'center'},
		{field:'kind',title:'物资类型',width:'20%',align:'center'},
		{field:'totalamount',title:'总数量',width:'18%',align:'center'},
		{field:'amount',title:'剩余数量',width:'18%',align:'center'}
		]],
	});
}

function start(){
	window.location.href = "map.jsp";
}