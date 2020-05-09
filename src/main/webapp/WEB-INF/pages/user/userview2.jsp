<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/INC/common/head.jsp"></jsp:include>


<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户管理页面 >> 用户信息查看页面</span>
    </div>
    <div class="providerView">
        <p><strong>用户编号：</strong><span>${userview.id}</span></p>
        <p><strong>用户名称：</strong><span>${userview.userName}</span></p>
        <p><strong>用户性别：</strong>
            <c:if test="${userview.gender==1}">
                <input type="radio" name="gender" value="${userview.gender}" checked="checked">男
                <input type="radio" name="gender" value="">女
            </c:if>
            <c:if test="${userview.gender==2}">
                <input type="radio" name="gender" value="${userview.gender}" checked="checked" >男
                <input type="radio" name="gender" value="" >女
            </c:if>
        </p>
        <p><strong>出生日期：</strong>
            <fmt:formatDate value="${userview.creationDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
        </p>

        <p><strong>用户电话：</strong><span>${userview.phone}</span></p>
        <p><strong>用户地址：</strong><span>${userview.address}</span></p>
        <div class="providerAddBtn">
            <a href="${pageContext.request.contextPath}/user/list_jsp" >返回</a>
        </div>
    </div>
</div>
</body>
<jsp:include page="/INC/common/foot.jsp"></jsp:include>
