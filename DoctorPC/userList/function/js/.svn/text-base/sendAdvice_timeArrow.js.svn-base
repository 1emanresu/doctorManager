/*@author luoyc*/
var mid = sessionStorage.getItem("mid");
var doctorId = sessionStorage.getItem("doctorid");
var eWeeks = 0;
var sWeeks = 0;
var seperator="-";
var address = sessionStorage.getItem("address");

$(function() {
	$.ajax({
		type: "post",
		url: address + "weekly/selectGravidaInfo.do",
		dataType: "json",
		async: true,
		data: {
			mids: mid
		},
		success: function(result) {
			var information = result.data;
			if(information != null) {
				createExpectBasic(information[0]);
			}
		},
	});
	$.ajax({
		type: "post",
		url: address + "gravidainfo/find.do",
		data: {
			mid: mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			getBaseMsg(e.data);	
		}
	});
});


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

//血糖
var chart1 = document.getElementById('echart1');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart1 = function() {
    chart1.style.width = 1080 / 2 - 20 + 'px';
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

var chart2 = document.getElementById('echart2');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart2 = function() {
    chart2.style.width = 1000 / 2 - 20 + 'px';
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
    chart3.style.width = 1000 / 2 - 20 + 'px';
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
    chart4.style.width = 1000 / 2 - 20 + 'px';
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
    chart5.style.width = 1000 / 2 - 20 + 'px';
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
    chart6.style.width = 1000 / 2 - 20 + 'px';
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
var chart15 = document.getElementById('echart15');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart15 = function() {
    chart15.style.width = 1000 / 2 - 20 + 'px';
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
        type: 'line',
        data: [77, 75, 78, 79, 73, 77, 76, 72, 81, 83]
    }]
};

