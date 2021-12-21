<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">Hệ thống tuyển dụng việc làm</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
          <a class="nav-link" href="<c:url value="/" />">Trang chu</a>
      </li>
      <c:forEach var="c" items="${categories}">
      <li class="nav-item">
          <c:url value="/" var="catPath">
              <c:param name="CateId" value="${c.id}"></c:param>
          </c:url>
        <a class="nav-link" href="${catPath}">${c.name}</a>
      </li>
      </c:forEach>
      
      <c:if test="${pageContext.request.userPrincipal.name == null}">
      <li class="nav-item">
          <a href="<c:url value="/login" />" class="nav-link text-danger">
              <i class="fa fa-user" aria-hidden="true"></i> Dang nhap
          </a>
      </li>
      <li class="nav-item">
          <a href="<c:url value="/register" />" class="nav-link text-danger">
              <i class="fa fa-check" aria-hidden="true"></i> Dang ky
          </a>
      </li>
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name != null}">
      <li class="nav-item">
          <a href="<c:url value="/" />" class="nav-link text-success">
              <c:if test="${currentUser.avatar != null}">
                    <img style="width:30px;" src="${currentUser.avatar}" class="rounded-circle" />
              </c:if>
              <c:if test="${currentUser.avatar == null}">
                    <i class="fa fa-user" aria-hidden="true"></i>
              </c:if>
              
              ${pageContext.request.userPrincipal.name}
          </a>
      </li>
      <li class="nav-item">
          <a href="<c:url value="/logout" />" class="nav-link text-success">
              Dang xuat
          </a>
      </li>
      </c:if>
      
      <li class="nav-item">
          <a href="<c:url value="/cart" />" class="nav-link text-success">
              <i class="fas fa-cart-plus"></i>
              <div class="badge badge-danger" id="cartCounter">${cartCounter}</div>
          </a>
      </li>
    </ul>
    <form class="form-inline" action="<c:url value="/" />">
        <input class="form-control mr-sm-2" name="kw" type="text" placeholder="Nhap tu khoa...">
        <button class="btn btn-success" type="submit">Tim</button>
    </form>
  </div>
</nav>
