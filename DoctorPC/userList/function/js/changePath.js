/*author:luoyc 孕妇未建档*/
function remindToBuild(){
	$("#pathSpan2").text("手动建档");
}
function buildNow(){
	$("#pathSpan2").text("提醒孕妇添加建档信息");
}
function Builded(){
	$("#pathSpan2").text("已建档");
}
function noBuild(){
	$("#pathSpan2").text("未建档");
}
function beforeBirthCheckDetail(){
	$("#pathSpan2").text("产前备孕检查详情");
}
function beforeBirthBuild(){
	$("#pathSpan2").text("产前建档详情");
}
function gravidaCheckDetail(){
	$("#pathSpan2").text("孕妇首诊详情");
}
function riskModel(){
	$("#pathSpan2").text("备孕风险模型分析");
}
function riskModelForFirstCheck(){
	$("#pathSpan2").text("首诊风险模型分析");
}
function editorAdviceForPath(){
	$("#pathSpan2").text("编辑医嘱");
}
function noPregnancyTest(){
	$("#pathSpan2").text("未孕检");
}
function PregnancyTestYet(){
	$("#pathSpan2").text("已孕检");
}
function turnBack(){
	location.href="javascript:history.back(-1)";
};