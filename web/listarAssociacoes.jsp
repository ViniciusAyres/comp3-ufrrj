<%@ page import="java.util.ArrayList" %>
<%@ page import="dominio.AssociacaoMD" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    AssociacaoMD associacaoMD = (AssociacaoMD) request.getAttribute("associacaoMD");
    ArrayList<String> matriculas = associacaoMD.getMatriculas();
%>
<html>
<head>
    <title>Associações</title>
</head>
<body>
<div class="container">
    <div class="card mt-5">
        <div class="card-header">
            <h3 class="font-weight-light mt-4 ml-2">Lista de Associados da SISFARJ</h3>
        </div>
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
                        for(String matricula : matriculas) {
                            out.print("<tr class=\"text-center\">");
                            out.print("<th>" + matricula + "</th>");
                            out.print("<th>" + associacaoMD.getNome(matricula) +"</th>");
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
