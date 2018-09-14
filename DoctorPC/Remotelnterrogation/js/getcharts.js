/* 画图*/
//var mid = "dg000001";
var mid=sessionStorage.getItem("mid");
var address=sessionStorage.getItem("address");
//var address = "http://192.168.1.43:8080/doctormanager/";
$("#makeEchart").click(function() {

	//showReportEcharts();
	findItems();
})

function showReportEcharts() {

	$('#modal_for_Report').modal('show');
	
}
var rname ;

function closeMove(){
	$('#modal_for_Report').modal('hide');
}
function findItems() {
	var thisTable = document.getElementById("report_table");
	var trs = thisTable.rows;
	
	var checkProjectId;
	var cnamelist = [];
	rname= $("#report_name").html();
	if(rname == "血常规报告单") {
		//console.log("血常规报告单")
		checkProjectId = 1;
		for(var i = 1; i < trs.length; i++) {
			//获取已选中的 tr对应的 指标名称
			if($("#check" + i).is(':checked')) {
				var cname = trs[i].cells[1].innerHTML;
				cnamelist.push(cname);
			}
	    }
		showReportEcharts();
		newReportChart(cnamelist,checkProjectId);
	} else {
		//尿常规
		//console.log("尿常规")
		checkProjectId = 2;
		var flag=true ;
		var nonList=['颜色','浑浊度']; //不能画图的指标
		for(var i = 1; i < trs.length; i++) {
			//获取已选中的 tr对应的 指标名称
			if($("#check" + i).is(':checked')) {
				var cname = trs[i].cells[1].innerHTML;
				for(var j=0; j<nonList.length;j++){
					if(cname==nonList[j]){
						flag=false ;
					}
				}
				if(flag){
					cnamelist.push(cname);
					
				}else{
					alert("您所选的指标中含有非量化指标，请重新选择");
					$('#modal_for_Report').modal('hide');
					break;
				}
			}
	    }
		if(flag){
			showReportEcharts();
			newReportChart(cnamelist,checkProjectId);
		}
	}
	
	

}

//新建echarts
function newReportChart(namalist,checkProjectId) {
	ReportChart = echarts.init(document.getElementById('report_charts'));
	
	// 显示标题，图例和空的坐标轴
	ReportChart.setOption({
		title: {
			text: rname
		},
		tooltip: {},

		xAxis: {
			data: []
		},
		yAxis: {},
		series: [{
			name: '',
			type: 'line',
			data: []
		}]
	});
	ReportChart.showLoading(); //数据加载完之前先显示一段简单的loading动画

	$.ajax({
		type: "post",
		async: true,
		//url:"http://192.168.1.43:8080/doctormanager/"+ "checkResult/queryHistoByCname.do",
		url: address + "checkResult/queryHistoByCname.do",
		data: {
			"cnamelist": namalist,
			"checkProjectId": checkProjectId,
			"mId": mid
		},
		traditional: true,
		dataType: "json",
		success: function(result) {
			var checkResult = result.data.checkResult;
			var length = checkResult.length;
			var names = []; //X轴坐标值
			var yvalues = []; // Y坐标值的数组 
			for(var j = 0; j < checkResult.length; j++) {
				console.log(j);

				var nums = []; //Y坐标值
				var cr = checkResult[j];
				for(var i = 0; i < cr.length; i++) {
					nums.push(cr[i].checkValue); //遍历取出并填入y轴
				}
				yvalues[j] = nums;
			}
			var cr = checkResult[0];
			for(var i = 0; i < cr.length; i++) {
				names.push(getDateString(cr[i].checkDate)); //遍历取出并填入x轴
			}
			if(length == 1) {
				console.log(1);
				var cr = checkResult[0];
				ReportChart.hideLoading(); //隐藏加载动画
				ReportChart.setOption({ //加载数据图表
					xAxis: {
						data: names
					},
					series: [{
						// 根据名字对应到相应的系列
						name: cr[0].cname,
						type: 'line',
						data: yvalues[0]
					}],
					legend: {
						data: namalist
					}
				});
			} else if(length == 2) {
				console.log(2);
				var cr = checkResult[0];
				var cr2 = checkResult[1];
				ReportChart.hideLoading(); //隐藏加载动画
				ReportChart.setOption({ //加载数据图表
					xAxis: {
						data: names
					},
					series: [{
						name: cr[0].cname,
						type: 'line',
						data: yvalues[0]
					}, {

						name: cr2[0].cname,
						type: 'line',
						data: yvalues[1]
					}],
					legend: {
						data: namalist
					}
				});
			} else if(length == 3) {
				console.log(3);
				var cr = checkResult[0];
				var cr2 = checkResult[1];
				var cr3 = checkResult[2];
				ReportChart.hideLoading(); //隐藏加载动画
				ReportChart.setOption({ //加载数据图表
					xAxis: {
						data: names
					},
					series: [{
						name: cr[0].cname,
						type: 'line',
						data: yvalues[0]
					}, {

						name: cr2[0].cname,
						type: 'line',
						data: yvalues[1]
					}, {

						name: cr3[0].cname,
						type: 'line',
						data: yvalues[2]
					}],
					legend: {
						data: namalist
					}
				});
			}

		},
		error: function(errorMsg) {
			//请求失败时执行该函数
			alert("图表请求数据失败!");
			ReportChart.hideLoading();
		}
	})
}

