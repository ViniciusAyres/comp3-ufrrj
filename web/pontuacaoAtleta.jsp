<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    String[] stArrayAtletas={"Jhonson","Cleyton","Mauro","Alberto"};
%>
<div class="container">
    <div class="card mt-5">
        <div class="card-header">
            <h3 class="font-weight-light mt-4 ml-2" >Pontuação dos Atletas da Prova selecionada</h3>
        </div>
        <div class="card-body">
            <div class="container">
                <div class="row mx-auto">
                    <div class="col-md-12 mt-2">
                        <table class="table table-bordered">
                        <thead class="thead-light">
                        <tr>
                            <th>Nome do Atleta</th>
                            <th>Matrícula</th>
                            <th>Sigla da Associação</th>
                            <th>Tempo</th>
                            <th>Pontos</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            int c=0;
                            for(c=0;c<stArrayAtletas.length;c++)
                            {
                                out.print("<tr class=\"text-center\">");
                                out.print("<th>"+stArrayAtletas[c]+"</th>");
                                out.print("<th>2015780589</th>");
                                out.print("<th>BRA</th>");
                                out.print("<th>00:01:03 s</th>");
                                out.print("<th>100 pontos</th>");
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