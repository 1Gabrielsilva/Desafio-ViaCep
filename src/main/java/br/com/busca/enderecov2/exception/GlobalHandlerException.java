package br.com.busca.enderecov2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<DadosForExceptions> respostaNula() {
		DadosForExceptions dadosForExceptions = DadosForExceptions.builder().message("Algum dado veio nulo")
				.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dadosForExceptions);
	}

	@ExceptionHandler(ErroResponseViaCep.class)
	public ResponseEntity<DadosForExceptions> respostaNula2() {
		DadosForExceptions dadosForExceptions = DadosForExceptions.builder()
				.message("Aconteceu um erro ao buscar as informações desse CEP")
				.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dadosForExceptions);
	}

}
