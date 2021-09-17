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

        String saida = cs.getString(5);
        cs.close();
        System.out.println(saida);
        return saida;
	}

	@Override
	public List<Grupo> selectGrupo() throws SQLException {
		List<Grupo> listaGrupo = new ArrayList<Grupo>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t.CodigoTime AS Codigo, ");
		sql.append(" t.NomeTime AS Times ");
		sql.append("FROM Times t, Grupos g ");
		sql.append("WHERE t.CodigoTime = g.CodigoTime1 ");
		
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Grupo gru = new Grupo();
			gru.setCodigoTime1(rs.getInt("Codigo"));
			gru.setNomeGrupo(rs.getString("Times"));
		}
		rs.close();
		ps.close();
		return listaGrupo;
	}
}
