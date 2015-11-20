$(document).ready(function() {
	// 审核状态从012变为，待审核，审核通过，未通过
	// 0.待审核 1.审核通过 2.审核未通过
	// 遍历表格
	console.log("11111")
	var aTable = $(".table"); // 选中table，可能会有两张表格
	
	for ( var i = 0; i < aTable.length; i++) {
		for ( var j = 0; j < aTable[i].tBodies[0].rows.length; j++) {
			if (aTable[i].tBodies[0].rows[j].cells[5].innerHTML === '0') {
				aTable[i].tBodies[0].rows[j].cells[5].innerHTML = "未使用";
			}
			if (aTable[i].tBodies[0].rows[j].cells[5].innerHTML === '1') {
				aTable[i].tBodies[0].rows[j].cells[5].innerHTML = "使用过";
			}
			if (aTable[i].tBodies[0].rows[j].cells[5].innerHTML === '2') {
				aTable[i].tBodies[0].rows[j].cells[5].innerHTML = "未通过";
			}
			if (aTable[i].tBodies[0].rows[j].cells[5].innerHTML === '3') {
				aTable[i].tBodies[0].rows[j].cells[5].innerHTML = "休眠";
			}
		}
	}
});

