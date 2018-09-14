/*此js是自测工具中的趋势图显示调用的--zhangqt*/
var address = sessionStorage.getItem("address")
var mid = sessionStorage.getItem("mid");
//var address = "http://192.168.1.26:8080/doctormanager/";
//var address = "http://192.168.1.38:8080/doctormanager/";
//var mid = 'dg000001';
var seperator = "-";
//血压
$.ajax({
	type: "post",
	url: address + "bloodpressure/findByDateRange.do",
	data: {
		"mid": mid
	},
	dataType: "json",
	ContentType: "application/x-www-form-urlencoded;charset=utf-8",
	success: function(e) {
		var list = e.data;
		if(list.length==0){
			$("#bloodpressureDate1").css({"color":"#333","opacity":"0.25","cursor":"default"});
			$("#bloodpressureDate1").find('img').attr('src','images/u2638.png');
		}else{
			$("#bloodpressureDate1").click(function(){
				showTestDate('bloodpressureDate',1)
			})	 
		}
	},
	error: function() {
		$("#bloodpressureDate1").css({"color":"#333","opacity":"0.25","cursor":"default"});
		$("#bloodpressureDate1").find('img').attr('src','images/u2638.png');
	}
});
function bloodpressure() {
	var chart9 = document.getElementById('chart9');
	//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
	var resizemyChart9 = function() {
		chart9.style.width = window.innerWidth / 1.5 - 20 + 'px';
	};
	//设置容器高宽
	resizemyChart9();
	// 基于准备好的dom，初始化echarts实例
	var myChart9 = echarts.init(chart9);
	var option9 = {

		tooltip: {
			trigger: 'axis'
		},
		legend: {
			data: ['收缩压(mmHg)', '舒张压(mmHg)'],
			top: '30px'
		},
		calculable: true,
		xAxis: [{
			type: 'category',

			boundaryGap: false,
			data: [],
			axisLabel: {

				textStyle: {
					fontSize: 10
				}
			}
		}],
		yAxis: [{
			type: 'value',
			min: '40',
			max: '180',
			splitNumber: 7,
			axisLabel: {
				formatter: '{value}'
			}

		}],
		series: [{
			name: '收缩压(mmHg)',
			type: 'line',
			itemStyle: {
				normal: {
					color: '#0000CD'
				}
			},
			data: [],
			markArea: {
				silent: true,
				itemStyle: {
					normal: {
						color: {
							type: 'linear',
							colorStops: [{
								offset: 0.5,
								color: '#D8E8F7' // 0% 处的颜色
							}],
							globalCoord: false // 缺省为 false
						}
						// 径向渐变，前三个参数分别是圆心 x, y 和半径，取值同线性渐变
					}
				},
				data: [
					[{
						yAxis: 139
					}, {
						yAxis: 90
					}]
				]
			}
		}, {
			name: '收缩压最小值',
			type: 'line',
			itemStyle: {
				normal: {
					color: '#FF4500'
				}
			},
			data: [90],
			markLine: {
				data: [{
					type: 'average',
					name: '1'
				}]
			}
		}, {
			name: '舒张压(mmHg)',
			type: 'line',
			itemStyle: {
				normal: {
					color: '#8B4513'
				}
			},
			data: [],
			markArea: {
				silent: true,
				itemStyle: {
					normal: {
						color: {
							type: 'linear',
							colorStops: [{
								offset: 0.5,
								color: '#EDFCF9' // 0% 处的颜色
							}],
							globalCoord: false // 缺省为 false
						}
						// 径向渐变，前三个参数分别是圆心 x, y 和半径，取值同线性渐变
					}
				},
				data: [
					[{
						yAxis: 89
					}, {
						yAxis: 60
					}]
				]
			}
		}, {
			name: '收缩压最大值',
			type: 'line',
			itemStyle: {
				normal: {
					color: '#C0C0C0'
				}
			},
			data: [139],
			markLine: {
				data: [{
					type: 'average',
					name: '1'
				}]
			}
		}, {
			name: '舒张压最小值',
			type: 'line',
			itemStyle: {
				normal: {
					color: '#D8BFD8'
				}
			},
			data: [60],
			markLine: {
				data: [{
					type: 'average',
					name: '1'
				}]
			}
		}, {
			name: '舒张压最大值',
			type: 'line',
			itemStyle: {
				normal: {
					color: '#F5DEB3'
				}
			},
			data: [89],
			markLine: {
				data: [{
					type: 'average',
					name: '1'
				}]
			}
		}]
	};
	// 使用刚指定的配置项和数据显示图表。
	myChart9.setOption(option9);
	var systoliclist = [];
	var diastoliclist = [];
	var heartratelist = [];
	var datelist1 = [];
	var bloodpressureDate = [];
	$.ajax({
		type: "post",
		url: address + "bloodpressure/findByDateRange.do",
		data: {
			"mid": mid
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			var list = e.data;
			$.each(list, function(i) {
				var date1 = new Date(list[i].bdate);
				//var seperator1 = "-";
				var year = date1.getFullYear();
				var month = date1.getMonth() + 1;
				var hour = date1.getHours();
				var minute = date1.getMinutes();
				var second = date1.getSeconds();
				if(month < 10) {
					month = "0" + month;
				};
				var strDate = date1.getDate();
				if(strDate < 10) {
					strDate = "0" + strDate;
				}
				var currentdate = month + seperator + strDate + " " + hour + ":" + minute;
				datelist1.push(currentdate);
				bloodpressureDate.push(date1);
				systoliclist.push(list[i].systolic);
				diastoliclist.push(list[i].diastolic);
			});
			myChart9.setOption({
				xAxis: {
					data: datelist1
				},
				series: [{
					// 根据名字对应到相应的系列  
					name: '收缩压(mmHg)',
					data: systoliclist
				}, {
					name: '舒张压(mmHg)',
					type: 'line',
					data: diastoliclist
				}]
			});
		},
		error: function() {

		}
	});
}
//血糖
$.ajax({
	type: "post",
	url: address + "bloodsugre/findByDateRange.do",
	data: {
		"mid": mid
	},
	dataType: "json",
	ContentType: "application/x-www-form-urlencoded;charset=utf-8",
	success: function(e) {
		var list = e.data;
		if(list.length==0){
			$("#bloodsugarDate1").css({"color":"#333","opacity":"0.25","cursor":"default"});
			$("#bloodsugarDate1").find('img').attr('src','images/u2636.png');
		}else{
			$("#bloodsugarDate1").click(function(){
				showTestDate('bloodsugarDate',2);
			})	 
		}
	},
	error: function() {
		$("#bloodsugarDate1").css({"color":"#333","opacity":"0.25","cursor":"default"});
		$("#bloodsugarDate1").find('img').attr('src','images/u2636.png');
	}
});
function bloodsugar() {
	var chart1 = document.getElementById('chart1');
	//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
	var resizemyChart1 = function() {
		chart1.style.width = window.innerWidth / 2 - 20 + 'px';
	};
	//设置容器高宽
	resizemyChart1();
	// 基于准备好的dom，初始化echarts实例
	var myChart1 = echarts.init(chart1);
	var option1 = {
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			data: ['早餐前', '早餐后', '午餐前', '午餐后', '晚餐前', '晚餐后', '夜间'],
			top: '15px',
			textStyle: {
				fontSize: '12',
				color: '#555555',
				fontFamily: '微软雅黑'
			}
		},
		calculable: true,
		xAxis: [{
			type: 'category',
			boundaryGap: false,
			data: []
		}],
		yAxis: [{
			type: 'value',
			min: '4',
			max: '10',
			splitNumber: 6,
			axisLabel: {
				formatter: '{value}'
			}
		}],
		series: [{
			name: '餐前血糖最大值',
			type: 'line',
			itemStyle: {
				normal: {
					color: '#F5DEB3'
				}
			},
			data: [5.1],
			markLine: {
				data: [{
					type: 'average',
					name: '1'
				}]
			}
		}, {
			name: '餐后血糖最大值',
			type: 'line',
			itemStyle: {
				normal: {
					color: '#F5DEB3'
				}
			},
			data: [8.5],
			markLine: {
				data: [{
					type: 'average',
					name: '1'
				}]
			}
		}, {
			name: '早餐前',
			type: 'line',
			itemStyle: {
				normal: {
					color: '#00FF7F'
				}
			},
			data: [55, 99]
		}, {
			name: '早餐后',
			type: 'line',
			data: []
		}, {
			name: '午餐前',
			type: 'line',
			data: []
		}, {
			name: '午餐后',
			type: 'line',
			data: []
		}, {
			name: '晚餐前',
			type: 'line',
			data: []
		}, {
			name: '晚餐后',
			type: 'line',
			data: []
		}, {
			name: '夜间',
			type: 'line',
			data: []
		}]
	};
	// 使用刚指定的配置项和数据显示图表。
	myChart1.setOption(option1);
	//血糖
	var bBreakfastlist = [];
	var afbrelist = [];
	var bflunlist = [];
	var aflunlist = [];
	var bfdinlist = [];
	var afdinlist = [];
	var bfslelist = [];
	var datelist = [];
	var seperator = "-";
	$.ajax({
		type: "post",
		url: address + "bloodsugre/findByDateRange.do",
		data: {
			"mid": mid
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			var list = e.data;
			$.each(list, function(i) {
				var date = new Date(list[i].wdate);
				//var seperator1 = "-";
				var year = date.getFullYear();
				var month = date.getMonth() + 1;
				if(month < 10) {
					month = "0" + month;
				};
				var strDate = date.getDate();
				if(strDate < 10) {
					strDate = "0" + strDate;
				}
				var currentdate1 = year + seperator + month + seperator + strDate;
				bBreakfastlist.push(list[i].bbreakfast);
				afbrelist.push(list[i].afbre);
				bflunlist.push(list[i].bflun);
				aflunlist.push(list[i].aflun);
				bfdinlist.push(list[i].bfdin);
				afdinlist.push(list[i].afdin);
				bfslelist.push(list[i].bfsle);
				datelist.push(currentdate1);
			});
			myChart1.setOption({
				xAxis: {
					data: datelist
				},
				series: [{
					// 根据名字对应到相应的系列  
					name: '早餐前',
					data: bBreakfastlist
				}, {
					// 根据名字对应到相应的系列  
					name: '早餐后',
					data: afbrelist
				}, {
					// 根据名字对应到相应的系列  
					name: '午餐前',
					data: bflunlist
				}, {
					// 根据名字对应到相应的系列  
					name: '午餐后',
					data: aflunlist
				}, {
					// 根据名字对应到相应的系列  
					name: '晚餐前',
					data: bfdinlist
				}, {
					// 根据名字对应到相应的系列  
					name: '晚餐后',
					data: afdinlist
				}, {
					// 根据名字对应到相应的系列  
					name: '夜间',
					data: bfslelist
				}]
			});
		},
		error: function() {

		}
	});
}

