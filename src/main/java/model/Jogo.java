package model;

public class Jogo {
	
	private Integer CodigoJogo;
	private Integer CodigoTimeA;
    private Integer CodigoTimeB;
    private Integer GolsTimeA;
    private Integer GolsTImeB;
    private String DataJogo;
    private Integer CodRodada;
	private Time tA;
    private Time tB;    
    
    public Time gettA() {
		return tA;
	}
	public void settA(Time tA) {
		this.tA = tA;
	}
	public Time gettB() {
		return tB;
	}
	public void settB(Time tB) {
		this.tB = tB;
	}

    
	public Integer getCodigoJogo() {
		return CodigoJogo;
	}
	public void setCodigoJogo(Integer codigoJogo) {
		CodigoJogo = codigoJogo;
	}
	public Integer getCodigoTimeA() {
		return CodigoTimeA;
	}
	public void setCodigoTimeA(Integer codigoTimeA) {
		CodigoTimeA = codigoTimeA;
	}
	public Integer getCodigoTimeB() {
		return CodigoTimeB;
	}
	public void setCodigoTimeB(Integer codigoTimeB) {
		CodigoTimeB = codigoTimeB;
	}
	public Integer getGolsTimeA() {
		return GolsTimeA;
	}
	public void setGolsTimeA(Integer golsTimeA) {
		GolsTimeA = golsTimeA;
	}
	public Integer getGolsTImeB() {
		return GolsTImeB;
	}
	public void setGolsTImeB(Integer golsTImeB) {
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
}
