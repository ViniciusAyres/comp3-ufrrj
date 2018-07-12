<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    String[] stArrayAtletas={"Jhonson","Cleyton","Diego","Alberto"};
%>
<html>
<head>
    <title>Atletas</title>
</head>
<body>
<h3 class="font-weight-light mt-4 ml-2">Selecione abaixo o Atleta desejado para realizar a transferência.</h3>
<div class="container">
    <div class="row mx-auto">
        <div class="col-md-12 mt-2">
            <table class="table table-bordered">
                <thead class="thead-light">
                <tr>
                    <th>Nome do Atleta</th>
                    <th>Matrícula</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <%
                    int a=0;
                    for(a=0;a<stArrayAtletas.length;a++)
                    {
                        out.print("<tr class=\"text-center\">");
                        out.print("<th>"+stArrayAtletas[a]+"</th>");
                        out.print("<th>123131231</th>");
                        out.print("<th><a href=\"transferencia.jsp\"><button class=\"btn btn-outline-info\">Transferir</button></a></th>");
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
