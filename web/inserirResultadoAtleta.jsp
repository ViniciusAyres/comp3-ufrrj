<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    String[] stArrayCompeticoes={"COMPETIÇÃO 1","COMPETIÇÃO 2","COMPETIÇÃO 3","COMPETIÇÃO 4"};
    String[] stArrayProvas={"Nado Sincronizado","Nado borboleta","Nado costa","Nado alguma coisa"};
    String[] stArrayAtletas={"Jhonson","Cleyton","Mauro","Alberto"};
%>
<html>
<body>
<h3 class="font-weight-light mt-4 ml-2">Selecione uma das Competições abaixo para inserir o resultado dos atletas em suas provas.</h3>
<div class="container">
    <div class="row mx-auto">
        <div class="col-md-12 mt-2">
            <table class="table table-bordered">
                <thead class="thead-light">
                <tr>
                    <th>Nome da Competição</th>
                    <th>Data</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <%
                    int a=0;
                    for(a=0;a<stArrayCompeticoes.length;a++)
                    {
                        out.print("<tr class=\"text-center\">");
                        out.print("<th>"+stArrayCompeticoes[a]+"</th>");
                        out.print("<th>12/03/2017</th>");
                        out.print("<th><button class=\"btn btn-outline-info\" data-toggle=\"modal\" data-target=\"#modalProvas\">Selecionar</button></th>");
                        out.print("</tr>");
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="modal fade" id="modalProvas" tabindex="-1" role="dialog" aria-labelledby="modalProvas" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalProvas">Selecione a Prova a qual deseja saber os resultados dos Atletas.</h5>
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
                                    <th>Nome da Prova</th>
                                    <th>Categoria</th>
                                    <th>Classe</th>
                                    <th>Tipo da Piscina</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    int b=0;
                                    for(b=0;b<stArrayProvas.length;b++)
                                    {
                                        out.print("<tr class=\"text-center\">");
                                        out.print("<th>"+stArrayProvas[b]+"</th>");
                                        out.print("<th>Masculino</th>");
                                        out.print("<th>Infantil</th>");
                                        out.print("<th>50 metros</th>");
                                        out.print("<th><a href=\"tempoAtleta.jsp\"><button class=\"btn btn-outline-info\" data-toggle=\"modal\" data-target=\"#modalAtletas\">Selecionar</button></a></th>");
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
