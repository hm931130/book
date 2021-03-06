<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新建</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/book/list.do">
                慕课网图书管理
            </a>
        </div>
    </div>
</nav>
<div class="container">
    <div class="jumbotron">
        <h1>Hello,Admin!</h1>
        <p>请小心的新增图书记录，要是建了一个错误的就不好了。。。</p>
    </div>
    <div class="page-header">
        <h3>
            <small>新建</small>
        </h3>
    </div>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/back?method=addBook" method="post"
          enctype="multipart/form-data">

        <!-- 保留分类id -->

        <div id="content">
            <input type="hidden" name="cid" value="${cid}"/>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">名称 ：</label>
                <div class="col-sm-8">
                    <input type="text" name="name" class="form-control" id="name">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">分类 ：</label>
                <select name="categoryId" class="col-sm-2 form-control" style="width: auto">
                    <!-- 此处数据需要从数据库中读取 -->
                    <c:forEach items="${requestScope.categories}" var="category">

                        <c:if test="${cid==category.id}">
                            <option id="${category.id}" value="${category.id}"
                                    selected="selected">${category.name}</option>
                        </c:if>

                        <c:if test="${cid!=category.id}">
                            <option id="${category.id}" value="${category.id}">${category.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">星级 ：</label>
                <select name="level" id="level" class="col-sm-2 form-control" style="width: auto">
                    <option id="1" value="1">1星</option>
                    <option id="2" value="2">2星</option>
                    <option id="3" value="3">3星</option>
                    <option id="4" value="4">4星</option>
                    <option id="5" value="5">5星</option>
                </select>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">价格 ：</label>
                <div class="col-sm-8">
                    <input name="price" type="number" class="form-control" id="price">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">图片 ：</label>
                <div class="col-sm-8">
                    <input name="smallImg" id="smallImg" class="file-loading"
                           type="file" multiple accept=".jpg,.jpeg,.png" data-min-file-count="1"
                           data-show-preview="true">
                </div>
            </div>

        </div>
        <div align="right">
            <button type="button" onclick="addContent()" class="btn btn-primary">增加</button>&nbsp;&nbsp;&nbsp;
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
    </form>
</div>
<footer class="text-center">
    copy@imooc
</footer>
<script type="text/javascript">
    var index = 1;

    function addContent() {
        var html =
            '           <h5 class="page-header"></h5>\n' +
            '            <input type="hidden" name="cid" value="${cid}"/>\n' +
            '           <div id="_div_"' + index + '>\n' +
            '               <div class="form-group">\n' +
            '                    <label for="name" class="col-sm-2 control-label">名称 ：</label>\n' +
            '                    <div class="col-sm-8">\n' +
            '                        <input name="name" class="form-control" id="name">\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '                <div class="form-group">\n' +
            '                    <label class="col-sm-2 control-label">分类 ：</label>\n' +
            '                    <select id= "categoryId" name="categoryId" class="col-sm-2 form-control" style="width: auto">\n' +
            '                        <c:forEach var="item" items="${categories}">\n' +
            '                            <option id="${item.id}" value="${item.id}">${item.name}</option>\n' +
            '                        </c:forEach>\n' +
            '                    </select>\n' +
            '                </div>\n' +
            '                <div class="form-group">\n' +
            '                    <label class="col-sm-2 control-label">星级 ：</label>\n' +
            '                    <select name="level" id="level" class="col-sm-2 form-control" style="width: auto">\n' +
            '                        <option id="1" value="1">1星</option>\n' +
            '                        <option id="2" value="2">2星</option>\n' +
            '                        <option id="3" value="3">3星</option>\n' +
            '                        <option id="4" value="4">4星</option>\n' +
            '                        <option id="5" value="5">5星</option>\n' +
            '                    </select>\n' +
            '                </div>\n' +
            '                <div class="form-group">\n' +
            '                    <label class="col-sm-2 control-label">价格 ：</label>\n' +
            '                    <div class="col-sm-8">\n' +
            '                        <input name="price" type="number" class="form-control" id="price">\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '                <div class="form-group">\n' +
            '                    <label class="col-sm-2 control-label">图片 ：</label>\n' +
            '                    <div class="col-sm-8">\n' +
            '                        <input name="smallImg" id="smallImg" class="file-loading"\n' +
            '                               type="file" multiple accept=".jpg,.jpeg,.png" data-min-file-count="1"\n' +
            '                               data-show-preview="true">\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '             </div>\n';

        var newDiv = document.createElement('div');
        newDiv.id = '_' + index++;
        newDiv.innerHTML = html;
        document.getElementById('content').appendChild(newDiv);
    }
</script>
</body>
</html>
