<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html> 
    <head>
        <title>Hello</title>
    </head>
    <body>
    <h1>All Employee</h1>
    	<table border="5">
    	<tr>
        <c:forEach var="empAll" items="${empAll}" varStatus="status">
        	<td>
    		   <table border="3">
    		  		<tr>
    		  			<td>EmpNo:</td>
    		  			<td>${empAll.empno}</td>
    		  		</tr>
    		  		<tr>
    		  			<td>Comm:</td>
    		  			<td>${empAll.comm}</td>
    		  		</tr>
    		  		<tr>
    		  			<td>Ename:</td>
    		  			<td>${empAll.ename}</td>
    		  		</tr>
    		  		<tr>
    		  			<td>HireDate:</td>
    		  			<td>${empAll.hiredate}</td>
    		  		</tr>
    		  		<tr>
    		  			<td>Job:</td>
    		  			<td>${empAll.jobno.job_title}</td>
    		  		</tr>	
    		  		<tr>
    		  			<td>Sal:</td>
    		  			<td>${empAll.sal}</td>
    		  		</tr>
    		  		<tr>
    		  			<td>Dept:</td>
    		  			<td>${empAll.deptno.dname}</td>
    		  		</tr>	
    		  		<tr>
    		  			<td colspan="2">
							<form method="post" action="<c:url value='/testView/empUpdatePage' />">
        						<input type="hidden" value="${empAll.empno}" name="empno" />
        						<input type="submit" value="資料修改" />
        					</form>
        					<form method="post" action="<c:url value='/testView/empDelete' />">
        						<input type="hidden" value="${empAll.empno}" name="empno" />
        						<input type="submit" value="刪除" />
        					</form>
        				</td>
        			</tr>
    		  		   		   
    		   </table>
    		 
    		</td>
      		  </c:forEach>
      		</tr>
      	</table>
      	
    </body>
</html>