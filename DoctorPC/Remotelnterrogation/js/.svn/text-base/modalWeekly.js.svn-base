/* 周报审核-通用模板js @author yinzx*/
var mid = sessionStorage.getItem("mid");
//var doctorId = sessionStorage.getItem("doctorid");
var address=sessionStorage.getItem("address");
//var address = "http://192.168.1.49:8080/doctormanager/";
//var mid = 'dg000001';
function showHighRiskData() {
	$("#highRiskData").css('display', 'block');
}
$("#highRiskData_close").click(function() {
	$("#highRiskData").css('display', 'none');
})

function showCheckReportData() {
	$("#checkReportData").css('display', 'block');
}
$("#checkReportData_close").click(function() {
	$("#checkReportData").css('display', 'none');
})

function sendNotice() {
	$('#myModal').modal('show')
}
//全选发送
//function selectAllSend() {
//	if($('.send_selectAll').is(':checked')) {
//
//		$(".select_gravida").attr("checked", 'true');
//		$(".select_husband").attr("checked", 'true');
//		$(".select_orderlies").attr("checked", 'true');
//
//	} else {
//
//		$(".select_gravida").removeAttr("checked");
//		$(".select_husband").removeAttr("checked");
//		$(".select_orderlies").removeAttr("checked");
//
//	}
//}
//全选检测项目建议
//function selectAllNotice() {
//	if($('.Notice_selectAll').is(':checked')) {
//
//		$(".select_fetelHeart").prop("checked", true);
//		$(".select_fetelMovement").prop("checked", true);
//		$(".select_pressure").prop("checked", true);
//		$(".select_urine").prop("checked", true);
//		$(".select_weight").prop("checked", true);
//	} else {
//
//		$(".select_fetelHeart").prop("checked", false);
//		$(".select_fetelMovement").prop("checked", false);
//		$(".select_pressure").prop("checked", false);
//		$(".select_urine").prop("checked", false);
//		$(".select_weight").prop("checked", false);
//	}
//}
/*改变路径 @author luoyc*/
function changePathFirst() {
	$("#path").text("待处理患者列表");
}

function changePathSecond() {
	$("#path").text("已处理患者列表");
}
//模态框弹出
function addMoreAdvice() {
	$('.add-more-advice').click();
}
/*author:luoyc 
 风险模型
*/
//罗盘生成
var riskModalchart = document.getElementById('riskModalchart');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart = function() {
	riskModalchart.style.width = '450px';
};
//设置容器高宽
resizemyChart();
// 基于准备好的dom，初始化echarts实例
var myriskModalchart = echarts.init(riskModalchart);
var riskModaloption = {
	title: {
		text: '中度高危',
		textStyle: {
			fontWeight: 'normal', //标题颜色  
			color: 'rgb(255,179,0)',
			fontSize: '14'
		},
		top: '0px',
		left: '80px'
	},
	series: [{
		name: '高危评分',
		type: 'gauge',
		startAngle: 180,
		endAngle: 0,
		radius: 180, //调整图表大小
		detail: { //数值样式
			formatter: '{value}',
			offsetCenter: [0, '-30%']
		},
		splitLine: {
			show: false,
			length: '25%'
		},
		max: '40',
		splitNumber: '4',
		data: [{
			value: 0,
			name: ''
		}],
		axisTick: {
			show: false
		}, //刻度线
		axisLine: { // 坐标轴线
			lineStyle: { // 属性lineStyle控制线条样式
				color: [
					[0.25, 'rgb(255,229,0)'],
					[0.50, 'rgb(255,179,0)'],
					[0.75, 'rgb(255,106,0)'],
					[1, 'rgb(255,50,14)']
				]
			}
		},
		pointer: { //指针
			width: 5,
			shadowColor: '#fff', //默认透明
			shadowBlur: 5
		},
		axisLabel: { //刻度值
			show: true
		}

	}]
};
//用于使chart自适应高度和宽度
window.onresize = function() {
	//重置容器高宽
	resizemyChart();
	myriskModalchart.resize();
};
// 使用刚指定的配置项和数据显示图表。
myriskModalchart.setOption(riskModaloption);
//血糖
var chart1 = document.getElementById('echart1');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart1 = function() {
	chart1.style.width = 1100/ 2 - 20 + 'px';
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
		top: '30px',
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
		data: [5.1],
		markLine: {
			data: [{
				type: 'average',
				name: '1'
			}]
		}
	},{
		name: '餐后血糖最大值',
		type: 'line',
		data: [8.5],
		markLine: {
			data: [{
				type: 'average',
				name: '1'
			}]
		}
	},{
		name: '早餐前',
		type: 'line',
		data: []
	},{
		name: '早餐后',
		type: 'line',
		data: []
	},{
		name: '午餐前',
		type: 'line',
		data: []
	},{
		name: '午餐后',
		type: 'line',
		data: []
	},{
		name: '晚餐前',
		type: 'line',
		data: []
	},{
		name: '晚餐后',
		type: 'line',
		data: []
	},{
		name: '夜间',
		type: 'line',
		data: []
	}
	]
};
// 使用刚指定的配置项和数据显示图表。
myChart1.setOption(option1);

var chart2 = document.getElementById('echart2');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart2 = function() {
	chart2.style.width = 1100 / 2 - 20 + 'px';
};
//设置容器高宽
resizemyChart2();
// 基于准备好的dom，初始化echarts实例
var myChart2 = echarts.init(chart2);
var option2 = {
	tooltip: {
		trigger: 'axis'
	},
	calculable: true,
	xAxis: [{
		type: 'category',
		data: ['早餐前', '早餐后', '午餐前', '午餐后', '晚餐前', '晚餐后', '夜间']
	}],
	yAxis: [{
		type: 'value',
		min: 0,
		max: 100,
		axisLabel: {
			formatter: '{value}%'
		}

	}],
	series: [{
		name: '血糖',
		type: 'bar',
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
		markLine: {
			data: [{
				type: 'average',
				name: '平均值'
			}]
		},
		barWidth: 30

	}]
};
// 使用刚指定的配置项和数据显示图表。
myChart2.setOption(option2);

var chart3 = document.getElementById('echart3');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart3 = function() {
	chart3.style.width = 1100/ 2 - 20 + 'px';
};
//设置容器高宽
resizemyChart3();
// 基于准备好的dom，初始化echarts实例
var myChart3 = echarts.init(chart3);
var option3 = {
	tooltip: {
		trigger: 'axis'
	},
	calculable: true,
	xAxis: [{
		type: 'category',
		splitNumber: 11,
		data: ['空腹', '早餐前', '早餐后', '午餐前', '午餐后', '晚餐前', '晚餐后', '夜间']
	}],
	yAxis: [{
		type: 'value',
		min: 0,
		max: 10

	}],
	series: [{
		name: '血糖',
		type: 'bar',
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
		markLine: {
			data: [{
				type: 'average',
				name: '平均值'
			}]
		},
		barWidth: 30
	}]
};
myChart3.setOption(option3);
//体温
var chart4 = document.getElementById('echart4');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart4 = function() {
	chart4.style.width = 1100/ 2 - 20 + 'px';
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
//血脂
var chart5 = document.getElementById('echart5');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart5 = function() {
	chart5.style.width = 1100 / 2 - 20 + 'px';
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
		top: '30px',
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
			data: []
		},
		{
			name: 'CHOL',
			type: 'line',
			stack: '总量',
			data: []
		},
		{
			name: 'HDL',
			type: 'line',
			stack: '总量',
			data: []
		},
		{
			name: 'LDL',
			type: 'line',
			stack: '总量',
			data: []
		},
		{
			name: 'CHOL/HDL',
			type: 'line',
			stack: '总量',
			data: []
		}
	]
};
myChart5.setOption(option5);
//血氧
var chart6 = document.getElementById('echart6');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart6 = function() {
	chart6.style.width = 1100 / 2 - 20 + 'px';
};
//设置容器高宽
resizemyChart6();
// 基于准备好的dom，初始化echarts实例
var myChart6 = echarts.init(chart6);
var option6 = {
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
	yAxis: [
		{
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
		}
	],
	series: [
		{
			name: '血氧饱和度',
			type: 'line',
			data: [96, 99, 95, 96, 95, 96, 97, 98, 97, 96]
		}
	]
};

