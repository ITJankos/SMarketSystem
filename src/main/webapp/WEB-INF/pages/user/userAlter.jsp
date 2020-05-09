<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/INC/common/head.jsp"></jsp:include>
<body>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户管理页面 >> 用户信修改页面</span>
    </div>
    <div class="providerView">
    <form action="${pageContext.request.contextPath}/user/update" method="post">
        <input type="hidden" name="id"  value="${userview.id}"/>
        <div>
            <label for="userCode">用户昵称：</label>
            <input type="text" name="userCode" id="userCode" value="${userview.userCode}" >
            <!-- 放置提示信息 -->
            <font color="red"></font>
        </div>
        <div>
            <label for="userName">用户信息：</label>
            <input type="text" name="userName" id="userName" value="${userview.userName}" >
            <!-- 放置提示信息 -->
            <font color="red"></font>
        </div>
        <div>
            <label for="phone">用户电话号码：</label>
            <input type="text" name="phone" id="phone" value="${userview.phone}" >
            <!-- 放置提示信息 -->
            <font color="red"></font>
        </div>
        <div>
            <label for="address">用户地址：</label>
            <input type="text" name="address" id="address" value="${userview.address}" >
            <!-- 放置提示信息 -->
            <font color="red"></font>
        </div>
        <input class="btn btn-primary" type="submit" value="提交" />
        <input class="btn btn-default" type="reset" value="重置" />
    </form>
    </div>
</div>
</body>
<jsp:include page="/INC/common/foot.jsp"></jsp:include>
