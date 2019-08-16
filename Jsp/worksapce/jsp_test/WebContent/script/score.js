/**
 * 
 */
function input() {
	if(document.inputForm.hakbun.value == ""){
		alert("학번을 입력하세요");
		document.inputForm.hakbun.focus();
	} else if(document.inputForm.name.value == ""){
		alert("이름을 입력하세요");
		document.inputForm.name.focus();
	} else {
		if(confirm("제출하시겠습니까?")){
			document.inputForm.submit();
		}
	}
}