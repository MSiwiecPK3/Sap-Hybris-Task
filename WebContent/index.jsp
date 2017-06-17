<%@page import="pl.project.MongoDB.SpringMongoConfig"%>
<body>
<%
SpringMongoConfig tc = new SpringMongoConfig();
  out.print(tc.connect());
  tc.close();
%>
</body>