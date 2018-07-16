package controladores;

import dados.datamappers.AssociacaoDataMapper;
import dados.datamappers.AtletaDataMapper;
import dados.datamappers.AtletaInscricaoDataMapper;
import dados.datamappers.InscricaoDataMapper;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.AssociacaoMT;
import dominio.AtletaMT;
import dominio.excecoes.RegistroInvalido;
import utils.RecordSet;
import utils.Row;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "TransferirAtleta", urlPatterns = "/transferirAtleta")
public class TransferirAtleta extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RecordSet recordSet;
            if(request.getParameter("matricula") != null ) {
                recordSet = new AtletaInscricaoDataMapper().buscarParaTransferencia(request.getParameter("matricula"));
                request.getSession().setAttribute("dados", recordSet);
                request.getRequestDispatcher("/transferencia.jsp").forward(request, response);
            }else {
                //lista todas as associacoes
                recordSet = new AtletaDataMapper().buscar();
                request.getSession().setAttribute("dados", recordSet);
                request.getSession().setAttribute("proximaPagina", "/transferirAtleta.jsp");
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

        row.put("matriculaAssociacao", request.getParameter("matriculaAssociacao"));
        row.put("numeroOficio", request.getParameter("numeroOficio"));
        row.put("dataOficio", request.getParameter("dataOficio"));
        row.put("dataAssociacao", request.getParameter("dataAssociacao"));
        row.put("numeroComprovante", request.getParameter("numeroComprovante"));

        recordSet.add(row);
        try {
            AssociacaoMT assmt = new AssociacaoMT();
            AtletaMT amt = new AtletaMT();
            assmt.validarTransferencia(recordSet);
            amt.validarTransferencia(recordSet);
            AssociacaoDataMapper.buscarPorMatricula(request.getParameter("matriculaAssociacao"));
            InscricaoDataMapper.transferirAtleta(recordSet);
            request.getSession().setAttribute("mensagemSucesso", "Atleta Atualizado com sucesso!");
            response.sendRedirect("/index.jsp");
        }
        catch (RegistroNaoEncontradoException re){
            re.printStackTrace();
            request.getSession().setAttribute("mensagemErro", re.getMessage());
            response.sendRedirect("/transferirAtleta?matriculaAtleta="+request.getParameter("matricula"));
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
            request.getSession().setAttribute("mensagemErro", "Ocorreu um erro na transação");
            response.sendRedirect("/index.jsp");
        }
         catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("mensagemErro", "Ocorreu um erro inesperado");
            response.sendRedirect("/index.jsp");
        }
    }
}