package br.com.busca.enderecov2.exception;

public class ErroResponseViaCep extends RuntimeException {

	private static final long serialVersionUID = 7278459454893237765L;

	public ErroResponseViaCep(String message) {
		super(message);
	}
	
}
