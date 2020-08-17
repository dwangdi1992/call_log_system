<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/19/2020
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<%--navbar-nav bg-gradient-primary sidebar sidebar-dark accordion--%>
<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
    id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<c:url value="/home"/>">
        <div class="sidebar-brand-icon">
            <i class="glyphicon glyphicon-dashboard"></i>
        </div>

        <div class="sidebar-brand-text mx-3"><i class="fa fa-home"></i>&nbsp;HOME</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse"
           data-target="#collapseTwo" aria-expanded="true"
           aria-controls="collapseTwo">
            <i class="fas fa-fw fa-cog"></i>
            <span class="sidebar-brand-text">Admin Panel</span>
        </a>

        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="py-2 collapse-inner rounded">
                <h6 class="collapse-header text-white">Admin Panel</h6>

                <security:authorize access="hasAuthority('01-01-001-VIEW')">
                    <a class="collapse-item" href="<c:url value="/groupSetup"/>">Group setup</a>
                </security:authorize>

                <security:authorize access="hasAuthority('01-01-002-VIEW')">
                    <a class="collapse-item" href="<c:url value="/usersetup"/>">User setup</a>
                </security:authorize>

                <security:authorize access="hasAuthority('01-01-003-VIEW')">
                    <a class="collapse-item" href="<c:url value="/permissionSetup"/>">Permission setup</a>
                </security:authorize>

                <security:authorize access="hasAuthority('01-01-004-VIEW')">
                    <a class="collapse-item" href="<c:url value="/passwordPolicy"/>">Password policy</a>
                </security:authorize>
            </div>
        </div>
    </li>

    <li class="nav-item">
        <a class="nav-link" href="#">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Charts</span></a>
    </li>
<%--todo required for mms --%>
  <%--  <li class="nav-item">
        <a class="nav-link collapsed" href="<c:url value="/kidu"/>" data-toggle="collapse"
           data-target="#collapseThree" aria-expanded="true"
           aria-controls="collapseTwo">
            <i class="fas fa-fw fa-cog"></i>
            <span class="sidebar-brand-text">Kidu </span>
        </a>

        <div id="collapseThree" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="py-2 collapse-inner rounded">
                <a class="collapse-item" href="<c:url value="/kidu"/>">Search By Company</a>
            </div>
        </div>
    </li>--%>


    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse"
           data-target="#collapse4" aria-expanded="true"
           aria-controls="collapseTwo">
            <i class="fas fa-fw fa-cog"></i>
            <span class="sidebar-brand-text">Caller Log</span>
        </a>

        <div id="collapse4" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="py-2 collapse-inner rounded">

                <a class="collapse-item" href="<c:url value="/callerLog"/>">Add Caller Log</a>
                <a class="collapse-item" href="<c:url value="/callerLog/Report"/>">Report</a>
            </div>
        </div>
    </li>

    <%--TODO need to check--%>
    <%--<a class="sidebar-brand " href="<c:url value="/kidu"/>">
        <div class="sidebar-brand-icon">
            <i class="glyphicon glyphicon-dashboard"></i>
        </div>

        <div class="sidebar-brand-text mx-3"><i class="fas fa-fw fa-cog"></i>&nbsp;Kidu Info</div>
    </a>--%>

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>
</ul>
<!-- End of Sidebar -->