/**
 * 
 */
$(document).ready(function(){	
	
	initwhtable();
	initlogparktable();
})

function initwhtable(){
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
		{field:'wname',title:'仓储名称',width:'62%',align:'center'},
		//{field:'type',title:'类型',width:'20%',align:'center'},
		{field:'select',title: '选择物流',align: 'center',width:'17%',  
            //添加超级链 
            formatter:function(value,rowData,rowIndex){
                //function里面的三个参数代表当前字段值，当前行数据对象，行号（行号从0开始
                return "<a href='javacript:void(0);' " +
                		"onclick='select("+ "\""+rowData.wid+ "\""+", " + "\""+rowData.coordinate+ "\""+ ","+ "\""+rowData.tool+ "\");'>" +
                				"选择</a>";
           }  
        },
		{field:'detail',title: '出救物资',align: 'center',width:'17%',  
            //添加超级链 
            formatter:function(value,rowData,rowIndex){
                //function里面的三个参数代表当前字段值，当前行数据对象，行号（行号从0开始
                return "<a href='javacript:void(0);' onclick='showgoods("+rowData.wid+");'>查看</a>";
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
	            content = content + "<a href='javacript:void(0);' onclick='showgoods("+data.all[i].wid+");'>查看出救物资</a>";
	            content += "</div>";
	            
	            createMarker(point,content,'wh');
			}
		}
	});
	
	var p = $('#selectwh').datagrid('getPager');  
    $(p).pagination({  
        displayMsg: '共 {total} 条记录',  
    });
	
}

function initlogparktable(){
	
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
            	//可以查看该物流园区的所有运输工具
                return "<a href='javacript:void(0);' onclick='selectvehicle(" +rowData.pid+ ");'>查看</a>";
           }  
        }
		]],
		
		onClickRow : function(index, row){
			selectvehicle(row.pid);
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
	
}

function createMarker(point,content,flag){
	var myIcon;
	var title;
	if(flag == 'wh'){
		var myIcon = new BMap.Icon("/mypaper/img/warehouse_select.png", new BMap.Size(32, 32), {    //仓库
			imageOffset: new BMap.Size(0, 0)    //图片的偏移量。为了是图片底部中心对准坐标点。
		  });
		title = "仓储详细信息";
	}
	if(flag == 'lp'){
		var myIcon = new BMap.Icon("/mypaper/img/logpark.png", new BMap.Size(32, 32), {    //仓库
			imageOffset: new BMap.Size(0, 0)    //图片的偏移量。为了是图片底部中心对准坐标点。
		  });
		title = "仓储详细信息";
	}
	var opts = {
			  width : 400,     // 信息窗口宽度
			  height: 120,     // 信息窗口高度
			  title : title 	// 信息窗口标题
			}
	var pointMarker = new BMap.Marker(point, {icon:myIcon});
	map.addOverlay(pointMarker);
	var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象 
	pointMarker.addEventListener("click", function(){          
		map.openInfoWindow(infoWindow,point); //开启信息窗口
	});
}

var staticwid;
function showgoods(wid){
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

function select(wid, wcoordinate, tool){
	statictool = tool;
	var result = wcoordinate.split(",");
	var point = new BMap.Point(result[0], result[1]);
	map.centerAndZoom(point, 14);
	
	$.ajax({  
        type: "POST",  
        url: "/mypaper/logpark/list",
        data: {"wid":wid, "page":1, "rows":1000},	//page和rows随意赋值，不影响  
        success: function(data){  
        	for(var i = 0 ; i < data.rows.length ; i++){
	        	var coordinate = data.rows[i].p_coordinate.split(",");
	        	var point = new BMap.Point(coordinate[0], coordinate[1]);
	        	
	        	var content = "<div>";  
	            content = content + "名称：" + data.rows[i].p_name +"</br>";  
	            content = content + "详细地址：" + data.rows[i].p_location + "</br>"; 
	            content = content + "联系人：" + data.rows[i].p_master + "</br>"; 
	            content = content + "联系方式：" + data.rows[i].p_contact + "</br>"; 
	            //只能查看该仓储已经确定的运输工具类型
	            content = content + "<a href='javacript:void(0);' onclick='selectvehiclebytool("+ "\""+data.rows[i].pid+ "\""+", " + "\""+tool+ "\""+");'>查看详细信息</a>";
	            content += "</div>";
	            
	        	createMarker(point, content, 'lp');
        	}
        },  
        error: function(data){  
            alert("系统异常，请刷新后重试...");  
        }  
    });
}

function freshmap(){
	map.clearOverlays();
	var point = new BMap.Point(103.048991,30.016365);
	map.centerAndZoom(point, 7);
	var marker = new BMap.Marker(point);  // 创建标注
	map.addOverlay(marker);               // 将标注添加到地图中
	marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
	initwhtable();
}

var staticpid;
var statictool;
function selectvehiclebytool(pid, tool){
	staticpid = pid;
	statictool = tool;
	var url = "selectvehicle.jsp";
	var options = {
			title:"选择出救工具",
			href: url,
			width:800,
			height:400
		};
	$("#selectvehicle").window(options);
}

function selectvehicle(pid){
	staticpid = pid;
	statictool = '';
	var url = "selectvehicle.jsp";
	var options = {
			title:"选择出救工具",
			href: url,
			width:800,
			height:400
		};
	$("#selectvehicle").window(options);
}

function reset(){
	window.location.href = "index.jsp"
}

function next(){
	window.location.href = "taskpage.jsp";
}