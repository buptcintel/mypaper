/**
 * 
 */

$(document).ready(function(){
	var title = '';
	var amount = '';
	if(staticwtype == '仓库'){
		title = '仓储物资表';
		amount = '存储量';
	}
	if(staticwtype == '供应商'){
		title = '供应商物资表';
		amount = '供应量';
	}
	if(staticwtype == '生产商'){
		title = '生产商物资表';
		amount = '产能';
	}
	
	initradio();
	
	//初始化物资表
	var IsCheckFlag = true; //标示是否是勾选复选框选中行的，true - 是 , false - 否
	var lastIndex;			//双击变成可编辑时用
	$('#goodstable').datagrid({
		url:'/mypaper/whgood/list?wid=' + staticwid,
		title:title,
		pageSize: 8,  
        pageList: [8, 16, 24],  
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
		{field:'gname',title:'物资名称',width:'14%',align:'center'},
		{field:'code',title:'物资编号',width:'17%',align:'center'},
		{field:'kind',title:'物资类型',width:'18%',align:'center'},
		{field:'amount',title:amount,width:'15%',align:'center'},
		{field:'usecount',title:'出救量',width:'15%',align:'center',editor: { type: 'text'}},
		{field:'weight',title:'单位重量',width:'15%',align:'center'},
		]],
		onDblClickRow:function(rowIndex,rowData) {
			$("#goodstable").datagrid('endEdit',lastIndex);
			lastIndex = rowIndex;
			$("#goodstable").datagrid('beginEdit',rowIndex);
			document.onkeydown=function(){
				if (event.keyCode == 13){
					$("#goodstable").datagrid('endEdit',rowIndex);
					updategrid(rowData.gwid, rowData.gid, rowData.usecount);
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
				$("#goodstable").datagrid("unselectRow", rowIndex);
			}
		},                    
		onUnselect: function (rowIndex, rowData) {
			if (!IsCheckFlag) {
				IsCheckFlag = true;
				$("#goodstable").datagrid("selectRow", rowIndex);
			}
		},
		onLoadSuccess:function(data){
			var rowData = data.rows;  
            $.each(rowData,function(idx,val){//遍历JSON  
                  if(val.ifuse=='1'){  
                    $("#goodstable").datagrid("selectRow", idx);//如果数据行为已选中则选中改行  
                  }  
            });
		}
	});
	
});

function initradio(){
	$.ajax({  
        type: "GET",  
        url: "/mypaper/warehouse/findbywid", 
        data: {"wid":staticwid},  
        success: function(data){
        	var trans = data.warehouse.transportation;
        	var radio = document.getElementsByName("tool");  
        	if(trans[0] == '1'){
        		document.getElementById("tool1").style.display="inline";
        		radio[0].style.display="inline";
        	}
        	if(trans[1] == '1'){
        		document.getElementById("tool2").style.display="inline";
        		radio[1].style.display="inline";
        	}
        	if(trans[2] == '1'){
        		document.getElementById("tool3").style.display="inline";
        		radio[2].style.display="inline";
        	}
            for (i=0; i<radio.length; i++) {
                if (radio[i].value == data.warehouse.tool) {
                    radio[i].checked = true;
                }
            }
        },  
        error: function(json){  
            alert("系统异常，请刷新后重试...");  
        }  
    });  
}

function updategrid(gwid, gid, usecount){
	if(window.confirm('确定修改？')){
		//判断该物资是否还被选中出救
		$.ajax({  
	        type: "POST",  
	        url: "/mypaper/whgood/adjustuse", 
	        data: {"gwid":gwid, "wid":staticwid,"gid":gid,"usecount":usecount},  
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
		$('#goodstable').datagrid('reload');
        return false;
    }
}

function choosetool(){
	if($('#goodstable').datagrid('getSelections').length == 0){
		var tools = document.getElementsByName('tool');
		for(var i = 0 ; i < tools.length ; i++){
			tools[i].checked = false;
		}
		alert("请先选择物资！！");
	}
}

function closewindow(){
	var radio = document.getElementsByName("tool");  
	var tool = '0';
    for (i=0; i<radio.length; i++) {
        if (radio[i].checked) {
            tool = radio[i].value;
        }
    }
	$('#selectgoods').window('close', true);
	//判断仓储中是否还有物资被选中，调整仓储表
	$.ajax({  
        type: "POST",  
        url: "/mypaper/warehouse/adjustwarehouse",
        data: {"wid":staticwid, "tool":tool},  
        success: function(data){  
        	$('#selectwarehouse').datagrid('load');
        	map.clearOverlays();
        },  
        error: function(json){  
            alert("系统异常，请刷新后重试...");  
        }  
    });
}

function cancel(){
	$('#selectgoods').window('close', true);
}