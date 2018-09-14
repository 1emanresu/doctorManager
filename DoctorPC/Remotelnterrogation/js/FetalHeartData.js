var sFHRoption;//存储小孕周 option
var lFHRoption;//存储大孕周 option
var sFHRChart;//存储小孕周 Chart
var lFHRChart;//存储大孕周Chart


var mid=sessionStorage.getItem("mid");
var address=sessionStorage.getItem("address");

/***************    初始化 胎心echarts       ******************/
//小胎心
function fetalSmall() {
	/*胎心监护 echarts画图 js */
	var resultdata = "";
	var chart18 = document.getElementById('echart18');
	//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽

	sFHRChart = echarts.init(chart18);
	//小孕周对应的option
    var fh_option = {


	//	title: {
	//		text: '胎心监护',
	//		padding: [5, 0, 0, 5],
	//
	//		textStyle: {
	//			fontWeight: 'normal',
	//			fontSize: 14
	//		}
	//	},
	tooltip: {
		trigger: 'axis'
	},
	axisPointer: {
		link: {
			xAxisIndex: 'all'
		}
	},
	//	grid: [{
	//		left: 40,
	//		right: 35,
	//		height: '85%'
	//	}],
	xAxis: [{

		type: 'category',
		boundaryGap: false,
		axisLine: {
			onZero: false
		},
		axisLabel: {
			interval: 59
		},
		splitLine: {
			show: true
		},
		data: []
	}],
	yAxis: [{
		name: '胎心率(bpm)',
		nameTextStyle: {
			fontSize: 12
		},
		nameGap: 15,
		type: 'value',
		max: 210,
		min: 50,
		splitNumber: 17,
		axisLabel: {
			show: true,
			textStyle: {
				color: "#555555"
			}
		},
		axisTick: {
			show: true

		},
		splitLine: {
			show: true,
			lineStyle: {
				// 使用深浅的间隔色
				color: '#FF86A7'
			}
		}
	}],
	//	X轴下方小图比例大小
	dataZoom: [{
		show: true,
		xAxisIndex: [0],
		start: 0,
		end: 100
	}],

	series: [{
		name: '胎心',
		type: 'line',
		data: [],
		//          data: data, 
		smooth: true,
		//标记点
		markPoint: {
			symbol: 'pin',
			silent: true, //不响应鼠标事件
			label: {
				normal: {

					formatter: function(param) {
						return param != null ? Math.round(param.value) : '';
					}
				}
			},
			itemStyle: {
				normal: {
					color: 'orange'
				}
			},
			data: [],
			tooltip: {
				formatter: function(param) {
					return param.name + '<br>' + (param.data.coord || '');
				}
			}
		},
		//标线（绿色虚线）
		markLine: {
			silent: true,
			lineStyle: {
				normal: {
					color: 'green'
				}
			},
			data: [{
				yAxis: 100
			}, {
				yAxis: 120
			}, {
				yAxis: 160
			}, {
				yAxis: 200
			}]
		},
		//标记区域（颜色区域）
		markArea: {
			silent: true,
			itemStyle: {
				normal: {
					color: 'rgba(237,252,249,0.7)'
				}
			},
			data: [
				[{
					yAxis: 120
				}, {
					yAxis: 160
				}]
			]
		}
	}, {
		type: 'scatter', //用于记录胎动（测试）
		symbol: 'circle',
		symbolSize: 10,
		data: []
	}],
	color: ['#999', '#3388FF', '#4EE2C0'] //自定义各个series颜色
};


	sFHRoption=fh_option;
	sFHRChart.setOption(fh_option);
	sFHRChart.showLoading();
	queryFetalSmalldata()
}
//大胎心
function fetalLarge() {
	/*胎心监护 echarts画图 js */
	
	var chart17 = document.getElementById('echart17');
	//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
//大孕周对应的 option
var fhAndUC_option = {
	id: 'main',
	tooltip: {
		trigger: 'axis'
	},
	axisPointer: {
		link: {
			xAxisIndex: 'all'
		}
	},
	grid: [{
		left: 35,
		right: 35,
		height: '55%'
	}, {
		left: 35,
		right: 35,
		top: '76%',
		height: '15%'
	}],
	xAxis: [{

			type: 'category',
			boundaryGap: false,
			axisLine: {
				onZero: false
			},
			axisLabel: {
				interval: 119
			},
			splitLine: {
				show: true
			},
			data:[]
		},
		{
			show: true,
			gridIndex: 1,
			type: 'category',
			boundaryGap: false,
			axisLine: {
				onZero: false
			},
			position: 'top',
			splitLine: {
				show: true
			},
			axisLabel: {
				show: false,

				interval: 119

			},
			axisTick: {
				show: false
			},
			data:[]
		}
	],
	yAxis: [{
			name: '胎心率(bpm)',
			nameTextStyle: {
				fontSize: 12
			},
			nameGap: 15,
			type: 'value',
			max: 210,
			min: 50,
			splitNumber: 17,
			axisLabel: {
				show: true,
				textStyle: {
					color: "#555555"
				}
			},
			axisTick: {
				show: true

			},
			splitLine: {
				show: true,
				lineStyle: {
					// 使用深浅的间隔色
					color: '#FF86A7'
				}
			}
		},
		{
			gridIndex: 1,
			name: '宫缩(mmHg)',
			nameLocation: 'start',
			nameGap: 8,
			type: 'value',
			max: 100,
			min: 0,
			axisLabel: {
				formatter: '{value}',
				textStyle: {
					color: "#555555"
				}
			},
			splitLine: {
				show: true,
				lineStyle: {
					// 使用深浅的间隔色
					color: '#FF86A7'
				}
			},
			//inverse: true    //反转y轴坐标
		}
	],
	//	X轴下方小图比例大小
	dataZoom: [{
		show: true,
		xAxisIndex: [0],
		start: 0,
		end: 100
	}, {

		//type: 'inside',
		realtime: true,
		start: 0,
		end: 100

	}, {
		//type: 'inside',
		show: true,
		xAxisIndex: [1],
		start: 0,
		end: 100

	}],

	/*visualMap: {
	    top: 10,
	    right: 10,
	    pieces: [{
	        gt: 0,
	        lte: 120,
	        color: 'orange'
	    }, {
	        gt: 160,
	        color: 'orange'
	    }],
	    outOfRange: {
	        color: '#999'
	    }
	},*/
	series: [{
			name: '胎心',
			type: 'line',
			data: [],
			//          data: data, 
			smooth: true,
			//标记点
			markPoint: {
				symbol: 'pin',
				silent: true, //不响应鼠标事件
				label: {
					normal: {

						formatter: function(param) {
							return param != null ? Math.round(param.value) : '';
						}
					}
				},
				itemStyle: {
					normal: {
						color: 'orange'
					}
				},
				data: [],
				tooltip: {
					formatter: function(param) {
						return param.name + '<br>' + (param.data.coord || '');
					}
				}
			},
			//标线（绿色虚线）
			markLine: {
				silent: true,
				lineStyle: {
					normal: {
						color: 'green'
					}
				},
				data: [{
					yAxis: 100
				}, {
					yAxis: 120
				}, {
					yAxis: 160
				}, {
					yAxis: 200
				}]
			},
			//标记区域（颜色区域）
			markArea: {
				silent: true,
				itemStyle: {
					normal: {
						color: 'rgba(237,252,249,0.7)'
					}
				},
				data: [
					[{
						yAxis: 120
					}, {
						yAxis: 160
					}]
				]
			}
		},
		{
			name: '宫缩',
			type: 'line',
			xAxisIndex: 1,
			yAxisIndex: 1,
			//symbolSize: 3,
			itemStyle: {
				normal: {
					lineStyle: {
						color: '#AEB1B1',
					}
				}
			},
			hoverAnimation: false,
			data: []
		}, {
			type: 'scatter', //用于记录胎动（测试）
			symbol: 'circle',
			symbolSize: 10,
			data: []
		}
	],
	color: ['#999', '#3388FF', '#4EE2C0'] //自定义各个series颜色
};

    lFHRoption=fhAndUC_option;
	lFHRChart = echarts.init(chart17);
	lFHRChart.setOption(fhAndUC_option);
	lFHRChart.showLoading();
	queryFetalLargedata()
}