//体重
$.ajax({
	type: "post",
	url: address + "gravidainfo/findWeight.do",
	data: {
		"mid": mid
	},
	dataType: "json",
	ContentType: "application/x-www-form-urlencoded;charset=utf-8",
	success: function(e) {
		datelist2 = e.data[0];
		if(datelist2.length==0){
			$("#weightData1").css({"color":"#333","opacity":"0.25","cursor":"default"});
			$("#weightData1").find("img").attr('src','images/u2635.png');
		}else{
			$("#weightData1").click(function(){
				showTestDate('weightData',5);
			})	 
		}
	},
	error: function() {
		$("#weightData1").css({"color":"#333","opacity":"0.25","cursor":"default"});
		$("#weightData1").find("img").attr('src','images/u2635.png');
	}
});
function weight() {
	var chart7 = document.getElementById('chart7');
	//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
	var resizemyChart7 = function() {
		chart7.style.width = window.innerWidth / 2 - 20 + 'px';
	};
	//设置容器高宽
	resizemyChart7();
	// 基于准备好的dom，初始化echarts实例
	var myChart7 = echarts.init(chart7);
	var option7 = {
		tooltip: {
			trigger: 'axis'
		},
		grid: {
			left: '8%',
			right: '15%',
			containLabel: true
		},
		legend: {
			data: ['体重', '体重上限', 'BMI'],
			top: "30px"
			//data: ['上限', '体重增长总量']
		},
		calculable: true,
		xAxis: [{
			type: 'category',
			name: '孕周',
			nameTextStyle: {
				color: "#555555",
				bottom: "30px"
			},
			nameGap: 60,
			boundaryGap: false,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				textStyle: {
					color: "#555555"
				}
			},
			data: [12, 13, 14, 15, 16, 17, 18]

		}],
		yAxis: [{
			type: 'value',
			min: '40',
			max: '60',
			splitNumber: 10,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				formatter: '{value}kg',
				textStyle: {
					color: "#555555"
				}
			}

		}, {
			type: 'value',
			min: '16',
			max: '26',
			splitNumber: 10,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				formatter: '{value}kg/㎡',
				textStyle: {
					color: "#555555"
				}
			}

		}],
		series: [{
			name: '体重',
			type: 'line',
			itemStyle: {
				normal: {
					color: '#708090'
				}
			},
			data: [46.2, 46.6, 46.8, 47.2, 47.5, 47.8, 48.3]
		}, {
			name: '体重上限',
			type: 'line',
			itemStyle: {
				normal: {
					color: '#FF4500'
				}
			},
			data: [46.4, 46.7, 47.0, 47.3, 47.7, 48.0, 48.4]
		}, {
			name: 'BMI',
			type: 'line',
			yAxisIndex: 1,
			itemStyle: {
				normal: {
					color: '#FFFF00'
				}
			},
			data: [19.8, 19.9, 20.1, 20.2, 20.4, 20.5, 20.7],
			markArea: {
				silent: true,
				itemStyle: {
					normal: {
						color: {
							type: 'linear',
							colorStops: [{
								offset: 0.5,
								color: '#EDFCF9' // 0% 处的颜色
							}],
							globalCoord: false // 缺省为 false
						}
						// 径向渐变，前三个参数分别是圆心 x, y 和半径，取值同线性渐变
					}
				},
				data: [
					[{
						yAxis: 24.9
					}, {
						yAxis: 18.5
					}]
				]
			}
		}]
	};
	// 使用刚指定的配置项和数据显示图表。
	myChart7.setOption(option7);
	var weightlist = [];
	var weightoringinlist = [];
	var datelist2 = [];
	var weightlimit = [];
	var BMIlist = [];
	$.ajax({
		type: "post",
		url: address + "gravidainfo/findWeight.do",
		data: {
			"mid": mid
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			weightlist = e.data[1];
			datelist2 = e.data[0];
			weightlimit = e.data[2];
			weightoringinlist = e.data[3];
			var height = e.data[4];
			var tableStr = '';
			for(var i = 0; i < datelist2.length; i++) {
				BMIlist.push((weightlist[i] / height / height * 10000).toFixed(1));
				tableStr += "<tr><td>孕" + datelist2[i] + "周</td><td>" + weightlist[i] + "</td><td>" + BMIlist[i] + "</td><td>" + weightlimit[i] + "</td></tr>"
			}
			$(".table-for-weight").append(tableStr);
			myChart7.setOption({
				xAxis: {
					data: datelist2
				},
				series: [{
					name: '体重上限',
					type: 'line',
					data: weightlimit
				}, {
					name: '体重',
					type: 'line',
					data: weightlist
				}, {
					name: 'BMI',
					type: 'line',
					data: BMIlist
				}]
			});
		},
		error: function() {

		}
	});
}