// 使用刚指定的配置项和数据显示图表。
myChart15.setOption(option15);
//体重
var chart7 = document.getElementById('echart7');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart7 = function() {
    chart7.style.width = 1000 / 2 - 20 + 'px';
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
//血压
var chart9 = document.getElementById('echart9');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart9 = function() {
    chart9.style.width = 1000 / 2 - 20 + 'px';
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
var chart10 = document.getElementById('echart10');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart10 = function() {
    chart10.style.width = 1000 / 2 - 20 + 'px';
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
    chart11.style.width = 1000 / 2 - 20 + 'px';
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
var chart12 = document.getElementById('echart12');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart12 = function() {
    chart12.style.width = 1000 / 2 - 20 + 'px';
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
var chart13 = document.getElementById('echart13');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart13 = function() {
    chart13.style.width = 1000 / 2 - 20 + 'px';
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
var chart14 = document.getElementById('echart14');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart14 = function() {
    chart14.style.width = 1000 / 2 - 20 + 'px';
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
/*胎心监护 echarts画图 js */
var resultdata = "";
var chart16 = document.getElementById('echart16');
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizemyChart16 = function() {
    chart16.style.width = 1000 / 2 - 20 + 'px';
};
//设置容器高宽
resizemyChart16();
var myChart16 = echarts.init(chart16);
var app = {};
var autodata = [];
var autodata2 = [];
var dataflag = 1200;
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
for(var i = 61; i < dataflag; i++) {
    initxAxis.push(toTime(i));
}
var option16 = {
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
    series: [{
            name: '胎心',
            type: 'line',
            data: [142, 143, 141, 143, 142, 144, 142, 143, 142, 143,
                142, 142, 142, 140, 142, 142, 144, 143, 144, 142,
                142, 142, 142, 140, 140, 139, 141, 139, 142, 143,
                144, 142, 142, 142, 142, 143, 144, 142, 143, 143,
                142, 142, 142, 140, 142, 142, 144, 143, 144, 142,
                144, 144, 145, 144, 145, 143, 145, 145, 145, 145,
                142, 142, 142, 140, 142, 142, 144, 143, 144, 142,
                141, 141, 141, 141, 143, 142, 142, 140, 141, 141,
                141, 141, 143, 142, 142, 142, 144, 143, 145, 143,
                144, 144, 145, 144, 145, 143, 145, 145, 145, 145,
                142, 144, 145, 144, 145, 146, 145, 145, 144, 146,
                148, 148, 146, 146, 148, 146, 148, 147, 148, 148,
                147, 147, 148, 148, 148, 146, 146, 145, 145, 146,
                145, 144, 145, 143, 142, 143, 145, 142, 143, 144,
                142, 143, 145, 146, 144, 143, 145, 146, 144, 145,
                146, 146, 149, 148, 148, 146, 148, 147, 147, 145,
                145, 145, 147, 147, 147, 147, 147, 147, 148, 147,
                148, 147, 148, 147, 148, 147, 149, 149, 151, 149,
                150, 148, 150, 150, 150, 148, 148, 148, 147, 148,
                148, 146, 147, 145, 145, 145, 146, 144, 146, 145,
                148, 144, 145, 144, 145, 146, 145, 145, 144, 146,
                148, 148, 147, 149, 150, 150, 150, 149, 149, 149,
                149, 148, 150, 149, 151, 149, 149, 147, 147, 147,
                149, 148, 150, 150, 152, 150, 151, 151, 151, 150,
                151, 149, 149, 147, 148, 148, 149, 147, 149, 148,
                149, 148, 150, 150, 152, 152, 153, 151, 153, 151,
                151, 149, 150, 148, 149, 149, 150, 150, 152, 151,
                153, 152, 154, 154, 154, 153, 154, 153, 153, 153,
                153, 152, 154, 154, 154, 153, 155, 155, 155, 154,
                154, 153, 154, 152, 154, 152, 152, 151, 153, 152,
                152, 150, 150, 149, 149, 149, 150, 148, 149, 148,
                149, 147, 147, 146, 148, 146, 148, 146, 147, 147,
                148, 147, 149, 147, 148, 148, 149, 147, 147, 146,
                147, 147, 148, 148, 148, 146, 146, 145, 145, 146,
                145, 147, 147, 147, 146, 148, 148, 149, 149, 149,
                150, 151, 150, 152, 152, 153, 153, 152, 154, 154,
                155, 155, 154, 156, 155, 156, 154, 157, 154, 157,
                156, 154, 158, 154, 155, 157, 156, 157, 158, 158,
                158, 161, 159, 160, 160, 161, 160, 162, 163, 164,
                164, 165, 165, 165, 166, 166, 165, 166, 168, 166,
                167, 166, 167, 166, 165, 165, 165, 165, 164, 163,
                160, 164, 161, 162, 160, 161, 158, 158, 159, 157,
                157, 156, 158, 157, 159, 158, 157, 157, 156, 155,
                155, 154, 156, 156, 156, 153, 153, 153, 152, 152,
                152, 151, 150, 150, 148, 148, 147, 145, 145, 142,
                143, 143, 144, 142, 143, 142, 144, 143, 145, 143,
                145, 144, 145, 143, 144, 145, 144, 146, 145, 144,
                145, 146, 147, 148, 145, 146, 144, 146, 145, 145,
                144, 143, 144, 144, 143, 142, 142, 143, 144, 143,
                145, 144, 142, 143, 143, 142, 141, 140, 141, 140,
                140, 141, 140, 142, 140, 142, 141, 143, 143, 141,
                142, 142, 143, 142, 143, 143, 142, 142, 142, 142,
                143, 141, 141, 142, 141, 141, 140, 140, 140, 144,
                142, 142, 142, 141, 141, 141, 142, 141, 142, 143,
                143, 144, 145, 145, 145, 146, 146, 145, 145, 146,
                144, 147, 148, 147, 149, 147, 148, 149, 150, 149,
                150, 149, 148, 148, 149, 149, 149, 149, 150, 150,
                150, 149, 151, 149, 149, 150, 149, 149, 151, 150,
                150, 149, 152, 151, 150, 152, 152, 151, 152, 150,
                150, 149, 149, 148, 149, 148, 147, 148, 150, 149,
                148, 148, 147, 146, 147, 148, 148, 147, 147, 145,
                145, 146, 145, 144, 144, 142, 143, 141, 142, 142,
                142, 142, 142, 142, 143, 142, 142, 140, 140, 140,
                142, 142, 142, 142, 143, 142, 142, 140, 140, 140,
                142, 141, 142, 141, 142, 142, 143, 143, 144, 142,
                142, 142, 142, 142, 143, 142, 142, 140, 140, 140,
                140, 138, 139, 139, 141, 139, 139, 138, 140, 140,
                141, 141, 142, 141, 141, 141, 142, 142, 142, 140,
                142, 141, 141, 140, 142, 140, 141, 141, 143, 142,
                144, 142, 142, 142, 142, 140, 140, 138, 138, 137,
                138, 137, 139, 139, 139, 138, 140, 139, 139, 138,
                139, 138, 138, 136, 137, 136, 137, 137, 137, 135,
                137, 137, 138, 137, 138, 138, 139, 138, 139, 138,
                139, 137, 138, 137, 137, 135, 137, 136, 137, 137,
                139, 138, 139, 139, 140, 140, 141, 139, 140, 140,
                142, 140, 142, 142, 143, 141, 141, 140, 140, 140,
                140, 139, 140, 138, 138, 137, 137, 137, 138, 138,
                139, 138, 138, 137, 138, 138, 138, 137, 139, 139,
                139, 138, 138, 138, 139, 137, 139, 138, 139, 139,
                141, 139, 139, 137, 138, 140, 139, 137, 138, 138,
                138, 138, 138, 140, 139, 139, 138, 140, 140, 140,
                142, 143, 142, 141, 140, 138, 139, 140, 142, 139,
                140, 139, 140, 140, 140, 141, 141, 142, 143, 144,
                143, 142, 145, 143, 143, 144, 143, 143, 144, 143,
                143, 144, 146, 145, 143, 142, 143, 141, 142, 143,
                142, 141, 142, 144, 143, 142, 143, 143, 142, 143,
                143, 143, 144, 143, 143, 142, 142, 140, 141, 140,
                142, 143, 142, 143, 142, 142, 144, 143, 144, 142,
                142, 142, 142, 140, 140, 139, 141, 139, 142, 143,
                143, 140, 139, 142, 142, 140, 141, 140, 141, 143,
                140, 139, 140, 140, 140, 141, 141, 142, 142, 142,
                140, 138, 138, 138, 139, 137, 139, 138, 139, 139,
                140, 140, 141, 141, 139, 139, 140, 141, 139, 138,
                140, 139, 140, 138, 138, 139, 139, 139, 140, 140,
                142, 142, 142, 140, 140, 139, 141, 139, 142, 143,
                144, 142, 142, 142, 142, 143, 144, 142, 143, 143,
                142, 142, 142, 140, 142, 142, 144, 143, 144, 142,
                140, 141, 142, 140, 140, 141, 140, 139, 139, 140,
                141, 140, 139, 137, 138, 137, 139, 137, 140, 138,
                140, 140, 141, 142, 142, 143, 141, 142, 142, 143,
                142, 142, 142, 140, 142, 142, 144, 143, 144, 142,
                142, 140, 142, 142, 143, 141, 141, 140, 140, 140,
                140, 139, 140, 138, 138, 137, 137, 137, 138, 138,
                138, 140, 138, 138, 140, 139, 138, 139, 139, 138,
                138, 138, 138, 140, 139, 139, 138, 140, 140, 140,
                141, 139, 139, 138, 138, 139, 137, 138, 137, 137,
                139, 138, 138, 137, 138, 137, 137, 138, 137, 137,
                138, 138, 138, 137, 138, 136, 137, 137, 137, 139,
                139, 138, 138, 137, 137, 138, 137, 138, 139, 138,
                140, 138, 140, 139, 141, 140, 142, 140, 142, 141,
                142, 140, 142, 142, 143, 143, 142, 142, 141, 140,
                139, 140, 138, 140, 139, 137, 139, 138, 139, 138,
                140, 141, 142, 140, 140, 141, 140, 139, 139, 140,
                142, 142, 143, 141, 142, 141, 141, 141, 141, 141,
                142, 143, 143, 141, 142, 143, 143, 143, 142, 142,
                141, 139, 140, 140, 140, 139, 141, 140, 141, 141,
                143, 143, 143, 141, 142, 141, 142, 141, 142, 140,
                140, 140, 140, 140, 142, 140, 142, 142, 144, 144,
                144, 144, 145, 144, 145, 143, 143, 143, 144, 142,
                144, 143, 145, 145, 146, 145, 146, 145, 145, 144
            ],
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
            data: [7, 7, 9, 7, 8, 7, 7, 9, 5, 5, 8, 5, 6, 9, 7, 7, 6, 6, 5, 8, 6, 5, 5, 8, 9, 9, 9, 8, 9, 8, 5, 6, 5, 9, 9, 7, 6, 6, 9, 5, 7, 8, 9, 9, 5, 6, 8, 7, 7, 8, 9, 5, 6, 8, 7, 9, 5, 7, 7, 7, 9, 8, 6, 5, 7, 7, 6, 8, 9, 8, 9, 8, 9, 5, 5, 8, 9, 6, 8, 9, 8, 7, 5, 7, 6, 8, 8, 8, 8, 6, 6, 7, 8, 6, 9, 5, 7, 6, 5, 7, 6, 7, 8, 6, 6, 9, 8, 8, 5, 5, 9, 9, 8, 9, 5, 7, 5, 7, 6, 9, 7, 9, 8, 8, 6, 8, 7, 9, 8, 6, 5, 5, 7, 5, 7, 9, 7, 5, 7, 7, 5, 6, 5, 8, 5, 7, 9, 9, 9, 7, 7, 7, 8, 9, 9, 9, 9, 6, 7, 6, 6, 8, 8, 6, 7, 8, 5, 6, 6, 5, 6, 8, 8, 6, 5, 7, 9, 9, 8, 5, 5, 6, 6, 7, 8, 9, 5, 5, 7, 5, 8, 9, 5, 8, 8, 9, 9, 8, 5, 6, 7, 9, 9, 7, 5, 5, 7, 9, 6, 8, 8, 6, 5, 9, 6, 6, 6, 6, 8, 8, 9, 6, 5, 6, 6, 8, 5, 6, 6, 6, 8, 8, 7, 5, 5, 5, 9, 9, 9, 8, 6, 6, 9, 6, 7, 7, 7, 7, 6, 7, 6, 8, 8, 9, 8, 9, 6, 6, 7, 6, 5, 5, 8, 6, 7, 7, 8, 6, 7, 7, 9, 5, 7, 7, 8, 6, 6, 5, 6, 8, 7, 6, 9, 9, 8, 8, 8, 7, 7, 8, 6, 5, 5, 8, 7, 5, 9, 6, 7, 6, 5, 8, 11, 14, 18, 20, 21, 25, 27, 28, 29, 31, 32, 35, 36, 38, 40, 42, 44, 45, 46, 48, 50, 51, 53, 54, 55, 56, 57, 59, 60, 61, 62, 64, 65, 66, 67, 69, 70, 71, 71, 72, 74, 75, 76, 77, 79, 80, 82, 82, 83, 85, 85, 86, 87, 88, 89, 90, 91, 92, 93, 93, 95, 96, 97, 98, 100, 100, 100, 100, 100, 100, 100, 99, 98, 98, 97, 96, 94, 90, 91, 91, 91, 87, 87, 87, 86, 84, 82, 80, 79, 80, 81, 79, 79, 78, 73, 73, 72, 71, 69, 71, 68, 69, 69, 67, 64, 65, 65, 62, 62, 62, 58, 60, 57, 58, 54, 55, 55, 53, 51, 51, 49, 49, 47, 46, 44, 42, 43, 43, 41, 38, 38, 38, 35, 38, 37, 35, 34, 34, 29, 29, 29, 26, 27, 27, 24, 23, 21, 24, 19, 21, 20, 19, 17, 16, 17, 13, 13, 14, 12, 9, 9, 10, 7, 5, 7, 5, 1, 2, 3, 2, 8, 8, 7, 6, 5, 5, 8, 6, 6, 5, 5, 6, 6, 7, 8, 7, 8, 6, 6, 8, 5, 6, 7, 7, 9, 6, 5, 8, 8, 9, 8, 7, 8, 6, 8, 9, 9, 9, 5, 8, 9, 7, 7, 7, 7, 9, 7, 9, 8, 6, 6, 6, 5, 8, 7, 9, 5, 7, 9, 5, 7, 6, 6, 8, 8, 9, 6, 6, 9, 9, 8, 6, 5, 6, 9, 8, 9, 9, 9, 9, 5, 5, 8, 7, 9, 5, 8, 5, 5, 9, 9, 5, 7, 9, 6, 7, 8, 6, 9, 8, 7, 9, 6, 9, 7, 7, 8, 8, 5, 9, 7, 9, 5, 5, 6, 9, 9, 6, 8, 6, 8, 9, 5, 8, 6, 8, 6, 5, 8, 5, 5, 5, 6, 6, 5, 5, 7, 9, 9, 5, 9, 9, 7, 7, 7, 5, 5, 6, 9, 9, 7, 8, 8, 7, 5, 5, 7, 8, 6, 5, 7, 6, 8, 5, 8, 6, 9, 5, 6, 7, 6, 9, 5, 8, 9, 8, 7, 8, 7, 9, 7, 7, 7, 7, 8, 9, 8, 7, 9, 5, 9, 6, 7, 9, 8, 8, 8, 6, 9, 7, 8, 6, 8, 5, 6, 5, 9, 8, 5, 5, 8, 9, 8, 9, 6, 7, 8, 7, 5, 5, 8, 8, 5, 7, 5, 6, 8, 6, 6, 9, 5, 9, 9, 6, 9, 7, 5, 5, 7, 8, 5, 7, 6, 8, 9, 5, 8, 7, 8, 9, 9, 5, 6, 7, 6, 6, 9, 9, 8, 5, 6, 5, 7, 7, 7, 9, 5, 6, 8, 5, 8, 8, 8, 9, 5, 6, 7, 9, 7, 6, 9, 8, 7, 7, 8, 7, 6, 7, 5, 8, 5, 9, 8, 8, 7, 9, 7, 8, 5, 8, 9, 8, 11, 10, 10, 13, 12, 12, 17, 17, 18, 17, 18, 19, 22, 23, 23, 25, 27, 28, 25, 29, 31, 28, 30, 30, 35, 33, 34, 36, 38, 40, 37, 41, 40, 41, 45, 46, 45, 48, 49, 48, 48, 49, 49, 52, 51, 54, 53, 54, 55, 59, 58, 62, 63, 63, 64, 63, 64, 65, 68, 67, 67, 69, 73, 70, 75, 72, 77, 77, 76, 77, 80, 79, 82, 82, 84, 82, 86, 87, 88, 90, 87, 91, 90, 93, 92, 94, 97, 95, 96, 96, 100, 100, 99, 100, 100, 100, 100, 100, 92, 91, 93, 91, 87, 86, 85, 86, 83, 83, 83, 82, 81, 79, 79, 76, 79, 76, 75, 76, 74, 72, 69, 70, 70, 67, 65, 65, 66, 64, 65, 60, 63, 62, 60, 56, 58, 58, 57, 52, 51, 51, 52, 50, 51, 46, 46, 48, 43, 45, 42, 40, 39, 42, 41, 39, 37, 37, 34, 35, 33, 34, 31, 29, 28, 26, 25, 24, 24, 25, 21, 24, 23, 20, 21, 19, 16, 16, 17, 16, 15, 13, 12, 10, 7, 6, 6, 7, 3, 6, 6, 8, 7, 5, 6, 5, 8, 9, 9, 8, 5, 8, 9, 8, 5, 5, 5, 9, 5, 7, 7, 8, 5, 7, 8, 5, 7, 5, 9, 7, 5, 7, 7, 9, 7, 8, 5, 5, 6, 6, 8, 9, 8, 7, 6, 8, 7, 7, 9, 5, 7, 7, 5, 7, 8, 9, 8, 6, 5, 6, 5, 6, 6, 5, 7, 5, 8, 5, 8, 9, 9, 8, 5, 5, 6, 9, 6, 7, 6, 9, 7, 5, 7, 9, 9, 5, 7, 9, 9, 9, 9, 8, 5, 8, 7, 9, 8, 6, 9, 9, 9, 9, 8, 8, 6, 9, 6, 7, 9, 8, 5, 8, 9, 7, 9, 8, 9, 8, 6, 9, 9, 7, 5, 9, 5, 9, 7, 8, 7, 9, 7, 6, 6, 9, 9, 6, 5, 7, 6, 7, 6, 6, 7, 8, 7, 5, 9, 5, 6, 6, 8, 5, 8, 6, 8, 7, 6, 6, 5, 6, 6, 6, 9, 6, 7, 8, 6, 9, 9, 9, 7, 7, 5, 9, 9, 8, 5, 6, 9, 8, 8, 5, 8, 8, 6, 8, 9, 6, 9, 5, 9, 7, 9, 7, 5, 8, 9, 7, 9, 5, 6, 6, 9, 5, 7, 8, 7, 6, 7, 6, 6, 7, 6, 6, 5, 9, 9, 5, 8, 8, 5, 6, 8, 5, 6, 8, 7, 7, 5, 9, 5, 5, 8, 7, 6, 5, 5, 6, 5, 8, 7, 9, 7, 8, 5, 5, 6, 8, 6, 7, 9, 9, 9, 9, 7, 7, 5, 9, 9, 6, 8, 9, 8, 6, 7, 7, 5, 7, 7, 6, 9, 5, 8, 6, 6, 8, 8, 6, 6, 5, 9, 9, 8, 5, 7, 7, 6, 6, 6, 7, 8, 6, 6, 9, 8, 8, 8, 8, 6]
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
function bloodsugreSetDate() {
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
    var sWeeks = sessionStorage.getItem("sWeeks");
    var eWeeks = sessionStorage.getItem("eWeeks");
    $.ajax({
        type: "post",
        url: address + "bloodsugre/findByWeekly.do",
        data: {
            "mid": mid,
            "eWeeks": eWeeks,
            "sWeeks": sWeeks
        },
        dataType: "json",
        ContentType: "application/x-www-form-urlencoded;charset=utf-8",
        success: function(e) {
            var list = e.data;
            if(list.length != 0) {
                $(".bloodsugar-tab-pane").show();
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
            }
        },
        error: function() {

        }
    });
}

function bloodpressureSetDate() {
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
            "eWeeks": eWeeks,
            "sWeeks": sWeeks
        },
        dataType: "json",
        ContentType: "application/x-www-form-urlencoded;charset=utf-8",
        success: function(e) {
            var list = e.data;
            if(list.length != 0) {
                $(".bloodpressure-tab-pane").show();
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
            }
        },
        error: function() {

        }
    });
}

function weightSetDate() {
    var sWeeks = sessionStorage.getItem("sWeeks");
    var eWeeks = sessionStorage.getItem("eWeeks");
    var weightlist = [];
    var weightoringinlist = [];
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
            weightoringinlist = e.data[3];
            var height = e.data[4];
            if(datelist2.length != 0) {
                $(".weight-tab-pane").show();
                var index5 = 0;
                var index6 = 0;
                for(var i = 0; i < datelist2.length; i++) {
                    BMIlist.push((weightlist[i] / height / height * 10000).toFixed(1));
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
            }
        },
        error: function() {

        }
    });
}

function ecgSetDate() {
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
            if(list.length != 0) {
                $(".electrocardio-tab-pane").show();
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
                    table += "<tr class='trForElectrocardio'><td>" + currentdate + "</td><td>" + list[i].hearrate + "</td><td>" + list[i].qtinterval + "</td><td>" + list[i].pdispersion + "</td><td>" + list[i].qtcinterval + "</td><td>" + list[i].qdispersion + "</td><td>" + list[i].qrsduration + "</td><td>" + list[i].stsegment + "</td><td>" + list[i].rwaveamplitude + "</td><td></td></tr>";
                });
                $(".trForElectrocardio").remove();
                $("#electrocardio_table").append(table);
            }
        },
        error: function() {

        }
    });
}

