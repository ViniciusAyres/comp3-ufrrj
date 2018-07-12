<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    String[] stArrayAtletas={"Jhonson","Cleyton","Mauro","Alberto","Jhonson","Cleytons","Mauro","Alberto","Jhonson","Cleyton","Mauro","Alberto"};
%>
<html>
<head>
    <title>Associações</title>
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <h3 class="font-weight-light ml-3">Insira abaixo o tempo de cada Atleta</h3>
        </div>
        <form class="form" role="form" method="POST" action="/inserirTempo">
        <div class="card-body">
                <div class="row mx-auto">
                    <div class="col-md-12 mt-2">
                        <table class ="table table-bordered" style="min-height:350px;max-height:400px;overflow-y:auto">
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
                                    out.print("<th><input type=\"text\" name=\"nome\" class=\"form-control\" maxlength=\"10\" id=\"nome\" placeholder=\"Tempo\" required ></th>");
                                    out.print("</tr>");
                                }
                            %>
                            </tbody>
                        </table>
                    </div>
                </div>
        </div>
        </form>
        <div class="card-footer">
            <div class="row mr-5" style="float:right">
                <button class="btn btn-info" type="submit" value="/inserirResultado/">Enviar</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>