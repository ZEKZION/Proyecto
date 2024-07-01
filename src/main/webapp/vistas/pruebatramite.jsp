<%-- 
    Document   : pruebatramite
    Created on : 29 jun. 2024, 23:36:44
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <form action="../svrconstancia?accion=pdf">
            
            
            <label>Realizar Pago</label>
            
            
            
            <input value="${sessionScope.Nombre}">
            
            <button type="submit">Generar PDF</button>
            
            
            
            
            
        </form>
            
            
            
    
        
        
    </body>
</html>
