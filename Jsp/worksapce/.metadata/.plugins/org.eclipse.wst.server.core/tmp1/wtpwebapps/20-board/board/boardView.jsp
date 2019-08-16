<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

#wrap{
	margin: auto;
	width: 500px;
	height:500px;
	border: 1px solid red;
	text-align: center;
}
#top{
	height:40px;
	
}
#content{
	margin-top: 20px;
	background-color: orange;
	height: 350px;
	overflow: auto;	/* 글자가 넘칠경우 자동조절 */
}
#commandlist{
	margin: auto;
	width: 500px;
	text-align: center;
}
</style>
</head>
<body>
<div id="wrap">
<h2 align="center">글 내용 상세보기</h2>
<div id="top">
제 목: ${bean.board_subject} &nbsp; 첨부파일: <a href="#">${bean.board_file }</a><br></div>
<div id="content"><pre>${bean.board_content }</pre></div>
</div>
<div id="commandlist">
<a href="boardReplyForm.do?board_num=${board_num}&pg=${pg}&board_re_seq=${bean.board_re_seq}&board_re_ref=${bean.board_re_ref}&board_re_lev=${bean.board_re_lev}">[답변]</a>
<a href="boardModifyForm.do?board_num=${board_num}&pg=${pg}">[수정]</a>
<a href="boardDeleteForm.do?board_num=${board_num}&pg=${pg}">[삭제]</a>
<a href="boardList.do?pg=${pg}">[목록]</a>

</div>
</body>
</html>