function temperatureSetDate() {
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
            if(list.length != 0) {
                $(".temperature-tab-pane").show();
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
            }
        },
        error: function() {

        }
    });
}

function bloodfatSetDate() {
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
            if(list.length != 0) {
                $(".bloodfat-tab-pane").show();
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
            }
        },
        error: function() {}
    });
}

function abdominalgirthSetDate() {
    //腹围
    var sWeeks = sessionStorage.getItem("sWeeks");
    var eWeeks = sessionStorage.getItem("eWeeks");
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
                $(".abdominalCircumference-tab-pane").show();
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
            }
        },
        error: function() {

        }
    });
}

function fundalheightSetDate() {
    //宫高
    var sWeeks = sessionStorage.getItem("sWeeks");
    var eWeeks = sessionStorage.getItem("eWeeks");
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
                $(".fundalHeight-tab-pane").show();
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
            }
        },
        error: function() {

        }
    });
}

function bloodoxygenSetDate() {
    //血氧
    var sWeeks = sessionStorage.getItem("sWeeks");
    var eWeeks = sessionStorage.getItem("eWeeks");
    var datelist11 = [];
    var bloodoxygenlist = [];
    var heartratelist2 = [];
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
            if(list.length != 0) {
                $(".bloodoxygen-tab-pane").show();
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
            }
        },
        error: function() {

        }
    });
}