// 使用刚指定的配置项和数据显示图表。
myChart6.setOption(option6);
var chart15 = document.getElementById('echart15');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart15 = function() {
	chart15.style.width = 1100 / 2 - 20 + 'px';
};
//设置容器高宽
resizemyChart15();
// 基于准备好的dom，初始化echarts实例
var myChart15 = echarts.init(chart15);
var option15= {
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
		}
	],
	series: [{
			type: 'line',
			data: [77, 75, 78, 79, 73, 77, 76, 72, 81, 83]
		}
	]
};

// 使用刚指定的配置项和数据显示图表。
myChart15.setOption(option15);
//体重
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
		data: ['体重', '上限', 'BMI'],
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
		max: '50',
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
		data: [46.2, 46.6, 46.8, 47.2, 47.5, 47.8, 48.3]
	}, {
		name: '上限',
		type: 'line',
		data: [46.4, 46.7, 47.0, 47.3, 47.7, 48.0, 48.4]
	}, {
		name: 'BMI',
		type: 'line',
		yAxisIndex: 1,
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
var chart8 = document.getElementById('echart8');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart8 = function() {
	chart8.style.width = 1100 / 2 - 20 + 'px';
};
//设置容器高宽
resizemyChart8();
// 基于准备好的dom，初始化echarts实例
var myChart8 = echarts.init(chart8);
var option8 = {
	tooltip: {
		trigger: 'axis'
	},
	grid: {
		left: '8%',
		right: '15%',
		containLabel: true
	},
	calculable: true,
	xAxis: [{
		type: 'category',
		name: '孕周',
		nameTextStyle: {
			color: "#555555"
		},
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
		min: '0',
		max: '5000',
		splitNumber: 10,
		axisLine: {
			onZero: false,
			lineStyle: {
				color: "#cccccc"
			}
		},
		axisLabel: {
			formatter: '{value}g',
			textStyle: {
				color: "#555555"
			}
		}

	}],
	series: [{
		name: '体重总量',
		type: 'line',
		data: []
	}]
};
// 使用刚指定的配置项和数据显示图表。
myChart8.setOption(option8);
//血压
var chart9 = document.getElementById('echart9');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart9 = function() {
	chart9.style.width = 1100 / 2 - 20 + 'px';
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
		data: [],
		markArea: {
        	    silent: true,
        	    itemStyle: {
        		    normal: {
        		        color: {
        			        type: 'linear',
                            colorStops: [{
                                offset: 0.5, color: '#D8E8F7' // 0% 处的颜色
                            }],
                            globalCoord: false // 缺省为 false
                        }
                        // 径向渐变，前三个参数分别是圆心 x, y 和半径，取值同线性渐变
        		    }
        	    },
        	    data: [[{
        	        yAxis: 139
                    },{
        	        yAxis: 90
                }]]
            }
	},{
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
                                offset: 0.5, color: '#EDFCF9' // 0% 处的颜色
                            }],
                            globalCoord: false // 缺省为 false
                        }
                        // 径向渐变，前三个参数分别是圆心 x, y 和半径，取值同线性渐变
        		    }
        	    },
        	    data: [[{
        	        yAxis: 89
                    },{
        	        yAxis: 60
                }]]
            }
	},{
		name: '收缩压最大值',
		type: 'line',
		data: [139],
		markLine: {
			data: [{
				type: 'average',
				name: '1'
			}]
		}
	},{
		name: '舒张压最小值',
		type: 'line',
		data: [60],
		markLine: {
			data: [{
				type: 'average',
				name: '1'
			}]
		}
	},{
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
var chart10 = document.getElementById('echart10');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart10 = function() {
	chart10.style.width = 1100 / 2 - 20 + 'px';
};
//设置容器高宽
resizemyChart10();
// 基于准备好的dom，初始化echarts实例
var myChart10 = echarts.init(chart10);
var option10 = {

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
		data: ['上周', '本周'],
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
		data: []
	}, {
		name: '舒张压(mmHg)',
		type: 'line',
		data: []
	}]
};
// 使用刚指定的配置项和数据显示图表。
myChart10.setOption(option10);
//胎动
var chart11 = document.getElementById('echart11');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart11 = function() {
	chart11.style.width = 1100 / 2 - 20 + 'px';
};
//设置容器高宽
resizemyChart11();
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
		}
	],
	series: [{
			name: '总次数',
			type: 'line',
			data: [36, 60, 48, 48, 36]
		}
	]
};
// 使用刚指定的配置项和数据显示图表。
myChart11.setOption(option11);
//腹围
var chart12 = document.getElementById('echart12');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart12 = function() {
	chart12.style.width = 1100/ 2 - 20 + 'px';
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
		right:'13%',
		containLabel: true
	},
	xAxis: {
		name:'孕周',
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
		data: [78,79,81,82,84],
		markArea: {
        	    silent: true,
        	    itemStyle: {
        		    normal: {
        		        color: {
        			        type: 'linear',
                            colorStops: [{
                                offset: 0.5, color: '#D8E8F7' // 0% 处的颜色
                            }],
                            globalCoord: false // 缺省为 false
                        }
                        // 径向渐变，前三个参数分别是圆心 x, y 和半径，取值同线性渐变
        		    }
        	    },
        	    data: [[{
        	        yAxis: 91
                    },{
        	        yAxis: 76
                }]]
            }
	}]
};
myChart12.setOption(option12);
//宫高
var chart13 = document.getElementById('echart13');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart13 = function() {
	chart13.style.width = 1100/ 2 - 20 + 'px';
};
//设置容器高宽
resizemyChart13();
// 基于准备好的dom，初始化echarts实例
var myChart13= echarts.init(chart13);
var option13 = {
	tooltip: {
		trigger: 'axis'
	},
	grid: {
		left: '3%',
		right:'15%',
		containLabel: true
	},
	xAxis: {
		name:'孕周',
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
		data: [21.3,22.1,22.9,23.6,24.7],
		markArea: {
        	    silent: true,
        	    itemStyle: {
        		    normal: {
        		        color: {
        			        type: 'linear',
                            colorStops: [{
                                offset: 0.5, color: '#D8E8F7' // 0% 处的颜色
                            }],
                            globalCoord: false // 缺省为 false
                        }
                        // 径向渐变，前三个参数分别是圆心 x, y 和半径，取值同线性渐变
        		    }
        	    },
        	    data: [[{
        	        yAxis: 27.5
                    },{
        	        yAxis: 19
                }]]
            }
	} ]
};
myChart13.setOption(option13);
var chart14 = document.getElementById('echart14');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart14= function() {
	chart14.style.width = 1100 / 2 - 20 + 'px';
};
//设置容器高宽
resizemyChart14();
// 基于准备好的dom，初始化echarts实例
var myChart14 = echarts.init(chart14);
var option14 = {
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
		data: ['07-05 09:30', '07-05 3:21', '07-05 21:38', '07-06 8:53', '07-06 14:26', '07-06 20:45', '07-07 10:20', '07-07 16:03', '07-07 21:11', '07-08 8:53', '07-08 14:26', '07-08 20:45','07-09 08:42','07-09 15:11','07-09 21:16']
	},
	yAxis: [
		{
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
		}
	],
	series: [
		{
			name: '单次次数',
			type: 'line',
			data: [3,5,4,3,3,4,5,3,5,4,4,5,4,3,5],
			markArea: {
        	    silent: true,
        	    itemStyle: {
        		    normal: {
        		        color: {
        			        type: 'linear',
                            colorStops: [{
                                offset: 0.5, color: '#D8E8F7' // 0% 处的颜色
                            }],
                            globalCoord: false // 缺省为 false
                        }
                        // 径向渐变，前三个参数分别是圆心 x, y 和半径，取值同线性渐变
        		    }
        	    },
        	    data: [[{
        	        yAxis: 5
                    },{
        	        yAxis: 3
                }]]
            }
		}
	]
};
// 使用刚指定的配置项和数据显示图表。
myChart14.setOption(option14);
/*胎心监护 echarts画图 js */
var resultdata = "";
var chart16 = document.getElementById('echart16');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart16= function() {
	chart16.style.width = 1100 / 2 - 20 + 'px';
};
//设置容器高宽
resizemyChart16();
var myChart16 = echarts.init(chart16);
var data = testdata;
var app = {};
var autodata = [];
var autodata2 = [];
var dataflag=1200;
var toTime = function(item) {
	var minute = parseInt(item / 60);
	var second = item % 60;
	if(minute < 1) {
		return second + "秒";
	} else {
		return minute + "分钟" + second;
	}
	
}
var initxAxis = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60];
for(var i=61;i<dataflag;i++){
	initxAxis.push(toTime(i));
}
var option16= {
	id: 'main',
	title: {
		text: '胎心监护',
		padding: [5, 0, 0, 5],

		textStyle: {
			fontWeight: 'normal',
			fontSize: 16
		}

	},
	tooltip: {
		trigger: 'axis'
	},
	axisPointer: {
		link: {
			xAxisIndex: 'all'
		}
	},
	grid: [{
		left: 40,
		right: 35,
		height: '55%'
	}, {
	left: 40,
	right: 35,
	top: '70%',
	height: '19%'
}],
	xAxis: [{

			type: 'category',
			boundaryGap: false,
			axisLine: {
				onZero: true
			},
			data: initxAxis.map(function(item) {
				return item + "秒";
			})
		},
		{
			show: false,
			gridIndex: 1,
			type: 'category',
			boundaryGap: false,
			axisLine: {
				onZero: true
			},
			position: 'top',
			data: initxAxis.map(function(item) {
				return item + "秒";
			})

		}
	],
	yAxis: [{
			name: '胎心率(bpm)',
			nameTextStyle: {
				fontSize: 14
			},
			nameGap: 15,
			type: 'value',
			max: 220,
			min: 40,
			axisLabel: {
				formatter: '{value}',
				textStyle: {
					color: "#555555"
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
			//inverse: true    //反转y轴坐标
		}
	],
	toolbox: {
		left: 'right',
		feature: {
			dataZoom: {
				yAxisIndex: 'none'
			},
			restore: {},
			saveAsImage: {}
		}
	},

	//X轴下方小图比例大小
	dataZoom: [{
		show: true,
		start: 0,
		end: 1200,
		xAxisIndex: [0, 1]
	}, {

		type: 'inside',
		realtime: true,
		start: 0,
		end: 1200,
		xAxisIndex: [0, 1]

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
			data: [142,143,141,143,142,144,142,143,142,143,
142,142,142,140,142,142,144,143,144,142,
142,142,142,140,140,139,141,139,142,143,
144,142,142,142,142,143,144,142,143,143,
142,142,142,140,142,142,144,143,144,142,
144,144,145,144,145,143,145,145,145,145,
142,142,142,140,142,142,144,143,144,142,
141,141,141,141,143,142,142,140,141,141,
141,141,143,142,142,142,144,143,145,143,
144,144,145,144,145,143,145,145,145,145,
142,144,145,144,145,146,145,145,144,146,
148,148,146,146,148,146,148,147,148,148,
147,147,148,148,148,146,146,145,145,146,
145,144,145,143,142,143,145,142,143,144,
142,143,145,146,144,143,145,146,144,145,
146,146,149,148,148,146,148,147,147,145,
145,145,147,147,147,147,147,147,148,147,
148,147,148,147,148,147,149,149,151,149,
150,148,150,150,150,148,148,148,147,148,
148,146,147,145,145,145,146,144,146,145,
148,144,145,144,145,146,145,145,144,146,
148,148,147,149,150,150,150,149,149,149,
149,148,150,149,151,149,149,147,147,147,
149,148,150,150,152,150,151,151,151,150,
151,149,149,147,148,148,149,147,149,148,
149,148,150,150,152,152,153,151,153,151,
151,149,150,148,149,149,150,150,152,151,
153,152,154,154,154,153,154,153,153,153,
153,152,154,154,154,153,155,155,155,154,
154,153,154,152,154,152,152,151,153,152,
152,150,150,149,149,149,150,148,149,148,
149,147,147,146,148,146,148,146,147,147,
148,147,149,147,148,148,149,147,147,146,
147,147,148,148,148,146,146,145,145,146,
145,147,147,147,146,148,148,149,149,149,
150,151,150,152,152,153,153,152,154,154,
155,155,154,156,155,156,154,157,154,157,
156,154,158,154,155,157,156,157,158,158,
158,161,159,160,160,161,160,162,163,164,
164,165,165,165,166,166,165,166,168,166,
167,166,167,166,165,165,165,165,164,163,
160,164,161,162,160,161,158,158,159,157,
157,156,158,157,159,158,157,157,156,155,
155,154,156,156,156,153,153,153,152,152,
152,151,150,150,148,148,147,145,145,142,
143,143,144,142,143,142,144,143,145,143,
145,144,145,143,144,145,144,146,145,144,
145,146,147,148,145,146,144,146,145,145,
144,143,144,144,143,142,142,143,144,143,
145,144,142,143,143,142,141,140,141,140,
140,141,140,142,140,142,141,143,143,141,
142,142,143,142,143,143,142,142,142,142,
143,141,141,142,141,141,140,140,140,144,
142,142,142,141,141,141,142,141,142,143,
143,144,145,145,145,146,146,145,145,146,
144,147,148,147,149,147,148,149,150,149,
150,149,148,148,149,149,149,149,150,150,
150,149,151,149,149,150,149,149,151,150,
150,149,152,151,150,152,152,151,152,150,
150,149,149,148,149,148,147,148,150,149,
148,148,147,146,147,148,148,147,147,145,
145,146,145,144,144,142,143,141,142,142,
142,142,142,142,143,142,142,140,140,140,
142,142,142,142,143,142,142,140,140,140,
142,141,142,141,142,142,143,143,144,142,
142,142,142,142,143,142,142,140,140,140,
140,138,139,139,141,139,139,138,140,140,
141,141,142,141,141,141,142,142,142,140,
142,141,141,140,142,140,141,141,143,142,
144,142,142,142,142,140,140,138,138,137,
138,137,139,139,139,138,140,139,139,138,
139,138,138,136,137,136,137,137,137,135,
137,137,138,137,138,138,139,138,139,138,
139,137,138,137,137,135,137,136,137,137,
139,138,139,139,140,140,141,139,140,140,
142,140,142,142,143,141,141,140,140,140,
140,139,140,138,138,137,137,137,138,138,
139,138,138,137,138,138,138,137,139,139,
139,138,138,138,139,137,139,138,139,139,
141,139,139,137,138,140,139,137,138,138,
138,138,138,140,139,139,138,140,140,140,
142,143,142,141,140,138,139,140,142,139,
140,139,140,140,140,141,141,142,143,144,
143,142,145,143,143,144,143,143,144,143,
143,144,146,145,143,142,143,141,142,143,
142,141,142,144,143,142,143,143,142,143,
143,143,144,143,143,142,142,140,141,140,
142,143,142,143,142,142,144,143,144,142,
142,142,142,140,140,139,141,139,142,143,
143,140,139,142,142,140,141,140,141,143,
140,139,140,140,140,141,141,142,142,142,
140,138,138,138,139,137,139,138,139,139,
140,140,141,141,139,139,140,141,139,138,
140,139,140,138,138,139,139,139,140,140,
142,142,142,140,140,139,141,139,142,143,
144,142,142,142,142,143,144,142,143,143,
142,142,142,140,142,142,144,143,144,142,
140,141,142,140,140,141,140,139,139,140,
141,140,139,137,138,137,139,137,140,138,
140,140,141,142,142,143,141,142,142,143,
142,142,142,140,142,142,144,143,144,142,
142,140,142,142,143,141,141,140,140,140,
140,139,140,138,138,137,137,137,138,138,
138,140,138,138,140,139,138,139,139,138,
138,138,138,140,139,139,138,140,140,140,
141,139,139,138,138,139,137,138,137,137,
139,138,138,137,138,137,137,138,137,137,
138,138,138,137,138,136,137,137,137,139,
139,138,138,137,137,138,137,138,139,138,
140,138,140,139,141,140,142,140,142,141,
142,140,142,142,143,143,142,142,141,140,
139,140,138,140,139,137,139,138,139,138,
140,141,142,140,140,141,140,139,139,140,
142,142,143,141,142,141,141,141,141,141,
142,143,143,141,142,143,143,143,142,142,
141,139,140,140,140,139,141,140,141,141,
143,143,143,141,142,141,142,141,142,140,
140,140,140,140,142,140,142,142,144,144,
144,144,145,144,145,143,143,143,144,142,
144,143,145,145,146,145,146,145,145,144]
,
			//          data: data, 
			smooth: true,
			//标记点
			markPoint: {
				symbol: 'pin',
				silent: true, //不响应鼠标事件
				label: {
					normal: {
						color: 'orange',
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
				data: [{
						name: '最大值',
						type: 'max'
					},
					{
						name: '最小值',
						type: 'min'
					}
				],
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
			symbolSize: 8,
			itemStyle: {
				normal: {
					lineStyle: {
						color: '#AEB1B1',
					}
				}
			},
			hoverAnimation: false,
			data: [7,7,9,7,8,7,7,9,5,5,8,5,6,9,7,7,6,6,5,8,6,5,5,8,9,9,9,8,9,8,5,6,5,9,9,7,6,6,9,5,7,8,9,9,5,6,8,7,7,8,9,5,6,8,7,9,5,7,7,7,9,8,6,5,7,7,6,8,9,8,9,8,9,5,5,8,9,6,8,9,8,7,5,7,6,8,8,8,8,6,6,7,8,6,9,5,7,6,5,7,6,7,8,6,6,9,8,8,5,5,9,9,8,9,5,7,5,7,6,9,7,9,8,8,6,8,7,9,8,6,5,5,7,5,7,9,7,5,7,7,5,6,5,8,5,7,9,9,9,7,7,7,8,9,9,9,9,6,7,6,6,8,8,6,7,8,5,6,6,5,6,8,8,6,5,7,9,9,8,5,5,6,6,7,8,9,5,5,7,5,8,9,5,8,8,9,9,8,5,6,7,9,9,7,5,5,7,9,6,8,8,6,5,9,6,6,6,6,8,8,9,6,5,6,6,8,5,6,6,6,8,8,7,5,5,5,9,9,9,8,6,6,9,6,7,7,7,7,6,7,6,8,8,9,8,9,6,6,7,6,5,5,8,6,7,7,8,6,7,7,9,5,7,7,8,6,6,5,6,8,7,6,9,9,8,8,8,7,7,8,6,5,5,8,7,5,9,6,7,6,5,8,11,14,18,20,21,25,27,28,29,31,32,35,36,38,40,42,44,45,46,48,50,51,53,54,55,56,57,59,60,61,62,64,65,66,67,69,70,71,71,72,74,75,76,77,79,80,82,82,83,85,85,86,87,88,89,90,91,92,93,93,95,96,97,98,100,100,100,100,100,100,100,99,98,98,97,96,94,90,91,91,91,87,87,87,86,84,82,80,79,80,81,79,79,78,73,73,72,71,69,71,68,69,69,67,64,65,65,62,62,62,58,60,57,58,54,55,55,53,51,51,49,49,47,46,44,42,43,43,41,38,38,38,35,38,37,35,34,34,29,29,29,26,27,27,24,23,21,24,19,21,20,19,17,16,17,13,13,14,12,9,9,10,7,5,7,5,1,2,3,2,8,8,7,6,5,5,8,6,6,5,5,6,6,7,8,7,8,6,6,8,5,6,7,7,9,6,5,8,8,9,8,7,8,6,8,9,9,9,5,8,9,7,7,7,7,9,7,9,8,6,6,6,5,8,7,9,5,7,9,5,7,6,6,8,8,9,6,6,9,9,8,6,5,6,9,8,9,9,9,9,5,5,8,7,9,5,8,5,5,9,9,5,7,9,6,7,8,6,9,8,7,9,6,9,7,7,8,8,5,9,7,9,5,5,6,9,9,6,8,6,8,9,5,8,6,8,6,5,8,5,5,5,6,6,5,5,7,9,9,5,9,9,7,7,7,5,5,6,9,9,7,8,8,7,5,5,7,8,6,5,7,6,8,5,8,6,9,5,6,7,6,9,5,8,9,8,7,8,7,9,7,7,7,7,8,9,8,7,9,5,9,6,7,9,8,8,8,6,9,7,8,6,8,5,6,5,9,8,5,5,8,9,8,9,6,7,8,7,5,5,8,8,5,7,5,6,8,6,6,9,5,9,9,6,9,7,5,5,7,8,5,7,6,8,9,5,8,7,8,9,9,5,6,7,6,6,9,9,8,5,6,5,7,7,7,9,5,6,8,5,8,8,8,9,5,6,7,9,7,6,9,8,7,7,8,7,6,7,5,8,5,9,8,8,7,9,7,8,5,8,9,8,11,10,10,13,12,12,17,17,18,17,18,19,22,23,23,25,27,28,25,29,31,28,30,30,35,33,34,36,38,40,37,41,40,41,45,46,45,48,49,48,48,49,49,52,51,54,53,54,55,59,58,62,63,63,64,63,64,65,68,67,67,69,73,70,75,72,77,77,76,77,80,79,82,82,84,82,86,87,88,90,87,91,90,93,92,94,97,95,96,96,100,100,99,100,100,100,100,100,92,91,93,91,87,86,85,86,83,83,83,82,81,79,79,76,79,76,75,76,74,72,69,70,70,67,65,65,66,64,65,60,63,62,60,56,58,58,57,52,51,51,52,50,51,46,46,48,43,45,42,40,39,42,41,39,37,37,34,35,33,34,31,29,28,26,25,24,24,25,21,24,23,20,21,19,16,16,17,16,15,13,12,10,7,6,6,7,3,6,6,8,7,5,6,5,8,9,9,8,5,8,9,8,5,5,5,9,5,7,7,8,5,7,8,5,7,5,9,7,5,7,7,9,7,8,5,5,6,6,8,9,8,7,6,8,7,7,9,5,7,7,5,7,8,9,8,6,5,6,5,6,6,5,7,5,8,5,8,9,9,8,5,5,6,9,6,7,6,9,7,5,7,9,9,5,7,9,9,9,9,8,5,8,7,9,8,6,9,9,9,9,8,8,6,9,6,7,9,8,5,8,9,7,9,8,9,8,6,9,9,7,5,9,5,9,7,8,7,9,7,6,6,9,9,6,5,7,6,7,6,6,7,8,7,5,9,5,6,6,8,5,8,6,8,7,6,6,5,6,6,6,9,6,7,8,6,9,9,9,7,7,5,9,9,8,5,6,9,8,8,5,8,8,6,8,9,6,9,5,9,7,9,7,5,8,9,7,9,5,6,6,9,5,7,8,7,6,7,6,6,7,6,6,5,9,9,5,8,8,5,6,8,5,6,8,7,7,5,9,5,5,8,7,6,5,5,6,5,8,7,9,7,8,5,5,6,8,6,7,9,9,9,9,7,7,5,9,9,6,8,9,8,6,7,7,5,7,7,6,9,5,8,6,6,8,8,6,6,5,9,9,8,5,7,7,6,6,6,7,8,6,6,9,8,8,8,8,6]
		}, { //用于曲线标记（未确认最终需求）
			id: 'a',
			type: 'line',
			data: []
		}, {
			type: 'line', //用于记录胎动（测试）
			symbol: 'circle',
			symbolSize: 10,
			data: [
				[33, 90]
			]
		}
	],
	color: ['#999', '#3388FF', '#4EE2C0'] //自定义各个series颜色
};
myChart16.setOption(option16);
window.onload = function() {
	window.onresize = function() {
		resizemyChart1();
		myChart1.resize();
		resizemyChart2();
		myChart2.resize();
		resizemyChart3();
		myChart3.resize();
		resizemyChart4();
		myChart4.resize();
		resizemyChart5();
		myChart5.resize();
		resizemyChart6();
		myChart6.resize();
		resizemyChart7();
		myChart7.resize();
		resizemyChart8();
		myChart8.resize();
		resizemyChart9();
		myChart9.resize();
		resizemyChart10();
		myChart10.resize();
		resizemyChart11();
		myChart11.resize();
		resizemyChart12();
		myChart12.resize();
		resizemyChart13();
		myChart13.resize();
		resizemyChart14();
		myChart14.resize();
		resizemyChart15();
		myChart15.resize();
		resizemyChart16();
		myChart16.resize();
	}
}
/*@author Luoyc 自测图表*/
//var address="http://120.76.194.76/doctormanager/";
//var address = sessionStorage.getItem("address")
function bloodsugreSetDate(){
	//血糖
	var bloodsugrelist = [];
	var bBreakfastlist = [];
	var percentagelist = [];
	//早餐前血糖异常计数
	//偏高
	var index11 = 0;
	//偏低
	var index12 = 0;
	//早餐后血糖异常计数
	//偏高
	var index21 = 0;
	//偏低
	var index22 = 0;
	//午餐前血糖异常计数
	//偏高
	var index31 = 0;
	//偏低
	var index32 = 0;
	//午餐后血糖异常计数
	//偏高
	var index41 = 0;
	//偏低
	var index42 = 0;
	//晚餐前血糖异常计数
	//偏高
	var index51 = 0;
	//偏低
	var index52 = 0;
	//晚餐后血糖异常计数
	//偏高
	var index61 = 0;
	//偏低
	var index62 = 0;
	//睡前血糖异常计数
	//偏高
	var index71 = 0;
	//偏低
	var index72 = 0;
	var afbrelist = [];
	var bflunlist = [];
	var aflunlist = [];
	var bfdinlist = [];
	var afdinlist = [];
	var bfslelist = [];
	var datelist = [];
	var bloodsugretimedatalist = [];
	var seperator = "-";
	$.ajax({
		type: "post",
		url: address + "bloodsugre/findByWeekly.do",
		data: {
			"mid": mid,
			"eWeeks":eWeeks,
			"sWeeks":sWeeks
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
				var flag = 0;
				var currentdate1 = year + seperator + month + seperator + strDate;
				bBreakfastlist.push(list[i].bbreakfast);
				afbrelist.push(list[i].afbre);
				bflunlist.push(list[i].bflun);
				aflunlist.push(list[i].aflun);
				bfdinlist.push(list[i].bfdin);
				afdinlist.push(list[i].afdin);
				bfslelist.push(list[i].bfsle);
				datelist.push(currentdate1);
				//每天的血糖平均值
				if(list[i].bbreakfast != null) {
					flag++
				}
				if(list[i].afbre != null) {
					flag++
				}
				if(list[i].bflun != null) {
					flag++
				}
				if(list[i].aflun != null) {
					flag++
				}
				if(list[i].bfdin != null) {
					flag++
				}
				if(list[i].afdin != null) {
					flag++
				}
				if(list[i].bfsle != null) {
					flag++
				}
				bloodsugrelist.push(Number((Number(list[i].bbreakfast) + Number(list[i].afbre) + Number(list[i].bflun) + Number(list[i].aflun) + Number(list[i].bfdin) + Number(list[i].afdin) + Number(list[i].bfsle)) / flag).toFixed(1));
				//把起始日期转换回yyyy-MM-dd格式
				if(i == 0) {
					currentdate = year + seperator + month + seperator + strDate;
					sessionStorage.setItem("startdate", currentdate);
				}
				if(i == list.length - 1) {
					currentdate = year + seperator + month + seperator + strDate;
					sessionStorage.setItem("enddate", currentdate);
				}
				if(list[i].bbreakfast > 7) {
					index11++
				}
				if(list[i].bbreakfast < 4.4) {
					index12++
				}
				if(list[i].afbre > 10) {
					index21++
				}
				if(list[i].afbre < 4.4) {
					index22++
				}
				if(list[i].bflun > 10) {
					index31++
				}
				if(list[i].bflun < 4.4) {
					index32++
				}
				if(list[i].aflun > 10) {
					index41++
				}
				if(list[i].aflun < 4.4) {
					index42++
				}
				if(list[i].bfdin > 10) {
					index51++
				}
				if(list[i].bfdin < 4.4) {
					index52++
				}
				if(list[i].afdin > 10) {
					index61++
				}
				if(list[i].afdin < 4.4) {
					index62++
				}
				if(list[i].bfsle > 10) {
					index71++
				}
				if(list[i].bfsle < 4.4) {
					index72++
				}
			});
			//血糖百分比柱状图数组赋值
			percentagelist.push(((bBreakfastlist.length - index11 - index12) / bBreakfastlist.length * 100).toFixed(0))
			percentagelist.push(((afbrelist.length - index21 - index22) / afbrelist.length * 100).toFixed(0))
			percentagelist.push(((bflunlist.length - index31 - index32) / bflunlist.length * 100).toFixed(0))
			percentagelist.push(((aflunlist.length - index41 - index42) / aflunlist.length * 100).toFixed(0))
			percentagelist.push(((bfdinlist.length - index51 - index52) / bfdinlist.length * 100).toFixed(0))
			percentagelist.push(((afdinlist.length - index61 - index62) / afdinlist.length * 100).toFixed(0))
			percentagelist.push(((bfslelist.length - index71 - index72) / bfslelist.length * 100).toFixed(0))
			//百分比表格赋值
			$('#td11').text((index12 / bBreakfastlist.length * 100).toFixed(0));
			$('#td12').text((index22 / afbrelist.length * 100).toFixed(0));
			$('#td13').text((index32 / bflunlist.length * 100).toFixed(0));
			$('#td14').text((index42 / aflunlist.length * 100).toFixed(0));
			$('#td15').text((index52 / bfdinlist.length * 100).toFixed(0));
			$('#td16').text((index62 / afdinlist.length * 100).toFixed(0));
			$('#td17').text((index72 / bfslelist.length * 100).toFixed(0));
			$('#td21').text(percentagelist[0])
			$('#td22').text(percentagelist[1])
			$('#td23').text(percentagelist[2])
			$('#td24').text(percentagelist[3])
			$('#td25').text(percentagelist[4])
			$('#td26').text(percentagelist[5])
			$('#td27').text(percentagelist[6])
			$('#td31').text((index11 / bBreakfastlist.length * 100).toFixed(0));
			$('#td32').text((index21 / afbrelist.length * 100).toFixed(0));
			$('#td33').text((index31 / bflunlist.length * 100).toFixed(0));
			$('#td34').text((index41 / aflunlist.length * 100).toFixed(0));
			$('#td35').text((index51 / bfdinlist.length * 100).toFixed(0));
			$('#td36').text((index61 / afdinlist.length * 100).toFixed(0));
			$('#td37').text((index71 / bfslelist.length * 100).toFixed(0));
			var index1 = 0;
			var index2 = 0;
			//日平均血糖计数
			for(var i = 0; i < bloodsugrelist.length; i++) {
				if(bloodsugrelist[i] - 10 > 0) {
					index1++
				}
			}
			for(var i = 1; i < bloodsugrelist.length; i++) {
				if(bloodsugrelist[i] - 4 < 0) {
					index2++
				}
			}
			$('#dataQuantity').text(bloodsugrelist.length);
			$('#max').text(Math.max.apply(null, bloodsugrelist));
			$('#min').text(Math.min.apply(null, bloodsugrelist));
			$('#more').text(index1);
			$('#less').text(index2);
			var sum = 0;
			var sum1 = 0;
			var sum2 = 0;
			var sum3 = 0;
			var sum4 = 0;
			var sum5 = 0;
			var sum6 = 0;
			var sum7 = 0;
			//血糖按时段求和
			for(var i = 0; i < bloodsugrelist.length; i++) {
				sum += Number(bloodsugrelist[i]);
				sum1 += Number(bBreakfastlist[i]);
				sum2 += Number(afbrelist[i]);
				sum3 += Number(bflunlist[i]);
				sum4 += Number(aflunlist[i]);
				sum5 += Number(bfdinlist[i]);
				sum6 += Number(afdinlist[i]);
				sum7 += Number(bfslelist[i]);
			}
			//血糖按时段取平均值
			bloodsugretimedatalist.push(Number(sum1 / datelist.length).toFixed(1))
			bloodsugretimedatalist.push(Number(sum1 / datelist.length).toFixed(1))
			bloodsugretimedatalist.push(Number(sum2 / datelist.length).toFixed(1))
			bloodsugretimedatalist.push(Number(sum3 / datelist.length).toFixed(1))
			bloodsugretimedatalist.push(Number(sum4 / datelist.length).toFixed(1))
			bloodsugretimedatalist.push(Number(sum5 / datelist.length).toFixed(1))
			bloodsugretimedatalist.push(Number(sum6 / datelist.length).toFixed(1))
			bloodsugretimedatalist.push(Number(sum7 / datelist.length).toFixed(1))
			$('#timedata1').text(bloodsugretimedatalist[0]);
			$('#timedata2').text(bloodsugretimedatalist[1]);
			$('#timedata3').text(bloodsugretimedatalist[2]);
			$('#timedata4').text(bloodsugretimedatalist[3]);
			$('#timedata5').text(bloodsugretimedatalist[4]);
			$('#timedata6').text(bloodsugretimedatalist[5]);
			$('#timedata7').text(bloodsugretimedatalist[6]);
			$('#timedata8').text(bloodsugretimedatalist[7]);
			$('#ave').text((sum / bloodsugrelist.length).toFixed(1));
			myChart1.setOption({
				xAxis: {
					data: datelist
				},
				series: [{
					// 根据名字对应到相应的系列  
					name: '早餐前',
					data: bBreakfastlist
				},{
					// 根据名字对应到相应的系列  
					name: '早餐后',
					data: afbrelist
				},{
					// 根据名字对应到相应的系列  
					name: '午餐前',
					data: bflunlist
				},{
					// 根据名字对应到相应的系列  
					name: '午餐后',
					data: aflunlist
				},{
					// 根据名字对应到相应的系列  
					name: '晚餐前',
					data: bfdinlist
				},{
					// 根据名字对应到相应的系列  
					name: '晚餐后',
					data: afdinlist
				},{
					// 根据名字对应到相应的系列  
					name: '夜间',
					data: bfslelist
				}]
			});
			myChart2.setOption({
				xAxis: {
					data: ['早餐前', '早餐后', '午餐前', '午餐后', '晚餐前', '晚餐后', '夜间']
				},
				series: [{
					// 根据名字对应到相应的系列  
					name: '血糖',
					data: percentagelist
				}]
			});
			myChart3.setOption({
				xAxis: {
					data: ['空腹', '早餐前', '早餐后', '午餐前', '午餐后', '晚餐前', '晚餐后', '夜间']
				},
				series: [{
					// 根据名字对应到相应的系列  
					name: '血糖',
					data: bloodsugretimedatalist
				}]
			});
		},
		error: function() {
	
		}
	});
}
function bloodpressureSetDate(){
	//血压
	var sWeeks = sessionStorage.getItem("sWeeks");
	var eWeeks = sessionStorage.getItem("eWeeks");
	var systoliclist = [];
	var diastoliclist = [];
	var heartratelist = [];
	var bloodpressuredatelist = [];
	var bloodpressureDate = [];
	$.ajax({
		type: "post",
		url: address + "bloodpressure/findByWeekly.do",
		data: {
			"mid": mid,
			"eWeeks":eWeeks,
			"sWeeks":sWeeks
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			var list = e.data;
			var lastDay;
			var beginDay;
			var middleDay;
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
				var currentdate = month + seperator + strDate + " " + hour + ":" + minute;
				var currentdate1 = year + seperator + month + seperator + strDate;
				bloodpressuredatelist.push(currentdate);
				bloodpressureDate.push(date);
				systoliclist.push(list[i].systolic);
				diastoliclist.push(list[i].diastolic);
				heartratelist.push(list[i].heartrate);
				//划分上周、本周
				if(i == list.length - 1) {
					var dateRange = date.getDay();
					lastDay = date;
					if(dateRange == 0) {
						middleDay = new Date(new Date(currentdate1) - 6 * 24 * 60 * 60 * 1000 - 8 * 60 * 60 * 1000);
						beginDay = new Date(middleDay - 6 * 24 * 60 * 60 * 1000);
					} else {
						middleDay = new Date(new Date(currentdate1) - (dateRange - 1) * 24 * 60 * 60 * 1000 - 8 * 60 * 60 * 1000);
						beginDay = new Date(middleDay - 7 * 24 * 60 * 60 * 1000);
						/*middleDay=middleDay.getFullYear()+seperator+(middleDay.getMonth() + 1)+seperator+middleDay.getDate();*/
					}
	
				}
			});
			var index3 = 0;
			var index4 = 0;
			for(var i = 0; i < bloodpressuredatelist.length; i++) {
				if(systoliclist[i] - 140 >= 0) {
					index3++
				}
			}
			for(var i = 1; i < bloodpressuredatelist.length; i++) {
				if(diastoliclist[i] - 60 <= 0) {
					index4++
				}
			}
			var pressuresum = Number(eval(diastoliclist.join("+"))) + Number(eval(systoliclist.join("+")));
			/*	$('#dataQuantity1').text(systoliclist.length);*/
			$('#max1').text(Math.max.apply(null, systoliclist));
			$('#min1').text(Math.min.apply(null, diastoliclist));
			$('#more1').text(index3);
			$('#less1').text(index4);
			$('#ave1').text((pressuresum / systoliclist.length / 2).toFixed(0));
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
			var thisWeekSystolicSum = 0;
			var thisWeekDiastolicSum = 0;
			var thisWeekHeartrateSum = 0;
			var lastWeekHeartrateSum = 0;
			var lastWeekSystolicSum = 0;
			var lastWeekDiastolicSum = 0;
			var thisWeekIndex = 0;
			var lastWeekIndex = 0;
			for(var i = 0; i < bloodpressureDate.length; i++) {
				if(bloodpressureDate[i] >= beginDay && bloodpressureDate[i] < middleDay) {
					lastWeekSystolicSum += Number(systoliclist[i]);
					lastWeekDiastolicSum += Number(diastoliclist[i]);
					lastWeekHeartrateSum += Number(heartratelist[i]);
					lastWeekIndex++;
				} else if(bloodpressureDate[i] >= middleDay && bloodpressureDate[i] <= lastDay) {
					thisWeekSystolicSum += Number(systoliclist[i]);
					thisWeekDiastolicSum += Number(diastoliclist[i]);
					thisWeekHeartrateSum += Number(heartratelist[i]);
					thisWeekIndex++;
				}
			}
			var thisWeekSystolicAve;
			var thisWeekDiastolicAve;
			var thisWeekHeartrateAve;
			var lastWeekSystolicAve;
			var lastWeekDiastolicAve;
			var lastWeekHeartrateAve;
			if(thisWeekIndex != 0) {
				thisWeekSystolicAve = Number((thisWeekSystolicSum / thisWeekIndex).toFixed(0));
				thisWeekDiastolicAve = Number((thisWeekDiastolicSum / thisWeekIndex).toFixed(0));
				thisWeekHeartrateAve = Number((thisWeekHeartrateSum / thisWeekIndex).toFixed(0));
			} else {
				thisWeekSystolicAve = '';
				thisWeekDiastolicAve = '';
				thisWeekHeartrateAve = '';
			}
			if(lastWeekIndex != 0) {
				lastWeekSystolicAve = Number((lastWeekSystolicSum / lastWeekIndex).toFixed(0));
				lastWeekDiastolicAve = Number((lastWeekDiastolicSum / lastWeekIndex).toFixed(0));
				lastWeekHeartrateAve = Number((lastWeekHeartrateSum / lastWeekIndex).toFixed(0));
			} else {
				lastWeekSystolicAve = '';
				lastWeekDiastolicAve = '';
				lastWeekHeartrateAve = '';
			}
			myChart10.setOption({
				series: [{
					// 根据名字对应到相应的系列  
					name: '收缩压(mmHg)',
					data: [lastWeekSystolicAve, thisWeekSystolicAve]
				}, {
					name: '舒张压(mmHg)',
					type: 'line',
					data: [lastWeekDiastolicAve, thisWeekDiastolicAve]
				}]
			});
		},
		error: function() {
	
		}
	});
}
function weightSetDate(){
	var sWeeks = sessionStorage.getItem("sWeeks");
	var eWeeks = sessionStorage.getItem("eWeeks");
	var weightlist = [];
	var weightoringinlist = [];
	var datelist2 = [];
	var weightlimit = [];
	var BMIlist=[];
	$.ajax({
		type: "post",
		url: address + "gravidainfo/findByWeekly.do",
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
			weightoringinlist = e.data[3];
			var height=e.data[4];
			var index5 = 0;
			var index6 = 0;
			for(var i = 0; i < datelist2.length; i++) {
				BMIlist.push((weightlist[i]/height/height*10000).toFixed(1));
				if(weightlist[i] - weightlimit[i] > 0) {
					index5++
				}
			}
			for(var i = 1; i < datelist2.length; i++) {
				if(weightlist[i] - weightlist[i - 1] < 0) {
					index6++
				}
			}
			var weightsum = Number(eval(weightoringinlist.join("+")));
			$('#dataQuantity2').text(weightoringinlist.length);
			$('#max2').text(Math.max.apply(null, weightoringinlist));
			$('#min2').text(Math.min.apply(null, weightoringinlist));
			$('#more2').text(index5);
			$('#less2').text(index6);
			$('#ave2').text((weightsum / weightoringinlist.length).toFixed(1));
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
		},
		error: function() {
	
		}
	});
	/*//胎儿体重
	$.ajax({
		type: "post",
		url: address + "checkResult/queryFetalWeight.do",
		data: {
			"mid": mid,
			"sWeeks": sWeeks,
			"eWeeks": eWeeks
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			fetalweightlist = e.data[1];
			datelist5 = e.data[0];
			myChart8.setOption({
				xAxis: {
					data: datelist5
				},
				series: [{
					name: '体重总量',
					type: 'line',
					data: fetalweightlist
				}]
			});
		},
		error: function() {

		}
	});*/
}
function ecgSetDate(){
	//心电
	var sWeeks = sessionStorage.getItem("sWeeks");
	var eWeeks = sessionStorage.getItem("eWeeks");
	var table = '';
	$.ajax({
		type: "post",
		url: address + "myEcg/findByWeekly.do",
		data: {
			"mid": mid,
			"sWeeks": sWeeks,
			"eWeeks": eWeeks
		},
		dataType: "json",
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
				var currentdate = year + seperator + month + seperator + strDate;
				table += "<tr><td>" + currentdate + "</td><td>" + list[i].hearrate + "</td><td>" + list[i].qtinterval + "</td><td>" + list[i].pdispersion + "</td><td>" + list[i].qtcinterval + "</td><td>" + list[i].qdispersion + "</td><td>" + list[i].qrsduration + "</td><td>" + list[i].stsegment + "</td><td>" + list[i].rwaveamplitude + "</td><td></td></tr>";
			});
			$("#electrocardio_table").append(table);
		},
		error: function() {
	
		}
	});
}
function temperatureSetDate(){
	//体温
	var sWeeks = sessionStorage.getItem("sWeeks");
	var eWeeks = sessionStorage.getItem("eWeeks");
	var temperaturelist = [];
	var datelist3 = [];
	$.ajax({
		type: "post",
		url: address + "temperature/findByWeekly.do",
		data: {
			"mid": mid,
			"sWeeks": sWeeks,
			"eWeeks": eWeeks
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
				var temperaturesum = Number(eval(temperaturelist.join("+")));
				var index7 = 0;
				var index8 = 0;
				for(var i = 0; i < datelist3.length; i++) {
					if(temperaturelist[i] - 38 > 0) {
						index7++
					}
				}
				for(var i = 1; i < datelist3.length; i++) {
					if(temperaturelist[i] - 36.5 < 0) {
						index8++
					}
				}
				$('#dataQuantity3').text(temperaturelist.length);
				$('#max3').text(Math.max.apply(null, temperaturelist));
				$('#min3').text(Math.min.apply(null, temperaturelist));
				$('#more3').text(index7);
				$('#less3').text(index8);
				$('#ave3').text((temperaturesum / temperaturelist.length).toFixed(1));
			});
		},
		error: function() {
	
		}
	});
}
function bloodfatSetDate(){
	//血脂
	var sWeeks = sessionStorage.getItem("sWeeks");
	var eWeeks = sessionStorage.getItem("eWeeks");
	var datalist1 = [];
	var datalist2 = [];
	var datalist3 = [];
	var datalist4 = [];
	var datalist5 = [];
	var datelist4 = [];
	$.ajax({
		type: "post",
		url: address + "bloodfat/findByWeekly.do",
		data: {
			"mid": mid,
			"sWeeks": sWeeks,
			"eWeeks": eWeeks
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
			});
		},
		error: function() {}
	});
}
function abdominalgirthSetDate(){
	//腹围
	var sWeeks = sessionStorage.getItem("sWeeks");
	var eWeeks = sessionStorage.getItem("eWeeks");
	var abdominalgirthlist = [];
	var datelist9 = [];
	$.ajax({
		type: "post",
		url: address + "abdominalgirth/findByWeekly.do",
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
function fundalheightSetDate(){
	//宫高
	var sWeeks = sessionStorage.getItem("sWeeks");
	var eWeeks = sessionStorage.getItem("eWeeks");
	var fundalheightlist = [];
	var datelist10 = [];
	$.ajax({
		type: "post",
		url: address + "fundalheight/findByWeekly.do",
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
function bloodoxygenSetDate(){
	//血氧
	var sWeeks = sessionStorage.getItem("sWeeks");
	var eWeeks = sessionStorage.getItem("eWeeks");
	var datelist11=[];
	var bloodoxygenlist=[];
	var heartratelist2=[];
	$.ajax({
		type: "post",
		url: address + "bloodoxygen/findByWeekly.do",
		data: {
			"mid": mid,
			"sWeeks": sWeeks,
			"eWeeks": eWeeks
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
			myChart15.setOption({
				xAxis: {
					data: datelist11
				},
				series: [{
					name: '脉率',
					type: 'line',
					data: heartratelist2
				}]
			});
			myChart6.setOption({
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
function featalMovementSetDate(){
	//胎动
	var sWeeks = sessionStorage.getItem("sWeeks");
	var eWeeks = sessionStorage.getItem("eWeeks");
	var actualclicklist = [];
	var datelist7 = [];
	var datelist8 = [];
	var seperator = "-";
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
				var currentdate = month + seperator + strDate + " " + hour + ":" + minute;
				var currentdate1 = month + seperator + strDate;
				if((i > 0 && currentdate1 != datelist8[datelist8.length - 1]) || i == 0) {
					if(countquickeningflag) {
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
				if(i==list.length-1){
					sumclicklist.push((sum / everydaytestindex * 12).toFixed(0));
				}
				datelist7.push(currentdate);
				actualclicklist.push(list[i].actualclick);
			});
			myChart11.setOption({
				xAxis: {
					data: datelist8
				},
				series: [{
					name: '总次数',
					type: 'line',
					data: sumclicklist
				}]
			});
			myChart14.setOption({
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
function editDoctorActive() {
	$("#edit_doctor_advice").click();
}
function myriskModalSetDate(){
	var sWeeks = sessionStorage.getItem("sWeeks");
	var eWeeks = sessionStorage.getItem("eWeeks");
	//风险模型赋值、编辑医嘱赋值
	$.ajax({
		type: "post",
		url: address + "abnormityinfo/findByWeeks.do",
		data: {
			"mid": mid,
			"sWeeks": sWeeks,
			"eWeeks": eWeeks
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			var list = e.data;
			var scoreSum = 0;
			var standardStr = '';
			var riskStr = '';
			var doctorAdviceStr = '';
			var unit = '';
			$.each(list, function(i) {
				scoreSum += Number(list[i].score);
				if(list[i].cunit == '' || list[i].cunit == null) {
					unit = ''
				} else {
					unit = list[i].cunit;
				}
				standardStr += (i + 1) + '.' + list[i].cname + '≥' + (Number(list[i].cend) + Number(list[i].difference)) + unit + '或≤' + (Number(list[i].cbegin) - Number(list[i].difference)) + unit + '<br/>';
				riskStr += (i + 1) + '.' + list[i].cname + '≥' + (Number(list[i].cend) + Number(list[i].difference)) + unit + '或≤' + (Number(list[i].cbegin) - Number(list[i].difference)) + unit + '  ' + '高危分值' + list[i].score + '分' + '\n';
				doctorAdviceStr += list[i].knowledge;
			});
			//罗盘赋值
			riskModaloption.series[0].data[0].value = scoreSum;
			myriskModalchart.setOption(riskModaloption, true);
			//判断标准说明赋值
			$("#standard_middle").html(standardStr);
			$("#risk_factor").html(riskStr);
			$("#risk_factor").css("color", 'red');
			$("#doctor_advice").html(doctorAdviceStr);
			//添加点击事件
		},
		error: function() {
	
		}
	});
}
$('.add-more-advice').click(function() {
	$('#myModal1_textarea').text($("#doctor_advice").text());
	$('#myModal1').modal('show');
});

function myModal1Hide() {
	$('#myModal1').modal('hide');
}

function changeDoctorAdvice() {
	$("#doctor_advice").text($('#myModal1_textarea').val());
	$('#myModal1').modal('hide');
}
