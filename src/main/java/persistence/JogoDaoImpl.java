package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import model.Jogo;

public class JogoDaoImpl implements IJogoDao {

	private Connection c;

	public Connection JogoDaoImpll () throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
		return c;
	}
	
	@Override
	public String insereJogos(Jogo jogo) throws SQLException {
		try {
			c = JogoDaoImpll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sql = "{CALL sp_geraJogo(?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setInt(1, jogo.getCodigoJogo());
		cs.setInt(2, jogo.getCodigoTimeA());
		cs.setInt(3, jogo.getCodigoTimeB());
		cs.setInt(4, jogo.getCodRodada());
		cs.setString(5, jogo.getDataJogo());
		//cs.registerOutParameter(2, Types.VARCHAR);
		cs.execute();
		cs.close();

		String saida = "Chamou aqui";
		//System.out.println(saida);
		return saida;

	}

	@Override
	public boolean validaRodada(Jogo jogo) throws SQLException {
		try {
			c = JogoDaoImpll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sql = "{CALL sp_confereJogo(?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setInt(1, jogo.getCodigoTimeA());
		cs.setInt(2, jogo.getCodigoTimeB());
		cs.registerOutParameter(3, Types.INTEGER);
		cs.execute();
		int saida = cs.getInt(3);
		cs.close();
		if(saida!= 0){
			return false;
		}
		return true;
	}

}
