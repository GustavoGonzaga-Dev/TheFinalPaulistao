package model;

public class Jogo {
	
	private int CodigoJogo;
	private int CodigoTimeA;
    private int CodigoTimeB;
    private int GolsTimeA;
    private int GolsTImeB;
    private String DataJogo;
    private int CodRodada;
	private String tA;
    private String tB; 
    private String Resultado;
    
	public String getResultado() {
		return Resultado;
	}
	public void setResultado(String resultado) {
		Resultado = resultado;
	}
	public String gettA() {
		return tA;
	}
	public void settA(String tA) {
		this.tA = tA;
	}
	public String gettB() {
		return tB;
	}
	public void settB(String tB) {
		this.tB = tB;
	}
	public int getCodigoJogo() {
		return CodigoJogo;
	}
	public void setCodigoJogo(int codigoJogo) {
		CodigoJogo = codigoJogo;
	}
	public int getCodigoTimeA() {
		return CodigoTimeA;
	}
	public void setCodigoTimeA(int codigoTimeA) {
		CodigoTimeA = codigoTimeA;
	}
	public int getCodigoTimeB() {
		return CodigoTimeB;
	}
	public void setCodigoTimeB(int codigoTimeB) {
		CodigoTimeB = codigoTimeB;
	}
	public int getGolsTimeA() {
		return GolsTimeA;
	}
	public void setGolsTimeA(int golsTimeA) {
		GolsTimeA = golsTimeA;
	}
	public int getGolsTImeB() {
		return GolsTImeB;
	}
	public void setGolsTImeB(int golsTImeB) {
		GolsTImeB = golsTImeB;
	}
	public String getDataJogo() {
		return DataJogo;
	}
	public void setDataJogo(String dataJogo) {
		DataJogo = dataJogo;
	}
	public Integer getCodRodada() {
		return CodRodada;
	}
	public void setCodRodada(Integer codRodada) {
		CodRodada = codRodada;
	}
	@Override
	public String toString() {
		return "" +
				"   [Jogo=" + CodigoJogo +
				" ], [" + tA + 
				"], [Gols: " + GolsTimeA +
				"], [  X  " + 
				"], [" + tB + 
				"], [Gols: " + GolsTImeB + 
				"], [Data=" + DataJogo + 
				"], [Rodada=" + CodRodada + 
				"]";
	}

}
