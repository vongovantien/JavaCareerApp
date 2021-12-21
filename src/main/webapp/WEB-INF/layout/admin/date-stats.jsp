<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h5 class="text-center text-info p-5">Thống kê bài viết theo thời điểm</h1>

<form action="<c:url value="/admin/report/" />">
    <div class="form-group">
        <input type="date" name="fromDate" placeholder="Ngày bắt đầu tìm kiếm..." class="form-control" />
    </div>
    <div class="form-group">
        <input type="date" name="endDate" placeholder="Ngày kết thúc tìm kiếm..." class="form-control" />
    </div>
    <input type="submit" value="Bao cao" class="btn btn-info" />
</form>

<div>
  <canvas id="myChart"></canvas>
</div>
<table class="table">
    <tr>
        <th>Mã ngành nghề</th>
        <th>Tên ngành nghề</th>
        <th>Số lượng bài viết</th>
    </tr> 
    <c:forEach items="${stats}" var="s">
    <tr>
        <td>${s[0]}</td>
        <td>${s[1]}</td>
        <td>${s[2]}</td>
    </tr>
    </c:forEach>
</table>

<script>
    let amounts = []
    let labels = []
    let colors = []
    <c:forEach items="${stats}" var="s">
        amounts.push(${s[2]})
        labels.push('${s[1]}')
        
        var r = parseInt(Math.random()*255)
        var g = parseInt(Math.random()*255)
        var b = parseInt(Math.random()*255)
        colors.push("rgba("+r+"," +g+","+b+", 0.2)")
    </c:forEach>
        
    window.onload = function() {
        
//        const labels = [1, 2, 3, 4, 5, 6, 7];
        const data = {
          labels: labels,
          datasets: [{
            label: 'Thong ke doanh thu theo san pham',
            data: amounts, //[65, 59, 80, 81, 56, 55, 40],
            backgroundColor: colors, 
//            [
//              'rgba(255, 99, 132, 0.2)',
//              'rgba(255, 159, 64, 0.2)',
//              'rgba(255, 205, 86, 0.2)',
//              'rgba(75, 192, 192, 0.2)',
//              'rgba(54, 162, 235, 0.2)',
//              'rgba(153, 102, 255, 0.2)',
//              'rgba(201, 203, 207, 0.2)'
//            ],
            borderColor: [
              'rgb(255, 99, 132)',
              'rgb(255, 159, 64)',
              'rgb(255, 205, 86)',
              'rgb(75, 192, 192)',
              'rgb(54, 162, 235)',
              'rgb(153, 102, 255)',
              'rgb(201, 203, 207)'
            ],
            borderWidth: 1
          }]
        };
        
        const config = {
            type: 'line',
            data: data,
            options: {
              scales: {
                y: {
                  beginAtZero: true
                }
              }
            },
          };
        
        var myChart = new Chart(
            document.getElementById('myChart'),
            config
          );
    }
</script>