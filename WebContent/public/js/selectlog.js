/**
 * 
 */
$(document).ready(function(){	
	//初始化物资表
	var IsCheckFlag = true; //标示是否是勾选复选框选中行的，true - 是 , false - 否
	$('#selectwh').datagrid({
		url:'/mypaper/warehouse/selectedwh',
		title:'已选仓储表',
		pageSize: 8,  
        pageList: [8, 16, 24],  
        height: '94%',
		iconCls:'icon-save',
		striped:true,
		rownumbers:true,
		pagination:true,
		singleSelect:false,
		loadMsg:'数据加载中......',
		columns:[[
		{field:'wname',title:'仓储名称',width:'60%',align:'center'},
		{field:'type',title:'类型',width:'20%',align:'center'},
		{field:'detail',title: '出救物资',align: 'center',width:'17%',  
            //添加超级链 
            formatter:function(value,rowData,rowIndex){
                //function里面的三个参数代表当前字段值，当前行数据对象，行号（行号从0开始
                return "<a href='javacript:void(0);' onclick='showgoods("+ "\""+rowData.wid+ "\""+", " + "\""+rowData.type+ "\""+");'>查看</a>";
           }  
        }
		]],
		//以下三个函数是控制 单击一行但不选中checkbox，注意，IsCheckFlag在上方定义
		onClickCell: function (rowIndex, field, value) {
			IsCheckFlag = false;
		},
		onSelect: function (rowIndex, rowData) {
			if (!IsCheckFlag) {
				IsCheckFlag = true;
				$("#selectwh").datagrid("unselectRow", rowIndex);
			}
		},                    
		onUnselect: function (rowIndex, rowData) {
			if (!IsCheckFlag) {
				IsCheckFlag = true;
				$("#selectwh").datagrid("selectRow", rowIndex);
			}
		},
		onLoadSuccess:function(data){
			var rowData = data.rows;  
			for(var i = 0; i < data.all.length; i++){
				var result = data.all[i].coordinate.split(",");
				var point = new BMap.Point(result[0], result[1]);
	            
	            var content = "<div>";  
	            content = content + "名称：" + data.all[i].wname +"</br>";  
	            content = content + "详细地址：" + data.all[i].location + "</br>"; 
	            content = content + "联系人：" + data.all[i].contact + "</br>"; 
	            content = content + "联系方式：" + data.all[i].number + "</br>"; 
	            content = content + "<a href='javacript:void(0);' onclick='showgoods("+ "\""+data.all[i].wid+ "\""+", "+ "\""+data.all[i].type+ "\""+");'>查看出救物资</a>";
	            content += "</div>";
	            
	            createMarker(point,content);
			}
		}
	});
	
	var p = $('#selectwh').datagrid('getPager');  
    $(p).pagination({  
        displayMsg: '共 {total} 条记录',  
    });
	
	//初始化物流公司表
    var IsCheckFlag2 = true; //标示是否是勾选复选框选中行的，true - 是 , false - 否
	$('#selectlog').datagrid({
		url:'/mypaper/logpark/list',
		title:'物流园区表',
		pageSize: 9,  
        pageList: [9, 18, 27],  
        height: '100%',
		iconCls:'icon-save',
		striped:true,
		rownumbers:true,
		pagination:true,
		singleSelect:false,
		loadMsg:'数据加载中......',
		columns:[[
		{field:'ck',checkbox:true,width:'5%'},
		{field:'p_name',title:'园区名称',width:'50%',align:'center'},
		{field:'p_power',title:'总运力(kg)',width:'24%',align:'center'},
		{field:'detail',title: '详情',align: 'center',width:'15%',  
            //添加超级链 
            formatter:function(value,rowData,rowIndex){
                //function里面的三个参数代表当前字段值，当前行数据对象，行号（行号从0开始
                return "<a href='javacript:void(0);' onclick='showvehicle(" +rowData.pid+ ");'>查看</a>";
           }  
        }
		]],
		
		onClickRow : function(index, row){
			showvehicles(row.lid);
		},
		//以下三个函数是控制 单击一行但不选中checkbox，注意，IsCheckFlag在上方定义
		onClickCell: function (rowIndex, field, value) {
			IsCheckFlag2 = false;
		},
		onSelect: function (rowIndex, rowData) {
			if (!IsCheckFlag2) {
				IsCheckFlag2 = true;
				$("#selectlog").datagrid("unselectRow", rowIndex);
			}
		},                    
		onUnselect: function (rowIndex, rowData) {
			if (!IsCheckFlag2) {
				IsCheckFlag2 = true;
				$("#selectlog").datagrid("selectRow", rowIndex);
			}
		}
	});
	
	var q = $('#selectlog').datagrid('getPager');  
    $(q).pagination({  
        displayMsg: '共 {total} 条记录',  
    });
	
})

function createMarker(point,content,flag){
	var myIcon = new BMap.Icon("/mypaper/img/warehouse_select.png", new BMap.Size(32, 32), {    //仓库
		imageOffset: new BMap.Size(0, 0)    //图片的偏移量。为了是图片底部中心对准坐标点。
	  });
	var opts = {
			  width : 400,     // 信息窗口宽度
			  height: 120,     // 信息窗口高度
			  title : "仓储详细信息" 	// 信息窗口标题
			}
	var pointMarker = new BMap.Marker(point, {icon:myIcon});
	map.addOverlay(pointMarker);
	var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象 
	pointMarker.addEventListener("click", function(){          
		map.openInfoWindow(infoWindow,point); //开启信息窗口
	});
}

var staticwid;
function showgoods(wid, wtype){
	staticwid = wid;
	var url = "showgoods.jsp";
	var options = {
			title:"出救物资信息",
			href: url,
			width:800,
			height:400
		};
	$("#showgoods").window(options);
}

function showvehicle(lid){
	alert(lid);
}

function reset(){
	window.location.href = "index.jsp"
}

function next(){
	window.location.href = "taskpage.jsp";
}