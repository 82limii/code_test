<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String yy = request.getParameter("year");
String mm = request.getParameter("month");

Calendar cal = Calendar.getInstance();

int y = cal.get(Calendar.YEAR);		// 2021
int m = cal.get(Calendar.MONTH);	// 0부터 출력 (1월 :0);

if(yy != null && mm != null && !yy.equals("") && !mm.equals("")) {
	y = Integer.parseInt(yy);
	m = Integer.parseInt(mm)-1;
}
cal.set(y,m,1);
// 출력 년월의 1일날의 요일
int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);	// 요일을 숫자로 리턴 (일:1, 월:2 ,... 토:7)
// dayOfWeek = 2;
// 출력 년월의 마지막 날짜
int lastDay = cal.getActualMaximum(Calendar.DATE);
// lastDay = 31;

// 이전 버튼을 위한 세팅
int b_y = y;
int b_m = m;
if(m == 0) {
	b_y = b_y - 1;
	b_m = 12;
}

// 다음 버튼을 위한 세팅
int n_y = y;
int n_m = m+2;
if(n_m == 13) {
	n_y = n_y + 1;
	n_m = 1;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
body {
	font-size: 9pt;
	color: #555555;
}
table {
	border-collapse: collapse;
}
th, td {
	border: 1px solid #cccccc;
	width: 50px;
	height: 25px;
	text-align: center;
}
caption {
	margin-bottom: 10px;
	font-size: 15px;
}
</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/jquery-3.6.0.min.js"></script>
</head>
<body>

<form name="frm" method="post" action="Calendar.jsp">
	<input type="text" name="year" size="3">년
	<input type="text" name="month" size="3">월
	<%--
	<select name="month">
		<%
		for(int m1=1; m1<=12; m1++) {
			String chk2 = "";
			if(m1 == Integer.parseInt(mm)) {
				chk2 = "selected";
			}
		%>
			<option value="<%=m1 %>" <%=chk2 %>><%=m1 %>월</option>
		<%	
		}
		%>
	</select>
	--%>
	<input type="submit" value="달력보기">
</form>
<br><br>
<table>
	<caption>
		<button type="button" onclick="location='Calendar.jsp?year=<%=b_y %>&month=<%=b_m %>'">이전</button>
		<%=y %>년 <%=m+1 %>월
		<button type="button" onclick="location='Calendar.jsp?year=<%=n_y %>&month=<%=n_m %>'">다음</button>
	</caption>
	<tr>
		<th>Sun</th>
		<th>Mon</th>
		<th>Tue</th>
		<th>Wed</th>
		<th>Thu</th>
		<th>Fri</th>
		<th>Sat</th>
	</tr>
	<tr>
		<%
		int count = 0;
		// 1일을 출력하기 전 빈칸을 출력하는 설정
		for(int s=1; s<dayOfWeek; s++) {
			out.print("<td></td>");
			count++;
		}
		// 날짜 출력하는 설정
		for(int d=1; d<=lastDay; d++) {
			count++;
			String color = "#555555";
			if(count == 7) {
				color = "blue";
			} else if(count == 1) {
				color = "red";
			}
		%>
			<td style="color:<%=color %>"><%=d %></td>
		<%
			// 개행을 위한 설정
			if(count == 7) {
				out.print("</tr><tr>");
				count = 0;	// 변수 초기화
			}
		}
		
		while(count < 7) {
			out.print("<td></td>");
			count++;
		}
		%>
	</tr>
</table>

</body>
</html>