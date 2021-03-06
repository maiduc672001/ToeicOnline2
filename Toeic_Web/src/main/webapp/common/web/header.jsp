<%@include file="/common/taglib.jsp"%>
<!--HEADER ROW-->
<div id="header-row">
    <div class="container">
        <div class="row">
            <!--LOGO-->
            <div class="span3"><a class="brand" href="#"><img src="img/logo.png"/></a></div>
            <!-- /LOGO -->

            <!-- MAIN NAVIGATION -->
            <div class="span9">
                <div class="navbar  pull-right">
                    <div class="navbar-inner">
                        <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a>
                        <div class="nav-collapse collapse navbar-responsive-collapse">
                            <ul class="nav">
                                <li class="active"><a href="index.html">Home</a></li>
<c:if test="${not empty login_name}">
<c:url var="logoutUrl" value="/logout.html">
    <c:param name="action" value="logout"></c:param>
</c:url>
    <li> <fmt:message bundle="${lang}" key="label.hello"></fmt:message> :${login_name}</li>
    <li> <a href=${logoutUrl}><fmt:message bundle="${lang}" key="label.logout"></fmt:message></a></li>
</c:if>
                                <c:if test="${empty login_name}">
                                    <c:url value="/login.html" var="loginUrl">
                                        <c:param name="action" value="login"></c:param>
                                    </c:url>
                                    <li> <a href=${loginUrl}><fmt:message bundle="${lang}" key="label.login"></fmt:message></a></li>
                                </c:if>
                                <li class="dropdown">
                                    <a href="about.html" class="dropdown-toggle" data-toggle="dropdown">About <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="about.html">Company</a></li>
                                        <li><a href="about.html">History</a></li>
                                        <li><a href="about.html">Team</a></li>
                                    </ul>
                                </li>
                                <li><a href="service.html">Services</a></li>

                                <li>
                                    <a href="blog.html">Blog</a>
                                </li>
                                <li><a href="contact.html">Contact</a></li>
                            </ul>
                        </div>

                    </div>
                </div>
            </div>
            <!-- MAIN NAVIGATION -->
        </div>
    </div>
</div>
<!-- /HEADER ROW -->