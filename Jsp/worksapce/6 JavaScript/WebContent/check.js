/**
 * gender[0] = 남자, gender[1] = 여자
 */
function doSubmit() {
	// alert(document.frm.gender[0].checked);
	/*
	 * 모든 항목이 입력되었을 경우를 검사하는 방법 1. if-else 사용 2. flag 변수 사용
	 */
	
	////////////////////////////////////////////////////////////
	var chk = false; // 체크박스가 1개라도 선택되어 있으면 true
					// 변수 chk는 flag 변수의 기능으로 사용함
					// flag 변수 : 상태를 저장하는 변수
	for (var i = 0; i < document.frm.hobby.length; i++) {
		if (document.frm.hobby[i].checked) {
			chk = true;
			break;
		}
	}
	var allCheck = true; // 모든 항목이 입력되었을 경우 : true
	// text 요소의 입력여부 검사
	if (document.frm.user_name.value == "") {
		alert("이름을 입력해 주세요");
		document.frm.user_name.focus();
	} else if (!document.frm.gender[0].checked
			&& !document.frm.gender[1].checked) { // 라디오버튼의 입력여부 검사
		alert("성별을 선택해 주세요");
		document.frm.gender[0].focus();
	}
	// alert(document.frm.job.selectedIndex);
	else if (document.frm.job.selectedIndex < 1) { // select 요소의 입력여부 검사
		alert("직업을 선택해 주세요.");
		document.frm.job.focus();
	}

	else if (chk == false) { // 체크박스의 선택여부 검사 if(!chk)
		alert("취미를 선택해주세요")
		document.frm.hobby[0].focus();
	}

	// textarea의 입력여부 검사
	else if (document.frm.memo.value == "") {
		alert("메모를 입력하세요");
		document.frm.memo.focus();
	}
	else {	// 모든 항목이 입력되었을 경우
		if (confirm("제출하시겠습니까?")) {
            alert("제출하였습니다.");
            document.frm.Submit();   // 서버로 form 태그 안 의 데 이 터 보 내기
		} else {
			alert("취소되었습니다.");
		}  
	}
}