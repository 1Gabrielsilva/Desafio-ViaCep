package br.com.busca.enderecov2.utils;

public enum RegioesFrete {

	/**
	 * Região Sudeste.
	 */
	SAO_PAULO("SP", 7.85), MINAS_GERAIS("MG", 7.85), ESPIRITO_SANTO("ES", 7.85), RIO_DE_JANEIRO("RJ", 7.85),

	/**
	 * Região Sul.
	 */
	RIO_GRANDE_DO_SUL("RS", 17.30), SANTA_CATARINA("SC", 17.30), PARANA("PR", 17.30),

	/**
	 * Região Centro-Oeste.
	 */
	MATO_GROSSO_DO_SUL("MS", 12.50), GOIAS("GO", 12.50), MATO_GROSSO("MT", 12.50), DISTRITO_FEDERAL("DF", 12.50),

	/**
	 * Região Norte.
	 */
	ACRE("AC", 20.83), AMAZONAS("AM", 20.83), RORAIMA("RR", 20.83), PARA("PA", 20.83), TOCANTINS("TO", 20.83),
	AMAPA("AP", 20.83), RONDONIA("RO", 20.83),

	/**
	 * Região Nordeste.
	 */
	MARANHAO("MA", 15.98), PIAUI("PI", 15.98), BAHIA("BA", 15.98), SERGIPE("SE", 15.98), ALAGOAS("AL", 15.98),
	PERNAMBUCO("PE", 15.98), PARAIBA("PB", 15.98), RIO_GRANDE_DO_NORTE("RN", 15.98), CEARA("CE", 15.98);

	private String estado;
	private Double frete;

	RegioesFrete(String estado, Double frete) {
		this.estado = estado;
		this.frete = frete;
	}

	@Override
	public String toString() {
		return this.estado;
	}

	public static Double findFrete(String estado) {
		for (RegioesFrete x : RegioesFrete.values()) {
			if (x.toString().equals(estado)) {
				return x.frete;
			}
		}
		return null;
	}

}
