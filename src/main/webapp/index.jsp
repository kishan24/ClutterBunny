<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clutter Bunny</title>

    <jsp:include page="top.jsp"></jsp:include>
</head>

<body id="page-top" class="index">
   <jsp:include page="header.jsp"></jsp:include>

<%
	String p = request.getParameter("p");
	if(p == null) {
		p = (String)request.getAttribute("p");
		if(p == null) {
			p = "home";
		}
	} 
	p = p +".jsp";
%>    
	<jsp:include page="<%=p%>"></jsp:include>
    <jsp:include page="footer.jsp"></jsp:include>
   <jsp:include page="bottom.jsp"></jsp:include>
</body>

</html>