/***************   查询胎心数据       ******************/
//查询小胎心数据
function queryFetalSmalldata(){
	//var mid=session.getItem("mid");
	//mid='dg000001';
	$.ajax({
		type: "post",
		
		dataType: 'json',
		url: address + "fetalHeartData/findSmallByMid.do",
	//	url:"http://192.168.1.43:8080/doctormanager/"+ "fetalHeartData/findSmallByMid.do",
		data:{
			mid:mid
		},
		success: function(e) {
			
			var data=e.data;
			if(data!=null){
				
				  var fhList=data.fhlistArr;
				  var fMlist=data.fmlistArr;
				 addFetalSmallData(fhList,fMlist);
				
			}else{
				alert("该孕妇暂无此胎心数据");
			}
		},
		error: function(e) {
			alert("该孕妇暂无此胎心数据");
		}
	});
}
//查询大胎心数据
function queryFetalLargedata(){
  // var mid=session.getItem("mid");
//	mid='dg000001';
	$.ajax({
		type: "post",
		
		dataType: 'json',
		url: address + "fetalHeartData/findLargeByMid.do",
	//	url: "http://192.168.1.43:8080/doctormanager/" + "fetalHeartData/findLargeByMid.do",
		data:{
			mid:mid
		},
		success: function(e) {
			
			var data=e.data;
			if(data!=null){
				  var fhList=data.fhlistArr;
				  var fMlist=data.fmlistArr;
				  var uclist=data.uclistArr;
				  var lengthtime=data.lengthtime;
				  var t=data.t;
				 addFetalLargeData(fhList,uclist,fMlist);
				 calculate(fhList, uclist, fMlist, lengthtime,t);
				
				
			}else{
				alert("该孕妇暂无此胎心数据");
			}
		},
		error: function(e) {
			alert("该孕妇暂无此胎心数据");
		}
	});
}

