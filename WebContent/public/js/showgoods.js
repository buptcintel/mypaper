/**
 * 
 */

$(document).ready(function(){
	initspan(staticwid);
	
	//初始化物资表
	var IsCheckFlag = true; //标示是否是勾选复选框选中行的，true - 是 , false - 否
	var lastIndex;			//双击变成可编辑时用
	$('#goodstable').datagrid({
		url:'/mypaper/whgood/selectgoods?wid=' + staticwid,
		title:'出救物资表',
		pageSize: 7,  
        pageList: [7, 14, 21],  
        height: '95%',
        width: '100%',
		iconCls:'icon-save',
		striped:true,
		rownumbers:true,
		pagination:true,
		singleSelect:false,
		loadMsg:'数据加载中......',
		columns:[[
		{field:'gname',title:'物资名称',width:'15%',align:'center'},
		{field:'code',title:'物资编号',width:'18%',align:'center'},
		{field:'kind',title:'物资类型',width:'20%',align:'center'},
		{field:'amount',title:'存储量',width:'16%',align:'center'},
		{field:'usecount',title:'出救量',width:'16%',align:'center'},
		{field:'weight',title:'单位重量',width:'15%',align:'center'},
		]],
		//以下三个函数是控制 单击一行但不选中checkbox，注意，IsCheckFlag在上方定义
		onClickCell: function (rowIndex, field, value) {
			IsCheckFlag = false;
		},
		onSelect: function (rowIndex, rowData) {
			if (!IsCheckFlag) {
				IsCheckFlag = true;
				$("#goodstable").datagrid("unselectRow", rowIndex);
			}
		},                    
		onUnselect: function (rowIndex, rowData) {
			if (!IsCheckFlag) {
				IsCheckFlag = true;
				$("#goodstable").datagrid("selectRow", rowIndex);
			}
		}
	});
});

function initspan(wid){
	$.ajax({  
        type: "GET",  
        url: "/mypaper/warehouse/findbywid", 
        data: {"wid":staticwid},  
        success: function(data){
        	var needpower = data.warehouse.needpower;
        	var tool = data.warehouse.tool;
        	if(tool == 'plane')
        		tool = '飞机';
        	if(tool == 'ship')
        		tool = '轮船';
        	if(tool == 'car')
        		tool = '车辆';
        	document.getElementById("tool").innerText = "*需要"+tool+"运力"+needpower+"kg";
        	document.getElementById("tool").style.display="block";
        },  
        error: function(json){  
            alert("系统异常，请刷新后重试...");  
        }  
    });
}

function closewindow(){
	$('#showgoods').window('close', true);
}
