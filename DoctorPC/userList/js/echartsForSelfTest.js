/*author luoyc*/
//查询目标孕妇所有的自测数据
//血压 bloodpressureSetDate(mid);
//血糖 bloodsugreSetDate(mid);
//体重 weightSetDate(mid);
//宫高 fundalheightSetDate(mid);
//腹围 abdominalgirthSetDate(mid);
//胎动 featalMovementSetDate(mid);
//胎心 featalHeartSetDate(mid);
var sWeeks = 0
var eWeeks = 43
var seperator = "-";
//血压
function bloodpressureSetDate(mid) {
	var chart9 = document.getElementById('echarts');
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

	function DataHandler(mid, sWeeks, eWeeks) {
		var systoliclist = [];
		var diastoliclist = [];
		var bloodpressuredatelist = [];
		var bloodpressureDate = [];
		$.ajax({
			type: "post",
			url: address + "bloodpressure/findByWeekly.do",
			data: {
				"mid": mid,
				"sWeeks": sWeeks,
				"eWeeks": eWeeks
			},
			dataType: "json",
			ContentType: "application/x-www-form-urlencoded;charset=utf-8",
			success: function(e) {
				var list = e.data;
				if(list.length != 0) {
					$.each(list, function(i) {
						var date = new Date(list[i].bdate);
						//var seperator1 = "-";
						var year = date.getFullYear();
						var month = date.getMonth() + 1;
						var hour = date.getHours();
						var minute = date.getMinutes();
						var second = date.getSeconds();
						if(month < 10) {
							month = "0" + month;
						};
						var strDate = date.getDate();
						if(strDate < 10) {
							strDate = "0" + strDate;
						}
						if(minute < 10) {
							minute = "0" + minute;
						}
						if(hour < 10) {
							hour = "0" + hour;
						}
						var currentdate = month + seperator + strDate + " " + hour + ":" + minute;
						var currentdate1 = year + seperator + month + seperator + strDate;
						bloodpressuredatelist.push(currentdate);
						bloodpressureDate.push(date);
						systoliclist.push(list[i].systolic);
						diastoliclist.push(list[i].diastolic);
					});
					myChart9.setOption({
						xAxis: {
							data: bloodpressuredatelist
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
				} else {
					myChart9.setOption({
						xAxis: {
							data: []
						},
						series: [{
							// 根据名字对应到相应的系列  
							name: '收缩压(mmHg)',
							data: []
						}, {
							name: '舒张压(mmHg)',
							type: 'line',
							data: []
						}]
					});
				}
			},
			error: function() {

			}
		});
	}
	DataHandler(mid, sWeeks, eWeeks);
	$("#echarts-select").bind("change", function() {
		var echartsIndex = sessionStorage.getItem("echartsIndex");
		var rangeValue = $(this).val();
		var endWeek = sessionStorage.getItem("week");
		var startWeek = startAndEnd(rangeValue, endWeek);
		DataHandler(mid, startWeek, endWeek + 1);
	})
}

//血糖
function bloodsugreSetDate(mid) {
	var chart1 = document.getElementById('echarts');
	// 基于准备好的dom，初始化echarts实例
	var myChart1 = echarts.init(chart1);
	var option1 = {
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			data: ['早餐前', '早餐后', '午餐前', '午餐后', '晚餐前', '晚餐后', '夜间'],
			top: '10px',
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
			max: '11',
			splitNumber: 7,
			axisLabel: {
				formatter: '{value}'
			}
		}],
		series: [{
			name: '餐前血糖最大值',
			type: 'line',
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
			data: []
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

	function DataHandler(mid, sWeeks, eWeeks) {
		var bloodsugrelist = [];
		var bBreakfastlist = [];
		var afbrelist = [];
		var bflunlist = [];
		var aflunlist = [];
		var bfdinlist = [];
		var afdinlist = [];
		var bfslelist = [];
		var datelist = [];
		$.ajax({
			type: "post",
			url: address + "bloodsugre/findByWeekly.do",
			data: {
				"mid": mid,
				"sWeeks": sWeeks,
				"eWeeks": eWeeks
			},
			dataType: "json",
			ContentType: "application/x-www-form-urlencoded;charset=utf-8",
			success: function(e) {
				var list = e.data;
				if(list.length != 0) {
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
						var currentdate1 = month + seperator + strDate;
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
				} else {
					myChart1.setOption({
						xAxis: {
							data: []
						},
						series: [{
							// 根据名字对应到相应的系列  
							name: '早餐前',
							data: []
						}, {
							// 根据名字对应到相应的系列  
							name: '早餐后',
							data: []
						}, {
							// 根据名字对应到相应的系列  
							name: '午餐前',
							data: []
						}, {
							// 根据名字对应到相应的系列  
							name: '午餐后',
							data: []
						}, {
							// 根据名字对应到相应的系列  
							name: '晚餐前',
							data: []
						}, {
							// 根据名字对应到相应的系列  
							name: '晚餐后',
							data: []
						}, {
							// 根据名字对应到相应的系列  
							name: '夜间',
							data: []
						}]
					})
				}
			},
			error: function() {

			}
		});
	}
	DataHandler(mid, sWeeks, eWeeks);
	$("#echarts-select").bind("change", function() {
		var echartsIndex = sessionStorage.getItem("echartsIndex");
		var rangeValue = $(this).val();
		var endWeek = sessionStorage.getItem("week");
		var startWeek = startAndEnd(rangeValue, endWeek);
		DataHandler(mid, startWeek, endWeek + 1);
	})
}

//体重
function weightSetDate(mid) {
	var chart7 = document.getElementById('echarts');
	// 基于准备好的dom，初始化echarts实例
	var myChart7 = echarts.init(chart7);
	var option7 = {
		tooltip: {
			trigger: 'axis'
		},
		grid: {
			left: '8%',
			right: '16%',
		},
		legend: {
			data: ['体重', '上限', 'BMI'],
			top: "30px"
		},
		calculable: true,
		xAxis: [{
			type: 'category',
			name: '孕周',
			nameTextStyle: {
				color: "#555555",
				bottom: "30px"
			},
			nameGap: 25,
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
			data: []

		}],
		yAxis: [{
			type: 'value',
			min: '40',
			max: '65',
			splitNumber: 5,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				formatter: '{value}',
				textStyle: {
					color: "#555555"
				}
			}

		}, {
			type: 'value',
			min: '16',
			max: '26',
			splitNumber: 5,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				formatter: '{value}',
				textStyle: {
					color: "#555555"
				}
			}
		}],
		series: [{
			name: '体重',
			type: 'line',
			data: []
		}, {
			name: '上限',
			type: 'line',
			data: []
		}, {
			name: 'BMI',
			type: 'line',
			yAxisIndex: 1,
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

	function DataHandler(mid, sWeeks, eWeeks) {
		var weightlist = [];
		var datelist2 = [];
		var weightlimit = [];
		var BMIlist = [];
		$.ajax({
			type: "post",
			url: address + "gravidainfo/findWeight.do",
			data: {
				"mid": mid,
				"sWeeks": sWeeks,
				"eWeeks": eWeeks
			},
			dataType: "json",
			ContentType: "application/x-www-form-urlencoded;charset=utf-8",
			success: function(e) {
				weightlist = e.data[1];
				datelist2 = e.data[0];
				weightlimit = e.data[2];
				var height = e.data[4];
				if(datelist2.length != 0) {
					for(var i = 0; i < datelist2.length; i++) {
						BMIlist.push((weightlist[i] / height / height * 10000).toFixed(1));
					}
					if(height==null||height==undefined){
						BMIlist=[];
					}
					myChart7.setOption({
						xAxis: {
							data: datelist2
						},
						series: [{
							name: '上限',
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
				} else {
					myChart7.setOption({
						xAxis: {
							data: []
						},
						series: [{
							name: '上限',
							type: 'line',
							data: []
						}, {
							name: '体重',
							type: 'line',
							data: []
						}, {
							name: 'BMI',
							type: 'line',
							data: []
						}]
					})
				}
			},
			error: function() {

			}
		});
	}
	DataHandler(mid, sWeeks, eWeeks);
	$("#echarts-select").bind("change", function() {
		var echartsIndex = sessionStorage.getItem("echartsIndex");
		var rangeValue = $(this).val();
		var endWeek = sessionStorage.getItem("week");
		var startWeek = startAndEnd(rangeValue, endWeek);
		DataHandler(mid, startWeek, endWeek + 1);
	})
}

//胎动
function featalMovementSetDate(mid) {
	var chart11 = document.getElementById('echarts');
	// 基于准备好的dom，初始化echarts实例
	var myChart11 = echarts.init(chart11);
	var option11 = {
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
			data: ['单次次数', '总次数'],
			top: '30px',
			textStyle: {
				color: '#555555',
				fontFamily: '微软雅黑'
			}
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
		}, {
			type: 'value',
			min: 0,
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
			name: '单次次数',
			type: 'line',
			data: []
		}, {
			name: '总次数',
			type: 'line',
			yAxisIndex: 1,
			data: []
		}]
	};
	// 使用刚指定的配置项和数据显示图表。
	myChart11.setOption(option11);

	function DataHandler(mid, sWeeks, eWeeks) {
		var actualclicklist = [];
		var datelist7 = [];
		var datelist8 = [];
		var sumclicklist = [];
		var sum = 0;
		var everydaytestindex = 0;
		var countquickeningflag = false
		$.ajax({
			type: "post",
			url: address + "countQuickening/findByWeekly.do",
			data: {
				"mid": mid,
				"sWeeks": sWeeks,
				"eWeeks": eWeeks
			},
			dataType: "json",
			ContentType: "application/x-www-form-urlencoded;charset=utf-8",
			success: function(e) {
				var list = e.data;
				if(list.length != 0) {
					$.each(list, function(i) {
						var date = new Date(list[i].cdate);
						//var seperator1 = "-";
						var year = date.getFullYear();
						var month = date.getMonth() + 1;
						var hour = date.getHours();
						var minute = date.getMinutes();
						if(month < 10) {
							month = "0" + month;
						};
						var strDate = date.getDate();
						if(strDate < 10) {
							strDate = "0" + strDate;
						}
						var currentdate1 = month + seperator + strDate;
						if((i > 0 && currentdate1 != datelist8[datelist8.length - 1]) || i == 0) {
							if(countquickeningflag) {
								actualclicklist.push((sum / everydaytestindex).toFixed(0));
								sumclicklist.push((sum / everydaytestindex * 12).toFixed(0));
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
							actualclicklist.push((sum / everydaytestindex).toFixed(0));
							sumclicklist.push((sum / everydaytestindex * 12).toFixed(0));
						}
					});
					myChart11.setOption({
						xAxis: {
							data: datelist8
						},
						series: [{
							name: '总次数',
							type: 'line',
							data: sumclicklist
						}, {
							name: '单次次数',
							type: 'line',
							data: actualclicklist
						}]
					});
				} else {
					myChart11.setOption({
						xAxis: {
							data: []
						},
						series: [{
							name: '总次数',
							type: 'line',
							data: []
						}, {
							name: '单次次数',
							type: 'line',
							data: []
						}]
					});
				}
			},
			error: function() {

			}
		});
	}
	DataHandler(mid, sWeeks, eWeeks);
	$("#echarts-select").bind("change", function() {
		var echartsIndex = sessionStorage.getItem("echartsIndex");
		var rangeValue = $(this).val();
		var endWeek = sessionStorage.getItem("week");
		var startWeek = startAndEnd(rangeValue, endWeek);
		DataHandler(mid, startWeek, endWeek + 1);
	})
}
//宫高
function fundalheightSetDate(mid) {
	var chart13 = document.getElementById('echarts');
	// 基于准备好的dom，初始化echarts实例
	var myChart13 = echarts.init(chart13);
	var option13 = {
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			data: ['宫高(cm)'],
			top: '30px',
			textStyle: {
				color: '#555555',
				fontFamily: '微软雅黑'
			}
		},
		grid: {
			left: '7%',
			right: '12%'
		},
		xAxis: {
			name: '孕周',
			nameTextStyle: {
				color: "#555555",
				bottom: "30px"
			},
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
				formatter: '{value}',
				textStyle: {
					color: "#555555"
				}
			}
		},
		series: [{
			name: '宫高',
			type: 'line',
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
						yAxis: 27.5
					}, {
						yAxis: 19
					}]
				]
			}
		}]
	};
	myChart13.setOption(option13);

	function DataHandler(mid, sWeeks, eWeeks) {
		var fundalheightlist = [];
		var datelist10 = [];
		$.ajax({
			type: "post",
			url: address + "fundalheight/find.do",
			data: {
				"mid": mid,
				"sWeeks": sWeeks,
				"eWeeks": eWeeks
			},
			dataType: "json",
			ContentType: "application/x-www-form-urlencoded;charset=utf-8",
			success: function(e) {
				fundalheightlist = e.data[0];
				datelist10 = e.data[1];
				if(datelist10.length != 0) {
					myChart13.setOption({
						xAxis: {
							data: datelist10
						},
						series: [{
							name: '宫高(cm)',
							type: 'line',
							data: fundalheightlist
						}]
					});
				} else {
					myChart13.setOption({
						xAxis: {
							data: []
						},
						series: [{
							name: '宫高(cm)',
							type: 'line',
							data: []
						}]
					});
				}
			},
			error: function() {

			}
		});
	}
	DataHandler(mid, sWeeks, eWeeks);
	$("#echarts-select").bind("change", function() {
		var echartsIndex = sessionStorage.getItem("echartsIndex");
		var rangeValue = $(this).val();
		var endWeek = sessionStorage.getItem("week");
		var startWeek = startAndEnd(rangeValue, endWeek);
		DataHandler(mid, startWeek, endWeek + 1);
	})
}
//腹围
function abdominalgirthSetDate(mid) {
	var chart12 = document.getElementById('echarts');
	// 基于准备好的dom，初始化echarts实例
	var myChart12 = echarts.init(chart12);
	var option12 = {
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			data: ['腹围(cm)'],
			top: '30px',
			textStyle: {
				color: '#555555',
				fontFamily: '微软雅黑'
			}
		},
		grid: {
			left: '9%',
			right: '12%'
		},
		xAxis: {
			name: '孕周',
			nameTextStyle: {
				color: "#555555",
				bottom: "30px"
			},
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
			min: '70',
			max: '100',
			splitNumber: 5,
			axisLine: {
				onZero: false,
				lineStyle: {
					color: "#cccccc"
				}
			},
			axisLabel: {
				formatter: '{value}',
				textStyle: {
					color: "#555555"
				}
			}
		},
		series: [{
			name: '腹围',
			type: 'line',
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
						yAxis: 91
					}, {
						yAxis: 76
					}]
				]
			}
		}]
	};
	myChart12.setOption(option12);

	function DataHandler(mid, sWeeks, eWeeks) {
		var abdominalgirthlist = [];
		var datelist9 = [];
		$.ajax({
			type: "post",
			url: address + "abdominalgirth/find.do",
			data: {
				"mid": mid,
				"sWeeks": sWeeks,
				"eWeeks": eWeeks
			},
			dataType: "json",
			ContentType: "application/x-www-form-urlencoded;charset=utf-8",
			success: function(e) {
				abdominalgirthlist = e.data[0];
				datelist9 = e.data[1];
				if(datelist9.length != 0) {
					myChart12.setOption({
						xAxis: {
							data: datelist9
						},
						series: [{
							name: '腹围(cm)',
							type: 'line',
							data: abdominalgirthlist
						}]
					});
				} else {
					myChart12.setOption({
						xAxis: {
							data: []
						},
						series: [{
							name: '腹围(cm)',
							type: 'line',
							data: []
						}]
					});
				}
			},
			error: function() {

			}
		});
	}
	DataHandler(mid, sWeeks, eWeeks);
	$("#echarts-select").bind("change", function() {
		var echartsIndex = sessionStorage.getItem("echartsIndex");
		var rangeValue = $(this).val();
		var endWeek = sessionStorage.getItem("week");
		console.log(endWeek);
		var startWeek = startAndEnd(rangeValue, endWeek);
		DataHandler(mid, startWeek, endWeek + 1);
	})
}
//胎心
function featalHeartSetDate(mid) {
	$("#echarts-select").hide();
	var chart18 = document.getElementById('echarts');
	var myChart18 = echarts.init(chart18);
	//小孕周对应的option
	var option18 = {
		tooltip: {
			trigger: 'axis'
		},
		grid: [{
			left: "12%",
		}],
		xAxis: [{

			type: 'category',
			boundaryGap: false,
			axisLine: {
				onZero: false
			},
			axisLabel: {
				interval: 179
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
			splitNumber: 5,
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
	myChart18.setOption(option18);

	function DataHandler(mid) {
		$.ajax({
			type: "post",
			dataType: 'json',
			url: address + "fetalHeartData/findSmallByMid.do",
			data: {
				mid: mid
			},
			success: function(e) {
				var data = e.data;
				var fhList = data.fhlistArr;
				var fMlist = data.fmlistArr;
				addFetalSmallData(fhList, fMlist);
			},
			error: function(e) {

			}
		});
	}
	DataHandler(mid)

	function addFetalSmallData(FHRdata, FMdata) {
		var xAixs = [];
		var dataxAisx = [];
		for(var i = 0; i < FHRdata.length; i++) {
			xAixs.push(toTime_FHR(i));
		}
		dataxAisx = xAixs; //横坐标结果集
		option18.series[0].data = FHRdata;
		option18.xAxis[0].data = dataxAisx;
		myChart18.setOption(option18);
	}

	function toTime_FHR(i) {
		var item = i / 2;
		var minute = parseInt(item / 60);
		var second = item % 60;
		if(minute < 1) {
			return second + "s";
		} else {
			return minute + "m" + second + "s";
		}
	}
}

function startAndEnd(index, end) {
	var start = 0;
	if(index == -1) {
		start = 0;
	} else {
		start = end - index
		if(start < 0) {
			start = 0;
		}
	}
	return start;
}


