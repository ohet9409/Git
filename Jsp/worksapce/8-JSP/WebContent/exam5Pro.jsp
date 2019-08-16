
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String name = request.getParameter("name");
        int kor = Integer.parseInt(request.getParameter("kor"));
        int eng = Integer.parseInt(request.getParameter("eng"));
        int mat = Integer.parseInt(request.getParameter("mat"));
        double avg = (double)(kor + eng + mat)/3; 
        String str ="";
       /*  if(avg>=90){
        	str ="수";
        } else if(avg>=80){
        	str ="우";
        } else if(avg>=70){
        	str ="미";
        } else if(avg>=60){
        	str ="양";
        } else 
        	str ="가"; */
        switch ((int)avg/10){
        case 10:
        case 9: str ="수"; break;
        case 8: str ="우"; break;
        case 7: str ="미"; break;
        case 6: str ="양"; break;
        default : str ="가"; break;
        }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= name %>님의 성적은 &lt;<%=str %>&gt; 입니다.
</body>
</html>