<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    String[] stArrayAssociacoes={"BRASILEIROS","BRASADORES","BRASANTES","BRASIMORFOS"};
%>
<html>
<head>
    <title>Alterar Filiações</title>
</head>
<body>
<div class="container">
    <div class="card mt-5">
        <div class="card-header">
            <h3 class="font-weight-light mt-4 ml-2">Selecione uma das Associações abaixo para poder alterar suas Filiações.</h3>
        </div>
    <div class="row mx-auto">
        <div class="col-md-12 mt-2">
            <table class="table table-bordered">
                <thead class="thead-light">
                <tr>
                    <th>Matrícula</th>
                    <th>Nome</th>
                    <th></th>
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
                        out.print("<th><a href=\"filiacoes.jsp\"><button class=\"btn btn-outline-info\">Selecionar</button></a></th>");
                        out.print("</tr>");
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
</body>
</html>