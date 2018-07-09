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
    <title>Cadastro Atleta</title>
</head>
<body>
<div class="card bg-ligth mx-auto mt-4" style="width: 50rem;">
    <form class="form" role="form" method="POST" action="/atleta">

        <div class="card-header text-center">
            <h4>
                <i class="fa fa-user-plus"></i> Cadastrar Atleta</h4>
        </div>
        <div class="card-body">
            <div class="row mt-4">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="numeroOficio"><i class="fa fa-file-text" aria-hidden="true"></i> Número de Ofício</label>
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

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="nome"><i class="fa fa-user-o" aria-hidden="true"></i> Nome</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="nome" class="form-control" maxlength="50" id="nome" placeholder="Cesar Ciélo"
                                   required >
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="dataNascimento"><i class="fa fa-calendar-o" aria-hidden="true"></i> Data de Nascimento</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="date" name="dataNascimento" class="form-control" id="dataNascimento" required>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="dataAssociacao"><i class="fa fa-calendar-o" aria-hidden="true"></i> Entrada na Associação</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="date" name="dataAssociacao" class="form-control" id="dataAssociacao" required>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="matriculaAssociacao"><i class="fa fa-id-card" aria-hidden="true"></i> Matrícula da Associação</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="matriculaAssociacao" class="form-control" id="matriculaAssociacao" placeholder="Matrícula"
                                   required maxlength="60">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 field-label-responsive text-left">
                    <label for="numeroComprovante"><i class="fa fa-file-o" aria-hidden="true"></i> Número de Comprovante de Pagamento</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-6">
                    <div class="form-group has-danger">
                        <div class="input-group">
                            <input type="text" name="numeroComprovante" class="form-control" id="numeroComprovante" placeholder="Número do Comprovante" required maxlength="30">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row mr-5" style="float:right">
                    <button type="submit" class="btn btn-info" value="/registra/">
                        Salvar</button>
            </div>
        </div>
    </form>
</div>
<div class="row mt-5">
    <small class="mx-auto">
        <span style="color:red">*</span> Campos obrigatórios
        <br/>
    </small>
</div>
</body>
</html>