//体温
$.ajax({
	type: "post",
	url: address + "temperature/findByDateRange.do",
	data: {
		"mid": mid
	},
	dataType: "json",
	ContentType: "application/x-www-form-urlencoded;charset=utf-8",
	success: function(e) {
		var list = e.data;
		if(list.length==0){
			$("#temperatureData1").css({"color":"#333","opacity":"0.25","cursor":"default"});
			$("#temperatureData1").find("img").attr('src','images/u2628.png');
		}else{
			$("#temperatureData1").click(function(){
				showTestDate('temperatureData',10);
			})	 
		}
	},
	error: function() {
		$("#temperatureData1").css({"color":"#333","opacity":"0.25","cursor":"default"});
		$("#temperatureData1").find("img").attr('src','images/u2628.png');
	}
});
 
function temperature() {
	//体温
	var chart4 = document.getElementById('chart4');
	//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
	var resizemyChart4 = function() {
		chart4.style.width = window.innerWidth / 2 - 20 + 'px';
	};
	//设置容器高宽
	resizemyChart4();
	// 基于准备好的dom，初始化echarts实例
	var myChart4 = echarts.init(chart4);
	var option4 = {
		tooltip: {
			trigger: 'axis'
		},
		grid: {
			left: '3%',
			containLabel: true
		},
		xAxis: {
			type: 'category',
			boundaryGap: false,
			maxInterval: 5,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				textStyle: {
					color: "#555555"
				}
			},
			data: []
		},
		yAxis: {
			type: 'value',
			min: '35',
			max: '42',
			splitNumber: 7,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				formatter: '{value}℃',
				textStyle: {
					color: "#555555"
				}
			}
		},
		series: [{
			name: '体温',
			type: 'line',
			itemStyle: {
				normal: {
					color: '#FFFF00'
				}
			},
			data: [],
			markPoint: {
				data: [{
						type: 'max',
						name: '最大值'
					},
					{
						type: 'min',
						name: '最小值'
					}
				]
			},
		}, ]
	};
	myChart4.setOption(option4);
	//end

	//体温
	var temperaturelist = [];
	var datelist3 = [];
	$.ajax({
		type: "post",
		url: address + "temperature/findByDateRange.do",
		data: {
			"mid": mid
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			var list = e.data;
			$.each(list, function(i) {
				var date = new Date(list[i].tdate);
				//var seperator1 = "-";
				var year = date.getFullYear();
				var month = date.getMonth() + 1;
				if(month < 10) {
					month = "0" + month;
				};
				var strDate = date.getDate();
				if(strDate < 10) {
					strDate = "0" + strDate;
				}
				var currentdate1 = year + seperator + month + seperator + strDate;
				datelist3.push(currentdate1);
				temperaturelist.push(list[i].temperature);
			});
			//把起始日期转换回yyyy-MM-dd格式
			myChart4.setOption({
				xAxis: {
					data: datelist3
				},
				series: [{
					name: '体温',
					type: 'line',
					data: temperaturelist
				}]
			});
		},
		error: function() {

		}
	});
}

