<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    String[] stArrayCompeticoes={"COMPETIÇÃO 1","COMPETIÇÃO 2","COMPETIÇÃO 3","COMPETIÇÃO 4"};
    String[] stArrayProvas={"Nado Sincronizado","Nado borboleta","Nado costa","Nado alguma coisa"};
    String[] stArrayAtletas={"Jhonson","Cleyton","Mauro","Alberto"};
%>
<html>
<head>
    <title>Lista de Competições</title>
    <script>
        $(document).ready(function () {
            $("button[data-number=1]").click(function () {
                $('#modalProvas').modal('hide');
            });

            $("button[data-number=2]").click(function () {
                $('#modalAtletas').modal('hide');
            });
        });
    </script>
</head>
<body>
<h3 class="font-weight-light mt-4 ml-2">Lista de Competições</h3>
<div class="container">
    <div class="row mx-auto">
        <div class="col-md-12 mt-2">
            <table class="table table-bordered">
                <thead class="thead-light">
                <tr>
                    <th>Nome da Prova</th>
                    <th>Data da Competição</th>
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
                        out.print("<th><button class=\"btn btn-outline-info\" data-toggle=\"modal\" data-target=\"#modalProvas\">Ver Provas</button></th>");
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
        <div class="modal-content" ng-cloak>
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalProvas">Provas da Competição selecionada</h5>
                <button type="button" class="close" data-number="1" aria-label="Close">
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
                                        out.print("<th><button class=\"btn btn-outline-info\" data-toggle=\"modal\" data-target=\"#modalAtletas\">Ver Atletas</button></th>");
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


<div class="modal fade" id="modalAtletas" tabindex="-1" role="dialog" aria-labelledby="modalAtletas" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content" ng-cloak>
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalAtletas">Resultados dos Atletas na Prova selecionada</h5>
                <button type="button" class="close" data-number="2" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="container">
                    <div class="row mx-auto">
                        <div class="col-md-12 mt-2">
                            <table class ="table table-bordered" style="min-height:350px;max-height:400px;overflow-y:auto">
                                <thead class="thead-light">
                                <tr>
                                    <th>Matrícula</th>
                                    <th>Nome</th>
                                    <th>Tempo</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    int c=0;
                                    for(c=0;c<stArrayAtletas.length;c++)
                                    {
                                        out.print("<tr class=\"text-center\">");
                                        out.print("<th>2015780589</th>");
                                        out.print("<th>"+stArrayAtletas[c]+"</th>");
                                        out.print("<th>00:01:03 s</th>");
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

</body>
</html>
