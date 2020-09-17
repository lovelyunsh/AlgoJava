<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<%!
public void init() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SSAFY - 글목록</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="shortcut icon" href="img/favicon.ico">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#mvWriteBtn").click(function() {
				$(location).attr("href", "/guestbookjsp/guestbook/write.jsp");
			});
		});
	</script>
</head>
<body>
	<div class="container" align="center">
		<div class="col-lg-8" align="center">
			<h2>글목록</h2>
			<p>좋은글 많이 올려 주세요!!!!!</p>
			<table class="table table-borderless">
				<tr>
					<td align="right">
						<button type="button" id="mvWriteBtn" class="btn btn-link">글쓰기</button>
					</td>
				</tr>
			</table>
			<table class="table table-active">
				<tbody>
					<tr class="table-info">
						<td>작성자 : 홍길동</td>
						<td align="right">작성일 : 2020-04-13 22:25:39</td>
					</tr>
					<tr>
						<td colspan="2" class="table-danger">
							<strong>10. 안녕하세요!!!</strong>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							즐거운 하루 되세요!!
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>