package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Grupo;

public class GrupoDaoImpl implements IGrupoDao{
	//sp_geraGrupoTESTE (@A INT)
	private Connection c;

	public Connection GrupoDaoImpll () throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
		return c;
	}

	@Override
	public String gerarGrupos() throws SQLException {
		try {
			c = GrupoDaoImpll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sql = "{CALL sp_geraGrupoTESTE(?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setInt(1, 1);
		//cs.registerOutParameter(2, Types.VARCHAR);
		cs.execute();
		cs.close();

		String saida = "Chamou aqui";
		//System.out.println(saida);
		return saida;
	}

	@Override
	public Grupo selectGrupo(Grupo gp) throws SQLException {
		try {
			c = GrupoDaoImpll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sql = "SELECT codigotime1, codigotime2, codigotime3, codigotime4 FROM grupos WHERE nomegrupo = ?";
		PreparedStatement ps = c.prepareStatement(sql);

		ps.setString(1, gp.getNomeGrupo());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			gp.setCodigoTime1(rs.getInt("codigotime1"));
			gp.setCodigoTime2(rs.getInt("codigotime2"));
			gp.setCodigoTime3(rs.getInt("codigotime3"));
			gp.setCodigoTime4(rs.getInt("codigotime4"));
		}
		rs.close();
		ps.close();
		///////////////////////////
		String sqll = "SELECT nometime FROM times WHERE codigotime in(?, ?, ?, ?)";
		PreparedStatement pss = c.prepareStatement(sqll);
		System.out.println("passou dessa merda de linha");

		pss.setInt(1, gp.getCodigoTime1());
		pss.setInt(2, gp.getCodigoTime2());
		pss.setInt(3, gp.getCodigoTime3());
		pss.setInt(4, gp.getCodigoTime4());
		ResultSet rss = pss.executeQuery();
		rss.next();
		gp.setNomeTime1(rss.getString("nometime"));
		rss.next();
		gp.setNomeTime2(rss.getString("nometime"));
		rss.next();
		gp.setNomeTime3(rss.getString("nometime"));
		rss.next();
		gp.setNomeTime4(rss.getString("nometime"));

		rss.close();
		pss.close();
		return gp;
	}
}
