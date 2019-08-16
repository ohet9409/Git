function checkImageboardWrite() {
	if(document.frm.imageId.value == "") {
		alert("상품코드를 입력하세요");
		document.frm.imageId.focus();
	} else if(document.frm.imageId.value == "") {
		alert("상품코드를 입력하세요");
		document.frm.imageId.focus();
	}  else if(document.frm.imageName.value == "") {
		alert("상품명을 입력하세요");
		document.frm.imageName.focus();
	}  else if(document.frm.imagePrice.value == "") {
		alert("단가를 입력하세요");
		document.frm.imagePrice.focus();
	} else if(document.frm.imageQty.value == "") {
		alert("개수를 입력하세요");
		document.frm.imageQty.focus();
	} else if(document.frm.imageContent.value == "") {
		alert("내용을 입력하세요");
		document.frm.imageContent.focus();
	} else {
		document.frm.submit();
	}
}