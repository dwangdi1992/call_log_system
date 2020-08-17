<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: RMA
  Date: 8/17/2020
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caller Log</title>
</head>
<body>
<div class="container-fluid">

    <!--Intput table card-->
    <div class="card shadow mb-4">
        <div class="card-body row">
            <div class="col-lg-12">
                <form id="callerLog" method="post" action="<c:url value='/callerLog'/>">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="hidden" name="actionType" value="C" id="actionType"/>


                    <div class="form-group row">
                        <label class="col-md-2 align-right required">Super Zone
                            : </label>

                        <div class="col-md-4">
                            <form:select id="super_zone"
                                         class="form-control editable input-sm" name="supper_zone"
                                         path="superZoneList" required="true">
                                <form:option value="">---Please select---</form:option>
                                <form:options items="${superZoneList}" itemValue="value"
                                              itemLabel="text"/>
                            </form:select>
                        </div>

                        <label class="col-md-2 align-right"> Zone</label>

                        <div class="col-md-3">
                            <form:select id="zone"
                                         class="form-control input-sm" name="zone"
                                         path="zoneList" required="true">
                                <form:option value="">---Please select---</form:option>
                                <form:options items="${zoneList}" itemValue="value"
                                              itemLabel="text"/>
                            </form:select>
                        </div>
                    </div>


                    <div class="form-group row">
                        <label class="col-md-2 align-right">Caller Name
                            : </label>

                        <div class="col-md-4">
                            <input type="text" name="caller_name" id="caller_name"
                                   class="form-control input-sm editable" maxlength="8" minlength="8"
                                   required>
                        </div>

                        <label class="col-md-2 align-right">Contact No
                            : </label>

                        <div class="col-md-3">
                            <input type="text" name="contact_no" id="contact_no"
                                   class="form-control input-sm editable number" maxlength="8" minlength="8"
                                   required>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-md-2 align-right required">Query</label>

                        <div class="col-md-4">
                            <input type="text" name="query" id="query"
                                   class="form-control input-sm editable"
                                   required>
                        </div>

                        <label class="col-md-2 align-right required">Status of Query
                            : </label>

                        <div class="col-md-3">
                            <select name="status" class="form-control">
                                <option value="1">--Please select--</option>
                                <option value="1">Resolved</option>
                                <option value="2">Un Resolved</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2 align-right">Unusual Questions</label>

                        <div class="col-md-6">
                            <input type="text" name="unusual_question" id="unusualQuestion"
                                   class="form-control input-sm editable">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-md-2 align-right required">Call Attended by</label>

                        <div class="col-md-2">
                            <input type="text" name="call_attend_by" id="call_attend_by"
                                   value="${callAttendBy}" readonly
                                   class="form-control input-sm editable">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-md-2 align-right required">Remark</label>

                        <div class="col-md-6">
                            <%--<input type="text"
                                   class="form-control input-sm editable"
                                   >--%>
                            <textarea class="form-control input-sm editable" name="remark" id="remark"
                                      placeholder="comments"></textarea>
                        </div>
                    </div>


                    <div class="form-group ">
                        <%-- <input type="reset" id="btnReset" class="btn btn-primary"
                                value="Reset">
                         <input type="button" id="btnEdit" value="Edit"
                                class="btn btn-primary"
                                disabled>--%>
                        <input type="submit" id="btnSave" value="Save"
                               class="btn btn-primary">
                        <%--<input type="button" id="btnDelete" value="Delete"
                               class="btn btn-primary" disabled>--%>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
