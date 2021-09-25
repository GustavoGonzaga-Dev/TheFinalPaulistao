package persistence;

import java.sql.SQLException;

import model.Jogo;

public interface IJogoDao {
	public String insereJogos(Jogo jogo) throws SQLException;
	public boolean validaRodada(Jogo jogo) throws SQLException;
}
