 <!-- Navigation -->
    <%@page import="com.clutterbunny.web.utils.RequestUtil"%>
<nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#page-top">
                	<img src="<%=RequestUtil.CTX_PATH%>/assets/img/clutterbunny.png" class="img-responsive" >
                	<span>Clutter Bunny</span> 
                	<small>New way to Give, Get and Benefit </small>
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                	 <li class="page-scroll">
                        <a href="<%=RequestUtil.CTX_PATH%>/"><i class="glyphicon glyphicon-home"></i>Home</a>
                    </li>
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                   <!--  <li class="page-scroll">
                        <a href="#portfolio">Portfolio</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#about">About</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#contact">Contact</a>
                    </li> -->
                    <li class="page-scroll">
                        <a href="<%=RequestUtil.CTX_PATH%>/user/signup"><i class="glyphicon glyphicon-user"></i>SIGNUP</a>
                    </li>
                    <li class="page-scroll">
                        <a href="<%=RequestUtil.CTX_PATH%>/registry/book"><i class="glyphicon glyphicon-book"></i>REGISTRY</a>
                    </li>
                    <li class="page-scroll">
                        <a href="<%=RequestUtil.CTX_PATH%>/registry/search"><i class="glyphicon glyphicon-search"></i>Search</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    