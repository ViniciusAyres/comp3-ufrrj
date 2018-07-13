<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    String[] stArrayProvas={"Nado Sincronizado","Nado borboleta","Nado costa","Nado alguma coisa"};
%>
<div class="card">
            <div class="card-header">
                <h3 class="font-weight-light mt-4 ml-2" id="exampleModalProvas">Selecione as Provas abaixo que deseja adicionar a Competição</h3>
            </div>
            <div class="card-body">
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
                                        out.print("<th><button class=\"btn btn-outline-info\">Selecionar</button></th>");
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
