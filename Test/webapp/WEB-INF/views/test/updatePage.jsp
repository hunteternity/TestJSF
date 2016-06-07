<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 使用 jQuery -->
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/themes/hot-sneaks/jquery-ui.css" rel="stylesheet">
 
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
 
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
<html> 
    <head>
        <title>Hello</title>
    </head>
    <body>
    
    <c:set var="action" >
    	<c:url value='/testView/empUpdate' />
    </c:set>	
    <h1>Update Employee Data</h1>
    	<form:form modelAttribute="empForm" method="post" action="${action }">
    		   <form:hidden path="empno" />
    		   <table border="5">
    		  		<tr>
    		  			<td>EmpNo:</td>
    		  			<td><form:input path="empno" /></td>
    		  		</tr>
    		  		<tr>
    		  			<td>Comm:</td>
    		  			<td><form:input path="comm" /></td>
    		  		</tr>
    		  		<tr>
    		  			<td>Ename:</td>
    		  			<td><form:input path="ename" /></td>
    		  		</tr>
    		  		<tr>
    		  			<td>HireDate:</td>
    		  			<td><form:input path="hiredate" id="dateChooser" readonly="true"/></td>
    		  		</tr>
    		  		<tr>
    		  			<td>Job:</td>
    		  			<td>
    		  				<form:select path="jobno">
    		  					<form:options items="${jobAll}" itemLabel="job_title" itemValue="jobno" />
    		  				</form:select>
    		  			</td>
    		  		</tr>	
    		  		<tr>
    		  			<td>Sal:</td>
    		  			<td><form:input path="sal" name="sal" /></td>
    		  		</tr>   
    		  		<tr>
    		  			<td>Dept:</td>
    		  			<td>
    		  				<form:select path="deptno">
    		  					<form:options items="${deptAll}" itemLabel="dname" itemValue="deptno" />
    		  				</form:select>
    		  			</td>
    		  		</tr>  		   
    		   </table>
    		   <input type="submit" value="修改">
    		   
    		   </form:form>
    		   <br>
   	<script language="JavaScript">
        
        $(document).ready(function(){ 
          $.datepicker.regional['zh-TW']={
            dayNames:["星期日","星期一","星期二","星期三","星期四","星期五","星期六"],
            dayNamesMin:["日","一","二","三","四","五","六"],
            monthNames:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
            monthNamesShort:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
            prevText:"上月",
            nextText:"次月",
            weekHeader:"週"
            };
          $.datepicker.setDefaults($.datepicker.regional["zh-TW"]);
          $("#dateChooser").datepicker({changeYear: true, changeMonth: true});
          });
      </script>
    </body>
</html>