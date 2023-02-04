<%-- 
    Document   : viewnote
    Created on : 4-Feb-2023, 12:06:24 PM
    Author     : xbali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <h3>Title: ${note.title}</h3>
        <h3>Contents: ${note.contents}</h3>
        <a href="note?edit">Edit</a>
    </body>
</html>
