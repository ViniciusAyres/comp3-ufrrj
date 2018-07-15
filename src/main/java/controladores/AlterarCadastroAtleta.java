package controladores;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AlterarCadastroAtleta", urlPatterns = "/alterarCadastroAtleta")
public class AlterarCadastroAtleta extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            ArrayList<Integer> perfisAutorizados = new ArrayList<Integer>();
//            perfisAutorizados.add(Perfil.SECRETARIO.getId());
//            perfisAutorizados.add(Perfil.DIRETOR_TECNICO.getId());
//            Utils.autenticar(request, perfisAutorizados);
//            //String matriculaAtleta = request.getRequestURL().toString().split("=")[1];
//            //System.out.println("matricula atleta" + matriculaAtleta);
//            AtletaDataMapper atletaDataMapper = new AtletaDataMapper();
//            ResultSet resultSet = atletaDataMapper.buscar();
//            AtletaMT atletaMT = new AtletaMT(resultSet);
//            request.setAttribute("atletaMT", atletaMT);
//            request.getRequestDispatcher("/alterarCadastroAtleta.jsp").forward(request, response);
//        } catch (UsuarioNaoAutenticadoException e) {
//            request.getSession().setAttribute("proximaPagina", "/alterarCadastroAtleta");
//            response.sendRedirect("/identificarUsuario");
//            //request.getRequestDispatcher("/identificarUsuario").forward(request, response);
//        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String matriculaAtleta = (String) request.getSession().getAttribute("matriculaAtleta");
//        System.out.println("sss matricula atleta: " + matriculaAtleta);
//
//        String numeroOficio = request.getParameter("numeroOficio");
//        Date dataOficio = Date.valueOf(request.getParameter("dataOficio"));
//
//        String nome = request.getParameter("nome");
//        Date dataNascimento = Date.valueOf(request.getParameter("dataNascimento"));
//        Date dataAssociacao = Date.valueOf(request.getParameter("dataAssociacao"));
//        String matriculaAssociacao = request.getParameter("matriculaAssociacao");
//        String numeroComprovante = request.getParameter("numeroComprovante");
//        String categoria = request.getParameter("categoria");
//        try {
//            AssociacaoDataMapper associacaoDataMapper = new AssociacaoDataMapper();
//            AssociacaoMT associacaoMD = new AssociacaoMT(associacaoDataMapper.buscar());
//            associacaoMD.existe(matriculaAssociacao);
//            System.out.println("aqui");
//            AtletaInscricaoDataMapper atletaInscricaoDataMapper = new AtletaInscricaoDataMapper();
//            atletaInscricaoDataMapper.atualizar(matriculaAtleta, nome, dataNascimento, categoria,
//                    matriculaAssociacao, dataAssociacao, numeroComprovante, numeroOficio, dataOficio);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            request.getRequestDispatcher("/alterarCadastroAtleta");
//        } catch (RegistroNaoEncontradoException e) {
//            e.printStackTrace();
//            request.getRequestDispatcher("/alterarCadastroAtleta");
//        }
        response.sendRedirect("/index.jsp");
    }

}
