/**
 * 
 */

$(document).ready(function(){
	//初始化物资表
	
	var IsCheckFlag = true; //标示是否是勾选复选框选中行的，true - 是 , false - 否
	var lastIndex;			//双击变成可编辑时用
	$('#vhtable').datagrid({
		url:'/mypaper/parkvehicle/findvehiclebypk?pid=' + staticpid,
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
		{field:'ck',checkbox:true,width:'5%'},
		{field:'v_name',title:'工具名称',width:'19%',align:'center'},
		{field:'v_power',title:'工具运力(kg)',width:'19%',align:'center'},
		{field:'v_cost',title:'出救成本(元)',width:'18%',align:'center'},
		{field:'vamount',title:'拥有量',width:'19%',align:'center',editor: { type: 'text'}},
		{field:'useamount',title:'出救量',width:'19%',align:'center'}
		]],
		onDblClickRow:function(rowIndex,rowData) {
			$("#vhtable").datagrid('endEdit',lastIndex);
			lastIndex = rowIndex;
			$("#vhtable").datagrid('beginEdit',rowIndex);
			document.onkeydown=function(){
				if (event.keyCode == 13){//空格键确认，否则无效
					$("#vhtable").datagrid('endEdit',rowIndex);
					updatevpgrid(rowData.pvid, rowData.vid, rowData.useamount);
				}
			};
		},
		//以下三个函数是控制 单击一行但不选中checkbox，注意，IsCheckFlag在上方定义
		onClickCell: function (rowIndex, field, value) {
			IsCheckFlag = false;
		},
		onSelect: function (rowIndex, rowData) {
			if (!IsCheckFlag) {
				IsCheckFlag = true;
				$("#vhtable").datagrid("unselectRow", rowIndex);
			}
		},                    
		onUnselect: function (rowIndex, rowData) {
			if (!IsCheckFlag) {
				IsCheckFlag = true;
				$("#vhtable").datagrid("selectRow", rowIndex);
			}
		}
	});
});

function useamount(pvid, vid, useamount){
	if(window.confirm('确定修改？')){
		//判断该物资是否还被选中出救
		$.ajax({  
	        type: "POST",  
	        url: "/mypaper/parkvehicle/adjustuse", 
	        data: {"pvid":pvid, "pid":staticpid,"vid":vid,"useamount":useamount},  
	        success: function(data){  
	        	$('#goodstable').datagrid('reload');
	        },  
	        error: function(json){  
	            alert("系统异常，请刷新后重试...");  
	        }  
	    });  
        return true;
    }
	else{
		$('#vhtable').datagrid('reload');
        return false;
    }
}

function closewindow(){
	$('#selectvehicle').window('close', true);
}

function setvh(){
	alert("确定");
	$('#selectvehicle').window('close', true);
}
