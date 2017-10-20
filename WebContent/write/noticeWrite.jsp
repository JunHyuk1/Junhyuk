<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>NOTICE</h2>

			<html>
			<body>
				<script type="text/javascript">
				      function check_onclick() {
				      var f = document.memberInfo;
				     
				   if(f.name.value == ""){
				            alert("제목을 입력해주십시오.");
				             return false;
				   }
				   else if(f.content.value == ""){
				         	alert("내용을 입력해주십시오.");
				          	return false;
				   }
				   else {
				   alert("작성완료 되었습니다.")
				   f.submit();
				   }  
				   return true;
				}
				   
				</script> 
	<form name="memberInfo" action="admin_noticeWrite.action" method="post" enctype="multipart/form-data" onsubmit="return check_onclick();"> 

	
	<s:hidden name="userReq" value="notice" />
	<s:hidden name="no" value="%{resultClass.no}"/>

	<s:if test="resultClass != NULL">    
		<s:hidden name="modifyReq" value="modifyReq"/> 
	</s:if>

	<ul>
		<c:if test="${sessionScope.mem_lev eq 3}">
		<li>
			제목<s:textarea name="name" theme="simple" value="%{resultClass.name}" />
		</li>
		
		<li>
			내용<s:textarea name="content" theme="simple" value="%{resultClass.content}" />
		</li>
		</c:if>
	</ul>
	
		
			<input name="submit" type="submit" value="작성완료" class="inputb">
		
</form>
</body>
</html>