/* 周报审核-通用模板js @author yinzx*/
var mid = sessionStorage.getItem("mid");
//var sWeeks = sessionStorage.getItem("sWeeks");
//var eWeeks = sessionStorage.getItem("eWeeks");
var doctorId = sessionStorage.getItem("doctorId");
//var address = "http://192.168.1.49:8080/doctormanager/";
var address = sessionStorage.getItem("address");
//var mid = 'dg000001';
//var doctorId = 2;
var sWeeks = 0;
var eWeeks = 43;

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
function selectAllSend() {
	if($('.send_selectAll').is(':checked')) {

		$(".select_gravida").attr("checked", 'true');
		$(".select_husband").attr("checked", 'true');
		$(".select_orderlies").attr("checked", 'true');

	} else {

		$(".select_gravida").removeAttr("checked");
		$(".select_husband").removeAttr("checked");
		$(".select_orderlies").removeAttr("checked");

	}
}
//全选检测项目建议
function selectAllNotice() {
	if($('.Notice_selectAll').is(':checked')) {

		$(".select_fetelHeart").prop("checked", true);
		$(".select_fetelMovement").prop("checked", true);
		$(".select_pressure").prop("checked", true);
		$(".select_urine").prop("checked", true);
		$(".select_weight").prop("checked", true);
	} else {

		$(".select_fetelHeart").prop("checked", false);
		$(".select_fetelMovement").prop("checked", false);
		$(".select_pressure").prop("checked", false);
		$(".select_urine").prop("checked", false);
		$(".select_weight").prop("checked", false);
	}
}
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
var chart = document.getElementById('chart');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart = function() {
	chart.style.width = '450px';
};
//设置容器高宽
resizemyChart();
// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(chart);
option = {
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
	myChart.resize();
};
// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);
//血糖
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

