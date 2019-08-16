/**
 * 
 */
function input() {
	if(document.frm.subject.value==""){
		alert("제목을 입력하세요");
		document.frm.subject.focus();
	} else if(document.frm.content.value==""){
		alert("내용을 입력하세요");
		document.frm.content.focus();
	} else {
		document.frm.submit();
	}
}
function checkBoardModify() {
	if(document.boardModifyForm.subject.value==""){
		alert("제목을 입력하세요");
		document.boardModifyForm.subject.focus();
	} else if(document.boardModifyForm.content.value==""){
		alert("내용을 입력하세요");
		document.boardModifyForm.content.focus();
	} else {
		if(confirm("수정?")){
		document.boardModifyForm.submit();
	}
	}
}