function toTime_FHR(i) {
	var item=i/2;
	var minute = parseInt(item / 60);
	var second = item % 60;
	if(minute < 1) {
		return second + "s";
	} else {
		return minute + "m" + second + "s";
	}
}
//function toTime_FHR(i) {
//var m = 0;
//var re;
//if(i < 10) {
//  re = "0" + m + ":0" + i;
//} else if(i >= 60) {
//  var m = parseInt(i / 60);
//  var ss = i % 60;
//  if(ss < 10) {
//    ss = "0" + i % 60;
//  } else {
//    ss = i % 60;
//  }
//  if(m < 10) {
//    re = "0" + m + ":" + ss;
//  } else {
//    re = m + ":" + ss;
//  }
//} else {
//  re = "0" + m + ":" + i;
//}
//return re;
//}


//往echarts增添小孕周数据
function addFetalSmallData(FHRdata,FMdata) {

	var xAixs = [];
	var dataxAisx = [];

	
	console.log(FHRdata.length);
	for(var i = 0; i < FHRdata.length; i++) {
			xAixs.push(toTime_FHR(i));
		
	}
	dataxAisx = xAixs; //横坐标结果集
	//小孕周对应数据
	sFHRoption.series[0].data = FHRdata;
	sFHRoption.xAxis[0].data = dataxAisx;
	sFHRChart.hideLoading();
	sFHRChart.setOption(sFHRoption);
	
}

//往echarts增添大孕周数据
function addFetalLargeData(FHRdata, ucdata,FMdata) {

	var xAixs = [];
	var dataxAisx = [];

	xAixs = [];
	for(var i = 0; i < FHRdata.length; i++) {
			xAixs.push(toTime_FHR(i));
	}
	dataxAisx = xAixs; //横坐标结果集
	
		//大孕周对应数据
		lFHRoption.series[0].data = FHRdata;
		lFHRoption.series[1].data = ucdata;
		lFHRoption.xAxis[0].data = dataxAisx;
		lFHRoption.xAxis[1].data = dataxAisx;
	lFHRChart.hideLoading();
	lFHRChart.setOption(lFHRoption);
	
}


/***************    计算评分       ******************/
var speedUpTimes = 15; //默认加速判定时长至少为15s
var declareTimes = 15; //默认减速判定时长至少为15s


