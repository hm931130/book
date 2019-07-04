<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>

    <!-- //Custom Theme files -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css" rel="stylesheet"
          media="all">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" rel="stylesheet"
          media="all">
    <!-- js -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/js/bootstrap-3.1.1.min.js"></script>
    <!-- //js -->
    <!-- cart -->
    <script src="${pageContext.request.contextPath}/resources/js/simpleCart.min.js"></script>
    <!-- cart -->
    <script type="text/javascript">

    </script>
</head>
<body>
<!--header-->
<div class="header">
    <div class="container">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <h1 class="navbar-brand"><a href="">IMOOC</a></h1>
            </div>
            <!--navbar-header-->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/site?method=getIndex" class="active">首页</a></li>
                    <!-- 此处分类应从数据库中读取 -->
                    <c:forEach items="${categories}" var="category">
                        <li class="dropdown">
                            <a href="${pageContext.request.contextPath}/site?method=getIndex&cid=${category.id}">${category.name}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </nav>


    </div>
    <div class="clearfix"></div>
</div>
</div>
<!--//header-->
<!--banner-->
<div class="banner">
    <div class="container" style="height: 300px">
        <h2 class="hdng">IMOOC <span>图书</span></h2>
        <p>读万卷书，行万里路</p>
        <a href="#">SHOP NOW</a>
        <!--
        <div class="banner-text">
            <img src="../../../images/tushu.jpeg" alt=""/>
        </div>
        -->
    </div>
</div>
<!--//banner-->
<!--gallery-->
<div class="gallery">
    <div class="container">
        <div class="gallery-grids">
            <input type="hidden" name="cid" value="${cid}"/>
            <c:forEach items="${books}" var="book">

                <div class="col-md-3 gallery-grid " style="float:left">
                    <a href="#">
                        <img src="http://localhost:8080/resources/img/${book.imgPath}" class="img-responsive" alt=""/>
                        <div class="gallery-info">
                            <p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> view</p>
                            <a class="shop" href="single.html">SHOP NOW</a>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                    <div class="galy-info">
                        <p style="size: 30px">${book.name}</p>
                        <div class="galry">
                            <div class="prices">
                                <h5 class="item_price">￥${book.price}</h5>
                            </div>
                            <div class="rating">
                                <c:forEach begin="1" end="${book.level}" var="i">
                                    <span>☆</span>
                                </c:forEach>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </c:forEach>


        </div>
        <div align="right">
            共${requestScope.pagehelper.total}条/共${requestScope.pagehelper.pages}页
            <a href="${pageContext.request.contextPath}/site?method=getIndex&num=1&cid=${cid}">首页</a>

            <a href="${pageContext.request.contextPath}/site?method=getIndex&cid=${cid}&num=${requestScope.pagehelper.prePage}">上一页</a>
            <c:forEach items="${requestScope.pagehelper.navigatepageNums}" var="num">
                <a href="${pageContext.request.contextPath}/site?method=getIndex&cid=${cid}&num=${num}">${num}</a>

            </c:forEach>

            <a href="${pageContext.request.contextPath}/site?method=getIndex&cid=${cid}&num=${requestScope.pagehelper.nextPage}">下一页</a>
            <a href="${pageContext.request.contextPath}/site?method=getIndex&cid=${cid}&num=${requestScope.pagehelper.pages}">末页</a>

            跳转到
            <input id="number" type="text" name="hello" size="6">页<input type="button" value="跳转"
                                                                         onclick="changeNumber()"></input>

            <script>
                function changeNumber() {
                    var num = document.getElementById("number").value;
                    //是否是数字  输入的数字一定是整数或者是小于总页数的值
                    window.location.href = "${pageContext.request.contextPath}/site?method=getIndex&cid=${cid}&num=" + num;
                }

            </script>
        </div>
    </div>

</div>
<!--//gallery-->
<!--subscribe-->
<!--//subscribe-->
<!--footer-->
<!--//footer-->
<div class="footer-bottom">
    <div class="container">
        <p>Copyright © 2017 imooc.com All Rights Reserved | 京ICP备 13046642号-2</p>
    </div>
</div>
</body>
</html>