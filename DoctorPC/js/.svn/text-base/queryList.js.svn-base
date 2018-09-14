var address = sessionStorage.getItem("address");
var url = address + 'gravidainfo/findByPage.do';
var typeId;
var oTable;
var queryList = function(queryParams, tableId) {
	if(tableId == undefined) tableId = $("#user_list");
	typeId = queryParams.typeId;
	var oTableInit = new Object();
	if(oTable == undefined) {
		oTable = new TableInit(url, tableId, returnColumn(typeId));
	}
	oTable.Init(queryParams);
}
var columnParams = [];
var countParams;
var returnColumn = function(typeId) {
	var countParams = {
		"checkbox": {
			title: 'checkbox',
			width: '4%',
			align: 'center',
			checkbox: true
		},
		"num": {
			title: '序号',
			align: 'center',
			width: '4%',
			clickToSelect: false, //点击是否选择此行
			formatter: function(value, row, index) {
				return "<span>" + (parseInt(index) + 1) + "</span>";
			}
		},
		"medicalrecordno": {
			field: 'medicalRecordNo',
			title: '病历号',
			width: '8%',
			align: 'center',
			clickToSelect: false,
			sortable: true
		},
		"name": {
			field: 'gName',
			title: '姓名',
			width: '6%',
			align: 'center',
			clickToSelect: false,
			sortable: true,
			formatter: function(value, row, index) {
				return "<a style='cursor: pointer;' onclick='setMid(\"" + row.mId + "\")'>" + row.gName + "</a>";
			}
		},
		"age": {
			field: 'birthYears',
			title: '年龄',
			align: 'center',
			width: '4%',
			clickToSelect: false,
			sortable: true,
			formatter: function(value) {
				return getAge(longToDate(value));
			}
		},
		"weeks": {
			field: 'endDate',
			title: '孕周',
			width: '4%',
			align: 'center',
			clickToSelect: false,
			sortable: true,
			formatter: function(value) {
				return getWeeks(value).weeks
			}
		},
		"risk_info": {
			field: 'birthYears',
			title: '风险提示',
			align: 'center',
			clickToSelect: false,
			formatter: function(value) {
				return '风险提示';
			}
		},
		"high_grade": {
			field: 'mId',
			title: '高危等级',
			align: 'center',
			clickToSelect: false,
			formatter: function(value) {
				return findHighriskTest(value, 1);
			}
		},
		"高危风险因素": {
			field: 'mId',
			title: '高危风险因素',
			align: 'center',
			clickToSelect: false,
			formatter: function(value) {
				return findHighriskTest(value, 2);
			}
		},
		"report_integrity": {
			field: 'mId',
			title: '检查报告完整度',
			align: 'center',
			width: '10%',
			clickToSelect: false,
			formatter: function(value, row, index) {
				return getPercentage(value, getWeeks(row.endDate).weeks);
			}
		},
		"test_integrity": {
			field: 'mId',
			title: '家庭自测完整度',
			align: 'center',
			width: '10%',
			clickToSelect: false,
			formatter: function(value, row, index) {
				return getPercentage(value, getWeeks(row.endDate).weeks);
			}
		},
		"vip_name": {
			field: 'vipGradeName',
			title: '服务套餐',
			width: '4%',
			align: 'center',
			clickToSelect: false,
			sortable: true
		},
		"report_examine": {
			field: 'vipGradeName',
			title: '报告审核',
			align: 'center',
			clickToSelect: false
		},
		"operation": {
			field: 'birthYears',
			title: '操作',
			align: 'center',
			clickToSelect: false,
			width: '220px',
			formatter: function(value, row, index) { 
				return operation(row.mId,typeId);
			}
		}
	}

	switch(typeId) {
		case 1:
			//建档
			columnParams.push(countParams.checkbox, countParams.num, countParams.name, countParams.age, countParams.high_grade, countParams.risk_info, countParams.report_integrity, countParams.vip_name, countParams.operation);
			break;
		case 2:
			//建档
			columnParams.push(countParams.checkbox, countParams.num, countParams.name, countParams.age, countParams.high_grade, countParams.risk_info, countParams.report_integrity, countParams.vip_name, countParams.operation);
			break;
		case 3:
			//建档
			columnParams.push(countParams.checkbox, countParams.num, countParams.name, countParams.age, countParams.high_grade, countParams.risk_info, countParams.report_integrity, countParams.vip_name, countParams.operation);
			break;
		case 4:
			//建档
			columnParams.push(countParams.checkbox, countParams.num, countParams.name, countParams.age, countParams.high_grade, countParams.risk_info, countParams.report_integrity, countParams.vip_name, countParams.operation);
			break;
		case 5:
			//建档
			columnParams.push(countParams.checkbox, countParams.num, countParams.name, countParams.age, countParams.high_grade, countParams.risk_info, countParams.report_integrity, countParams.vip_name, countParams.operation);
			break;
		case 6:
			//建档
			columnParams.push(countParams.checkbox, countParams.num, countParams.name, countParams.age, countParams.high_grade, countParams.risk_info, countParams.report_integrity, countParams.vip_name, countParams.operation);
			break;
		default:
			alert("typeId params error");
	}
	return columnParams;
}