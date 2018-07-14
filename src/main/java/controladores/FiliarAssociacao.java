package controladores;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dados.datamappers.AssociacaoFiliacaoEnderecoDataMapper;
import dominio.Perfil;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(name = "FiliarAssociacao", urlPatterns = "/filiarAssociacao")
public class FiliarAssociacao extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            request.getSession().setAttribute("proximaPagina", "/filiarAssociacao.jsp");
            request.getRequestDispatcher("/identificarUsuario").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro","Ocorreu um erro inesperado");
            response.sendRedirect("/index.jsp");
        }

    }

    //TODO: Ajustar o UF
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numeroOficio = request.getParameter("numeroOficio");
        Date dataOficio = Date.valueOf(request.getParameter("dataOficio"));
        String numeroComprovante = request.getParameter("numeroComprovante");

        String nome = request.getParameter("nome");
        String sigla = request.getParameter("sigla");
        String telefone = request.getParameter("telefone");

        String logradouro = request.getParameter("logradouro");
        int numeroLogradouro = Integer.parseInt(request.getParameter("numeroLogradouro"));
        String complemento = request.getParameter("complemento");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");

        System.out.println("NOME: " + nome);
        System.out.println("DATA_OFICIO: " + dataOficio);
        System.out.println("NUMERO_LOGRADOURO: " + numeroLogradouro);

        AssociacaoFiliacaoEnderecoDataMapper associacaoFiliacaoEnderecoDataMapper = new AssociacaoFiliacaoEnderecoDataMapper();
        boolean result = associacaoFiliacaoEnderecoDataMapper.criar(nome, sigla, telefone,
                                                    logradouro, numeroLogradouro, cidade, bairro, cep, 1,
                                                    numeroOficio, dataOficio, numeroComprovante);

        if(result){
            request.setAttribute("mensagemSucesso", "Associação filiada com sucesso");
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
