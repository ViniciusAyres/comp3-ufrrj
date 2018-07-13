<%@ page import="java.util.ArrayList" %>
<%@ page import="dominio.LocalCompeticaoMD" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    LocalCompeticaoMD localCompeticaoMD = (LocalCompeticaoMD) request.getAttribute("competicaoLocalMD");
    //ArrayList<String> locais = localCompeticaoMD.getLocais();
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
                    <th>Endereço</th>
                    <th>Tipo da Piscina</th>
                </tr>
                </thead>
                o local de competição informado, o endereço e o tipo de piscinas.
                <tbody>
                <%
      //            for(String local: locais)
        //          {
          //            out.print("<tr class=\"text-center\">");
            //          out.print("<th>" + local + "</th>");
              //        out.print("<th>" + localCompeticaoMD.getEnderecoByLocal(local) +"</th>");
                //      out.print("<th>" + localCompeticaoMD.getTamanhoPiscinaByLocal(local) +"</th>");
                  //    out.print("</tr>");
                  //}
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
