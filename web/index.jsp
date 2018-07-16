<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%
    request.getSession().invalidate();
%>
<style>
    #sidebar {
        overflow: hidden;
        z-index: 3;
    }
    #sidebar .list-group {
        min-width: 400px;
        background-color: #e9ecef;
        min-height: 100vh;
    }
    #sidebar i {
        margin-right: 6px;
    }

    #sidebar .list-group-item {
        border-radius: 0;
        background-color: #e9ecef;
        color: #ccc;
        border-left: 0;
        border-right: 0;
        border-color: #6c757d;
        white-space: nowrap;
    }

    /* highlight active menu */
    #sidebar .list-group-item:not(.collapsed) {
        background-color: #e9ecef;
    }

    /* closed state */
    #sidebar .list-group .list-group-item[aria-expanded="false"]::after {
        content: " \f0d7";
        font-family: FontAwesome;
        display: inline;
        text-align: right;
        padding-left: 5px;
    }

    /* open state */
    #sidebar .list-group .list-group-item[aria-expanded="true"] {
        background-color: #e9ecef;
    }
    #sidebar .list-group .list-group-item[aria-expanded="true"]::after {
        content: " \f0da";
        font-family: FontAwesome;
        display: inline;
        text-align: right;
        padding-left: 5px;
    }

    /* level 1*/
    #sidebar .list-group .collapse .list-group-item,
    #sidebar .list-group .collapsing .list-group-item  {
        padding-left: 20px;
    }

    /* level 2*/
    #sidebar .list-group .collapse > .collapse .list-group-item,
    #sidebar .list-group .collapse > .collapsing .list-group-item {
        padding-left: 30px;
    }

    /* level 3*/
    #sidebar .list-group .collapse > .collapse > .collapse .list-group-item {
        padding-left: 40px;
    }

    @media (max-width:768px) {
        #sidebar {
            min-width: 35px;
            max-width: 40px;
            overflow-y: auto;
            overflow-x: visible;
            transition: all 0.25s ease;
            transform: translateX(-45px);
            position: fixed;
        }

        #sidebar.show {
            transform: translateX(0);
        }

        #sidebar::-webkit-scrollbar{ width: 0px; }

        #sidebar, #sidebar .list-group {
            min-width: 35px;
            overflow: visible;
        }
        /* overlay sub levels on small screens */
        #sidebar .list-group .collapse.show, #sidebar .list-group .collapsing {
            position: relative;
            z-index: 1;
            width: 190px;
            top: 0;
        }
        #sidebar .list-group > .list-group-item {
            text-align: center;
            padding: .75rem .5rem;
        }
        /* hide caret icons of top level when collapsed */
        #sidebar .list-group > .list-group-item[aria-expanded="true"]::after,
        #sidebar .list-group > .list-group-item[aria-expanded="false"]::after {
            display:none;
        }
    }

    .collapse.show {
        visibility: visible;
    }
    .collapsing {
        visibility: visible;
        height: 0;
        -webkit-transition-property: height, visibility;
        transition-property: height, visibility;
        -webkit-transition-timing-function: ease-out;
        transition-timing-function: ease-out;
    }
    .collapsing.width {
        -webkit-transition-property: width, visibility;
        transition-property: width, visibility;
        width: 0;
        height: 100%;
        -webkit-transition-timing-function: ease-out;
        transition-timing-function: ease-out;
    }
</style>
<title>Início</title>
<div class="container-fluid">
    <div class="row d-flex d-md-block flex-nowrap wrapper">
        <div class="col-md-3 float-left col-1 pl-0 pr-0 collapse width show" id="sidebar">
            <div class="list-group border-0 card text-center text-md-left">
                <a href="#menu1" class="list-group-item d-inline-block collapsed text-dark" data-toggle="collapse" aria-expanded="false"><i class="fa fa-handshake-o" aria-hidden="true"></i> <span class="d-none d-md-inline">Associação</span></a>
                <div class="collapse" id="menu1" data-parent="#sidebar">
                    <a href="/alterarFiliacaoAssociacao" class="list-group-item text-dark">Alterar Filiação da Associação</a>
                    <a href="/filiarAssociacao" class="list-group-item text-dark">Filiar uma Associação</a>
                    <a href="/listarAssociacoes" class="list-group-item text-dark">Listar Associações</a>
                </div>
                <a href="#menu2" class="list-group-item d-inline-block collapsed text-dark" data-toggle="collapse" aria-expanded="false"><i class="fa fa-user" aria-hidden="true"></i> <span class="d-none d-md-inline">Atleta</span></a>
                <div class="collapse" id="menu2" data-parent="#sidebar">
                    <a href="/alterarCadastroAtleta" class="list-group-item text-dark">Alterar Cadastro do Atleta</a>
                    <a href="/cadastrarAtleta" class="list-group-item text-dark">Cadastrar Atleta</a>
                    <a href="/inscreverAtletaCompeticao.jsp" class="list-group-item text-dark">Inscrever Atleta em Competição</a>
                    <a href="/inserirResultadoAtleta.jsp" class="list-group-item text-dark">Inserir resultado do Atleta</a>
                    <a href="/transferirAtleta" class="list-group-item text-dark">Transferir Atleta</a>
                </div>
                <a href="#menu3" class="list-group-item d-inline-block collapsed text-dark" data-toggle="collapse" aria-expanded="false"><i class="fa fa-trophy" aria-hidden="true"></i> <span class="d-none d-md-inline">Competição</span></a>
                <div class="collapse" id="menu3" data-parent="#sidebar">
                    <a href="/alterarCompeticao.jsp" class="list-group-item text-dark">Alterar Competição</a>
                    <a href="/alterarLocaisCompeticao.jsp" class="list-group-item text-dark">Alterar Locais de Competição</a>
                    <a href="/criarCompeticao.jsp" class="list-group-item text-dark">Criar Competição</a>
                    <a href="/incluirLocaisCompeticao" class="list-group-item text-dark">Incluir Locais de Competição</a>
                    <a href="/listarCompeticoes.jsp" class="list-group-item text-dark">Listar Competições</a>
                    <a href="/listarBalizamentoCompeticao.jsp" class="list-group-item text-dark">Listar Balizamento de Competição</a>
                    <a href="/listarLocaisCompeticao" class="list-group-item text-dark">Listar Locais de Competição</a>
                    <a href="/listarPontuacaoCompeticao.jsp" class="list-group-item text-dark">Listar Pontuação de Competição</a>
                    <a href="/listarPontuacaoFinal.jsp" class="list-group-item text-dark">Listar Pontuação Final de Competição</a>
                </div>
            </div>
        </div>
        <main class="col-md-9 float-left col px-5 pl-md-2 pt-2 main">
            <a href="#" data-target="#sidebar" data-toggle="collapse" style="color:#17a2b8" title="Mover Menu"><i class="fa fa-outdent fa-2x py-2 p-1"></i></a>
                <div class="jumbotron jumbotron-fluid">
                    <h1 class="display-4 ml-3 text-center">SISFARJ</h1>
                    <p class="lead ml-3 text-center">Filie-se e participe de competições de natação amadoras, estaduais e a nível mundial.</p>
                    <hr class="my-4">
                     <div class="row">
                        <div class="mx-auto">
                            <img src="/img/Swimming.jpg" class="img-responsive" alt="Responsive image" width="430">
                        </div>
                    </div>
                    <p class="mt-4 ml-3 text-center">Competições para atletas de todas as idades, divididos em suas devidas classes para competir em provas com outros atletas.</p>
                </div>
        </main>
    </div>
</div>
