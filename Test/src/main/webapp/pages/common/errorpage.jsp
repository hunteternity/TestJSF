<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>戶役資訊服務網</title>
</head>
<body style="text-align: center;">
	<%
	    String errmsg = "";

	    errmsg = ((Exception) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION")).getMessage();
	%>

	<center>
		<div style="margin: 3em;">
			<h2>戶役政資訊服務網</h2>
		</div>
		<hr />
		<div align="center" class="loginBox" style="margin-top: 5em;">
			<table style="width: 800px; text-align: left;">
				<tr>
					<td style="padding-right: 1em;" width="60%">
						<div style="padding-left: 2.5em; margin-bottom: 3em;">
							<h3>
								<center>
									<font color="red">登入失敗</font><br /> <font color="red">原因：<%=errmsg%></font>
									<br />
									<font color="blue">回Protal：</font>
								</center>
							</h3>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</center>
</body>
</html>