//function getDateString(mydate) {
//	var d = new Date(mydate);
//	//格式化日，如果小于9，前面补0  
//	var day = ("0" + d.getDate()).slice(-2);
//	//格式化月，如果小于9，前面补0  
//	var month = ("0" + (d.getMonth() + 1)).slice(-2);
//	//拼装完整日期格式  
//	var date1 = d.getFullYear() + "-" + (month) + "-" + (day);
//	return date1;
//
//}

$("#ech_send").click(function() {
	signSend("report_charts");
	$('#modal_for_Report').modal('hide');
	$("#div_report").css('display', 'none');
	markCircle2(false);
})
var draw = true;
$("#ech_mark").click(function() {
	if(draw) {
		markCircle2(draw);
		draw = false;
	} else {
		markCircle2(draw);
	}
})

function markCircle2(drawFlag2) {
	// 圆  
	var $circle = null;
	// 画布  
	var $drawing = $("#report_charts");
	// 圆心位置  
	var centerX = 0;
	var centerY = 0;
	// 是否正在画圆  
	var isDrawing = false;
	if(drawFlag2) {
		//增加鼠标绑定事件
		$drawing.bind('mousedown');
		// 按下鼠标开始画圆  
		$drawing.mousedown(function(event) {
			$circle = $('<div class="circle"></div>');
			centerX = event.pageX - $drawing.offset().left;
			centerY = event.pageY - $drawing.offset().top;
			$(this).append($circle);
			isDrawing = true;
			event.preventDefault();
		});
		// 鼠标拖动  
		$(document).mousemove(function(event) {
			if(isDrawing) {
				var radiusX = Math.abs(event.pageX - $drawing.offset().left - centerX);
				var radiusY = Math.abs(event.pageY - $drawing.offset().top - centerY);
				var radius = Math.sqrt(radiusX * radiusX + radiusY * radiusY); // 半径，勾股定理  

				// 下面四个条件判断是限制圆不能超出画布区域，如果不需要这个限制可以去掉这段代码  
				if(centerX - radius < 0) {
					radius = centerX;
				}
				if(centerY - radius < 0) {
					radius = centerY;
				}
				if(centerX + radius > $drawing.width()) {
					radius = $drawing.width() - centerX;
				}
				if(centerY + radius > $drawing.height()) {
					radius = $drawing.height() - centerY;
				}

				// 设置圆的大小和位置  
				$circle.css("left", centerX - radius + "px");
				$circle.css("top", centerY - radius + "px");
				$circle.css("width", 2 * radius + "px");
				$circle.css("height", 2 * radius + "px");
				$circle.css("border-radius", radius + "px");
			}
		});

		// 鼠标松开停止画圆  
		$(document).mouseup(function() {
			isDrawing = false;
		});
	} else {
		//解除鼠标绑定事件
		$drawing.unbind('mousedown');
		draw = true;
		return;
	}
}