var chart2 = document.getElementById('chart2');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart2 = function() {
	chart2.style.width = window.innerWidth / 2 - 20 + 'px';
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

var chart3 = document.getElementById('chart3');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart3 = function() {
	chart3.style.width = window.innerWidth / 2 - 20 + 'px';
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
		top: '30px',
		textStyle: {
			fontSize: '12',
			color: '#555555',
			fontFamily: '微软雅黑'
		}
	},
	grid: {
		left: '1%',
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
var chart6 = document.getElementById('chart6');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart6 = function() {
	chart6.style.width = window.innerWidth / 2 - 20 + 'px';
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
myChart6.setOption(option6);
var chart15 = document.getElementById('chart15');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart15 = function() {
	chart15.style.width = window.innerWidth / 2 - 20 + 'px';
};
//设置容器高宽
resizemyChart15();
// 基于准备好的dom，初始化echarts实例
var myChart15 = echarts.init(chart15);
var option15 = {
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
		name: '脉率',
		type: 'line',
		data: [77, 75, 78, 79, 73, 77, 76, 72, 81, 83]
	}]
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
var chart8 = document.getElementById('chart8');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart8 = function() {
	chart8.style.width = window.innerWidth / 2 - 20 + 'px';
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
var chart9 = document.getElementById('chart9');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart9 = function() {
	chart9.style.width = window.innerWidth / 2 - 20 + 'px';
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
var chart10 = document.getElementById('chart10');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart10 = function() {
	chart10.style.width = window.innerWidth / 2 - 20 + 'px';
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
var chart11 = document.getElementById('chart11');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart11 = function() {
	chart11.style.width = window.innerWidth / 2 - 20 + 'px';
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
	}],
	series: [{
		name: '总次数',
		type: 'line',
		data: [36, 60, 48, 48, 36]
	}]
};
// 使用刚指定的配置项和数据显示图表。
myChart11.setOption(option11);
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
//宫高
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
		max: '30',
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
var chart14 = document.getElementById('chart14');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart14 = function() {
	chart14.style.width = window.innerWidth / 2 - 20 + 'px';
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
myChart14.setOption(option14);
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
	}
}
//datepicker
$(function() {
	$(".datepicker").datepicker({
		language: "zh-CN",
		autoclose: true, //选中之后自动隐藏日期选择框
		clearBtn: true, //清除按钮
		//todayBtn: true,//今日按钮
		format: "yyyy-mm-dd" //日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
	});
});
/*@author Luoyc 自测图表*/
//var address="http://120.76.194.76/doctormanager/";
//var address = sessionStorage.getItem("address")

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
	url: address + "bloodsugre/find.do",
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
//血压
var systoliclist = [];
var diastoliclist = [];
var heartratelist = [];
var datelist1 = [];
var bloodpressureDate = [];
$.ajax({
	type: "post",
	url: address + "bloodpressure/find.do",
	data: {
		"mid": mid
	},
	dataType: "json",
	ContentType: "application/x-www-form-urlencoded;charset=utf-8",
	success: function(e) {
		var list = e.data;
		var lastDay;
		var beginDay;
		var middleDay;
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
			var currentdate1 = year + seperator + month + seperator + strDate;
			datelist1.push(currentdate);
			bloodpressureDate.push(date1);
			systoliclist.push(list[i].systolic);
			diastoliclist.push(list[i].diastolic);
			heartratelist.push(list[i].heartrate);
			//划分上周、本周
			if(i == list.length - 1) {
				var dateRange = date1.getDay();
				lastDay = date1;
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
		for(var i = 0; i < datelist1.length; i++) {
			if(systoliclist[i] - 140 >= 0) {
				index3++
			}
		}
		for(var i = 1; i < datelist1.length; i++) {
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
var weightlist = [];
var weightoringinlist = [];
var datelist2 = [];
var weightlimit = [];
var BMIlist=[];
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
		"mid": mid
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
//心电
var table = '';
$.ajax({
	type: "post",
	url: address + "myEcg/find.do",
	data: {
		"mid": mid
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
//体温
var temperaturelist = [];
var datelist3 = [];
$.ajax({
	type: "post",
	url: address + "temperature/find.do",
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
//血脂
var datalist1 = [];
var datalist2 = [];
var datalist3 = [];
var datalist4 = [];
var datalist5 = [];
var datelist4 = [];
$.ajax({
	type: "post",
	url: address + "bloodfat/find.do",
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
//胎动
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
	url: address + "countQuickening/find.do",
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
//腹围
var abdominalgirthlist = [];
var datelist9 = [];
$.ajax({
	type: "post",
	url: address + "abdominalgirth/find.do",
	data: {
		"mid": mid
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
//宫高
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
var datelist11=[];
var bloodoxygenlist=[];
var heartratelist2=[];
$.ajax({
	type: "post",
	url: address + "bloodoxygen/find.do",
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
function editDoctorActive() {
	$("#edit_doctor_advice").click();
}
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
		option.series[0].data[0].value = scoreSum;
		myChart.setOption(option, true);
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
//发送医嘱提醒
function send_reminder() {
	if($("#doctor_advice").text() == '') {
		alert("医嘱不能为空");
	} else {
		var selected_selfTest = '';
		if($(".select_pressure:checked").next().find("option:selected").text() != '') {
			selected_selfTest += $(".select_pressure:checked").next().find("option:selected").text();
			$(".selected_selfTest:checked").each(function() {
				selected_selfTest += "~" + $(this).next().text();
			});
		} else {
			$(".selected_selfTest:checked").each(function(i) {
				if(i == 0) {
					selected_selfTest += $(this).next().text();
				} else {
					selected_selfTest += "~" + $(this).next().text();
				}
			});
		}
		var sendTo_people = '';
		$(".sendTo_people:checked").each(function(i) {
			if(i == 0) {
				sendTo_people += $(this).next().text();
			} else {
				sendTo_people += "~" + $(this).next().text();
			}
		});
		var sending_way = '';
		$(".sending_way:checked").each(function(i) {
			if(i == 0) {
				sending_way += $(this).next().text();
			} else {
				sending_way += "~" + $(this).next().text();
			}
		});
		if(sendTo_people == '' || sending_way == '') {
			alert("请选择接收人或提醒方式");
		} else {
			var doctor_advice = $("#doctor_advice").text();
			var date = new Date();
			var seperator = "-";
			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			if(month < 10) {
				month = "0" + month;
			};
			var strDate = date.getDate();
			var currentdate = year + seperator + month + seperator + strDate;
			$.ajax({
				type: "post",
				dataType: "json",
				data: {
					"mid": mid,
					"doctorid": doctorId,
					"myknowledge": doctor_advice,
					"advicedate": currentdate,
					"sendingways": sending_way,
					"acceptedpeople": sendTo_people,
					"selftestdetails": selected_selfTest
				},
				url: address + "Reminder/insert.do",
				success: function(result) {
					alert("发送成功！")
				},
				error: function() {}
			});
		}
	}
}

function saveMyAdvice() {
	var doctor_advice = $("#doctor_advice").text();
	if(doctor_advice != '') {
		$.ajax({
			type: "post",
			dataType: "json",
			data: {
				"doctorid": doctorId,
				"myknowledge": doctor_advice
			},
			url: address + "myAdvice/insert.do",
			success: function(result) {
				alert("保存成功！")
			},
			error: function() {}
		});
	} else {
		alert("医嘱不能为空");
	}
}

function saveMyAdvice1() {
	var doctor_advice = $("#myModal1_textarea").val();
	if(doctor_advice != '') {
		$.ajax({
			type: "post",
			dataType: "json",
			data: {
				"doctorid": doctorId,
				"myknowledge": doctor_advice
			},
			url: address + "myAdvice/insert.do",
			success: function(result) {
				alert("保存成功！")
			},
			error: function() {}
		});
	} else {
		alert("医嘱不能为空");
	}
}

function choiceAdvice(e) {
	$("#myModal1_textarea").val($("#myModal1_textarea").val() + $(e).text().trim());
}
//改变鼠标形状
$(".advice-table1 tr td").mouseover(function() {
	$(this).css("cursor", "pointer");
});
//模糊查询医嘱库
var keyword = '';
$(".advice-table1 tr td").click(function() {
	keyword = $(this).text();
	getknowledge();
});

function searchKnowledge() {
	keyword = $("#search_keyword").val().trim();
	if(keyword == '') {
		alert("搜索关键字不能为空");
	} else {
		getknowledge();
	}
}

function getknowledge() {
	$.ajax({
		type: "post",
		dataType: "json",
		data: {
			"keyword": keyword
		},
		url: address + "knowledge/queryByKeyword.do",
		success: function(result) {
			var list = result.data;
			var tableStr = '';
			if(list.length != 0) {
				$.each(list, function(i) {
					tableStr += "<tr><td ondblclick='choiceAdvice(this)'>" + list[i] + "</td></tr>";
				});
				$(".advice-table2 tr").remove();
				$(".advice-table2").append(tableStr);
			} else {
				alert("暂无相关医嘱");
			}
		},
		error: function() {}
	});
}