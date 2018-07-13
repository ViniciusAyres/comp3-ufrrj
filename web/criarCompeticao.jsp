<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<html>
<body>
<div class="container">
    <div class="card mt-5">
        <div class="card-header">
            <h3 class="font-weight-light ml-3"><i class="fa fa-trophy" aria-hidden="true"></i> Insira abaixo o nome e data da Competição</h3>
        </div>
        <form class="form" role="form" method="POST" action="/criarCompeticao">
            <div class="card-body">
            <div class="container">
                <div class="row mx-auto">
                    <div class="col-md-12 mt-2">
                        <table class ="table table-bordered">
                            <thead class="thead-light">
                            <tr>
                                <th>Nome da Competição</th>
                                <th>Data da Competição</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th><input type="text" name="nome" class="form-control" maxlength="10" id="nome" placeholder="Nome" required ></th>
                                <th><input type="date" class="form-control" id="date" required ></th>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            </div>
        </form>
        <div class="card-footer">
            <div class="row mr-5" style="float:right">
                <button class="btn btn-info" type="submit" value="/criarCompeticao/">Verificar</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
