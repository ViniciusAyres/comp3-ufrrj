<%@ page import="dominio.LocalCompeticaoMT" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="utils.RecordSet" %>
<%@ page import="dados.datamappers.LocalDataMapper" %>
<%@ page import="utils.Row" %>
<%@ page import="utils.Utils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>

<%

    RecordSet recordSet = (RecordSet)request.getSession().getAttribute("dados");
%>
<html>
<head>
    <title>Locais de Competição</title>
</head>
<body>
<h3 class="font-weight-light mt-4 ml-2 text-center">Lista de Locais de Competição</h3>
<div class="container">
    <div class="row mx-auto">
        <div class="col-md-12 mt-2">
            <table class="table table-bordered">
                <thead class="thead-light">
                <tr>
                    <th Class="text-center">Nome do Local</th>
                    <th Class="text-center">Endereço</th>
                    <th Class="text-center">Tipo da Piscina</th>
                </tr>
                </thead>
                <tbody>
                <%
                for(Row row: recordSet)
                  {
                      out.print("<tr class=\"text-center\">");
                      out.print("<th>" + row.getString("nome") + "</th>");
                      out.print("<th>" + row.getString("endereco") +"</th>");
                      out.print("<th>" + Utils.piscinaToString(row.getInt("tamanhoPiscina")) +"</th>");
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
