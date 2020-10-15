<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/inforead.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form role="form" >
	

		<table border="1">
			<tr>
				<td colspan="2"><input type="text" value="${inforead.userid}" style="border :none;" readOnly></td>
			</tr>

			<tr>
				<td colspan="2"><input type="text" value="${inforead.userpw}"style="border :none;"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" value="${inforead.username}"style="border :none;"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" value="${inforead.email}"style="border :none;"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" value="${inforead.regdate}"style="border :none;"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" value="${inforead.updatedate}"style="border :none;"></td>
			</tr>
	
		 	<tr><td style="border :none;"><select name="authority" size=1>
				 <option value=1> ${inforead.authority}</option>
				 <option value=2> ${!inforead.authority}</option>
				</select></td>
			</tr>

			<tr>
				<td colspan="2">
					<button type="submit" class="btn-warning">수정</button>
					<button type="submit" class="btn-danger">삭제</button>
					<button type="submit" class="btn-primary">목록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>