/**
 * 
 */

$(document).ready(function(){
	//初始化物资表
	var tool;
	if(statictool == '汽车')
		tool = 0;
	if(statictool == '火车')
		tool = 1;
	if(statictool == '飞机')
		tool = 2;
	
	var flag;
	var width;
	if(!statictool){
		flag = true;
		width = '24%';
	}
	else{
		flag = false;
		width = '19%';
	}
		
	var IsCheckFlag = true; //标示是否是勾选复选框选中行的，true - 是 , false - 否
	var lastIndex;			//双击变成可编辑时用
	$('#vhtable').datagrid({
		url:'/mypaper/parkvehicle/findvehiclebypk?pid=' + staticpid + '&tool=' + tool,
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
		{field:'ck',checkbox:true ,width:'5%', hidden:flag},
		{field:'v_name',title:'工具名称',width:width,align:'center'},
		{field:'v_power',title:'工具运力(kg)',width:'19%',align:'center'},
		{field:'v_cost',title:'出救成本(元)',width:'18%',align:'center'},
		{field:'availableamount',title:'可用量',width:'19%',align:'center'},
		{field:'useamount',title:'出救量',width:'19%',align:'center',editor: { type: 'text'}}
		]],
		onDblClickRow:function(rowIndex,rowData) {
			$("#vhtable").datagrid('endEdit',lastIndex);
			lastIndex = rowIndex;
			$("#vhtable").datagrid('beginEdit',rowIndex);
			document.onkeydown=function(){
				if (event.keyCode == 13){//空格键确认，否则无效
					$("#vhtable").datagrid('endEdit',rowIndex);
					updatevpgrid(rowData.pvid, rowData.vid, rowData.useamount, rowData.availableamount);
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
		},
		onLoadSuccess:function(data){
			var rowData = data.rows;  
            $.each(rowData,function(idx,val){//遍历JSON  
                  if(val.ifuse=='1'){  
                    $("#vhtable").datagrid("selectRow", idx);//如果数据行为已选中则选中改行  
                  }  
            });
		}
	});
});

function updatevpgrid(pvid, vid, useamount, availableamount){
	useamount = useamount.substring(0,useamount.length-1);
	availableamount = availableamount.substring(0,availableamount.length-1);
	if(window.confirm('确定修改？')){
		if(Number(availableamount) < Number(useamount)){
			alert("可用量不足，请重新输入！");
			$('#vhtable').datagrid('reload');
			return false;
		}
		else{
			$.ajax({  
		        type: "POST",  
		        url: "/mypaper/parkvehicle/adjustuse", 
		        data: {"pvid":pvid, "vid":vid, "pid":staticpid, "wid":staticwid,"useamount":useamount},  
		        success: function(data){  
		        	$('#vhtable').datagrid('reload');
		        },  
		        error: function(json){  
		            alert("系统异常，请刷新后重试...");  
		        }  
		    });  
			
	        return true;
		}
    }
	else{
		$('#vhtable').datagrid('reload');
        return false;
    }
}

function closewindow(){
	$('#selectvehicle').window('close', true);
	map.clearOverlays();
	freshmap();
	select(staticwid, staticwcoordinate, statictool);
}
