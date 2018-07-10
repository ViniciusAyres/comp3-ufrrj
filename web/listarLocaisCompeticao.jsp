<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    String[] stArrayLocais={"Brás de Pina","Jundiaí","Morro do Macaco","Vila Vintem"};
%>
<html>
<head>
    <title>Locais de Competição</title>
</head>
<body>
<h3 class="font-weight-light mt-4 ml-2">Lista de Locais de Competição</h3>
<div class="container">
    <div class="row mx-auto">
        <div class="col-md-12 mt-2">
            <table class="table table-bordered">
                <thead class="thead-light">
                <tr>
                    <th>Nome do Local</th>
                    <th>Logradouro</th>
                    <th>Bairro</th>
                    <th>CEP</th>
                    <th>Complemento</th>
                    <th>Número</th>
                    <th>Cidade</th>
                    <th>UF</th>
                    <th>Tipo da Piscina</th>
                </tr>
                </thead>
                <tbody>
                <%
                    int a=0;
                    for(a=0;a<stArrayLocais.length;a++)
                    {
                        out.print("<tr class=\"text-center\">");
                        out.print("<th>"+stArrayLocais[a]+"</th>");
                        out.print("<th>Rua Xablau</th>");
                        out.print("<th>Belford Roxo</th>");
                        out.print("<th>2424242424</th>");
                        out.print("<th>Próximo a boca de fumo</th>");
                        out.print("<th>71</th>");
                        out.print("<th>Rio de Janeiro</th>");
                        out.print("<th>RJ</th>");
                        out.print("<th>50 metros</th>");
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
