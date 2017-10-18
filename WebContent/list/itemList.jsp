<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>ITEM 리스트</h2>

    <s:iterator value="list" status="stat">

    <s:url id="viewURL" action="other_itemView">

        <s:param name="no">
            <s:property value="no" />
        </s:param>

        <s:param name="currentPage">
            <s:property value="currentPage" />
        </s:param>

        <s:param name="userReq"> item </s:param>

    </s:url>

    <s:url id="viewURL2" action="admin_itemOk">

        <s:param name="no">
            <s:property value="no" />
        </s:param>

        <s:param name="currentPage">
            <s:property value="currentPage" />
        </s:param>

        <s:param name="sal_id"> 
            <s:property value="sal_id" />
        </s:param>

    </s:url>

       
    <ul>
        <li>
                <s:property value="img" />
            		<s:property value="no" />
                
                <s:a href="%{viewURL}">
            	   		<s:property value="name" />
                <s:property value="price" />
                <s:property value="item_sum" />
                </s:a>
                <s:property value="cat_no" />
                <s:property value="sal_id" />
             	<c:if test="${sessionScope.mem_lev eq 3}">

                    <s:a href="%{viewURL2}">
                        승인
                    </s:a>
                </c:if>
        </li>
    </ul>
           
    
    </s:iterator>

    <s:property value="pagingHtml" escape="false" />
    