<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/23
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="/css/public.css"/>
    <%-- <link href="/assets/css/bootstrap.min.css" rel="stylesheet">--%>
    <script type="text/javascript" src="/assets/js/jquery.min.js"></script>
</head>
<script>
    // 获取当前准确时间
    function getNowTime() {
        let date = new Date();
        let year = date.getFullYear();
        let month = date.getMonth()+1;
        let day = date.getDate();
        let hours = date.getHours();
        let minutes = date.getMinutes();
        let seconds = date.getSeconds();
        let days = date.getDay();
        switch(days) {
            case 0:
                days = '星期日';
                break;
            case 1:
                days = '星期一';
                break;
            case 2:
                days = '星期二';
                break;
            case 3:
                days = '星期三';
                break;
            case 4:
                days = '星期四';
                break;
            case 5:
                days = '星期五';
                break;
            case 6:
                days = '星期六';
                break;
        }
        var str = year+"年"+buchong(month)+"月" + buchong(day) + "日 "+
            buchong(hours) + ":"+ buchong(minutes) + ":"+ buchong(seconds) + " " +
            days;
// 填充指定位置
        $("#time").html(str)
    }
    // 对时间数字补0
    function buchong(str){
        if(str<=9){
            return "0"+str;
        }else {
            return str;
        }
    }
    window.setInterval(getNowTime,1000)
</script>

<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市订单管理系统</h1>
    <div class="publicHeaderR">
        <p><span>${login_user.userName}</span><span>下午好！</span><span style="color: #fff21b"> </span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/user/logout">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="${pageContext.request.contextPath }/bill/findAll">订单管理</a></li>
                <li><a href="${pageContext.request.contextPath }/provider/findAllByPage">供应商管理</a></li>
                <li><a href="${pageContext.request.contextPath }/user/findAll">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath }/user/topwd">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath }/user/logout">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <input type="hidden" id="path" name="path" value=""/>
    <input type="hidden" id="referer" name="referer" value="null"/>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/role/findAll",
                dataType: "json",
                success:function(data){
                    var str="";
                    for(var role of data) {
                        str += '<option value="' + role.id + '">--'+ role.roleName+'--</option>';
                    }
                    //追加到指定位置
                    $("#queryUserRole").append(str);
                    $("#queryUserRole").val($("#roleid").val())
                }
            })
        })
    </script>

    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面</span>
        </div>
        <div class="search">
            <form id="queryForm" method="post" action="/user/findAll">
                <span>用户名：</span>
                <input name="userName" class="input-text" type="text" value="${userName}">
                <input type="hidden" id="roleid" value="${roleId}"/>
                <span>用户角色：</span>
                <select id="queryUserRole" name="role.id">
                    <option value="0">--请选择--</option>
                </select>

                <input type="hidden" id="pageNo" name="pageNo" value="1"/>
                <input value="查 询" type="submit" id="searchbutton">
                <a href="${pageContext.request.contextPath}/user/toUserAddPage">添加用户</a>
            </form>
        </div>
        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">用户编码</th>
                <th width="20%">用户名称</th>
                <th width="10%">性别</th>
                <th width="10%">生日</th>
                <th width="10%">电话</th>
                <th width="10%">用户角色</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach items="${pageBean.list}" var="user">
                <tr>
                    <td>
                        <span>${user.userCode}</span>
                    </td>
                    <td>
                        <span>${user.userName}</span>
                    </td>
                    <td>
							<span>
                                    ${user.gender}
                            </span>
                    </td>
                    <td>
						<span>
                                ${user.birthday}
                        </span>
                    </td>
                    <td>
                        <span>${user.phone}</span>
                    </td>
                    <td>
                        <span>${user.role.roleName}</span>
                    </td>
                    <td>
                        <span><a href="/user/userview/?id=${user.id}"><img src="/images/read.png" alt="查看" title="查看"/></a></span>
                        <span><a href="/user/toUpdate/?id=${user.id}"><img src="/images/xiugai.png" alt="修改" title="修改"/></a></span>
                        <span><a class="deleteUser" href="/user/toDelete/?id=${user.id}" onclick="return confirm('真的删除吗？')"><img src="/images/schu.png" alt="删除" title="删除"/></a></span>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <input type="hidden" id="totalPageCount" value=""/>
        【当前第${pageBean.pageNum}页 / 共${pageBean.totalPage}页】
        <div class="pageNum">
            <ul>
                <c:if test="${pageBean.pageNum==1}">
                    <li class="disabled"><a href="#">首页</a></li>
                    <li class="threeword disabled"><a href="#">上一页</a></li>
                </c:if>
                <c:if test="${pageBean.pageNum>1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/user/findAll?pageNum=1&pageSize=${pb.pageSize}">首页</a>
                    </li>
                    <li class="threeword"><a
                            href="${pageContext.request.contextPath}/user/findAll?pageNum=${pb.pageNum-1}&pageSize=${pb.pageSize}">上一页</a>
                    </li>
                </c:if>

                &lt;%&ndash;循环遍历每一页按钮&ndash;%&gt;
                <c:forEach begin="${pageBean.begin}" end="${pageBean.end}" var="currentPage">
                    <c:if test="${pageBean.pageNum==currentPage}">
                        <li class="btn-primary"><a
                                href="${pageContext.request.contextPath}/user/findAll?pageNum=${currentPage}&pageSize=${pb.pageSize}">${currentPage}</a>
                        </li>
                    </c:if>
                    <c:if test="${pageBean.pageNum!=currentPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/user/findAll?pageNum=${currentPage}&pageSize=${pb.pageSize}">${currentPage}</a>
                        </li>
                    </c:if>
                </c:forEach>

                <c:if test="${pageBean.pageNum==pagepage}">
                    <li class="threeword disabled"><a href="#">下一页</a></li>
                    <li class="threeword disabled"><a href="#">末页</a></li>
                </c:if>
                <c:if test="${pageBean.pageNum !=pagepage}">
                    <li class="threeword"><a
                            href="${pageContext.request.contextPath}/user/findAll?pageNum=${pageBean.pageNum+1}&pageSize=${pageBean.pageSize}">下一页</a>
                    </li>
                    <li class="threeword"><a
                            href="${pageContext.request.contextPath}/user/findAll?pageNum=${pageBean.totalPage}&pageSize=${pageBean.pageSize}">末页</a>
                    </li>
                </c:if>

            </ul>
        </div>

    </div>
</section>


<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>


<footer class="footer">
    &copy;2017
</footer>
<script type="text/javascript" src="/js/time.js"></script>
<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/calendar/WdatePicker.js"></script>
</body>
</html>
<script>

</script>