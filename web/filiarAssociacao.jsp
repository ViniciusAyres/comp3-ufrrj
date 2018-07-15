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
    <title>Filiar Associação</title>
</head>
<body>
<div class="card bg-ligth mx-auto mt-4" style="width: 50rem;">
    <form class="form" role="form" method="POST" action="/filiarAssociacao">

        <div class="card-header text-center">
            <h4>
                <i class="fa fa-handshake-o" aria-hidden="true"></i> Filiar Associação</h4>
        </div>
        <div class="card-body">
            <div class="row mt-4">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="numeroOficio"> Número de Ofício</label>
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
                    <label for="dataOficio"> Data de ofício</label>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="date" name="dataOficio" class="form-control" id="dataOficio" >
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="nome"> Nome da Associação</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="nome" class="form-control" maxlength="50" id="nome" placeholder="Nome da Associação"
                                   required >
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="sigla"> Sigla</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="sigla" class="form-control" id="sigla" placeholder="Sigla" required maxlength="30">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="endereco"> Endereço</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="endereco" class="form-control" id="endereco" required maxlength="30" placeholder="Endereco">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="telefone"> Telefone</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="telefone" class="form-control" id="telefone" required maxlength="15" placeholder="Telefone">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 field-label-responsive text-left">
                    <label for="numeroComprovante"> Número de Comprovante de Pagamento</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-6">
                    <div class="form-group has-danger">
                        <div class="input-group">
                            <input type="text" name="numeroComprovante" class="form-control" id="numeroComprovante" placeholder="Número do Comprovante" required maxlength="9">
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
