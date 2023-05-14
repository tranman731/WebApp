<%-- 
    Document   : home
    Created on : Apr 8, 2023, 10:28:02 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="./inc/header.jsp" %>

<div class="container-fluid pt-5">
    <div class="row px-xl-5 pb-3">
        <div class="col-md-12" style="text-align: center">
            <h1>Category</h1>
        </div>
    </div>
</div>

<!-- Categories Start -->
<div class="container-fluid pt-5">
    <div class="row px-xl-5 pb-3">
        <c:forEach items="${categoryList}" var="category">
        <div class="col-lg-4 col-md-6 pb-1">
            <div
                class="cat-item d-flex flex-column border mb-4"
                style="padding: 30px"
                >
                <p class="text-right">15 Products</p>
                <a href="CategoryServlet?categoryId=${category.id}" class="cat-img position-relative overflow-hidden mb-3">
                    <img class="img-fluid" src="${category.image}" alt="" />
                </a>
                <h5 class="font-weight-semi-bold m-0">${category.name}</h5>
            </div>
        </div>
      
        </c:forEach>
    </div>
</div>
<!-- Categories End -->

<!-- Products Start -->
<div class="container-fluid pt-5">
    <div class="text-center mb-4">
        <h2 class="section-title px-5">
            <span class="px-2">Trandy Products</span>
        </h2>
    </div>
    <div class="row px-xl-5 pb-3">
  <c:forEach items="${productList}" var="product">
        <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="card product-item border-0 mb-4">
                    <div
                        class="card-header product-img position-relative overflow-hidden bg-transparent border p-0"
                        >
                        <img class="img-fluid w-100" src="${product.image}" alt="" />
                    </div>
                    <div
                        class="card-body border-left border-right text-center p-0 pt-4 pb-3"
                        >
                        <h6 class="text-truncate mb-3">${product.name}</h6>
                        <div class="d-flex justify-content-center">
                            <h6>${product.price}</h6>
                            <h6 class="text-muted ml-2"><del>${product.price}</del></h6>
                        </div>
                    </div>
                    <div
                        class="card-footer d-flex justify-content-between bg-light border"
                        >
                        <a href="ProductDetailServlet?productId=${product.id}" class="btn btn-sm text-dark p-0"
                           ><i class="fas fa-eye text-primary mr-1"></i>View Detail</a
                        >
                        <a href="" class="btn btn-sm text-dark p-0"
                           ><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To
                            Cart</a
                        >
                    </div>

                </div>      
        </div>
  </c:forEach>
    </div>

</div>
<!-- Products End -->

<!-- Products Start -->
<div class="container-fluid pt-5">
    <div class="text-center mb-4">
        <h2 class="section-title px-5">
            <span class="px-2">Just Arrived</span>
        </h2>
    </div>
    <div class="row px-xl-5 pb-3">
         <c:forEach items="${productList}" var="product">
        <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="card product-item border-0 mb-4">
                    <div
                        class="card-header product-img position-relative overflow-hidden bg-transparent border p-0"
                        >
                        <img class="img-fluid w-100" src="${product.image}" alt="" />
                    </div>
                    <div
                        class="card-body border-left border-right text-center p-0 pt-4 pb-3"
                        >
                        <h6 class="text-truncate mb-3">${product.name}</h6>
                        <div class="d-flex justify-content-center">
                            <h6>${product.price}</h6>
                            <h6 class="text-muted ml-2"><del>${product.price}</del></h6>
                        </div>
                    </div>
                    <div
                        class="card-footer d-flex justify-content-between bg-light border"
                        >
                        <a href="ProductDetailServlet?productId=${product.id}" class="btn btn-sm text-dark p-0"
                           ><i class="fas fa-eye text-primary mr-1"></i>View Detail</a
                        >
                        <a href="" class="btn btn-sm text-dark p-0"
                           ><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To
                            Cart</a
                        >
                    </div>

                </div>      
        </div>
  </c:forEach>
        
    </div>
</div>
<!-- Products End -->

<%@include file="./inc/footer.jsp" %>

</body>
</html>



