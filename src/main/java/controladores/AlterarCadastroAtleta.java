package controladores;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dados.datamappers.AssociacaoDataMapper;
import dados.datamappers.AssociacaoFiliacaoDataMapper;
import dados.datamappers.AtletaDataMapper;
import dados.datamappers.AtletaInscricaoDataMapper;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.*;
import utils.RecordSet;
import utils.Row;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "AlterarCadastroAtleta", urlPatterns = "/alterarCadastroAtleta")
public class AlterarCadastroAtleta extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RecordSet recordSet;
            if(request.getParameter("matriculaAtleta") != null ) {
                recordSet = new AtletaInscricaoDataMapper().buscarPorMatricula(request.getParameter("matriculaAtleta"));
                request.getSession().setAttribute("dados", recordSet);
                request.getRequestDispatcher("/alterarAtleta.jsp").forward(request, response);
            }else {
                //lista todas as associacoes
                recordSet = new AtletaDataMapper().buscar();
                request.getSession().setAttribute("dados", recordSet);
                request.getSession().setAttribute("proximaPagina", "/alterarCadastroAtleta.jsp");
                request.getRequestDispatcher("/identificarUsuario").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("mensagemErro","Ocorreu um erro inesperado");
            response.sendRedirect("/index.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecordSet recordSet = new RecordSet();
        Row row = new Row();

        row.put("matricula", request.getParameter("matricula"));
        row.put("nome", request.getParameter("nome"));
        row.put("dataAssociacao", request.getParameter("data_entrada"));
        row.put("numero_oficio", request.getParameter("numero_oficio"));
        row.put("data_oficio", request.getParameter("dataOficio"));

        recordSet.add(row);
        try {
            InscricaoMT imt = new InscricaoMT();
            AtletaMT amt = new AtletaMT();
            imt.validarEdicao(recordSet);
            amt.validarEdicao(recordSet);
            AtletaInscricaoDataMapper.atualizar(recordSet);
            request.getSession().setAttribute("mensagemSucesso","Atleta Atualizado com sucesso!");
            response.sendRedirect("/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("mensagemErro", "Ocorreu um erro inesperado");
            response.sendRedirect("/index.jsp");
        }
    }
}
