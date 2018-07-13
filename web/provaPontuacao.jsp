<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    String[] stArrayProvas={"Nado Sincronizado","Nado borboleta","Nado costa","Nado alguma coisa"};
%>
<div class="container">
    <div class="card mt-5">
        <div class="card-header">
            <h3 class="font-weight-light mt-4 ml-2" >Selecione a Prova a qual deseja saber a Pontuação dos Atletas</h3>
        </div>
        <div class="card-body">
            <div class="container">
                <div class="row mx-auto">
                    <div class="col-md-12 mt-2">
                        <table class="table table-bordered">
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
                                    out.print("<th><a href=\"pontuacaoAtleta.jsp\"><button class=\"btn btn-outline-info\" >Selecionar</button></th></a>");
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