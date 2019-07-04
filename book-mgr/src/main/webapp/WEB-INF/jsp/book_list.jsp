<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书列表</title>
    <%-- c:url 标签的作用：
       1.自动在URL的前面加上context path
       2.如果客户端禁用了Cookie，自动使用URL重写技术，把jsessionid放到url的分号后面
       /taobao/resources/bootstrap/css/bootstrap.css;jsessionid=xxxxx
    --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>

<body>
<header>
    <div class="container">

        <c:forEach items="${requestScope.categories}" var="category">
            <nav>
                <a href="<c:url value="/back?method=toAddBook" />">${category.name}</a>
            </nav>
        </c:forEach>
        <nav>
            <a href="<c:url value="/back?method=getIndex" />">分类</a>
        </nav>

    </div>
</header>
<section class=" banner">
    <div class="container">
        <div>
            <h1>图书</h1> <span style="color: red;">${tip}</span>
            <p>图书分类列表</p>
        </div>
    </div>
</section>
<section class="main">
    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>名称</th>
                <th>创建时间</th>
                <th>最后修改时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.categories}" var="category">
                <tr>
                    <td>${category.name}</td>
                    <td><fmt:formatDate value="${category.createTime}" pattern="yyyy-MM-dd hh:mm"/></td>
                    <td><fmt:formatDate value="${category.updateTime}" pattern="yyyy-MM-dd hh:mm"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<section class="page">
    <div class="container">
        <div id="fatie">
            <a href="<c:url value="/back?method=toAddCategory" />">
                <button>新建</button>
            </a>
        </div>
    </div>
</section>
<footer>
    copy@慕课网
</footer>
</body>
</html>