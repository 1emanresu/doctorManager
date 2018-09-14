//计算当前孕周--通用方法 参数为时间格式1990-1-1,返回json
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

//返回预产期-参数为时间类型
function getBudgetDate(date1) {
	var date2 = new Date(date1);
	date2.setDate(date1.getDate() + 280);
	var times = date2.getFullYear() + "-" + (date2.getMonth() + 1) + "-" + date2.getDate();
	return times;
}

//long类型转为时间类型
function longToDate(long) {
	var myDate = new Date(long);
	var date2 = myDate.getFullYear() + "-" + (myDate.getMonth() + 1) + "-" + myDate.getDate();
	return date2;
}

//计算剩余天数
function surplusDay(date2) {
	var date1 = new Date();
	var date3 = date2.getTime() - new Date(date1).getTime();
	var days = Math.floor(date3 / (24 * 3600 * 1000));
	return days;
}

//undefined处理
function un(data) {
	if(data == undefined||data==null) {
		return "";
	}
	return data;
}

/*根据出生日期算出年龄*/
function getAge(strBirthday) {
	var returnAge;
	var strBirthdayArr = strBirthday.split("-");
	var birthYear = strBirthdayArr[0];
	var birthMonth = strBirthdayArr[1];
	var birthDay = strBirthdayArr[2];

	d = new Date();
	var nowYear = d.getFullYear();
	var nowMonth = d.getMonth() + 1;
	var nowDay = d.getDate();

	if(nowYear == birthYear) {
		returnAge = 0; //同年 则为0岁  
	} else {
		var ageDiff = nowYear - birthYear; //年之差  
		if(ageDiff > 0) {
			if(nowMonth == birthMonth) {
				var dayDiff = nowDay - birthDay; //日之差  
				if(dayDiff < 0) {
					returnAge = ageDiff - 1;
				} else {
					returnAge = ageDiff;
				}
			} else {
				var monthDiff = nowMonth - birthMonth; //月之差  
				if(monthDiff < 0) {
					returnAge = ageDiff - 1;
				} else {
					returnAge = ageDiff;
				}
			}
		} else {
			returnAge = ""; //返回-1 表示出生日期输入错误 晚于今天  
		}
	}
	return returnAge; //返回周岁年龄  
}