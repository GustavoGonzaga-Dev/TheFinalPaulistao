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

import model.Grupo;
import persistence.GrupoDaoImpl;
import persistence.IGrupoDao;

/**
 * Servlet implementation class CarregaGrupoServlet
 */
@WebServlet("/CarregaGrupoServlet")
public class CarregaGrupoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IGrupoDao igp; 
	private Grupo gpA = new Grupo();
	private Grupo gpB = new Grupo();
	private Grupo gpC = new Grupo();
	private Grupo gpD = new Grupo();
	
	
    public CarregaGrupoServlet() {
    	igp = new GrupoDaoImpl();
       
    }

    public void encherVariaveis() {
		try {
			gpA.setNomeGrupo("A");
			gpB.setNomeGrupo("B");
			gpC.setNomeGrupo("C");
			gpD.setNomeGrupo("D");
			gpA = igp.selectGrupo(gpA);
			gpB = igp.selectGrupo(gpB);
			gpC = igp.selectGrupo(gpC);
			gpD = igp.selectGrupo(gpD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		encherVariaveis();
		ArrayList<String> t = new ArrayList<String>();
		System.out.println("ta chamando essa buceta");
		t.add(gpA.getNomeTime1());
		t.add(gpA.getNomeTime2());
		t.add(gpA.getNomeTime3());
		t.add(gpA.getNomeTime4());
		
		request.setAttribute("gpA", gpA.toString2());
		RequestDispatcher rd = request.getRequestDispatcher("grupos.jsp");
        rd.forward(request, response);
	}

}
