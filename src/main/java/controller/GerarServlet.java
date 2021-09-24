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

import model.Grupo;
import persistence.GrupoDaoImpl;
import persistence.IGrupoDao;

@WebServlet("/Gerar")
public class GerarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IGrupoDao igp;   
    private Grupo gpA = new Grupo();
    private Grupo gpB = new Grupo();
    private Grupo gpC = new Grupo();
    private Grupo gpD = new Grupo();
    
    public GerarServlet() {
        igp = new GrupoDaoImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("button");
		//System.out.println("Japa otario" + cmd);
		switch (cmd){
		case "Gerar Grupos":
			EnxerTabGrupo();
			System.out.println("Termminei o metodo de gerar grupos");
			RequestDispatcher rdG = request.getRequestDispatcher("grupos.jsp");
			rdG.forward(request, response);
		break;
		case "Gerar Jogos":
			geraJogo();
			System.out.println("Termminei o metodo de gerar jogo");
			RequestDispatcher rdJ = request.getRequestDispatcher("jogos.jsp");
			rdJ.forward(request, response);
		break;
		case "Gerar Rodadas":
			System.out.println("Japa viado");
			RequestDispatcher rd = request.getRequestDispatcher("rodadas.jsp");
			rd.forward(request, response);
		break;
		
		}
	}
	
	public void EnxerTabGrupo() {
		gpA.setNomeGrupo("A");
		gpB.setNomeGrupo("B");
		gpC.setNomeGrupo("C");
		gpD.setNomeGrupo("D");
		try {
			igp.gerarGrupos();
			gpA = igp.selectGrupo(gpA);
			gpB = igp.selectGrupo(gpB);
			gpC = igp.selectGrupo(gpC);
			gpD = igp.selectGrupo(gpD);
			System.out.println(gpA.getNomeGrupo() + gpA.getCodigoTime1()+ gpA.getCodigoTime2()+ gpA.getCodigoTime3()+ gpA.getCodigoTime4());
			System.out.println(gpB.getNomeGrupo() + gpB.getCodigoTime1()+ gpB.getCodigoTime2()+ gpB.getCodigoTime3()+ gpB.getCodigoTime4());
			System.out.println(gpC.getNomeGrupo() + gpC.getCodigoTime1()+ gpC.getCodigoTime2()+ gpC.getCodigoTime3()+ gpC.getCodigoTime4());
			System.out.println(gpD.getNomeGrupo() + gpD.getCodigoTime1()+ gpD.getCodigoTime2()+ gpD.getCodigoTime3()+ gpD.getCodigoTime4());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void geraJogo() {
		
	}

}
