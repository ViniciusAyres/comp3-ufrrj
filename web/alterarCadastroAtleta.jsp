<%@ page import="dominio.AtletaMT" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    AtletaMT atletaMT = (AtletaMT) request.getAttribute("atletaMT");
    ArrayList<String> matriculas = atletaMT.getMatriculas();
%>
<html>
<head>
    <title>Atletas</title>
</head>
<body>
<h3 class="font-weight-light mt-4 ml-2">Selecione abaixo o Atleta desejado para realizar a alteração.</h3>
<div class="container">
    <div class="row mx-auto">
        <div class="col-md-12 mt-2">
            <table class="table table-bordered">
                <thead class="thead-light">
                <tr>
                    <th>Nome</th>
                    <th>Matrícula</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <%
                    for(String matricula : matriculas) {
                        out.print("<tr class=\"text-center\">");
                        out.print("<th>" + atletaMT.getNome(matricula) + "</th>");
                        out.print("<th>" + matricula +"</th>");
                        out.print("<th><a href=\"alterarAtleta.jsp?matriculaAtleta=" + matricula + "\"><button class=\"btn btn-outline-info\">Alterar</button></a></th>");
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

