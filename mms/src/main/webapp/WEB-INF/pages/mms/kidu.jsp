<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: RMA
  Date: 6/29/2020
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kidu</title>
</head>
<body>

<div class="container-fluid">

    <!--Intput table card-->
    <div class="card shadow mb-4">
        <div class="card-body row">
            <div class="col-lg-6">
                <form method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <label for="company">Search by company</label>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="Enter company" id="company">
                        <div class="input-group-append">
                            <button class="btn btn-primary" id="btnSearch" type="button">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%-- Loan Detail --%>
    <div class="card shadow mb-4" id="loanDetailDiv">
        <div class="card-header py-1">
            <h6 class="m-0 font-weight-bold text-primary">Kidu Detail</h6>
        </div>

        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered css-serial" id="kiduTbl" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>CID</th>
                        <th>Name</th>
                        <th>Occupation</th>
                        <th>Company name</th>
                        <th>Sector</th>
                        <th>Total Kidu</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
