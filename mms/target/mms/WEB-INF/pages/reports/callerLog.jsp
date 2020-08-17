<%--
  Created by IntelliJ IDEA.
  User: RMA
  Date: 8/17/2020
  Time: 9:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caller Log Report</title>
</head>
<body>

<%-- Loan Detail --%>
<div class="card shadow mb-4" id="loanDetailDiv">
    <div class="card-header py-1">
        <h6 class="m-0 font-weight-bold text-primary">Caller Log Report</h6>
    </div>

    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered css-serial" id="callerLogTbl" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>SL</th>
                    <th>Super Zone</th>
                    <th>Zone</th>
                    <th>contact No</th>
                    <th>call_attend_by</th>
                    <th>Date</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
