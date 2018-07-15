<%@ page import="utils.RecordSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    RecordSet recordSet = (RecordSet) request.getSession().getAttribute("dados");
%>
<html>
<head>
    <style>
        @media(min-width: 768px) {
            .field-label-responsive {
                padding-top: .5rem;
                text-align: right;
            }
        }
    </style>
    <title>Alterar Atleta</title>
</head>
<body>
<div class="card bg-ligth mx-auto mt-4" style="width: 50rem;">
    <form class="form" role="form" method="POST" action="alterarCadastroAtleta?matricula=<%= recordSet.get(0).getString("matricula") %>">

        <div class="card-header text-center">
            <h4>
                <i class="fa fa-user-plus"></i> Alterar Atleta</h4>
        </div>
        <div class="card-body">
            <div class="row mt-4">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="numero_oficio"><i class="fa fa-file-text" aria-hidden="true"></i> Número de Ofício</label>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" id="numero_oficio" name="numero_oficio" class="form-control" placeholder="Número de Ofício"
                                   maxlength="50" value="<%= recordSet.get(0).getString("numero_oficio") %>">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="dataOficio"><i class="fa fa-calendar" aria-hidden="true"></i> Data de ofício</label>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="date" name="dataOficio" class="form-control" id="dataOficio"  maxlength="50" value="<%= recordSet.get(0).getString("data_oficio") %>">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="nome"><i class="fa fa-user-o" aria-hidden="true"></i> Nome</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="nome" class="form-control" maxlength="50" id="nome" placeholder="Cesar Ciélo"
                                   required value="<%= recordSet.get(0).getString("nome") %>">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="data_entrada"><i class="fa fa-calendar-o" aria-hidden="true"></i> Entrada na Associação</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="date" name="data_entrada" class="form-control" id="data_entrada" required
                                   value="<%= recordSet.get(0).getString("data_entrada") %>" >
                        </div>
                    </div>
                </div>
            </div>

                <div class="bg-info clearfix" style="background-color: #ffffff !important;">
                    <button type="submit" class="btn btn-info float-right" value="/alterar/">Alterar</button>
                </div>
        </div>
    </form>
</div>
<div class="container">
    <div class="row mt-2">
        <small class="mx-auto">
            <span style="color:red">*</span> Campos obrigatórios
            <br/>
        </small>
    </div>
</div>
</body>
</html>
