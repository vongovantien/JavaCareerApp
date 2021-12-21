<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<p class="text-center text-info p-5">Thống kê số lượng theo tháng của năm</h1>

<form action="">
    <div class="form-group">
        <input type="text" name="year" class="form-control" placeholder="Nhập năm cần thống kê..."/>
    </div>
    <input type="submit" value="Tìm kiếm" class="btn btn-success" />
</form>

<div>
  <canvas id="myProductMonthStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Số lượng bài viết</th>
    </tr>
    <c:forEach items="${productMonthStats}" var="p">
    <tr>
        <td>${p[0]}/${p[1]}</td>
        <td>${p[2]} VND</td>
    </tr> 
    </c:forEach>
</table>

<script>
    let productLabels=[], productInfo=[]
    <c:forEach items="${productMonthStats}" var="p">
        productLabels.push('${p[0]}/${p[1]}')
        productInfo.push(${p[2]})
    </c:forEach>
    
    window.onload = function() {
        productChart("myProductMonthStatsChart", productLabels, productInfo)
    }
</script>
