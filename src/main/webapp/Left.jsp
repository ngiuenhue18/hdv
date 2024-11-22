

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${listC}" var="o">
                <li class="list-group-item text-white ${markup == o.category ? "active" : ""}"><a href="Category?catalogue=${o.category}">${o.category}</a></li>
            </c:forEach>

        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Sản phẩm mới nhất</div>
        <div class="card-body">
            <img class="img-fluid" src="${lastSP.product_img}" />
            <h5 class="card-title">${lastSP.product_name}</h5>
            <p class="card-text">${lastSP.product_description}</p>
            <p class="bloc_left_price">${lastSP.product_price.intValue()} VNĐ</p>
        </div>
    </div>
</div>