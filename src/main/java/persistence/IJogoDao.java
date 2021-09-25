package persistence;

import java.sql.SQLException;

import model.Jogo;

public interface IJogoDao {
	public String insereJogos(Jogo jogo) throws SQLException;
}
