<$-- 
    Document    : MyFirstJSP
    Created on  : 21 out, 2019, 12:39 AM 
    Author      : Rafael
--%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>MyFirstJSP an Hello World </title>
<body>
    <h1>Hello World</h1>

    <%! 
        int i = 9; %>
    <%
        out.println("Hello World " + i + " ;)"); 
        out.println(i);
    %>

    <%= 
        i
    %>
</body>
</html>