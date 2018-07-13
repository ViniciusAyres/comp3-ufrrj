<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    String[] stArrayAtletas={"Jhonson","Cleyton","Mauro","Alberto"};
%>
<h3 class="font-weight-light mt-4 ml-2">Resultados dos Atletas na Prova selecionada</h3>
<div class="container">
    <div class="row mx-auto">
        <div class="col-md-12 mt-2">
            <table class="table table-bordered">
                <thead class="thead-light">
                <tr>
                    <th>Nome do Atleta</th>
                    <th>Matrícula</th>
                    <th>Tempo</th>
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
                        out.print("<th>00:01:03 s</th>");
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
