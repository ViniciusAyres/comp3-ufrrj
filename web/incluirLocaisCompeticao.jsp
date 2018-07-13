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
    <title>Incluir Locais</title>
</head>
<body>
<div class="card bg-ligth mx-auto mt-4" style="width: 50rem;">
    <form class="form" role="form" method="POST" action="">

        <div class="card-header text-center">
            <h4>
                <i class="fa fa-map-o" aria-hidden="true"></i> Incluir Locais de Competição</h4>
        </div>
        <div class="card-body">
            <div class="row mt-4">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="nome"> Nome</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="nome" class="form-control" maxlength="50" id="nome" placeholder="Nome">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="logradouro"> Logradouro</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="logradouro" class="form-control" id="logradouro" required maxlength="30" placeholder="Logradouro">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="numeroLogradouro"> Número do Logradouro</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="numeroLogradouro" class="form-control" id="numeroLogradouro" maxlength="30" placeholder="Número do Logradouro" required>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="complemento"> Complemento</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="complemento" class="form-control" id="complemento" maxlength="30" placeholder="Complemento" required>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="cidade"> Cidade</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="cidade" class="form-control" id="cidade" required maxlength="30" placeholder="Cidade">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="bairro"> Bairro</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="bairro" class="form-control" id="bairro" required maxlength="30" placeholder="Bairro">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="cep"> CEP</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="cep" class="form-control" id="cep" required maxlength="8" placeholder="CEP">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label for="uf"> UF</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="uf" class="form-control" id="uf" required maxlength="2" placeholder="UF">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 field-label-responsive text-left">
                    <label> Tipo de Piscina</label>
                    <span style="color:red">*</span>
                </div>
                <div class="col-md-8">
                    <div class="col-auto my-1">
                        <div class="custom-control custom-checkbox mr-sm-2">
                            <input type="checkbox" class="custom-control-input" id="custom25" checked>
                            <label class="custom-control-label" for="custom25">25 metros</label>
                        </div>
                    </div>
                    <div class="col-auto my-1">
                        <div class="custom-control custom-checkbox mr-sm-2">
                            <input type="checkbox" class="custom-control-input" id="custom50">
                            <label class="custom-control-label" for="custom50">50 metros</label>
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
