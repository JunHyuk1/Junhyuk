<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul>
	<li>
		<h2>로그인</h2>
	</li>
	
	<form action="login.action">
		<li>
			아이디 : <s:textfield name="mem_id" theme="simple" />
		</li>

		<li>
			비밀번호 : <s:password name="mem_pwd"  />
		</li>

		<li>
			<input name="submit" type="submit" value="작성완료" class="inputb">
		</li>
	</form>
</ul>