function featalMovementSetDate() {
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
            if(list.length != 0) {
                $(".fetalMovement-tab-pane").show();
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
                    if(i == list.length - 1) {
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
            }
        },
        error: function() {

        }
    });
}

function editDoctorActive() {
    $("#edit_doctor_advice").click();
}

function myriskModalSetDate() {
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
            var abnormityStr = '';
            var referencevalue = '';
            $.each(list, function(i) {
                scoreSum += Number(list[i].score);
                if(list[i].cunit == '' || list[i].cunit == null) {
                    unit = ''
                } else {
                    unit = list[i].cunit;
                }
                standardStr += (i + 1) + '.' + list[i].cname + '≥' + (Number(list[i].cend) + Number(list[i].difference)) + unit + '或≤' + (accSub(Number(list[i].cbegin), Number(list[i].difference))) + unit + '<br/>';
                riskStr += (i + 1) + '.' + list[i].cname + '≥' + (Number(list[i].cend) + Number(list[i].difference)) + unit + '或≤' + (accSub(Number(list[i].cbegin), Number(list[i].difference))) + unit + '  ' + '高危分值' + list[i].score + '分' + '\n';
                if(list[i].knowledge != undefined) {
                    doctorAdviceStr += list[i].knowledge;
                }
                if(list[i].referencevalue != null) {
                    referencevalue = list[i].referencevalue;
                } else {
                    referencevalue = '';
                }
                if(i == 0) {
                    abnormityStr += "<thead><td>名称</td><td>结果</td><td>参考值</td></thead><tbody id='tbody_abnormity'><tr><td>" + list[i].cname + "</td><td>" + list[i].abnormity + "</td><td>" + referencevalue + "</td></tr>";
                } else {
                    abnormityStr += "<tr><td>" + list[i].cname + "</td><td>" + list[i].abnormity + "</td><td>" + referencevalue + "</td></tr>";
                }
                if(i == list.length - 1) {
                    abnormityStr += "</tbody>";
                }
            });
            if(list.length < 6) {
                for(i = 0; i < 6 - list.length; i++) {
                    standardStr += " " + '<br/>';
                }
            }
            //罗盘赋值
            var hrisklevel = '正常';
            if(scoreSum == 0) {

            } else if(scoreSum <= 5) {
                hrisklevel = "轻度高危";
            } else if(scoreSum <= 10) {
                hrisklevel = "中度高危";
            } else if(scoreSum <= 15) {
                hrisklevel = "高度高危";
            } else {
                hrisklevel = "极度高危";
            }
            //判断标准说明赋值
            if(doctorAdviceStr.trim() == '') {
                doctorAdviceStr = '暂无';
            }
            if(riskStr.trim() == "") {
                riskStr = "暂无";
            }
            if(list.length == 0) {
                abnormityStr = "暂无";
            }
            $("#standard_middle").html(standardStr);
            $("#risk_factor").html(riskStr);
            $("#risk_factor2").html(riskStr);
            $("#risk_score_for_basic").text(scoreSum);
            $("#risk_factor").css("color", 'red');
            $("#doctor_advice").html(doctorAdviceStr);
            $("#risk_leave").text(hrisklevel);

            $("#table_abnormal_detail").html(abnormityStr);
            //添加点击事件
        },
        error: function() {

        }
    });
}
var spanIndex = 0;
//所有已经做了的检查项目
function checkProjectDone() {
    var sWeeks = sessionStorage.getItem("sWeeks");
    var eWeeks = sessionStorage.getItem("eWeeks");
    $.ajax({
        type: "post",
        url: address + "checkResult/queryResultByDateRange.do",
        data: {
            "mid": mid,
            "sWeeks": sWeeks,
            "eWeeks": eWeeks
        },
        dataType: "json",
        ContentType: "application/x-www-form-urlencoded;charset=utf-8",
        success: function(e) {
            var list = e.data;
            //已做项目数组
            var doneList = [];
            var expecialCheckStr = '';
            var spanCount = Math.ceil(list.length / 4);
            spanIndex = 0;
            var checkDate;
            var checkDetailList = [];
            $.each(list, function(i) {
                var reportName = list[i].checkProject.riskname;
                doneList.push(reportName);
                checkDetailList = list[i].checkDetailList;
                if(i % 4 == 0) {
                    spanIndex++;
                    expecialCheckStr += "<span id='reportSpan" + spanIndex + "' class='check-table-span2'>"
                }
                expecialCheckStr += "<div class='class_firstDiagnose_bloodRule_content'>" +
                    "<div class='class_firstDiagnose_bloodRule_title_info'>" +
                    reportName + "</div>" +
                    "<div class='class_firstDiagnose_table_container'>" +
                    "<table>" +
                    "<tr class='tr_firstDiagnose_width tr_firstDiagnose_color'>" +
                    "<td>名称</td><td>结果</td><td>单位</td><td>参考值</td></tr>";
                $.each(checkDetailList, function(j) {
                    if(j == 8) {
                        return false;
                    }
                    var checkresult = '';
                    if(checkDetailList[j].checkvalue != null) {
                        checkresult = checkDetailList[j].checkvalue;
                    } else if(checkDetailList[j].description != null) {
                        checkresult = checkDetailList[j].description;
                    }
                    var unit = '';
                    if(checkDetailList[j].checkindex.cunit != null) {
                        unit = checkDetailList[j].checkindex.cunit
                    }
                    var referencevalue = '';
                    if(checkDetailList[j].checkindex.referencevalue != null) {
                        referencevalue = checkDetailList[j].checkindex.referencevalue;
                    }
                    expecialCheckStr += "<tr class='tr_firstDiagnose_width'><td>" +
                        checkDetailList[j].checkindex.cname +
                        "</td><td>" +
                        checkresult +
                        "</td><td>" +
                        unit +
                        "</td><td>" +
                        referencevalue +
                        "</td></tr>";
                });
                var src = '';
                if(list[i].picLink != null && list[i].picLink.trim() != '') {
                    src = list[i].picLink;
                }
                expecialCheckStr += "<tr class='tr_firstDiagnose_width'><td></td><td></td><td></td><td>" +
                    "<a style='cursor:pointer;' onclick='seeOriginalReport(\"" +
                    src +
                    "\")'>查看原始报告单</a>" +
                    "</td></tr></table></div></div>";
                if(i % 2 == 1) {
                    expecialCheckStr += "<div style='height:10px; clear: both;width:100%;'></div>"
                }
                if(i % 4 == 3) {
                    expecialCheckStr += "</span>";
                }

                if(i == list.length - 1) {
                    if(list[i].checkdate != null) {
                        checkDate = new Date(list[i].checkdate);
                        var year = checkDate.getFullYear();
                        var month = checkDate.getMonth() + 1;
                        if(month < 10) {
                            month = "0" + month;
                        };
                        var strDate = checkDate.getDate();
                        if(strDate < 10) {
                            strDate = "0" + strDate;
                        }
                        checkDate = year + '-' + month + '-' + strDate;
                    } else {
                        checkDate = '暂无';
                    }
                    if(i % 4 != 3) {
                        expecialCheckStr += "</span>";
                    }
                }

            });
            $("#checkProjectHaveDone").html(expecialCheckStr);
            if(list.length > 4) {
                var pageSize = Number(list.length / 4).toFixed(0);
                $("#checkProjectChange").show();
                $(".check-table-span2").hide();
                $("#reportSpan1").show();
                var checkProjectChangeIndex = 1;
                $("#checkProjectChange").click(function() {
                    if(checkProjectChangeIndex == pageSize) {
                        checkProjectChangeIndex = 0;
                    }
                    checkProjectChangeIndex++;
                    for(var k = 1; k < spanCount + 1; k++) {
                        if(checkProjectChangeIndex == k) {
                            $(".check-table-span2").hide();
                            $("#reportSpan" + k).show();
                        }
                    }
                });
            }
            if(list.length == 0) {
                $(".no-anyProject").show();
            }
            //去重复
            for(var i = 0; i < doneList.length - 1; i++) {
                for(var j = doneList.length - 1; j > i; j--) {
                    if(doneList[j] == doneList[i]) {
                        doneList.splice(j, 1);
                    }
                }
            }
            if(doneList.length == 0) {
                $("#cehckName").text("暂无")
            } else {
                $("#cehckName").text(doneList);
            }
            if(list.length == 0) {
                checkDate = '暂无';
            }
            $("#cehcDate").text(checkDate);
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

/*author luoyc*/
var index = 0;
var bloodsugarIndex = 0;
var weightIndex = true;
var secondCheckIndex = true;

function modalForWeekly(i) {
    bloodsugarIndex = 0;
    weightIndex = true;
    secondCheckIndex = true;
    //每次进入先还原
    $("#main-information").click();
    //先将所有的echarts选项卡隐藏
    $(".self-test").hide();
    //将所有的报告item隐藏
    $(".reportItem").removeClass("item");
    $(".reportItem").css("display", "none");
    //多个Echart图表页面切换还原
    $("#bloodsugarEchart2").hide();
    $("#bloodsugarEchart1").show();
    $("#bloodsugarEchart3").hide();
    $("#weightEcharts2").hide();
    $("#weightEcharts1").show();
    $("#checkProjectChange").hide();
    $(".no-anyProject").hide();
    index = i;
    if(index == 1) {
        sessionStorage.setItem("eWeeks", 5);
        sessionStorage.setItem("sWeeks", 0);
        //风险模型及摘要
        myriskModalSetDate();
        //echart
        bloodsugreSetDate();
        bloodpressureSetDate();
        weightSetDate();
        featalMovementSetDate();
        abdominalgirthSetDate();
        fundalheightSetDate();
        ecgSetDate();
        temperatureSetDate();
        bloodfatSetDate();
        bloodoxygenSetDate();
        //已做检查项目
        checkProjectDone();
        //主诉症状
        symptom();
        //报告item
        $("#bloodRutineItem").attr("class", "item reportItem");
        $("#bloodTypeItem").attr("class", "item reportItem");
        $("#urineRutine").attr("class", "item reportItem");
        $("#liverAndKidneyItem").attr("class", "item reportItem");
        $("#bloodRutineItem").css("display", "");
        $("#bloodTypeItem").css("display", "");
        $("#urineRutine").css("display", "");
        $("#liverAndKidneyItem").css("display", "");
    } else if(index == 2) {
        sessionStorage.setItem("eWeeks", 13);
        sessionStorage.setItem("sWeeks", 5);
        //风险模型及摘要
        myriskModalSetDate();
        //echart
        bloodsugreSetDate();
        bloodpressureSetDate();
        weightSetDate();
        featalMovementSetDate();
        abdominalgirthSetDate();
        fundalheightSetDate();
        ecgSetDate();
        temperatureSetDate();
        bloodoxygenSetDate();
        bloodfatSetDate();
        //已做检查项目
        checkProjectDone();
        //主诉症状
        symptom();
        //报告item
        $("#bloodRutineItem").attr("class", "item reportItem");
        $("#bloodTypeItem").attr("class", "item reportItem");
        $("#urineRutine").attr("class", "item reportItem");
        $("#liverAndKidneyItem").attr("class", "item reportItem");
        $("#HIVItem").attr("class", "item reportItem");
        $("#GDMItem").attr("class", "item reportItem");
        $("#bloodRutineItem").css("display", "");
        $("#bloodTypeItem").css("display", "");
        $("#urineRutine").css("display", "");
        $("#liverAndKidneyItem").css("display", "");
        $("#HIVItem").css("display", "");
        $("#GDMItem").css("display", "");
    } else if(index == 3) {
        sessionStorage.setItem("eWeeks", 20);
        sessionStorage.setItem("sWeeks", 13);
        //风险模型及摘要
        myriskModalSetDate();
        //echart
        bloodsugreSetDate();
        bloodpressureSetDate();
        weightSetDate();
        featalMovementSetDate();
        abdominalgirthSetDate();
        fundalheightSetDate();
        ecgSetDate();
        temperatureSetDate();
        bloodfatSetDate();
        bloodoxygenSetDate();
        //已做检查项目
        checkProjectDone();
        //主诉症状
        symptom();
    } else if(index == 4) {
        sessionStorage.setItem("eWeeks", 24);
        sessionStorage.setItem("sWeeks", 20);
        //风险模型及摘要
        myriskModalSetDate();
        //echart
        bloodsugreSetDate();
        bloodpressureSetDate();
        weightSetDate();
        featalMovementSetDate();
        abdominalgirthSetDate();
        fundalheightSetDate();
        ecgSetDate();
        temperatureSetDate();
        bloodfatSetDate();
        //已做检查项目
        checkProjectDone();
        //主诉症状
        symptom();
        //报告item
        $("#bloodRutineItem").attr("class", "item reportItem");
        $("#urineRutine").attr("class", "item reportItem");
        $("#BscanItem").attr("class", "item reportItem");
        $("#bloodRutineItem").css("display", "");
        $("#urineRutine").css("display", "");
        $("#BscanItem").css("display", "");
    } else if(index == 5) {
        sessionStorage.setItem("eWeeks", 28);
        sessionStorage.setItem("sWeeks", 24);
        //风险模型及摘要
        myriskModalSetDate();
        //echart
        bloodsugreSetDate();
        bloodpressureSetDate();
        weightSetDate();
        featalMovementSetDate();
        abdominalgirthSetDate();
        fundalheightSetDate();
        ecgSetDate();
        temperatureSetDate();
        bloodfatSetDate();
        bloodoxygenSetDate();
        //已做检查项目
        checkProjectDone();
        //主诉症状
        symptom();
        //报告item
        $("#GDMItem").attr("class", "item reportItem");
        $("#urineRutine").attr("class", "item reportItem");
        $("#NIPTItem").attr("class", "item reportItem");
        $("#GDMItem").css("display", "");
        $("#urineRutine").css("display", "");
        $("#NIPTItem").css("display", "");
    } else if(index == 6) {
        sessionStorage.setItem("eWeeks", 32);
        sessionStorage.setItem("sWeeks", 28);
        //风险模型及摘要
        myriskModalSetDate();
        //echart
        bloodsugreSetDate();
        bloodpressureSetDate();
        weightSetDate();
        featalMovementSetDate();
        abdominalgirthSetDate();
        fundalheightSetDate();
        ecgSetDate();
        temperatureSetDate();
        bloodfatSetDate();
        bloodoxygenSetDate();
        //已做检查项目
        checkProjectDone();
        //主诉症状
        symptom();
        //报告item
        $("#bloodRutineItem").attr("class", "item reportItem");
        $("#urineRutine").attr("class", "item reportItem");
        $("#BscanItem").attr("class", "item reportItem");
        $("#bloodRutineItem").css("display", "");
        $("#urineRutine").css("display", "");
        $("#BscanItem").css("display", "");

    } else if(index == 7) {
        sessionStorage.setItem("eWeeks", 36);
        sessionStorage.setItem("sWeeks", 32);
        //风险模型及摘要
        myriskModalSetDate();
        //echart
        bloodsugreSetDate();
        bloodpressureSetDate();
        weightSetDate();
        featalMovementSetDate();
        abdominalgirthSetDate();
        fundalheightSetDate();
        ecgSetDate();
        temperatureSetDate();
        bloodfatSetDate();
        bloodoxygenSetDate();
        //已做检查项目
        checkProjectDone();
        //主诉症状
        symptom();
        //报告item
        $("#BscanItem").attr("class", "item reportItem");
        $("#BscanItem").css("display", "");
    } else if(index == 8) {
        sessionStorage.setItem("eWeeks", 41);
        sessionStorage.setItem("sWeeks", 36);
        //风险模型及摘要
        myriskModalSetDate();
        //echart
        bloodsugreSetDate();
        bloodpressureSetDate();
        weightSetDate();
        featalMovementSetDate();
        abdominalgirthSetDate();
        fundalheightSetDate();
        ecgSetDate();
        temperatureSetDate();
        bloodfatSetDate();
        bloodoxygenSetDate();
        //已做检查项目
        checkProjectDone();
        //主诉症状
        symptom();
        //报告item
        $("#featalHeartItem").attr("class", "item reportItem");
        $("#featalHeartItem").css("display", "");
        $("#BscanItem").attr("class", "item reportItem");
        $("#BscanItem").css("display", "");
    }
    $('#modal_for_weekly').show();
}

$("#bloodsugarEchart2").hide();
$("#bloodsugarEchart3").hide();
$("#weightEcharts2").hide();
$("#bloodsugarChange").click(function() {
    bloodsugarIndex++;
    if(bloodsugarIndex % 3 == 1) {
        $("#bloodsugarEchart2").show();
        $("#bloodsugarEchart1").hide();
        $("#bloodsugarEchart3").hide();
    } else if(bloodsugarIndex % 3 == 2) {
        $("#bloodsugarEchart2").hide();
        $("#bloodsugarEchart1").hide();
        $("#bloodsugarEchart3").show();
    } else if(bloodsugarIndex % 3 == 0) {
        $("#bloodsugarEchart2").hide();
        $("#bloodsugarEchart1").show();
        $("#bloodsugarEchart3").hide();
    }
})
$("#weightChange").click(function() {
    if(weightIndex) {
        $("#weightEcharts2").show();
        $("#weightEcharts1").hide();
        weightIndex = false;
    } else {
        $("#weightEcharts2").hide();
        $("#weightEcharts1").show();
        weightIndex = true;
    }
})
$("#checkProjectChange").click(function() {
    if(secondCheckIndex) {
        $("#secondSpan").show();
        $("#firstSpan").hide();
        secondCheckIndex = false;
    } else {
        $("#secondSpan").hide();
        $("#firstSpan").show();
        secondCheckIndex = true;
    }
});

$("#checkreport_close").click(function() {
    $("#myModal").modal("hide");
})
$("#weekly_close").click(function() {
    $("#modal_for_weekly").hide();
})

function selectFirstTap() {
    var selectFirstTapIndex = true;
    $(".self-test").each(function(i) {
        if($(this).css("display") != "none") {
            $(this).find('a').click();
            selectFirstTapIndex = false;
            return false;
        }
    })
    if(selectFirstTapIndex) {
        $("#bloodsugar-tab-pane").click();
        $(".bloodsugar-tab-pane").attr("class", "bloodsugar-tab-pane self-test");
        $("#panel-bloodsugar").attr("class", "tab-pane");
        $("#no-selftest").attr("class", "active tab-pane");
    }
}


function changeColor(week) {
	if(week>5 && week<= 13){
		$("#btn2").css('background','#666');
	}
	if(week>13 && week<= 20){
		$("#btn3").css('background','#666');
	}
	if(week>20 && week<= 24){
		$("#btn4").css('background','#666');
	}
	if(week>24 && week<= 28){
		$("#btn5").css('background','#666');
	}
	if(week>28 && week<= 32){
		$("#btn6").css('background','#666');
	}
	if(week>32 && week<= 36){
		$("#btn7").css('background','#666');
	}
	if(week>36 ){
		$("#btn8").css('background','#666');
	}
	$('#arrows').css({'background':'url(../../Remotelnterrogation/images/jiantou.png)','background-size':'100% 70px'});
	$("#btn1").find("img").attr("src","../../Remotelnterrogation/images/1-411.png");
	$("#btn1").click(function() {
		modalForWeekly(1);
	});
	$("#btn1").css("cursor", "pointer");
	if(week > 5) {
		$("#btn2").find("img").attr("src", "../../Remotelnterrogation/images/6-131.png");
		$("#btn2").click(function() {
			modalForWeekly(2);
		});
		$("#btn2").css("cursor", "pointer");
	}
	if(week > 13) {
		$("#btn3").find("img").attr("src", "../../Remotelnterrogation/images/14-201.png");
		$("#btn3").click(function() {
			modalForWeekly(3);
		});
		$("#btn3").css("cursor", "pointer");
	}
	if(week > 20) {
		$("#btn4").find("img").attr("src", "../../Remotelnterrogation/images/21-241.png");
		$("#btn4").click(function() {
			modalForWeekly(4);
		});
		$("#btn4").css("cursor", "pointer");
	}
	if(week > 24) {
		$("#btn5").find("img").attr("src", "../../Remotelnterrogation/images/25-281.png");
		$("#btn5").click(function() {
			modalForWeekly(5);
		});
		$("#btn5").css("cursor", "pointer");
	}
	if(week > 28) {
		$("#btn6").find("img").attr("src", "../../Remotelnterrogation/images/29-321.png");
		$("#btn6").click(function() {
			modalForWeekly(6);
		});
		$("#btn6").css("cursor", "pointer");
	}
	if(week > 32) {
		$("#btn7").find("img").attr("src", "../../Remotelnterrogation/images/33-361.png");
		$("#btn7").click(function() {
			modalForWeekly(7);
		});
		$("#btn7").css("cursor", "pointer");
	}
	if(week > 36) {
		$("#btn8").find("img").attr("src", "../../Remotelnterrogation/images/37-411.png");
		$("#btn8").click(function() {
			modalForWeekly(8);
		});
		$("#btn8").css("cursor", "pointer");
	}
}

function getBaseMsg(data) {
    if(data == null) {
        return;
    }
    $(".graName").html(data.gname); //孕妇名称
    sessionStorage.setItem("gName", data.gname);
    $(".expectedDate").html(getDateString(data.expectedconfinement)); //预产期
    $(".enddate").html(getDateString(data.enddate)); //末次月经
    weeks = getWeeks(new Date(data.enddate)).weeks;
    $(".weeks").html(weeks); //孕周
    sessionStorage.setItem("weeks", weeks);
    changeColor(weeks);
    sessionStorage.setItem("enddate", getDateString(data.enddate));
    $(".buildWeeks").html(weeks); //建档孕周
    $(".mhistory").html(data.pregnancyBirth); //孕 育 史
    var patienttypeid = "";

    switch(data.patienttypeid) {
        case 1:
            patienttypeid = "备孕";
            break;
        case 2:
            patienttypeid = "怀孕";
            break;
        case 3:
            patienttypeid = "育儿";
            break;
    }
    $("#graStatus").html(patienttypeid);
    var gravida = data.familyMemberList[0];
    var dad = data.familyMemberList[1];
    var mbloodtype = "";
    var fbloodtype = "";
    var mRh = "";
    var fRh = "";
    if(gravida != undefined) {
        switch(gravida.bloodtype) {
            case 0:
                mbloodtype = "A";
                break;
            case 1:
                mbloodtype = "B";
                break;
            case 2:
                mbloodtype = "O";
                break;
            case 3:
                mbloodtype = "AB";
                break;
        }
        if(gravida.rh == 0) {
            mRh = "阴性";
        } else {
            mRh = "阳性";
        }
        $("#mRh").html(mRh);
        $("#mbloodtype").html(mbloodtype);
        var now=new Date();
        var age="暂无数据";
        var birthDay="暂无数据"
		if(gravida.birthYears!=undefined){
			age=Math.floor(((now-gravida.birthYears)/1000/365/24/60/60));
			birthDay=getDateString(gravida.birthYears);
		}
        $(".graAge").html(age); //年龄
        $("#birthDate").html(birthDay);
    }
    if(dad != undefined) {
        switch(dad.bloodtype) {
            case 0:
                fbloodtype = "A";
                break;
            case 1:
                fbloodtype = "B";
                break;
            case 2:
                fbloodtype = "O";
                break;
            case 3:
                fbloodtype = "AB";
                break;
        }
        if(dad.rh == 0) {
            fRh = "阴性";
        } else {
            fRh = "阳性";
        }
        $("#fRh").html(fRh);
        $("#fbloodtype").html(fbloodtype);
    }
}

function getDateString(mydate) {
	var d = new Date(mydate);
	//格式化日，如果小于9，前面补0  
	var day = ("0" + d.getDate()).slice(-2);
	//格式化月，如果小于9，前面补0  
	var month = ("0" + (d.getMonth() + 1)).slice(-2);
	//拼装完整日期格式  
	var date1 = d.getFullYear() + "-" + (month) + "-" + (day);
	return date1;

}

function getWeeks(date1) {
	var date2 = new Date();
	var date3 = date2.getTime() - new Date(date1).getTime();
	var days = Math.floor(date3 / (24 * 3600 * 1000));
	var json = {
		"weeks": parseInt(days / 7),
		"day": days % 7
	};
	return json;
}

function symptom() {
    var eWeeks = sessionStorage.getItem("eWeeks");
    var sWeeks = sessionStorage.getItem("sWeeks");
    var symptom = null;
    $.ajax({
        type: "post",
        url: address + "pregnancyHistory/querySymptom.do",
        async: true,
        dataType: "json",
        data: {
            mid: mid,
            "sWeeks": sWeeks,
            "eWeeks": eWeeks
        },
        success: function(result) {
            var data = result.data;
            $("#symptomName").empty();
            for(var i = 0; i < data.length; i++) {
                if(i == 0) {
                    var content = "<span>" + data[i].symptomName + "</span>";
                } else {
                    var content = "<span>、" + data[i].symptomName + "</span>";
                }

                $("#symptomName").append(content);

            }
            if(data.length == 0) {
                $("#symptomName").append("无");
                $("#symptomName").css("color", "#666");
            }

        },
    });
}

medicalHistory(mid);
manQueryPersonage(mid);
graderInfoMedicalHistory(mid);
blood(mid);
wonmanQueryPersonage(mid);
symptoms(mid);
bloodPressures();

function medicalHistory(mid) {
    $.ajax({
        type: "post",
        url: address + "pregnancyHistory/selectHistoryGradeInfo.do",
        dataType: "json",
        async: true,
        data: {
            mid: mid
        },
        success: function(result) {
            if(result.data.length == 0) {
            	$("#heart").text("暂无数据");
                $("#lung").text("暂无数据");
                $("#vulva").text("暂无数据");
                $("#cervixUteri").text("暂无数据");
                $("#uterus").text("暂无数据");
                $("#vagina").text("暂无数据");
                $("#td_doctorAdviceManager_heart").text("暂无数据");
                $("#td_doctorAdviceManager_lung").text("暂无数据");
                $("#td_doctorAdviceManager_vulva").text("暂无数据");
                $("#td_doctorAdviceManager_cervixUteri").text("暂无数据");
                $("#td_doctorAdviceManager_uteri").text("暂无数据");
                $("#td_doctorAdviceManager_vagina").text("暂无数据");
                $("#td_doctorAdviceManager_abdominal").text("暂无数据");
                return;
            }
            var information = result.data;
            var heart = null;
            var lung = null;
            var vulva = null;
            var cervixUteri = null;
            var uterus = null;
            var vagina = null;
            var abdominal = null;
            if(information != null) {
                if(information[0].heart == 0) {
                    heart = "正常";
                } else if(information[0].heart == 1) {
                    heart = "异常";
                } else {
                    heart = "其他";
                }
                if(information[0].lung == 0) {
                    lung = "正常";
                } else if(information[0].lung == 1) {
                    lung = "异常";
                } else {
                    lung = "其他";
                }
                if(information[0].vulva == 0) {
                    vulva = "正常";
                } else if(information[0].vulva == 1) {
                    vulva = "异常";
                } else {
                    vulva = "其他";
                }
                if(information[0].cervixUteri == 0) {
                    cervixUteri = "正常";
                } else if(information[0].cervixUteri == 1) {
                    cervixUteri = "异常";
                } else {
                    cervixUteri = "其他";
                }
                if(information[0].uterus == 0) {
                    uterus = "正常";
                } else if(information[0].uterus == 1) {
                    uterus = "异常";
                } else {
                    uterus = "其他";
                }
                if(information[0].vagina == 0) {
                    vagina = "正常";
                } else if(information[0].vagina == 1) {
                    vagina = "异常";
                } else {
                    vagina = "其他";
                }
                if(information[0].abdominal == 0) {
                    abdominal = "正常";
                } else if(information[0].abdominal == 1) {
                    abdominal = "异常";
                } else {
                    abdominal = "其他";
                }
                $("#heart").text(heart);
                $("#lung").text(lung);
                $("#vulva").text(vulva);
                $("#cervixUteri").text(cervixUteri);
                $("#uterus").text(uterus);
                $("#vagina").text(vagina);
                $("#td_doctorAdviceManager_heart").text(heart);
                $("#td_doctorAdviceManager_lung").text(lung);
                $("#td_doctorAdviceManager_vulva").text(vulva);
                $("#td_doctorAdviceManager_cervixUteri").text(cervixUteri);
                $("#td_doctorAdviceManager_uteri").text(uterus);
                $("#td_doctorAdviceManager_vagina").text(vagina);
                $("#td_doctorAdviceManager_abdominal").text(abdominal);

            }
        },
    });
}

function graderInfoMedicalHistory(mid) {
    $.ajax({
        type: "post",
        url: address + "pregnancyHistory/selectHistory.do",
        async: true,
        dataType: "json",
        data: {
            mid: mid
        },
        success: function(result) {
            $("#gHistory").text(replaceUndefined(result.data.history));
            $("#td_doctorAdviceManager_ji").text(replaceUndefined(result.data.history));
        },
    });
}
//父亲血型
function blood(mid) {
    var bloodType = null;
    $.ajax({
        type: "post",
        url: address + "pregnancyHistory/queryManBlood.do",
        async: true,
        dataType: "json",
        data: {
            mid: mid
        },
        success: function(result) {
            if(result.data == null) {
            	$("#manBlood").text("暂无数据");
            	$("#td_doctorAdviceManager_blood").text("暂无数据");
                return;
            }
            var data = result.data;
            if(data.bloodType == 0) {
                bloodType = "A型";
            } else if(data.bloodType == 1) {
                bloodType = "B型";
            } else if(data.bloodType == 2) {
                bloodType = "O型";
            } else if(data.bloodType == 3) {
                bloodType = "AB型";
            } else{
            	bloodType = "暂无数据";
            }
            $("#manBlood").text(bloodType);
            $("#td_doctorAdviceManager_blood").text(bloodType);
        },
    });
}

function wonmanQueryPersonage(mid) {
    var hPersonalHistory = null;
    $.ajax({
        type: "post",
        url: address + "pregnancyHistory/queryPersonage.do",
        async: true,
        dataType: "json",
        data: {
            relationId: 1,
            mid: mid
        },
        success: function(result) {
            if(result.data == null || result.data.length == 0) {
            	$("#womanHistory").text("暂无数据");
	            $("#womanPersonage").text("暂无数据");
	            $("#td_doctorAdviceManager_womanF").text("暂无数据");
	            $("#td_doctorAdviceManager_womanper").text("暂无数据");
	            $("#pregnancyBirth").text("暂无数据");
                return;
            }
            var data = result.data;
            if(data.hPersonalHistory == 0) {
                hPersonalHistory = "无";
            } else if(data.hPersonalHistory == 1) {
                hPersonalHistory = "其他";
            } else if(data.hPersonalHistory == 2) {
                hPersonalHistory = "接触放射线";
            } else if(data.hPersonalHistory == 3) {
                hPersonalHistory = "接触有毒有害物质";
            } else if(data.hPersonalHistory == 4) {
                hPersonalHistory = "服用药物";
            } else if(data.hPersonalHistory == 5) {
                hPersonalHistory = "饮酒";
            } else if(data.hPersonalHistory == 6) {
                hPersonalHistory = "吸烟";
            }else{
            	hPersonalHistory = "暂无数据";
            }
            $("#womanHistory").text(hPersonalHistory);
            $("#womanPersonage").text(hPersonalHistory);
            $("#td_doctorAdviceManager_womanF").text(hPersonalHistory);
            $("#td_doctorAdviceManager_womanper").text(hPersonalHistory);
            $("#pregnancyBirth").text(data.pregnancyBirth.replace("#"," "));
        },
    });
}

function manQueryPersonage(mid) {
    var hPersonalHistory = null;
    $.ajax({
        type: "post",
        url: address + "pregnancyHistory/queryPersonage.do",
        async: true,
        dataType: "json",
        data: {
            relationId: 2,
            mid: mid
        },
        success: function(result) {
            if(result.data == null || result.data.length == 0) {
            	$("#manHistory").text("暂无数据");
	            $("#manPersonage").text("暂无数据");
	            $("#td_doctorAdviceManager_manF").text("暂无数据");
	            $("#td_doctorAdviceManager_manper").text("暂无数据");

                return;
            }
            var data = result.data;
            if(data.hPersonalHistory == 0) {
                hPersonalHistory = "无";
            } else if(data.hPersonalHistory == 1) {
                hPersonalHistory = "其他";
            } else if(data.hPersonalHistory == 2) {
                hPersonalHistory = "接触放射线";
            } else if(data.hPersonalHistory == 3) {
                hPersonalHistory = "接触有毒有害物质";
            } else if(data.hPersonalHistory == 4) {
                hPersonalHistory = "服用药物";
            } else if(data.hPersonalHistory == 5) {
                hPersonalHistory = "饮酒";
            } else if(data.hPersonalHistory == 6) {
                hPersonalHistory = "吸烟";
            }else{
            	hPersonalHistory="暂无数据"
            }
            $("#manHistory").text(hPersonalHistory);
            $("#manPersonage").text(hPersonalHistory);
            $("#td_doctorAdviceManager_manF").text(hPersonalHistory);
            $("#td_doctorAdviceManager_manper").text(hPersonalHistory);
        },
    });
}

function symptoms(mid) {
    $.ajax({
        type: "post",
        url: address + "symptom/querySymptom.do",
        async: true,
        dataType: "json",
        data: {
            mid: mid
        },
        success: function(result) {
            var data = result.data;
            for(var i = 0; i < data.length; i++) {
                if(data[i].symptomName.trim() == "皮肤瘙痒") {
                    $("#td_doctorAdviceManager_symptoms0").text("有");
                    $("#symptomInfo").val("皮肤瘙痒");
                } else {
                    $("#td_doctorAdviceManager_symptoms0").text("无");
                }
                if(data[i].symptomName.trim() == "腹痛") {
                    $("#td_doctorAdviceManager_symptoms1").text("有");
                    $("#symptomInfo").val("腹痛");
                } else {
                    $("#td_doctorAdviceManager_symptoms1").text("无");
                }
                if(data[i].symptomName.trim() == "外阴出血") {
                    $("#symptomInfo").val("外阴出血");
                    $("#td_doctorAdviceManager_symptoms2").text("有");
                } else {
                    $("#td_doctorAdviceManager_symptoms2").text("无");
                }
                if(data[i].symptomName.trim() == "头昏") {
                    $("#td_doctorAdviceManager_symptoms3").text("有");
                    $("#symptomInfo").val("头昏");
                } else {
                    $("#td_doctorAdviceManager_symptoms3").text("无");
                }
                if(data[i].symptomName.trim() == "发热") {
                    $("#td_doctorAdviceManager_symptoms4").text("有");
                    $("#symptomInfo").val("发热");
                } else {
                    $("#td_doctorAdviceManager_symptoms4").text("无");
                }
                if(data[i].symptomName.trim() == "阴道溢液") {
                    $("#td_doctorAdviceManager_symptoms5").text("有");
                    $("#symptomInfo").val("阴道溢液");
                } else {
                    $("#td_doctorAdviceManager_symptoms5").text("无");
                }
                if(data[i].symptomName.trim() == "呼吸困难") {
                    $("#td_doctorAdviceManager_symptoms6").text("有");
                    $("#symptomInfo").val("呼吸困难");
                } else {
                    $("#td_doctorAdviceManager_symptoms6").text("无");
                }
                if(data[i].symptomName.trim() == "眼花") {
                    $("#td_doctorAdviceManager_symptoms7").text("有");
                    $("#symptomInfo").val("眼花");
                } else {
                    $("#td_doctorAdviceManager_symptoms7").text("无");
                }
                if(data[i].symptomName.trim() == "其他") {
                    $("#td_doctorAdviceManager_symptoms8").text("有");
                    $("#symptomInfo").val("其他");
                } else {
                    $("#td_doctorAdviceManager_symptoms8").text("无");
                }
            }
        },
    });
}
//基本信息
function createExpectBasic(data) {
    if(data == undefined) {
    	$("#statures").text("暂无数据");
    	$("#weights").text("暂无数据");
    	$("#bmis").text("暂无数据");
        return;
    }
    var str_start = data.expectedConfinement;
    var count = 295;
    var start = new Date(str_start);
    var date = new Date();
    var init = parseInt(Math.abs(date - start) / 1000 / 60 / 60 / 24);
    var end = start.setDate(start.getDate() + 295);
    var str_end = start.getFullYear() + "/" + (start.getMonth() + 1) + "/" + start.getDate();
    var gWeeks = null;
    if(init) {
        if(parseInt(init % 7) == 0) {
            gWeeks = "孕" + parseInt(init / 7) + "周";
            var graweek = "孕" + parseInt(init / 7) + "周";
            sessionStorage.setItem("graWeeks", graweek);
        } else {
            gWeeks = "孕" + parseInt(init / 7) + "周" + "+" + init % 7 + "天";
            var graweek = "孕" + parseInt(init / 7) + "周" + "+" + init % 7 + "天";
            sessionStorage.setItem("graWeeks", graweek);
        }
    }
    var bmis = (data.pregnancy / data.gHigh / data.gHigh * 10000).toFixed(1);
    $("#expectedDate").text(replaceUndefined(data.expectedConfinement));
    $("#gestationalWeeks").text(gWeeks);
    $("#ages").text(replaceUndefined(data.age));
    $("#statures").text(replaceUndefined(data.gHigh));
    $("#weights").text(replaceUndefined(data.pregnancy));
    if(bmis=="NaN"){
    	bmis="暂无数据";
    };
    $("#bmis").text(bmis);
    $("#weeksTime").text(gWeeks);
    $("#td_doctorAdviceManager_sHisk").text(replaceUndefined(data.gHigh));
    $("#td_doctorAdviceManager_weight").text(replaceUndefined(data.pregnancy));
    $("#td_doctorAdviceManager_BMI").text(bmis);
    $("#td_doctorAdviceManager_Age").text(replaceUndefined(data.age));
}
//血压
function bloodPressures() {
    $.ajax({
        type: "post",
        url: address + "bloodpressure/find.do",
        dataType: "json",
        async: true,
        data: {
            mid: mid
        },
        success: function(result) {
            if(result.data.length == 0) {
            	$("#booldPressure").text("暂无数据");
                return;
            }
            var list = result.data;
            var bloodPressureStr = list[list.length - 1].diastolic + "/" + list[list.length - 1].systolic;
            $("#booldPressure").text(bloodPressureStr);
        },
    });
}

var checkProjectChange = document.getElementById('checkProjectChange');
//替换空值
function replaceUndefined(str){
	if(str==undefined||str==null){
		return "暂无数据"
	}
	return str;
}
drag($("#modal_for_weekly"));
$('.img_close_button').click(function(){
	$(this).parent().parent().hide();
});