//腹围
$.ajax({
	type: "post",
	url: address + "abdominalgirth/find.do",
	data: {
		"mid": mid,
	},
	dataType: "json",
	ContentType: "application/x-www-form-urlencoded;charset=utf-8",
	success: function(e) {
		datelist9 = e.data[1];
		if(datelist9.length==0){
			$("#circumferenceDate1").css({"color":"#333","opacity":"0.25","cursor":"default"});
			$("#circumferenceDate1").find('img').attr('src','images/u2629.png');
		}else{
			$("#circumferenceDate1").click(function(){
				showTestDate('circumferenceDate',8);
			})	 
		}
	},
	error: function() {
		$("#circumferenceDate1").css({"color":"#333","opacity":"0.25","cursor":"default"});
		$("#circumferenceDate1").find('img').attr('src','images/u2629.png');
	}
});
function abdominalCircumference() {
	//腹围
	var chart12 = document.getElementById('chart12');
	//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
	var resizemyChart12 = function() {
		chart12.style.width = window.innerWidth / 2 - 20 + 'px';
	};
	//设置容器高宽
	resizemyChart12();
	// 基于准备好的dom，初始化echarts实例
	var myChart12 = echarts.init(chart12);
	var option12 = {
		tooltip: {
			trigger: 'axis'
		},
		grid: {
			left: '3%',
			right: '13%',
			containLabel: true
		},
		xAxis: {
			name: '孕周',
			type: 'category',
			boundaryGap: false,
			maxInterval: 5,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				textStyle: {
					color: "#555555"
				}
			},
			data: [16, 17, 18, 19, 20]
		},
		yAxis: {
			type: 'value',
			min: '70',
			max: '99',
			splitNumber: 10,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				formatter: '{value}cm',
				textStyle: {
					color: "#555555"
				}
			}
		},
		series: [{
			name: '腹围',
			type: 'line',
			itemStyle: {
				normal: {
					color: '#FF0000'
				}
			},
			data: [78, 79, 81, 82, 84],
			markArea: {
				silent: true,
				itemStyle: {
					normal: {
						color: {
							type: 'linear',
							colorStops: [{
								offset: 0.5,
								color: '#D8E8F7' // 0% 处的颜色
							}],
							globalCoord: false // 缺省为 false
						}
						// 径向渐变，前三个参数分别是圆心 x, y 和半径，取值同线性渐变
					}
				},
				data: [
					[{
						yAxis: 91
					}, {
						yAxis: 76
					}]
				]
			}
		}]
	};
	myChart12.setOption(option12);
	var abdominalgirthlist = [];
	var datelist9 = [];
	$.ajax({
		type: "post",
		url: address + "abdominalgirth/find.do",
		data: {
			"mid": mid,
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			abdominalgirthlist = e.data[0];
			datelist9 = e.data[1];
			var referenceList = e.data[2];
			var tableStr = ''
			for(var i = 0; i < datelist9.length; i++) {
				tableStr += "<tr><td>孕" + datelist9[i] + "周</td><td>" + abdominalgirthlist[i] + "</td><td>" + referenceList[i] + "</td></tr>"
			}
			$(".table-for-circumference").append(tableStr);
			myChart12.setOption({
				xAxis: {
					data: datelist9
				},
				series: [{
					name: '腹围',
					type: 'line',
					data: abdominalgirthlist
				}]
			});

		},
		error: function() {

		}
	});
}
//宫高
$.ajax({
	type: "post",
	url: address + "fundalheight/find.do",
	data: {
		"mid": mid
	},
	dataType: "json",
	ContentType: "application/x-www-form-urlencoded;charset=utf-8",
	success: function(e) {
		datelist10 = e.data[1];
		if(datelist10.length==0){
			$("#uterineDate1").css({"color":"#333","opacity":"0.25","cursor":"default"});
			$("#uterineDate1").find('img').attr('src','images/u2630.png');
		}else{
			$("#uterineDate1").click(function(){
				showTestDate('uterineDate',7);
			})	 
		}
	},
	error: function() {
		$("#uterineDate1").css({"color":"#333","opacity":"0.25","cursor":"default"});
		$("#uterineDate1").find('img').attr('src','images/u2630.png');
	}
});
function fundalHeight() {

	var chart13 = document.getElementById('chart13');
	//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
	var resizemyChart13 = function() {
		chart13.style.width = window.innerWidth / 2 - 20 + 'px';
	};
	//设置容器高宽
	resizemyChart13();
	// 基于准备好的dom，初始化echarts实例
	var myChart13 = echarts.init(chart13);
	var option13 = {
		tooltip: {
			trigger: 'axis'
		},
		grid: {
			left: '3%',
			right: '15%',
			containLabel: true
		},
		xAxis: {
			name: '孕周',
			type: 'category',
			boundaryGap: false,
			maxInterval: 5,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				textStyle: {
					color: "#555555"
				}
			},
			data: [23, 24, 25, 26, 27]
		},
		yAxis: {
			type: 'value',
			min: '15',
			max: '35',
			splitNumber: 5,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				formatter: '{value}cm',
				textStyle: {
					color: "#555555"
				}
			}
		},
		series: [{
			name: '宫高',
			type: 'line',
			itemStyle: {
				normal: {
					color: '#FFFF00'
				}
			},
			data: [21.3, 22.1, 22.9, 23.6, 24.7],
			markArea: {
				silent: true,
				itemStyle: {
					normal: {
						color: {
							type: 'linear',
							colorStops: [{
								offset: 0.5,
								color: '#D8E8F7' // 0% 处的颜色
							}],
							globalCoord: false // 缺省为 false
						}
						// 径向渐变，前三个参数分别是圆心 x, y 和半径，取值同线性渐变
					}
				},
				data: [
					[{
						yAxis: 27.5
					}, {
						yAxis: 19
					}]
				]
			}
		}]
	};
	myChart13.setOption(option13);
	var fundalheightlist = [];
	var datelist10 = [];
	$.ajax({
		type: "post",
		url: address + "fundalheight/find.do",
		data: {
			"mid": mid
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			fundalheightlist = e.data[0];
			datelist10 = e.data[1];
			var referenceList = e.data[2];
			var tableStr = ''
			for(var i = 0; i < datelist10.length; i++) {
				tableStr += "<tr><td>孕" + datelist10[i] + "周</td><td>" + fundalheightlist[i] + "</td><td>" + referenceList[i] + "</td></tr>"
			}
			$(".table-for-fundalheight").append(tableStr);
			myChart13.setOption({
				xAxis: {
					data: datelist10
				},
				series: [{
					name: '宫高',
					type: 'line',
					data: fundalheightlist
				}]
			});

		},
		error: function() {

		}
	});
}

