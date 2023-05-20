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
        <title>Cart</title>
    </head>

    <body>
        <%@include file="./inc/header.jsp" %>
        <!-- Cart Start -->
        <div class="container-fluid pt-5">
            <div class="row px-xl-5">
                <div class="col-lg-8 table-responsive mb-5">
                    <table class="table table-bordered text-center mb-0">
                        <thead class="bg-secondary text-dark">
                            <tr>
                                <th>Products</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th>Remove</th>
                            </tr>
                        </thead>
                        <tbody class="align-middle">
                            <c:forEach items="${cart}" var="orderDetailSession">
                                <tr>
                                    <td class="align-middle"><img src="${orderDetailSession.image}" alt="" style="width: 50px;">${orderDetailSession.name}</td>
                                    <td class="align-middle">${orderDetailSession.price}</td>
                                    <td class="align-middle">
                                        <div class="input-group quantity mx-auto" style="width: 100px; ">
                                            <form action="CartServlet" method="post" class="quantity-item">
                                                <input type="hidden" name="productId" value="${orderDetailSession.id}"/>
                                                <input type="hidden" name="action" value="update"/>
                                                <input type="hidden" name="quantity" value="-1"/>

                                                <button type="submit"> - </button>
                                            </form>
                                            <div class="quantity-item" style="margin-left: 10px; margin-right: 10px;text-align: center;">${orderDetailSession.quantity}</div>
                                            <form action="CartServlet" method="post" class="quantity-item">
                                                <input type="hidden" name="productId" value="${orderDetailSession.id}"/>
                                                <input type="hidden" name="action" value="update"/>
                                                <input type="hidden" name="quantity" value="1"/>
                                                <button type="submit"> + </button>
                                            </form>
                                        </div>
                                    </td>
                                    <td class="align-middle">${orderDetailSession.quantity * orderDetailSession.price}</td>
                                    <td class="align-middle">                          
                                        <form action="CartServlet" method="post" class="delete">
                                            <input type="hidden" name="productId" value="${orderDetailSession.id}"/>
                                            <input type="hidden" name="action" value="delete"/>
                                            <button type="submit" class="fa fa-times"></button>
                                        </form>                          
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-4">
                    <form class="mb-5" action="">
                        <div class="input-group">
                            <input type="text" class="form-control p-4" placeholder="Coupon Code">
                            <div class="input-group-append">
                                <button class="btn btn-primary">Apply Coupon</button>
                            </div>
                        </div>
                    </form>
                    <div class="card border-secondary mb-5">
                        <div class="card-header bg-secondary border-0">
                            <h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
                        </div>
                        <div class="card-body">
                            <div class="d-flex justify-content-between mb-3 pt-1">
                                <h6 class="font-weight-medium">Subtotal</h6>
                                <h6 class="font-weight-medium">$${total}</h6>
                            </div>
                            <div class="d-flex justify-content-between">
                                <h6 class="font-weight-medium">Shipping</h6>
                                <h6 class="font-weight-medium">$10</h6>
                            </div>
                        </div>
                        <div class="card-footer border-secondary bg-transparent">
                            <div class="d-flex justify-content-between mt-2">
                                <h5 class="font-weight-bold">Total</h5>
                                <h5 class="font-weight-bold">$${total}</h5>
                            </div>
                            <button class="btn btn-block btn-primary my-3 py-3">
                                <a href="CheckoutServlet">Process to checkout</a>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Cart End -->

        <%@include file="./inc/footer.jsp" %>

    </body>
</html>



