<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h5 class="text-center text-info p-5">THONG KE DOANH THU THEO SAN PHAM</h5>

<form action="">
    <div class="form-group">
        <input type="text" name="kw" class="form-control" placeholder="Nhập ngành nghề cần thống kê..."/>
    </div>
    <div class="form-group">
        <input type="date" name="fromDate" class="form-control" placeholder="Ngày bắt đầu tìm kiếm..."/>
    </div>
    <div class="form-group">
        <input type="date" name="toDate" class="form-control" placeholder="Ngày kết thúc tìm kiếm..."/>
    </div>
    <input type="submit" value="Bao cao" class="btn btn-success" />
</form>

<div>
  <canvas id="myProductStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Mã ngành nghề</th>
        <th>Tên ngành nghề</th>
        <th>Số lượng bài viết</th>
    </tr>
    <c:forEach items="${productStats}" var="p">
    <tr>
        <td>${p[0]}</td>
        <td>${p[1]}</td>
        <td>${p[2]} VND</td>
    </tr> 
    </c:forEach>
</table>

<script>
    let productLabels=[], productInfo=[]
    <c:forEach items="${productStats}" var="p">
        productLabels.push('${p[1]}')
        productInfo.push(${p[2]})
    </c:forEach>
    
    window.onload = function() {
        productChart("myProductStatsChart", productLabels, productInfo)
    }
</script>