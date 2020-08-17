<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication var="auth" property="principal"/>
<c:url value="/logout" var="logoutUrl"/>

<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Caller Log System</title>
</head>
<body>

<%--<div class="container-fluid">

    <div class="row">

        <!-- Content Column -->
        <div class="col-lg-6 mb-4">

            <div class="card shadow mb-4">
                <!-- Card Body -->
                <div class="card-body">
                    <div id="deposit_by_bank" style="height: 300px; width: 100%;"></div>
                </div>
            </div>
        </div>

        <div class="col-lg-6 mb-4">
            <div class="card shadow mb-4">
                <div class="card-body">
                    <div id="total_amount" style="height: 300px; width: 100%;"></div>
                </div>
            </div>
        </div>
    </div>


    <!--Intput table card-->
    <div class="card shadow mb-4">
        <div class="card-body row">
            <div class="col-lg-6">
                <form method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="form-group">
                        <label for="keyword">Search By</label>
                        <input type="text" class="form-control" name="keyword" maxlength="11"
                               id="keyword" required="true" placeholder="Enter CID/TPN/LicenseNo">
                    </div>

                    <button type="button" class="btn btn-primary" id="btnSearch">Search</button>
                </form>
            </div>

            <div class="col-lg-6">
                <label>Personal Information.</label><br>
                CID No. <span id="cidNo"></span><br>
                Name: <span id="name"></span><br>
                Dzongkhag: <span id="dzongkhag"></span><br>
                Gewog: <span id="gewog"></span><br>
                Village: <span id="village"></span><br>
            </div>
        </div>
    </div>

    &lt;%&ndash; Loan Detail &ndash;%&gt;
    <div class="card shadow mb-4" hidden id="loanDetailDiv">
        <div class="card-header py-1">
            <h6 class="m-0 font-weight-bold text-primary">Loan Detail</h6>
        </div>

        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered css-serial" id="loanDetailTbl" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Loan Account No</th>
                        <th>Sector</th>
                        <th>Sanction Date</th>
                        <th>Outstanding</th>
                        <th>Interest Waiver</th>
                        <th>FSPs</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    &lt;%&ndash; Deposit Detail &ndash;%&gt;
    <div class="card shadow mb-4" hidden id="depositDetailDiv">
        <div class="card-header py-1">
            <h6 class="m-0 font-weight-bold text-primary">Deposit Detail</h6>
        </div>

        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered css-serial" id="depositDetailTbl" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>CID</th>
                        <th>Deposit Type</th>
                        <th>Amount</th>
                        <th>FSPs</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    &lt;%&ndash; Working capital &ndash;%&gt;
    <div class="card shadow mb-4" hidden id="workingCapitalDiv">
        <div class="card-header py-1">
            <h6 class="m-0 font-weight-bold text-primary">Working Capital</h6>
        </div>

        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered css-serial" id="workingCapitalTbl" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Account No</th>
                        <th>Sector Type</th>
                        <th>Sanction Date</th>
                        <th>Sanction Amount</th>
                        <th>Outstanding</th>
                        <th>FSPs</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    &lt;%&ndash; Druk Gyelpo Kidu Recipient(dgk) &ndash;%&gt;
    <div class="card shadow mb-4" hidden id="dgkDiv">
        <div class="card-header py-1">
            <h6 class="m-0 font-weight-bold text-primary">Druk Gyelpo Kidu Recipient</h6>
        </div>

        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered css-serial" id="dgkTbl" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>CID/TPN/LicenseNo</th>
                        <th>Occupation</th>
                        <th>Sector</th>
                        <th>Name of company</th>
                        <th>Total Kidu</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    &lt;%&ndash; Land information&ndash;%&gt;
    <div class="card shadow mb-4" hidden id="landInfoDiv">
        <div class="card-header py-1">
            <h6 class="m-0 font-weight-bold text-primary">Land information</h6>
        </div>

        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered css-serial" id="landInfoTbl" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>CID/TPN/LicenseNo</th>
                        <th>Name</th>
                        <th>Urban-Rural</th>
                        <th>Thram No</th>
                        <th>Land Type</th>
                        <th>Ownership</th>
                        <th>Size</th>
                        <th>Plot Id</th>
                        <th>Gewog/Thromde</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    &lt;%&ndash; vehicle Information &ndash;%&gt;
    <div class="card shadow mb-4" hidden id="vehicleInfoDiv">
        <div class="card-header py-1">
            <h6 class="m-0 font-weight-bold text-primary">Vehicle Information</h6>
        </div>

        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered css-serial" id="vehicleInfoTbl" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>CID/TPN/LicenseNo</th>
                        <th>Name</th>
                        <th>Registration No</th>
                        <th>Ownership</th>
                        <th>Engine Number</th>
                        <th>Type</th>
                        <th>Expiry Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>--%>


<!-- /.container-fluid -->
<%--<script src="<c:url value='/resources/js/financialInfo.js'/>"></script>--%>
</body>
</html>






