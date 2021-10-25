package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.IJogoDao;
import persistence.JogoDaoImpl;

@WebServlet("/ClassGeral")
public class ClassGeral extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IJogoDao ijg;
	
    public ClassGeral() {
    	ijg = new JogoDaoImpl();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ijg.ClassGeral();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