//血脂
$.ajax({
	type: "post",
	url: address + "bloodfat/findByDateRange.do",
	data: {
		"mid": mid
	},
	dataType: "json",
	ContentType: "application/x-www-form-urlencoded;charset=utf-8",
	success: function(e) {
		var list = e.data;
		if(list.length==0){
			$("#bloodfatDate1").css({"color":"#333","opacity":"0.25","cursor":"default"});
			$("#bloodfatDate1").find('img').attr('src','images/u2640.png');
		}else{
			$("#bloodfatDate1").click(function(){
				showTestDate('bloodfatDate',11)
			})	 
		}
	},
	error: function() {
		$("#bloodfatDate1").css({"color":"#333","opacity":"0.25","cursor":"default"});
		$("#bloodfatDate1").find('img').attr('src','images/u2640.png');
	}
});

function bloodfat() {
	//血脂
	var chart5 = document.getElementById('chart5');
	//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
	var resizemyChart5 = function() {
		chart5.style.width = window.innerWidth / 2 - 20 + 'px';
	};
	//设置容器高宽
	resizemyChart5();
	// 基于准备好的dom，初始化echarts实例
	var myChart5 = echarts.init(chart5);
	var option5 = {
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			data: ['TRIG', 'CHOL', 'HDL', 'LDL', 'CHOL/HDL'],
			top: '35px',
			textStyle: {
				fontSize: '12',
				color: '#555555',
				fontFamily: '微软雅黑'
			}
		},
		grid: {
			left: '5%',
			right: '8%',
			bottom: '3%',
			containLabel: true
		},
		xAxis: {
			type: 'category',
			boundaryGap: false,
			splitLine: {
				show: true
			},
			axisLabel: {
				textStyle: {
					color: "#555555"
				}
			},
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			data: ['06-15', '06-16', '06-17', '06-18', '06-19']
		},
		yAxis: {
			type: 'value',
			min: '0',
			max: '7',
			splitNumber: 8,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			//minInterval: 3,
			axisLabel: {
				formatter: '{value}',
				textStyle: {
					color: "#555555"
				}
			}

		},
		series: [{
				name: 'TRIG',
				type: 'line',
				stack: '总量',
				itemStyle: {
					normal: {
						color: '#EE82EE'
					}
				},
				data: []
			},
			{
				name: 'CHOL',
				type: 'line',
				stack: '总量',
				itemStyle: {
					normal: {
						color: '#708090'
					}
				},
				data: []
			},
			{
				name: 'HDL',
				type: 'line',
				stack: '总量',
				itemStyle: {
					normal: {
						color: '#FA8072'
					}
				},
				data: []
			},
			{
				name: 'LDL',
				type: 'line',
				stack: '总量',
				itemStyle: {
					normal: {
						color: '#FFDAB9'
					}
				},
				data: []
			},
			{
				name: 'CHOL/HDL',
				type: 'line',
				stack: '总量',
				itemStyle: {
					normal: {
						color: '#DA70D6'
					}
				},
				data: []
			}
		]
	};
	myChart5.setOption(option5);
	//end

	//血脂
	var datalist1 = [];
	var datalist2 = [];
	var datalist3 = [];
	var datalist4 = [];
	var datalist5 = [];
	var datelist4 = [];
	$.ajax({
		type: "post",
		url: address + "bloodfat/findByDateRange.do",
		data: {
			"mid": mid
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			var list = e.data;
			$.each(list, function(i) {
				var date = new Date(list[i].bdate);
				//var seperator1 = "-";
				var year = date.getFullYear();
				var month = date.getMonth() + 1;
				if(month < 10) {
					month = "0" + month;
				};
				var strDate = date.getDate();
				if(strDate < 10) {
					strDate = "0" + strDate;
				}
				var currentdate1 = year + seperator + month + seperator + strDate;
				datelist4.push(currentdate1);
				datalist1.push(list[i].trig);
				datalist2.push(list[i].chol);
				datalist3.push(list[i].hdl);
				datalist4.push(list[i].ldl);
				datalist5.push(list[i].hdlc);
			});
			myChart5.setOption({
				xAxis: {
					data: datelist4
				},
				series: [{
						name: 'TRIG',
						type: 'line',
						stack: '1',
						data: datalist1
					},
					{
						name: 'CHOL',
						type: 'line',
						stack: '2',
						data: datalist2
					},
					{
						name: 'HDL',
						type: 'line',
						stack: '3',
						data: datalist3
					},
					{
						name: 'LDL',
						type: 'line',
						stack: '4',
						data: datalist4
					},
					{
						name: 'CHOL/HDL',
						type: 'line',
						stack: '5',
						data: datalist5
					}
				]
			});
		},
		error: function() {}
	});
}

