package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Jogo;
import persistence.IJogoDao;
import persistence.JogoDaoImpl;

@WebServlet("/jogo")
public class JogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IJogoDao ijg;
	public JogoServlet() {
		ijg = new JogoDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("button");

		switch (cmd){
		case "Pesquisar":
			List<Jogo> listaJogos = new ArrayList<Jogo>();
			String jg = validaCampos(request,cmd);
			try {
				if (jg != null) {
					if(cmd.contains("Pesquisar")) {
						listaJogos = ijg.encontrarJogos(jg);
					}	
				}else {
					System.out.println("TA vazio a parada");

				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				request.setAttribute("listaJogos", listaJogos);
				RequestDispatcher rd = request.getRequestDispatcher("rodadas.jsp");
				rd.forward(request, response);
			}
			break;
		case "Resultado":
			System.out.println("o codigo do jogo é " );
			String Resultado = "Sem Resultado";
			try {
				
				Resultado = ijg.BuscaResultadoJogos(Integer.parseInt(request.getParameter("jg.codigoJogo")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				request.setAttribute("listaJogos", Resultado);
				RequestDispatcher rd = request.getRequestDispatcher("rodadas.jsp");
				rd.forward(request, response);
			}
			//System.out.println("Apertou outra parada ai " + request.getParameter("escolhas") + " , o codigo do jogo é " + request.getParameter("jg.CodigoJogo"));
			//ijg.encontrarJogos(jg);
			
			break;
		}
	}

	private String validaCampos(HttpServletRequest request, String cmd){
		String jg = null ;
		if (cmd.equals("Pesquisar")) {
			jg = (request.getParameter("DataJogo"));
		}
		return jg;
	}
}
