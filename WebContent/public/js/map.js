/**
 * 
 */
var plan = 0;
$(document).ready(function(){	
	alert("已经默认为您选择时间最短方案！");
	
	//初始化物资表
	$('#needgoods').datagrid({
		url:'/mypaper/reqgood/list',
		title:'物资需求表',
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
		{field:'gname',title:'物资名称',width:'17%',align:'center'},
		{field:'code',title:'物资编号',width:'22%',align:'center'},
		{field:'kind',title:'物资类型',width:'25%',align:'center'},
		{field:'amount',title:'数量',width:'16%',align:'center'},
		{field:'deadline',title:'限制时间',width:'17%',align:'center'}
		]],
	});
	
	var p = $('#needgoods').datagrid('getPager');  
    $(p).pagination({  
        displayMsg: '共 {total} 条记录',  
    });
	
	//初始化仓储表
    var IsCheckFlag = true; //标示是否是勾选复选框选中行的，true - 是 , false - 否
	$('#selectwarehouse').datagrid({
		url:'/mypaper/warehouse/list?plan='+plan,
		title:'仓储表',
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
		{field:'wname',title:'仓储名称',width:'55%',align:'center'},
		{field:'type',title:'类型',width:'18%',align:'center'},
		{field:'detail',title: '物资信息',align: 'center',width:'17%',  
            //添加超级链 
            formatter:function(value,rowData,rowIndex){
                //function里面的三个参数代表当前字段值，当前行数据对象，行号（行号从0开始
                return "<a href='javacript:void(0);' onclick='selectgoods("+ "\""+rowData.wid+ "\""+", " + "\""+rowData.type+ "\""+");'>查看</a>";
           }  
        }
		]],
		
		onClickRow : function(index, row){
			selectgoods(row.wid, row.type);
		},
		//以下三个函数是控制 单击一行但不选中checkbox，注意，IsCheckFlag在上方定义
		onClickCell: function (rowIndex, field, value) {
			IsCheckFlag = false;
		},
		onSelect: function (rowIndex, rowData) {
			if (!IsCheckFlag) {
				IsCheckFlag = true;
				$("#selectwarehouse").datagrid("unselectRow", rowIndex);
			}
		},                    
		onUnselect: function (rowIndex, rowData) {
			if (!IsCheckFlag) {
				IsCheckFlag = true;
				$("#selectwarehouse").datagrid("selectRow", rowIndex);
			}
		},
		
		onLoadSuccess:function(data){
			var rowData = data.rows;  
            $.each(rowData,function(idx,val){//遍历JSON  
                  if(val.flag=='1'){  
                    $("#selectwarehouse").datagrid("selectRow", idx);//如果数据行为已选中则选中改行  
                  }  
            });
			for(var i = 0; i < data.all.length; i++){
				var result = data.all[i].coordinate.split(",");
				var point = new BMap.Point(result[0], result[1]);
	            
	            var content = "<div>";  
	            content = content + "名称：" + data.all[i].wname +"</br>";  
	            content = content + "详细地址：" + data.all[i].location + "</br>"; 
	            content = content + "联系人：" + data.all[i].contact + "</br>"; 
	            content = content + "联系方式：" + data.all[i].number + "</br>"; 
	            content = content + "<a href='javacript:void(0);' onclick='selectgoods("+ "\""+data.all[i].wid+ "\""+", "+ "\""+data.all[i].type+ "\""+");'>查看物资信息</a>";
	            content += "</div>";
	            
	            createMarker(point,content,data.all[i].flag);
			}
		}
	});
	
	var q = $('#selectwarehouse').datagrid('getPager');  
    $(q).pagination({  
        displayMsg: '共 {total} 条记录',  
    });
	
})

function createMarker(point,content,flag){
	var myIcon;
	if(flag == '1'){
		var myIcon = new BMap.Icon("/mypaper/img/warehouse_select.png", new BMap.Size(32, 32), {    //仓库
			imageOffset: new BMap.Size(0, 0)    //图片的偏移量。为了是图片底部中心对准坐标点。
		  });
	}
	if(flag == '0'){
		var myIcon = new BMap.Icon("/mypaper/img/warehouse.png", new BMap.Size(32, 32), {    //仓库
			imageOffset: new BMap.Size(0, 0)    //图片的偏移量。为了是图片底部中心对准坐标点。
		  });
	}
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

function chooseplan(){
	var radio = document.getElementsByName("plan");  
    for (i=0; i<radio.length; i++) {
        if (radio[i].checked) {
            //alert(radio[i].value);
        	plan = radio[i].value;
        }
    }
    $('#selectwarehouse').datagrid("options").url = '/mypaper/warehouse/list?plan='+plan;  
    $('#selectwarehouse').datagrid('load');  
}

var staticwid;
var staticwtype;
function selectgoods(wid, wtype){
	staticwid = wid;
	staticwtype = wtype;
	var url = "selectgoods.jsp";
	var options = {
			title:"物资信息",
			href: url,
			width:800,
			height:450
		};
	$("#selectgoods").window(options);
}

function reset(){
	alert("reset");
}

function next(){
	//删除warehouse_park表中所有记录
	//将logpark表中totaluse字段设为0
	//将park_vehicle表中ifuse字段设为0，useamount字段设为0
//	$.ajax({  
//        type: "POST",  
//        url: "/mypaper/logpark/clearpark", 
//        success: function(data){  
//			
//        },  
//        error: function(json){  
//            alert("系统异常，请刷新后重试...");  
//        }  
//    });  
	window.location.href = "selectlog.jsp";
}