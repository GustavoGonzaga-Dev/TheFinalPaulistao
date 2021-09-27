package model;

public class Grupo {

	private String nomeGrupo;
    private Integer CodigoTime1;
    private Integer CodigoTime2;
    private Integer CodigoTime3;
    private Integer CodigoTime4;
    
    private String NomeTime1;
    private String NomeTime2;
    private String NomeTime3;
    private String NomeTime4;
    
    

    public String getNomeTime1() {
		return NomeTime1;
	}

	public void setNomeTime1(String nomeTime1) {
		NomeTime1 = nomeTime1;
	}

	public String getNomeTime2() {
		return NomeTime2;
	}

	public void setNomeTime2(String nomeTime2) {
		NomeTime2 = nomeTime2;
	}

	public String getNomeTime3() {
		return NomeTime3;
	}

	public void setNomeTime3(String nomeTime3) {
		NomeTime3 = nomeTime3;
	}

	public String getNomeTime4() {
		return NomeTime4;
	}

	public void setNomeTime4(String nomeTime4) {
		NomeTime4 = nomeTime4;
	}

	public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public Integer getCodigoTime1() {
        return CodigoTime1;
    }

    public void setCodigoTime1(Integer codigoTime1) {
        CodigoTime1 = codigoTime1;
    }

    public Integer getCodigoTime2() {
        return CodigoTime2;
    }

    public void setCodigoTime2(Integer codigoTime2) {
        CodigoTime2 = codigoTime2;
    }

    public Integer getCodigoTime3() {
        return CodigoTime3;
    }

    public void setCodigoTime3(Integer codigoTime3) {
        CodigoTime3 = codigoTime3;
    }

    public Integer getCodigoTime4() {
        return CodigoTime4;
    }

    public void setCodigoTime4(Integer codigoTime4) {
        CodigoTime4 = codigoTime4;
    }

    @Override
    public String toString() {
        return "Grupos{" +
                "nomeGrupo='" + nomeGrupo + '\'' +
                ", CodigoTime1=" + CodigoTime1 +
                ", CodigoTime2=" + CodigoTime2 +
                ", CodigoTime3=" + CodigoTime3 +
                ", CodigoTime4=" + CodigoTime4 +
                '}';
    }
	
}