function calculate(fetaHeart, fhr_uc, quicking, timer,t) {
	var sTimer = [1, 2];
	sTimer.push(timer);
	console.log("*********** calculate  **************")
	$.ajax({
		type: "post",
		data: {
			ylist: fetaHeart,
			uclist: fhr_uc,
			fMlist: quicking,
			datelist: sTimer,
			t: t,
			speedUpTimes: speedUpTimes,
			declareTimes: declareTimes,
			mode: 0
		},
		dataType: 'json',
		url: address + "fetalHeart/analysisFHRandUC.do",
	//	url: "http://192.168.1.43:8080/doctormanager/" + "fetalHeart/analysisFHRandUC.do",
		traditional: true,
		async: false,
		success: function(e) {
			var FHdata = e.data;
			console.log(JSON.stringify(FHdata))
			if(FHdata!=null && FHdata.Msglist.length>0){
				getLargeScore(FHdata);
			}
			else if(FHdata.Msglist.length==0){
				alert("该数据可能过于紊乱或过于稳定，无法检测出胎心加速或减速等情况，建议重新进行监测");
			}

		},
		error: function(e) {
			
		}
	});
}


//小孕周得分
function getSmallScore(data){

	var nst = data.nst;
				$("#s_flineScore").html(nst.flineScore);
				$("#s_fwaveScore").html(nst.fwaveScore);
				$("#s_friseScore").html(nst.friseScore);
				$("#s_fchangeScore").html(nst.fchangeScore);
				$("#s_sumScore").html(nst.fmoveScore);
				$("#s_Fischer").val(nst.sumScore );
				$("#s_fline").html(nst.fline);
				$("#s_fwave").html(nst.fwave);
				$("#s_frise").html(nst.frise);
				$("#s_fchange").html(nst.fchange);
				$("#s_fmove").html(nst.fmove);
	
}
//大孕周得分
function getLargeScore(data){
		var Msglist = data.Msglist;
	var baseFHR = 0;
	if(Msglist.length > 0) {
		baseFHR = Msglist[0].basevalue;
		for(var i = 0; i < Msglist.length; i++) {
			if(Msglist[i].type == 2) {
				//加速
				var peak = Msglist[i].peak;
				var temp_x = peak;
				addTab(temp_x, Msglist[i].max, '加速');
			}
			if(Msglist[i].type == 3) {
				//减速速
				var dtype = Msglist[i].dtype;
				console.log("dtype=" + dtype);
			}
		}
		lFHRChart.setOption({
		series: [{
			id: 'main',
			type: 'line',
			markLine: {
				silent: false,
				lineStyle: {
					normal: {
						color: 'green'
					}
				},
				label: {
					normal: {
						show: 'true',
						formatter: function(param) {
							return "基线" + Math.round(param.value);
						}

					}
				},
				data: [{
					yAxis: baseFHR
				}]
			}
		}]
	});
	}
	
	var nst = data.nst;
	
				$("#l_flineScore").html(nst.flineScore);
				$("#l_fwaveScore").html(nst.fwaveScore);
				$("#l_friseScore").html(nst.friseScore);
				$("#l_fchangeScore").html(nst.fchangeScore);
				$("#l_fmoveScore").html(nst.fmoveScore);
				$("#l_sumScore").html(nst.sumScore);
				$("#l_fline").html(nst.fline);
				$("#l_fwave").html(nst.fwave);
				$("#l_frise").html(nst.frise);
				$("#l_fchange").html(nst.fchange);
				$("#l_fmove").html(nst.fmove);
	
}

//添加标签信息
function addTab(temp_X, temp_Y, tip) {
    

	xValue = toTime_FHR(temp_X);
	
	var mk_data = lFHRoption.series[0].markPoint.data;
	var new_data = {
		coord: [xValue, temp_Y],
		value: tip
	};
	mk_data.push(new_data);
	lFHRChart.setOption({
		series: [{
			id: 'main',
			type: 'line',
			silent: true, //不响应鼠标事件（鼠标焦点 标签不显示纵坐标值）
			markPoint: {
				symbol: 'pin',
				label: {
					normal: {
						formatter: function(param) {
							return param != null ? param.value : '';
						}
					}
				},
				itemStyle: {
					normal: {
						//color: '#c4c4c4'
					}
				},
				data: mk_data
			}
		}]
	});
}
