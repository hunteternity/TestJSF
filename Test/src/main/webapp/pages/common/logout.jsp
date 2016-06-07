
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="refresh" content="3; url=/AGLogout" />
<title>Clear Sessions</title>
</head>
<body onload="doCookie();">
	Clearing sessions...
	<script type="text/javascript">
		function doCookie() {
			var cookieName = "JSESSIONID"; // set this to the session cookie name
			var cookiePath = "/IDM"; // set this to the path of the session cookie
			var now = new Date(); // creates a new date object
			now.setTime(now.getTime() - 1); // sets the date to the past
			document.cookie = cookieName + "=x; expires=" + now + "; path="
					+ cookiePath;
		}
	</script>
</body>
</html>
