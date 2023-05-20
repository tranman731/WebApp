<%-- 
    Document   : home
    Created on : Apr 8, 2023, 10:28:02 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Shop</title>
    </head>

    <body>
        <%@include file="./inc/header.jsp" %>


        <div class="container-fluid pt-5">
            <div class="row px-xl-5">
                <!-- Shop Sidebar Start -->
                <div class="col-lg-3 col-md-12">
                    <!-- Price Start -->
                    <div class="border-bottom mb-4 pb-4">
                        <h5 class="font-weight-semi-bold mb-4">Filter by price</h5>
                        <form>
                            <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="checkbox" class="custom-control-input" checked id="price-all">
                                <label class="custom-control-label" for="price-all">All Price</label>
                                <span class="badge border font-weight-normal">1000</span>
                            </div>
                            <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="checkbox" class="custom-control-input" id="price-1">
                                <label class="custom-control-label" for="price-1">$0 - $100</label>
                                <span class="badge border font-weight-normal">150</span>
                            </div>

                        </form>
                    </div>
                    <!-- Price End -->

                    <!-- Color Start -->
                    <div class="border-bottom mb-4 pb-4">
                        <h5 class="font-weight-semi-bold mb-4">Filter by color</h5>
                        <form>
                            <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="checkbox" class="custom-control-input" checked id="color-all">
                                <label class="custom-control-label" for="price-all">All Color</label>
                                <span class="badge border font-weight-normal">1000</span>
                            </div>
                            <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="checkbox" class="custom-control-input" id="color-1">
                                <label class="custom-control-label" for="color-1">Black</label>
                                <span class="badge border font-weight-normal">150</span>
                            </div>

                        </form>
                    </div>
                    <!-- Color End -->

                    <!-- Size Start -->
                    <div class="mb-5">
                        <h5 class="font-weight-semi-bold mb-4">Filter by size</h5>
                        <form>
                            <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="checkbox" class="custom-control-input" checked id="size-all">
                                <label class="custom-control-label" for="size-all">All Size</label>
                                <span class="badge border font-weight-normal">1000</span>
                            </div>
                            <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="checkbox" class="custom-control-input" id="size-1">
                                <label class="custom-control-label" for="size-1">XS</label>
                                <span class="badge border font-weight-normal">150</span>
                            </div>

                        </form>
                    </div>
                    <!-- Size End -->
                </div>
                <!-- Shop Sidebar End -->


                <!-- Shop Product Start -->
                <div class="col-lg-9 col-md-12">
                    <div class="row pb-3">
                        <div class="col-12 pb-1">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <form action="SearchServlet" method="get">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="Search by name">
                                        <div class="input-group-append">
                                            <span class="input-group-text bg-transparent text-primary">
                                                <i class="fa fa-search"></i>
                                            </span>
                                        </div>
                                    </div>
                                </form>
                                <div class="dropdown ml-4">
                                    <button class="btn border dropdown-toggle" type="button" id="triggerId" data-toggle="dropdown" aria-haspopup="true"
                                            aria-expanded="false">
                                        Sort by
                                    </button>
                                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="triggerId">
                                        <a class="dropdown-item" href="#">Latest</a>
                                        <a class="dropdown-item" href="#">Popularity</a>
                                        <a class="dropdown-item" href="#">Best Rating</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:forEach items="${productList}" var="product">
                            <div class="col-lg-4 col-md-6 col-sm-12 pb-1">
                                <div class="card product-item border-0 mb-4">
                                    <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                        <img class="img-fluid w-100" src="${product.image}" alt="">
                                    </div>
                                    <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                        <h6 class="text-truncate mb-3">${product.name}</h6>
                                        <div class="d-flex justify-content-center">
                                            <h6>${product.price}</h6><h6 class="text-muted ml-2"><del>${product.price}</del></h6>
                                        </div>
                                    </div>
                                    <div class="card-footer d-flex justify-content-between bg-light border">
                                        <a href="ProductDetailServlet?productId=${product.id}" class="btn btn-sm text-dark p-0"
                                           ><i class="fas fa-eye text-primary mr-1"></i>View Detail</a
                                        >

                                        <form action="CartServlet?productId=${product.id}" method="post">
                                            <input type="hidden" name="productId" value="${product.id}"/>
                                            <input type="hidden" name="quantity" value="1"/>
                                            <input type="hidden" name="action" value="create"/>
                                            <i class="fas fa-eye text-primary mr-1"> <button type="submit" class="btn btn-sm text-dark p-0">Add to cart</button></i>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>



                    </div>
                </div>
                <!-- Shop Product End -->
            </div>
        </div>
        <!-- Shop End -->



        <%@include file="./inc/footer.jsp" %>

    </body>
</html>



