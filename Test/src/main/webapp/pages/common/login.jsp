<%@ page contentType="text/html;charset=UTF-8"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
a {
	color: black;
	text-decoration: none;
}

a:hover {
	font-weight: 900;
	color: blue;
	text-decoration: underline;
}

a:active {
	color: red;
	text-decoration: underline;
}

.acc_enable {
	color: black;
	border-bottom: solid 2px #638eb5;
}

.acc_disable {
	color: gray;
}
</style>
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="expires" content="0" />
<title>戶役政開發環境 — 登入</title>
</head>
<body style="text-align: center;">


	<%
	    String version = "";
	    String sysId = "N/A";
	    String sysTitle = "";
	    String errmsg = "";
	    try {
	        if (request.getParameter("error") != null) {
	            Object exc = session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
	            if (exc != null) {
	                errmsg = ((Exception) exc).getMessage();
	                // ((Exception) exc).printStackTrace();
	                if (errmsg == null) {
	                    errmsg = "null";
	                } else if (errmsg.equals("Bad credentials")) {
	                    errmsg = "帳號或密碼錯誤";
	                }
	            }
	        }
	    } catch (Exception e) {
	        errmsg = e.getMessage();
	        e.printStackTrace();
	    }
	%>

	<center>
		<div style="margin: 1em;">
			<h2>
				<a href="/">強化戶役政資訊系統與應用推廣計畫 資料查詢工具</a>
			</h2>
		</div>
		<hr />
		<form method="POST" action="<%=request.getContextPath()%>/faces/pages/j_spring_security_check">
			<table style="width: 300px; text-align: left;">
				<tr>
					<td style="vertical-align: top; padding-bottom: 1.5em;">
						<table class="form-noindent" width="100%" style="border: solid 1px #638eb5; background-color: #c5dbff;">
							<tr>
								<td style="border: solid 1px #638eb5; padding: 0.7em; text-align: center; background-color: #f5dbff;" colspan="2">登入帳號</td>
							</tr>
							<tr>
								<td width="35%" style="padding-left: 1.5em; padding-top: 1.2em; text-align: right;">帳號：</td>
								<td width="65%" style="padding-right: 2.5em; padding-top: 1.2em; text-align: left;"><input name="j_username" type="text"
									value="" style="width: 90%;"></input></td>
							</tr>
							<tr>
								<td style="padding-left: 1.5em; text-align: right;">密碼：</td>
								<td style="padding-right: 2.5em; text-align: left;"><input name="j_password" type="password" value="" style="width: 90%;"></input></td>
							</tr>
							<tr>
								<td colspan="2" style="text-align: center; padding-top: 1.5em; padding-bottom: 1.2em;"><input type=submit value="登入"></input> <input
									type=reset value="重設"></input>
									<p><%=version%></p></td>
							</tr>
							<tr>
								<td colspan="2" style="text-align: center;">
									<p style="color: red; font-weight: bold;"><%=errmsg%></p>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="height: 3em;"></td>
				</tr>

			</table>
		</form>
	</center>
</body>
</html>


