<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<title>Autenticação</title>
<html>
<body>
<div class="container py-5">
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <!-- form card login -->
                    <div class="card rounded-0">
                        <div class="card-header">
                            <h3 class="font-weight-light mb-0"><i class="fa fa-user-circle-o" aria-hidden="true"></i> Autenticar-se</h3>
                        </div>
                        <div class="card-body">
                            <form class="form" action="/identificarUsuario" role="form" autocomplete="off" id="formLogin" novalidate="" method="POST">
                                <div class="form-group">
                                    <label for="matricula">Matrícula</label>
                                    <input type="text" class="form-control form-control-lg rounded-0" name="matricula" id="matricula" placeholder="Matricula">
                                    <div class="invalid-feedback">Esqueceu a matrícula.</div>
                                </div>
                                <div class="form-group">
                                    <label>Senha</label>
                                    <input type="password" class="form-control form-control-lg rounded-0" name="senha" id="senha" autocomplete="new-password" placeholder="Senha">
                                    <div class="invalid-feedback">Entre com sua senha!</div>
                                </div>
                                <button type="submit" class="btn btn-success btn-lg float-right" id="btnLogin">Login</button>
                            </form>
                        </div>
                        <!--/card-block-->
                    </div>
                    <!-- /form card login -->
                </div>
            </div>
            <!--/row-->
        </div>
        <!--/col-->
    </div>
    <!--/row-->
</div>
<!--/container-->
</body>
</html>
