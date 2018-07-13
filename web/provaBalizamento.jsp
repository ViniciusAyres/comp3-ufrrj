<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    String[] stArrayProvas={"Nado Sincronizado","Nado borboleta","Nado costa","Nado alguma coisa"};
%>

<div class="container">
    <div class="card mt-5">
        <div class="card-header">
            <h3 class="font-weight-light mt-4 ml-2">Selecione uma das Competições abaixo para saber o Balizamento</h3>
        </div>
        <div class="row mx-auto">
            <div class="col-md-12 mt-2">
                <table class="table table-bordered" >
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
                        int c=0;
                        for(c=0;c<stArrayProvas.length;c++)
                        {
                            out.print("<tr class=\"text-center\">");
                            out.print("<th>"+stArrayProvas[c]+"</th>");
                            out.print("<th>Masculino</th>");
                            out.print("<th>Infantil</th>");
                            out.print("<th>50 metros</th>");
                            out.print("<th><a href=\"balizamento.jsp\"><button class=\"btn btn-outline-info\" >Selecionar</button></a></th>");
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