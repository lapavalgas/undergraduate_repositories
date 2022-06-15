<!@ page import="java.util;" %>     //this is a directive   | do imports to the page
<%! int value; %>                   //this is a declaration | declare scriptlets outside jsp
<% int value = 45; %>               //this is a scriptlet   | declare sciptlet
<%= k %>                            //this is a expression  | print content

//this is good for put data in page
//the servlet is good for processing data


// Directives =--->

@page
//imports, specify something for the entire page
<%@ page attribute="value" attribute="value" %>
=--> commoly:
language="scripting language"   | java
extends="className"             | extends ads.lp2.FileUpload.java
import="importList"             | import some libs
session="true|false"            | if want session in the JSP file
buffer=none|00kbs               | control the buffer of page jsp ?! http://esus.com/buffer-autoflush-attributes-jsp-page-directive/
autoFlush="true|false"          | like a buffer; but the container JSP ?! http://esus.com/buffer-autoflush-attributes-jsp-page-directive/
contentType="ctinfo"            | defines the content type of response of JSP
errorPage="error_url"           | an alternative page if got an error in any process
isErrorPage="true|false"        | the attribute that define the error page
info="information"              | just info about JSP
isELIgnored="true|false"        |
isThreadSafe="true|false"       | can take multiple threads?!

@inclued
//works the same way at liquid jekyll, include some webpage inside
<@include file="page.jsp" %>

@taglib
//external tags, like spring framework tags
<@taglib uri="uri" prefix="fx" %>   | this one import an .lib of tags to use in html an be interpreted by chrome/firefox/edge 

