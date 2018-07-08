<%--
  Created by IntelliJ IDEA.
  User: Leonardo
  Date: 08/07/2018
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</head>
<body>
<!-- HEADER -->
<nav class="navbar navbar-expand-lg navbar-info bg-info">
    <span class="navbar-brand mb-0 text-white">SISFARJ</span>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link text-white" href="/"> Início</a>
            </li>
            <li class="nav-item dropdown has-mega-menu">
                <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">Competições</a>
                <div class="dropdown-menu dropdown-menu-left">
                    <div class="px-0 container container-sm">
                        <div class="row">
                            <a class="dropdown-item text-white" href="#">TESTE</a>
                        </div>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/faq">FAQ</a>
            </li>
        </ul>
    </div>
</nav>
<!-- FOOTER -->
<%--<hr style="border:solid">
<footer class="text-center">
    <small id="footer">
        <p class="font-weight-light mt-3">
            <br /> Copyright © 2018 SISFARJ
            <br /> Todos os direitos reservados
        </p>
    </small>
</footer>--%>
</body>
</html>
