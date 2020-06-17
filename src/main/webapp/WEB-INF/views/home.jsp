<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<style>
table {
	border: 1px solid black;
}

tr, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<div class="col-12">
		<!-- general form elements disabled -->
		<div class="card card-warning">
			<div class="card-header">
				<h3 class="card-title">회원등록</h3>
			</div>
			<!-- /.card-header -->
			<div class="card-body">
				<form role="form" action="/admin/member/create" method="POST">
					<div class="row">
						<div class="col-sm-6">
							<!-- text input -->
							<div class="form-group">
								<label>아이디</label> <input name="userid" type="text"
									class="form-control" placeholder="Enter ...">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label>암호</label> <input name="userpw" type="text"
									class="form-control" placeholder="Enter ...">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<!-- textarea -->
							<div class="form-group">
								<label>이름</label> <input name="username" type="text"
									class="form-control" placeholder="Enter ...">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label>이메일</label> <input name="email" type="text"
									class="form-control" placeholder="Enter ...">
							</div>
						</div>
						<button type="submit" class="btn btn-block btn-info btn-lg">회원등록</button>
					</div>
				</form>
			</div>
			<!-- /.card-body -->
		</div>
		<!-- /.card -->
	</div>
	<table class="bbsListTbl" summary="회원정보리스트">
		<caption class="hdd">회원정보 목록:제작자-${jspMaker}</caption>
		<thead>
			<tr>
			<form action="/admin/member/delete" method ="post">
				<th scope="col">번호</th>
				<th scope="col">사용자ID</th>
				<th scope="col">사용자암호</th>
				<th scope="col">사용자이름</th>
				<th scope="col">사용자이메일</th>
				<th scope="col">사용자등록일</th>
				<th scope="col">사용자수정일</th>
				<th scope="col">삭제</th>
			</tr>
		</form>
		</thead>
		<tbody>
			<c:forEach items="${memberList}" var="memberVO" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${memberVO.userid}</td>
					<td>${memberVO.userpw}</td>
					<td>${memberVO.username}</td>
					<td>${memberVO.email}</td>
					<td>${memberVO.regdate}</td>
					<td>${memberVO.updatedate}</td>
					<td>
					
					<form action="/admin/member/delete" method ="post">
					<input type="submit" value="삭제">
					<input type="text" name ="userid" value="${memberVO.userid}">
					</form>
					
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>