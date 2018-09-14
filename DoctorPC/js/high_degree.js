//此js用于判断高危程度，可共用
function high_degree(score) {
	var high_result = "";
	if(score == 0) {
		high_result = "无高危";
	} else if(score > 0 && score < 10) {
		high_result = "轻度高危";
	} else if(score >= 10 && score < 20) {
		high_result = "中度高危";
	} else if(score >= 20 && score < 30) {
		high_result = "重度高危";
	} else if(score >= 30) {
		high_result = "极度高危";
	}
	return high_result;
}