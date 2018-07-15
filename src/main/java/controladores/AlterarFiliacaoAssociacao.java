package controladores;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AlterarFiliacaoAssociacao", urlPatterns = "/alterarFiliacaoAssociacao")
public class AlterarFiliacaoAssociacao extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            ArrayList<Integer> perfisAutorizados = new ArrayList<Integer>();
//            perfisAutorizados.add(Perfil.SECRETARIO.getId());
//            ResultSet resultSet = new AssociacaoDataMapper().buscar();
//            AssociacaoMD associacaoMD = new AssociacaoMD(resultSet);
//            request.setAttribute("associacaoMD", associacaoMD);
//            Utils.autenticar(request, perfisAutorizados);
//            request.getRequestDispatcher("/alterarFiliacaoAssociacao.jsp").forward(request, response);
//        } catch (UsuarioNaoAutenticadoException e) {
//            ArrayList<Integer> perfisAutorizados = new ArrayList<Integer>();
//            perfisAutorizados.add(Perfil.SECRETARIO.getId());
//
//            request.getSession().setAttribute("proximaPagina", "/alterarFiliacaoAssociacao");
//            request.setAttribute("perfisAutorizados", perfisAutorizados);
//            response.sendRedirect("/identificarUsuario");
//            //request.getRequestDispatcher("/identificarUsuario").forward(request, response);
//        }
    }

    /* protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        AssociacaoFiliacaoDataMapper associacaoFiliacaoEnderecoDataMapper = new AssociacaoFiliacaoDataMapper();
        boolean result = associacaoFiliacaoEnderecoDataMapper.criar(nome, sigla, telefone,
                logradouro, numeroLogradouro, cidade, bairro, cep, 1,
                numeroOficio, dataOficio, numeroComprovante);

        if(result){
            request.setAttribute("mensagemSucesso", "Associação filiada com sucesso");
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
*/
}


