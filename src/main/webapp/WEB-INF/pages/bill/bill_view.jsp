<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/assets/js/jquery.min.js"></script>
<jsp:include page="/INC/common/head.jsp"></jsp:include>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>订单管理页面 >> 信息查看</span>
    </div>
    <div class="providerView">
        <p><strong>订单编号：</strong><span>${billView.billCode}</span></p>
        <p><strong>商品名称：</strong><span>${billView.productName}</span></p>
        <p><strong>商品单位：</strong><span>${billView.productUnit}</span></p>
        <p><strong>商品数量：</strong><span>${billView.productCount}</span></p>
        <p><strong>总金额：</strong><span>${billView.totalPrice}</span></p>
        <div class="providerAddBtn">
            <input type="button" id="back" name="back" value="返回">

        </div>
    </div>
</div>
<script>
    $("#back").click(function () {
        window.history.back();
    })
</script>
</section>
<jsp:include page="/INC/common/foot.jsp"></jsp:include>