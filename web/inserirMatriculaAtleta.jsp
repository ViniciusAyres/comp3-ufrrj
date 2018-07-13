<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>

<div class="container mt-5">
    <div class="card">
        <div class="card-header">
                <h5 class="modal-title" id="exampleModalAtletas">Insira abaixo a matrícula do Atleta que deseja adicionar à Prova</h5>
        </div>
            <div class="card-body">
                <div class="container" style="min-height: 130px">
                    <div class="row mt-5">
                        <div class="col-md-3 text-right">
                            <label class="mt-2" for="matricula"><i class="fa fa-id-card" aria-hidden="true"></i> Matrícula</label>
                            <span style="color:red">*</span>
                        </div>
                        <div class="col-md-9">
                            <div class="form-group has-danger">
                                <div class="input-group">
                                    <input type="text" name="matricula" class="form-control" id="matricula" placeholder="Matrícula" required maxlength="10">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-footer">
                <div class="bg-info clearfix" style="background-color:#f7f7f7 !important;">
                    <a href="inscreverAtletaCompeticao.jsp" class="float-left mt-2">Voltar</a>
                    <button class="btn btn-info float-right" type="submit" value="/inserirMatricula/">Enviar</button>
                </div>
            </div>
    </div>
</div>
