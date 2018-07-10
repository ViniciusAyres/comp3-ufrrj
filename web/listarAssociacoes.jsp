<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    String[] stArrayAssociacoes={"BRASILEIROS","BRASADORES","BRASANTES","BRASIMORFOS"};
%>
<html>
<head>
    <title>Associações</title>
</head>
<body>
<h3 class="font-weight-light mt-4 ml-2">Lista de Associados da SISFARJ</h3>
<div class="container">
    <div class="row mx-auto">
        <div class="col-md-12 mt-2">
                <table class="table table-bordered">
                    <thead class="thead-light">
                    <tr>
                        <th>Matricula</th>
                        <th>Nome</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        int a=0;
                        for(a=0;a<stArrayAssociacoes.length;a++)
                        {
                            out.print("<tr class=\"text-center\">");
                            out.print("<th>2015780589</th>");
                            out.print("<th>"+stArrayAssociacoes[a]+"</th>");
                            out.print("</tr>");
                        }
                    %>
                    </tbody>
                </table>
        </div>
    </div>
</div>
</body>
</html>
