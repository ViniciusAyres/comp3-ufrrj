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
</head>
<body>
<div class="card text-white bg-dark mx-auto mt-4" style="width: 50rem;">
    <form class="form" role="form" method="POST" action="">

        <div class="card-header text-center">
            <h4>
                <i class="fa fa-user-plus"></i> Registre-se!</h4>
        </div>
        {% endif %}
        <div class="card-body">
            <div class="row mt-3">
                <div class="col-md-3 field-label-responsive">
                    <span style="color:red">*</span>
                    <label for="first_name">Nome</label>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <div class="input-group">
                            <div class="mt-2" style="width: 2.6rem">
                                <i class="fa fa-user"></i>
                            </div>
                            <input type="text" id="first_name" value="{{ form.first_name.value }}" name="first_name" class="form-control" placeholder="Leonardo"
                                   required onKeyPress="return validaLetras(event);" onpaste="return false" ondrop="return false"
                                   maxlength="50">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-control-feedback">
                <small class="text-danger text-center">
                    {{ form.first_name.errors }}
                </small>
            </div>
            <div class="row">
                <div class="col-md-3 field-label-responsive">
                    <span style="color:red">*</span>
                    <label for="sobrenome">Sobrenome</label>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <div class="input-group">
                            <div class="mt-2" style="width: 2.6rem">
                                <i class="fa fa-user-o" aria-hidden="true"></i>
                            </div>
                            <input type="text" value="{{ form.last_name.value }}" name="last_name" class="form-control" id="last_name" placeholder="Almeida"
                                   required onKeyPress="return validaLetras(event);" onpaste="return false" ondrop="return false"
                                   maxlength="50">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-control-feedback">
                <small class="text-danger text-center">
                    {{ form.last_name.errors }}
                </small>
            </div>
            <div class="row">
                <div class="col-md-3 field-label-responsive">
                    <span style="color:red">*</span>
                    <label for="cpf">CPF</label>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <div class="input-group">
                            <div class="mt-2" style="width: 2.6rem">
                                <i class="fa fa-id-card-o" aria-hidden="true"></i>
                            </div>
                            <input type="text" value="{{ form.cpf.value }}" name="cpf" class="form-control" maxlength="14" id="cpf" placeholder="xxx.xxx.xxx-xx"
                                   required onkeypress="formatar('###.###.###-##', this);return validaNumeros(event)" onpaste="return false"
                                   ondrop="return false" {%if user.is_authenticated%}disabled{%endif%}>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-control-feedback">
                <small class="text-danger text-center">
                    {{ form.cpf.errors }}
                </small>
            </div>
            <div class="row">
                <div class="col-md-3 field-label-responsive">
                    <label for="profissao">Profissão</label>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <div class="input-group">
                            <div class="mt-2" style="width: 2.6rem">
                                <i class="fa fa-briefcase" aria-hidden="true"></i>
                            </div>
                            <input type="text" value="{{ form.profissao.value }}" name="profissao" class="form-control" id="profissao" placeholder="Estudante"
                                   maxlength="80">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-control-feedback">
                <small class="text-danger text-center">
                    {{ form.profissao.errors }}
                </small>
            </div>
            <div class="row">
                <div class="col-md-3 field-label-responsive">
                    <label for="formacao">Formação</label>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <div class="input-group">
                            <div class="mt-2" style="width: 2.6rem">
                                <i class="fa fa-graduation-cap" aria-hidden="true"></i>
                            </div>
                            <input type="text" value="{{ form.formacao.value }}" name="formacao" class="form-control" id="formacao" placeholder="Ciência da Computação" maxlength="80">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-control-feedback">
                <small class="text-danger text-center">
                    {{ form.formacao.errors }}
                </small>
            </div>
            <div class="row">
                <div class="col-md-3 field-label-responsive">
                    <span style="color:red">*</span>
                    <label for="email">E-mail
                    </label>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <div class="input-group">
                            <div class="mt-2" style="width: 2.6rem">
                                <i class="fa fa-at"></i>
                            </div>
                            <input type="email" value="{{ form.email.value }}" name="email" class="form-control" id="email" placeholder="voce@exemplo.com"
                                   required maxlength="60">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-control-feedback">
                <small class="text-danger text-center">
                    {{ form.email.errors }}
                </small>
            </div>
            {% if not user.is_authenticated %}
            <div class="row">
                <div class="col-md-3 field-label-responsive">
                    <span style="color:red">*</span>
                    <label for="password1">Senha</label>
                </div>
                <div class="col-md-6">
                    <div class="form-group has-danger">
                        <div class="input-group">
                            <div class="mt-2" style="width: 2.6rem">
                                <i class="fa fa-key"></i>
                            </div>
                            <input type="password" name="password1" class="form-control" id="password1" placeholder="Senha" required>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-control-feedback">
                <small class="text-danger text-center">
                    {{ form.password1.errors }}
                </small>
            </div>
            <div class="row">
                <div class="col-md-3 field-label-responsive">
                    <span style="color:red">*</span>
                    <label for="password2">Confirmar Senha</label>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <div class="input-group">
                            <div class="mt-2" style="width: 2.6rem">
                                <i class="fa fa-repeat"></i>
                            </div>
                            <input type="password" name="password2" class="form-control" id="password2" placeholder="Confirmar Senha" required>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-control-feedback">
                <small class="text-danger text-center">
                    {{ form.password2.errors }}
                </small>
            </div>
            {% endif %}
            <div class="row">
                <div class="col-md-3 field-label-responsive">
                    <span style="color:red">**</span>
                    <label for="password">Conta pública</label>
                </div>
                <div class="mt-2 ml-3" style="width: 2.6rem">
                    <i class="fa fa-user-secret" aria-hidden="true"></i>
                </div>
                <div class="col-md-5 mt-2">
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="id_conta_publica_0" value="True" name="conta_publica" class="custom-control-input" {%if publica%}
                               checked {%endif%}>
                        <label class="custom-control-label" for="id_conta_publica_0">Sim</label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="id_conta_publica_1" value="False" name="conta_publica" class="custom-control-input" {% if not publica%}checked{%endif%}>
                        <label class="custom-control-label" for="id_conta_publica_1">Não</label>
                    </div>
                </div>
            </div>
            <div class="form-control-feedback">
                <small class="text-danger text-center">
                    {{ form.conta_publica.errors }}
                </small>
            </div>
            <div class="row">
                <div class="col-md-7"></div>
                <div class="col-md-3 ml-5">
                    {% if user.is_authenticated %}
                    <button type="submit" class="btn btn-primary" value="/atualizar/">
                        Atualizar</button>{% else %}
                    <button type="submit" class="btn btn-primary" value="/registra/">
                        Salvar</button>{% endif %}
                </div>
            </div>
        </div>
    </form>
</div>
<div class="row mt-5">
    <small class="mx-auto">
        <span style="color:red">*</span> Campos obrigatórios
        <br/>
        <span style="color:red">**</span> A conta pública torna a autoria de suas alterações no site visíveis para outros usuários.
    </small>
</div>
</body>
</html>
