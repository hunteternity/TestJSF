<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上傳</title>
</head>
<style>
.AutoNewline {
	word-break: break-all; /*必須*/
}

.greyFont {
	
}
</style>

<body>
	<p>hello</p>
	<c:set var="action">
		<c:url value="/testView/uploadCert" />
	</c:set>
	<form method="post" action="${action }" enctype="multipart/form-data">
		<input name="file" type="file" /> <input type="submit" value="送出" />
	</form>

	<c:if test="${not empty certForm}">
		
		<table width="50%" height="100">
			<tr>
				<td>
					<img height="60" width="80"
						src="<c:url value="/resources/images/image1.jpg" />" />
				</td>
				<td>
					Issued by: ${O }<br/>
					Expires: ${certForm.notAfter }
				</td>
			</tr>
		</table>
		<table width="25%" height="200">
			<tr height="40px" class="grey-Font">
				<td>Subject Name</td>
				<td>-------------------------------------</td>
			</tr>
			<tr>
				<td>Country</td>
				<td>${C}</td>
			</tr>
			<tr>
				<td>Organization</td>
				<td>${O}</td>
			</tr>
			<tr>
				<td>Organization Unit</td>
				<td>${OU}</td>
			</tr>
			<tr>
				<td>Organization Unit</td>
				<td>${CN}</td>
			</tr>
			<tr>
				<td>Common Name</td>
				<td></td>
			</tr>
			<tr>
				<td>Serial Number</td>
				<td>${certForm.serialNumber}</td>
			</tr>
			<tr height="40px">
				<td>Issuer Name</td>
				<td>-------------------------------------</td>
			</tr>
			<tr>
				<td>Country</td>
				<td>${C}</td>
			</tr>
			<tr>
				<td>Organization</td>
				<td>${O}</td>
			</tr>
			<tr>
				<td>Organizational Unit</td>
				<td>政府憑證管理中心</td>
			</tr>
		</table>
	</c:if>

</body>
</html>