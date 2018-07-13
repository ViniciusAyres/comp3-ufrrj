<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
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
    <title>Incluir Local</title>
</head>
<body>
<div class="card bg-ligth mx-auto mt-4" style="width: 50rem;">
    <form class="form" role="form" method="POST" action="/atleta">

        <div class="card-header text-center">
            <h4>
                <i class="fa fa-user-plus"></i> Incluir Local de Competição</h4>
        </div>
        <div class="card-body">

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="nome"><i class="fa fa-user-o" aria-hidden="true"></i> Nome</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="nome" class="form-control" maxlength="50" id="nome" placeholder="Nome"
                                   required >
                        </div>
                    </div>
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="numeroOficio"><i class="fa fa-file-text" aria-hidden="true"></i> Endereço</label>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" id="numeroOficio" name="numeroOficio" class="form-control" placeholder="Número de Ofício"
                                   maxlength="50">
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
                            <input type="date" name="dataOficio" class="form-control" id="dataOficio"  maxlength="50">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row mr-5" style="float:right">
                    <button type="submit" class="btn btn-info" value="/registra/">Salvar</button>
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
