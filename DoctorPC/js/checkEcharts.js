var address = sessionStorage.getItem("address");
function setCheckEchart(week) {
	var ins = 0;
	var not = 0;
	var data;
	var inCheck = "";
	var notCheck = "";
	$.ajax({
		type: "post",
		url: address + "weekly/findCheckProject.do",
		data: {
			mid: sessionStorage.getItem('mid'),
			week: week
		},
		async: false,
		success: function(d) {
			data = d.data;
			if(data != null){
				if(data.in !=null){
				ins = data.in.length;
			}
			if(data.not !=null){
				not = data.not.length;
			}
			if(data.in.length != 0){
			for(var i = 0; i < data.in.length; i++) {
				if(i == 0) {
					inCheck += "\n\n" + data.in[i].name + "\n\n";
				}else if(i<6){
					inCheck += data.in[i].name + "\n\n";
				} else if(i>=8) {
					inCheck += data.in[i].name + "等";
				}
			}
			}
			if(data.not.length != 0){
				for(var i = 0; i < data.not.length; i++) {
				if(i == 0) {
					notCheck += "\n\n" + data.not[i].name + "\n\n";
				}else if(i<6){
					notCheck += data.not[i].name + "\n\n";
				} else if(i>=8) {
					notCheck += data.not[i].name + '等';
				}
			}
			}
			}	
		}
	});
	if(inCheck == "") {
		inCheck = "无";
	}
	if(notCheck == "") {
		notCheck = "无";
	}
	var echart1 = document.getElementById('checkEchart');
	var myChart9 = echarts.init(echart1);
	
	/*if(notCheck.length >=5){
		notCheck = notCheck.slice(0, 6) + '等';
	}*/
	
	option = {
		tooltip: {
			trigger: 'item',
			formatter: "{b}"
		},
		legend: {
			orient: 'vertical',
			x: 'center',
			y: 'bottom',
			data: ['未检查项目' + notCheck, '已检查项目' + inCheck]
		},
		series: [{
			name: '',
			type: 'pie',
			radius: ['45%', '65%'],
			center: ['50%', '50%'],
			label: {
				normal: {
					formatter: "{b}",
					backgroundColor: '#eee',
					borderColor: '#aaa',
					borderWidth: 1,
					borderRadius: 4
				}
			},
			labelLine: {
				normal: {
					length: 15
				}
			},
			data: [{
					value: not,
					name: '未检查:' + notCheck,
					itemStyle: {
						normal: {
							label: {
								show: true,
							},
							labelLine: {
								show: true
							}
						}
					}
				},
				{
					value: ins,
					name: '已检查:' + inCheck,
					itemStyle: {
						normal: {
							label: {
								show: true,
							},
							labelLine: {
								show: true
							}
						}
					}
				}
			]
		}]
	};

	var opt = option.series[0];
	lineHide(opt);
	//数据为零时隐藏线段  
	function lineHide(opt) {
		jQuery.each(opt.data, function(i, item) {
			if(item.value == 0) {
				item.itemStyle.normal.labelLine.show = false;
				item.itemStyle.normal.label.show = false;
			}
		});
	}
	myChart9.setOption(option);
}