<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    String[] stArrayFiliacoes={"A","B","C","D"};
%>
<head>
    <title>Filiações</title>
</head>
<div class="container">
    <div class="card mt-5">
        <div class="card-header">
            <h3 class="font-weight-light mt-4 ml-2">Selecione a Filiação que deseja alterar.</h3>
        </div>
    <div class="row mx-auto">
        <div class="col-md-12 mt-2">
            <table class="table table-bordered">
                <thead class="thead-light">
                                <tr>
                                    <th>Nome</th>
                                    <th>Sigla</th>
                                    <th>Número</th>
                                    <th>Data do Ofício</th>
                                    <th>Matrículo</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    int b=0;
                                    for(b=0;b<stArrayFiliacoes.length;b++)
                                    {
                                        out.print("<tr class=\"text-center\">");
                                        out.print("<th>"+stArrayFiliacoes[b]+"</th>");
                                        out.print("<th>XXT</th>");
                                        out.print("<th>231231</th>");
                                        out.print("<th>12/11/2015</th>");
                                        out.print("<th>245435435</th>");
                                        out.print("<th><a href=\"alterarFiliacao.jsp\"><button class=\"btn btn-outline-info\" data-toggle=\"modal\" data-target=\"#modalAtletas\">Alterar</button></a></th>");
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