/**
 * 
 */

$(document).ready(function(){	
	$('#reqgoodtable').datagrid({
		url:'/mypaper/reqgood/list',
		title:'物资需求表',
		pageSize: 8,  
        pageList: [8, 16, 24],  
        height: '98%',
		iconCls:'icon-save',
		striped:true,
		rownumbers:true,
		pagination:true,
		singleSelect:false,
		loadMsg:'数据加载中......',
		columns:[[
		{field:'gname',title:'物资名称',width:'20%',align:'center'},
		{field:'code',title:'物资编号',width:'20%',align:'center'},
		{field:'kind',title:'物资类型',width:'20%',align:'center'},
		{field:'totalamount',title:'总数量',width:'20%',align:'center'},
		]],
	});
	
})

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
		pageSize: 8,  
        pageList: [8, 16, 24],  
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