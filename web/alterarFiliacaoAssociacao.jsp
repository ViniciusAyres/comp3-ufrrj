<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    String[] stArrayAssociacoes={"BRASILEIROS","BRASADORES","BRASANTES","BRASIMORFOS"};
    String[] stArrayFiliacoes={"A","B","C","D"};
%>
<html>
<head>
    <title>Alterar Filiações</title>
</head>
<body>
<h3 class="font-weight-light mt-4 ml-2">Selecione uma das Associações abaixo para poder alterar suas Filiações.</h3>
<div class="container">
    <div class="row mx-auto">
        <div class="col-md-12 mt-2">
            <table class="table table-bordered">
                <thead class="thead-light">
                <tr>
                    <th>Matricula</th>
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
                        out.print("<th><button class=\"btn btn-outline-info\" data-toggle=\"modal\" data-target=\"#modalFiliados\">Selecionar</button></th>");
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

<div class="modal fade" id="modalFiliados" tabindex="-1" role="dialog" aria-labelledby="modalFiliados" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalAssociacoes">Selecione a Filiação que deseja alterar.</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="container">
                    <div class="row mx-auto">
                        <div class="col-md-12 mt-2">
                            <table class="table table-bordered" style="min-height:300px;max-height:350px;overflow-y:auto">
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
        </div>
    </div>
</div>
