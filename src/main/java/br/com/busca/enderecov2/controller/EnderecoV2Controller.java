package br.com.busca.enderecov2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.busca.enderecov2.request.EnderecoRequest;
import br.com.busca.enderecov2.response.ResponseFinal;
import br.com.busca.enderecov2.service.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
@Api(value = "Api para buscar CEP e calcular o valor do frete pela região")
public class EnderecoV2Controller {
	
	private final EnderecoService enderecoService;

	@PostMapping("/consulta-endereco")
	@ApiOperation(value = "Faz a busca das informações pelo CEP")
	public ResponseEntity<ResponseFinal> buscaCep(@RequestBody @Valid  EnderecoRequest request) {
		return ResponseEntity.ok(enderecoService.executa(request));
	}
		
}
