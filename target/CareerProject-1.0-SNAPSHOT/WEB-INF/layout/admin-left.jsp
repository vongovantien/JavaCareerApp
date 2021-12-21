<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar bg-light text-link">

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/cate-stats" />">Thống kê số lượng bài đăng theo ngành nghề</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/date-stats" />">Thống kê bài đăng theo thời điểm</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/year-stats" />">Thống kê số lượng bài viết theo năm</a>
    </li>
  </ul>

</nav>
