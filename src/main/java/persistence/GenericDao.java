package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {
		
	 private Connection c;

	 

	 public Connection getConnection() throws ClassNotFoundException, SQLException {

	 

		 Class.forName("net.sourceforge.jtds.jdbc.Driver");
	     c = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=bdPaulistao;namedPipe=true","usuario","senha");
	     //System.out.println("Conexao ok");
	     return c;
	 }
	
	
	
	
	    //private Connection c;

	    //public Connection getConnection() throws ClassNotFoundException, SQLException {

		//String hostName = "localhost";
	    //String dbName ="bdPaulistao";
	    //String user ="usuario";
	    //String senha ="senha";
	    //Class.forName("net.sourceforge.jtds.jdbc.Driver");
	    //c = DriverManager.getConnection(String.format("jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;", hostName, dbName, user, senha));

	    //return c;
	    //}

}
