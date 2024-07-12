<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style type="text/css">
	#QaTable{
	  width: 100%;
      border: 2px solid black;
	}
	th,td{
      align-content: center;
      border: 1px solid black;
    }
</style>
</head>
<body>
	<h2>QA 게시판</h2>
	<div>
		<button id="regBtn" type="button">글 쓰기</button>
	</div>
	<div>
		<table id="QaTable">
		   <thead>	
			 <tr>
				<th>member_num</th>
				<th>title</th>
				<th>context</th>
				<th>writer</th>
				<th>memberType</th>
				<th>prescript_no</th>
			 </tr>
		   </thead>
		   	<tbody>
		   		<c:forEach  items="${qadto}" var="qaDTO">
		   			<tr>
		   				<td><c:out value="${qaDTO.member_num}"/></td>
		   				<td><a href="http://localhost:8090/qa/get?qa_id=${qaDTO.qa_id}"><c:out value="${qaDTO.title }"/></a></td>
		   				<td><c:out value="${qaDTO.context }"/></a></td>
		   				<td><c:out value="${qaDTO.writer }"/></td>
		   				<td><c:out value="${qaDTO.memberType }"/></td>
		   				<td><c:out value="${qaDTO.prescript_no }"/></td>
		   			</tr>
		   		</c:forEach>
		   	</tbody>
		</table>
	</div>
	<div>

	</div>
<script type="text/javascript">
$(document).ready(function(){
	$("#regBtn").click(function() {
		self.location = "/qa/register";
	});
});
	
</script>
</body>
</html>