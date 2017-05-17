/**
 * 
 */
$(document).ready(function(){	
	initgoodtable();
	initwhtable();
    initlogtable();
})

function initgoodtable(){
	$('#goodtg').datagrid({
		url:'/mypaper/reqgood/list',
		title:'出救物资表',
		pageSize: 4,  
        pageList: [4, 8, 12],  
        height: '94%',
		iconCls:'icon-save',
		striped:true,
		rownumbers:true,
		pagination:true,
		singleSelect:false,
		loadMsg:'数据加载中......',
		columns:[[
		{field:'gname',title:'物资名称',width:'17%',align:'center'},
		{field:'code',title:'物资编号',width:'22%',align:'center'},
		{field:'kind',title:'物资类型',width:'25%',align:'center'},
		{field:'amount',title:'数量',width:'16%',align:'center'},
		{field:'detail',title: '出救详情',align: 'center',width:'17%',  
            //添加超级链 
            formatter:function(value,rowData,rowIndex){
                //function里面的三个参数代表当前字段值，当前行数据对象，行号（行号从0开始
                return "<a href='javacript:void(0);' onclick='showgoodinfo(" +rowData.gid+ ");'>表</a>" + "  " + 
                "<a href='javacript:void(0);' onclick='showgoodmap(" +rowData.gid+ ");'>图</a>" ;
           }  
        }
		]],
	});
	
	var p = $('#goodtg').datagrid('getPager');  
    $(p).pagination({  
        displayMsg: '共 {total} 条记录',  
    });
}

function initwhtable(){
	var IsCheckFlag = true; //标示是否是勾选复选框选中行的，true - 是 , false - 否
	$('#warehousetg').datagrid({
		url:'/mypaper/warehouse/selectedwh',
		title:'出救仓储表',
		pageSize: 4,  
        pageList: [4, 8, 12],  
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
                return "<a href='javacript:void(0);' onclick='showwhinfo(" +rowData.wid+ ");'>表</a>" + "  " + 
                "<a href='javacript:void(0);' onclick='showwhmap("+ "\""+rowData.wid+ "\""+", " + "\""+rowData.coordinate+ "\""+");'>图</a>" ;
           }  
        }
		]],
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
	            content = content + "<a href='javacript:void(0);' onclick='showwhinfo(" +data.all[i].wid+");'>查看详情</a>";
	            content += "</div>";
	            
	            createMarker(point,content);
			}
		}
	});
	
	var p = $('#warehousetg').datagrid('getPager');  
    $(p).pagination({  
        displayMsg: '共 {total} 条记录',  
    });
}

function initlogtable(){
	$('#logistictg').datagrid({
		url:'/mypaper/logpark/selectedpk',
		title:'出救物流园区表',
		pageSize: 4,  
        pageList: [4, 8, 12],  
        height: '100%',
		iconCls:'icon-save',
		striped:true,
		rownumbers:true,
		pagination:true,
		singleSelect:false,
		loadMsg:'数据加载中......',
		columns:[[
		{field:'p_name',title:'园区名称',width:'50%',align:'center'},
		{field:'totaluse',title:'出救运力(kg)',width:'27%',align:'center'},
		{field:'detail',title: '出救工具',align: 'center',width:'20%',  
            //添加超级链 
            formatter:function(value,rowData,rowIndex){
                //function里面的三个参数代表当前字段值，当前行数据对象，行号（行号从0开始
                return "<a href='javacript:void(0);' onclick='showpkinfo(" +rowData.lid+ ");'>查看</a>";
           }  
        }
		]],
	});
	
	var q = $('#logistictg').datagrid('getPager');  
    $(q).pagination({  
        displayMsg: '共 {total} 条记录',  
    });
}

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

var staticgid;
function showgoodinfo(gid){
	staticgid = gid;
	var url = "goodsinfo.jsp";
	var options = {
			title:"物资出救详情",
			href: url,
			width:800,
			height:400
		};
	$("#goodsinfo").window(options);
}

function showgoodmap(gid){
	freshmap();	//刷新地图
	$.ajax({  
        type: "POST",  
        url: "/mypaper/whgood/findwhbygoods",
        data: {"gid":gid, "page":1, "rows":10},	//page和rows随意赋值，不影响  
        success: function(data){  
        	for(var i = 0 ; i < data.all.length ; i++){
	        	var coordinate = data.all[i].warehouse.coordinate.split(",");
	        	var myIcon = new BMap.Icon("/mypaper/img/jiantou.png",{    //仓库
	        		imageOffset: new BMap.Size(64, 64)    //图片的偏移量。为了是图片底部中心对准坐标点。
	        	  });
	        	var point = new BMap.Point(coordinate[0], coordinate[1]);
	        	var pointMarker = new BMap.Marker(point, {icon:myIcon});
	        	map.addOverlay(pointMarker);
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

var staticwid;
function showwhinfo(wid){
	staticwid = wid;
	var url = "whinfo.jsp";
	var options = {
			title:"仓储出救详情",
			href: url,
			width:800,
			height:400
		};
	$("#whinfo").window(options);
}

function showwhmap(wid, wcoordinate){
	//map.clearOverlays();
	var result = wcoordinate.split(",");
	var point = new BMap.Point(result[0], result[1]);
	map.centerAndZoom(point, 14);
//	var myIcon = new BMap.Icon("/mypaper/img/warehouse_select.png", new BMap.Size(32, 32), {    //仓库
//		imageOffset: new BMap.Size(0, 0)    //图片的偏移量。为了是图片底部中心对准坐标点。
//	  });
//	var pointMarker = new BMap.Marker(point, {icon:myIcon});
//	map.addOverlay(pointMarker);
	
	$.ajax({  
        type: "POST",  
        url: "/mypaper/whlogpark/findlogbywh",
        data: {"wid":wid, "page":1, "rows":10},	//page和rows随意赋值，不影响  
        success: function(data){  
        	for(var i = 0 ; i < data.all.length ; i++){
	        	var coordinate = data.all[i].logpark.p_coordinate.split(",");
	        	var myIcon = new BMap.Icon("/mypaper/img/logpark_select.png",{    //仓库
	        		imageOffset: new BMap.Size(0, 0)    //图片的偏移量。为了是图片底部中心对准坐标点。
	        	  });
	        	var point = new BMap.Point(coordinate[0], coordinate[1]);
	        	var pointMarker = new BMap.Marker(point, {icon:myIcon});
	        	map.addOverlay(pointMarker);
        	}
        },  
        error: function(data){  
            alert("系统异常，请刷新后重试...");  
        }  
    });
}


function reset(){
	window.location.href = "selectlog.jsp"
}

function next(){
	alert("下发任务");
}