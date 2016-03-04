var randomScalingFactor = function(){ return Math.round(Math.random()*1000)};
var doughnutData = [
	{
		value: 20,
		color:"#30a5ff",
		highlight: "#62b9fb",
		label: "借出设备"
	},
	{
		value: 30,
		color: "#ffb53e",
		highlight: "#fac878",
		label: "报废设备"
	},
	{
		value: 20,
		color: "#1ebfae",
		highlight: "#3cdfce",
		label: "维修设备"
	},
	{
		value: 10,
		color: "#f9243f",
		highlight: "#f6495f",
		label: "库存设备"
	}

];
window.onload = function(){
	var applyNum=$("#applyNum").val();
	var maintainNum=$("#maintainNum").val();
	var dumpNum=$("#dumpNum").val();
	var residueNum=$("#residueNum").val();
	doughnutData[0].value=Number(applyNum);
	doughnutData[1].value=Number(dumpNum);
	doughnutData[2].value=Number(maintainNum);
	doughnutData[3].value=Number(residueNum);
	var chart3 = document.getElementById("doughnut-chart").getContext("2d");
	window.myDoughnut = new Chart(chart3).Doughnut(doughnutData, {responsive : true
	});
};