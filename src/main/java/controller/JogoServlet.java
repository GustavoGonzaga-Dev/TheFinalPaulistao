package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
		System.out.println("entrou aqui");
		ArrayList<Jogo> listaJogos = new ArrayList<Jogo>();
	
		try {
			if(cmd.contains("Pesquisar")) {
				listaJogos = ijg.encontrarJogos("");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			request.setAttribute("listaJogos", listaJogos);
			RequestDispatcher rd = request.getRequestDispatcher("rodadas.jsp");
            rd.forward(request, response);
		}
	}

}