//胎动
$.ajax({
	type: "post",
	url: address + "countQuickening/findByDateRange.do",
	data: {
		"mid": mid
	},
	dataType: "json",
	ContentType: "application/x-www-form-urlencoded;charset=utf-8",
	success: function(e) {
		var list = e.data;
		if(list.length==0){
			$("#fetalMovementData1").css({"color":"#333","opacity":"0.25","cursor":"default"});
			$("#fetalMovementData1").find('img').attr('src','images/u2632.png');
		}else{
			$("#fetalMovementData1").click(function(){
				showTestDate('fetalMovementData',6);
			})	 
		}
	},
	error: function() {
		$("#fetalMovementData1").css({"color":"#333","opacity":"0.25","cursor":"default"});
		$("#fetalMovementData1").find('img').attr('src','images/u2632.png');
	}
});			  
function featalMovement2() {
	var chart19 = document.getElementById('echart19');
	//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
	// 基于准备好的dom，初始化echarts实例
	var mychart19 = echarts.init(chart19);
	var option19 = {
		tooltip: {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				crossStyle: {
					color: '#8e8e93'
				}
			}
		},
		legend: {
			data: ['总次数', '单次次数'],
			top: '30px',
			textStyle: {
				color: '#555555',
				fontFamily: '微软雅黑'
			}
		},
		grid: {
			containLabel: true
		},
		xAxis: {
			type: 'category',
			boundaryGap: false,
			maxInterval: 5,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				textStyle: {
					color: "#555555"
				}
			},
			data: ['07-05 09:30', '07-05 3:21', '07-05 21:38', '07-06 8:53', '07-06 14:26', '07-06 20:45', '07-07 10:20', '07-07 16:03', '07-07 21:11', '07-08 8:53', '07-08 14:26', '07-08 20:45', '07-09 08:42', '07-09 15:11', '07-09 21:16']
		},
		yAxis: [{
			type: 'value',
			min: 0,
			max: 20,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			interval: 5,
			axisLabel: {
				formatter: '{value}',
				textStyle: {
					color: "#555555"
				}
			}
		}],
		series: [{
			name: '单次次数',
			type: 'line',
			data: [3, 5, 4, 3, 3, 4, 5, 3, 5, 4, 4, 5, 4, 3, 5],
			markArea: {
				silent: true,
				itemStyle: {
					normal: {
						color: {
							type: 'linear',
							colorStops: [{
								offset: 0.5,
								color: '#D8E8F7' // 0% 处的颜色
							}],
							globalCoord: false // 缺省为 false
						}
						// 径向渐变，前三个参数分别是圆心 x, y 和半径，取值同线性渐变
					}
				},
				data: [
					[{
						yAxis: 5
					}, {
						yAxis: 3
					}]
				]
			}
		}]
	};
	// 使用刚指定的配置项和数据显示图表。
	mychart19.setOption(option19);

	var chart20 = document.getElementById('echart20');
	//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
	// 基于准备好的dom，初始化echarts实例
	var myChart20 = echarts.init(chart20);
	var option20 = {
		tooltip: {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				crossStyle: {
					color: '#8e8e93'
				}
			}
		},
		legend: {
			data: ['总次数', '单次次数'],
			top: '30px',
			textStyle: {
				color: '#555555',
				fontFamily: '微软雅黑'
			}
		},
		grid: {
			containLabel: true
		},
		xAxis: {
			type: 'category',
			boundaryGap: false,
			maxInterval: 5,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				textStyle: {
					color: "#555555"
				}
			},
			data: ['07-05', '07-06', '07-07', '07-08', '07-09']
		},
		yAxis: [{
			type: 'value',
			min: 30,
			max: 240,
			interval: 30,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				textStyle: {
					color: "#555555"
				},
				formatter: '{value}'
			}
		}],
		series: [{
			name: '总次数',
			type: 'line',
			data: [36, 60, 48, 48, 36]
		}]
	};
	// 使用刚指定的配置项和数据显示图表。
	myChart20.setOption(option20);
	var actualclicklist = [];
	var datelist7 = [];
	var datelist8 = [];
	var seperator = "-";
	var sumclicklist = [];
	var sum = 0;
	var everydaytestindex = 0;
	var countquickeningflag = false
	var tableStr = ''
	var datelist9 = [];
	$.ajax({
		type: "post",
		url: address + "countQuickening/findByDateRange.do",
		data: {
			"mid": mid
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			var list = e.data;
			$.each(list, function(i) {
				var date = new Date(list[i].cdate);
				//var seperator1 = "-";
				var year = date.getFullYear();
				var month = date.getMonth() + 1;
				var hour = date.getHours();
				var minute = date.getMinutes();
				var strDate = date.getDate();
				var currentdate = month + seperator + strDate + " " + hour + ":" + minute;
				var currentdate1 = month + seperator + strDate;
				var currentdate2 = year + "/" + month + "/" + strDate;
				if((i > 0 && currentdate1 != datelist8[datelist8.length - 1]) || i == 0) {
					if(countquickeningflag) {
						sumclicklist.push((sum / everydaytestindex * 12).toFixed(0));
						datelist9.push(currentdate2);
					}
					sum = Number(list[i].actualclick);
					datelist8.push(currentdate1);
					everydaytestindex = 1;
					countquickeningflag = true;
				} else {
					everydaytestindex++;
					sum += Number(list[i].actualclick);
				}
				if(i == list.length - 1) {
					sumclicklist.push((sum / everydaytestindex * 12).toFixed(0));
					datelist9.push(currentdate2);
				}
				datelist7.push(currentdate);
				actualclicklist.push(list[i].actualclick);
			});
			for(var i = 0; i < datelist9.length; i++) {
				tableStr += "<tr><td>" + datelist9[i] + "</td><td>" + (sumclicklist[i] / 12).toFixed(0) + "</td><td>" + sumclicklist[i] + "</td></tr>";
			}
			$(".table-for-fetalMovement").append(tableStr);
			myChart20.setOption({
				xAxis: {
					data: datelist8
				},
				series: [{
					name: '总次数',
					type: 'line',
					data: sumclicklist
				}]
			});
			mychart19.setOption({
				xAxis: {
					data: datelist7
				},
				series: [{
					name: '单次次数',
					type: 'line',
					data: actualclicklist
				}]
			});
		},
		error: function() {

		}
	});
}
//血氧
$.ajax({
	type: "post",
	url: address + "bloodoxygen/findByDateRange.do",
	data: {
		"mid": mid
	},
	dataType: "json",
	ContentType: "application/x-www-form-urlencoded;charset=utf-8",
	success: function(e) {
		var list = e.data;
		if(list.length==0){
			$("#bloodoxygenDate1").css({"color":"#333","opacity":"0.25","cursor":"default"});
			$("#bloodoxygenDate1").find('img').attr('src','images/u2639.png');
		}else{
			$("#bloodoxygenDate1").click(function(){
				showTestDate('bloodoxygenDate',9);
			})	 
		}
	},
	error: function() {
		$("#bloodoxygenDate1").find('img').attr('src','images/u2639.png');
		$("#bloodoxygenDate1").css({"color":"#333","opacity":"0.25","cursor":"default"});
	}
});
function bloodoxygen2() {
	
	var chart21 = document.getElementById('echart21');
	//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
	// 基于准备好的dom，初始化echarts实例
	var myChart21 = echarts.init(chart21);
	var option21 = {
		tooltip: {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				crossStyle: {
					color: '#8e8e93'
				}
			}
		},
		grid: {
			containLabel: true
		},
		xAxis: {
			type: 'category',
			boundaryGap: false,
			maxInterval: 5,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				textStyle: {
					color: "#555555"
				}
			},
			data: ['2017-08-01', '2017-08-02', '2017-08-03', '2017-08-04', '2017-08-05', '2017-08-06', '2017-08-07', '2017-08-08', '2017-08-09', '2017-08-10']
		},
		yAxis: [{
			type: 'value',
			min: 72,
			max: 100,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			interval: 4,
			axisLabel: {
				formatter: '{value}%',
				textStyle: {
					color: "#555555"
				}
			}
		}],
		series: [{
			name: '血氧饱和度',
			type: 'line',
			data: [96, 99, 95, 96, 95, 96, 97, 98, 97, 96]
		}]
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart21.setOption(option21);
	var chart22 = document.getElementById('echart22');
	// 基于准备好的dom，初始化echarts实例
	var myChart22 = echarts.init(chart22);
	var option22 = {
		tooltip: {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				crossStyle: {
					color: '#8e8e93'
				}
			}
		},
		grid: {
			containLabel: true
		},
		xAxis: {
			type: 'category',
			boundaryGap: false,
			maxInterval: 5,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				textStyle: {
					color: "#555555"
				}
			},
			data: ['2017-08-01', '2017-08-02', '2017-08-03', '2017-08-04', '2017-08-05', '2017-08-06', '2017-08-07', '2017-08-08', '2017-08-09', '2017-08-10']
		},
		yAxis: [{
			type: 'value',
			min: 50,
			max: 120,
			interval: 10,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				textStyle: {
					color: "#555555"
				},
				formatter: '{value}'
			}
		}],
		series: [{
			type: 'line',
			data: [77, 75, 78, 79, 73, 77, 76, 72, 81, 83]
		}]
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart22.setOption(option22);
	var datelist11 = [];
	var bloodoxygenlist = [];
	var heartratelist2 = [];
	$.ajax({
		type: "post",
		url: address + "bloodoxygen/findByDateRange.do",
		data: {
			"mid": mid
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			var list = e.data;
			$.each(list, function(i) {
				var date = new Date(list[i].bdate);
				//var seperator1 = "-";
				var year = date.getFullYear();
				var month = date.getMonth() + 1;
				if(month < 10) {
					month = "0" + month;
				};
				var strDate = date.getDate();
				if(strDate < 10) {
					strDate = "0" + strDate;
				}
				var currentdate1 = year + seperator + month + seperator + strDate;
				datelist11.push(currentdate1);
				bloodoxygenlist.push(list[i].bloodoxygen);
				heartratelist2.push(list[i].heartrate);
			});
			myChart22.setOption({
				xAxis: {
					data: datelist11
				},
				series: [{
					name: '脉率',
					type: 'line',
					data: heartratelist2
				}]
			});
			myChart21.setOption({
				xAxis: {
					data: datelist11
				},
				series: [{
					name: '血氧饱和度',
					type: 'line',
					data: bloodoxygenlist
				}]
			});
		},
		error: function() {

		}
	});
}
