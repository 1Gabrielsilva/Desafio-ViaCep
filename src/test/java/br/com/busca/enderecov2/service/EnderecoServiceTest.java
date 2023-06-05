package br.com.busca.enderecov2.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.busca.enderecov2.exception.ErroResponseViaCep;
import br.com.busca.enderecov2.request.EnderecoRequest;
import br.com.busca.enderecov2.response.ResponseFinal;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
public class EnderecoServiceTest {
	
	@Autowired
	private EnderecoService enderecoService = new EnderecoService();
	
	@Test
	public void TestEnderecoService_BuscaCepComSucesso() {
		
		EnderecoRequest request = EnderecoRequest.builder().cep("01001000").build();
		
		ResponseFinal response = enderecoService.executa(request);

		ResponseFinal responseFinal = ResponseFinal.builder().cep("01001-000").rua("Praça da Sé").complemento("lado ímpar").bairro("Sé").cidade("São Paulo").estado("SP").frete(7.85).build();
		
		assertTrue(response.equals(responseFinal));
		
	}
	@Test
	public void TestEnderecoService_FalhaAoBuscarCep() {
		
		EnderecoRequest request = EnderecoRequest.builder().cep("00000000").build();
		
		assertThrows(NullPointerException.class, () ->  enderecoService.executa(request));
		
	}
	@Test
	public void TestEnderecoService_FalhaAoPassarCepInvalido() {
		
		EnderecoRequest request = EnderecoRequest.builder().cep("").build();
		EnderecoRequest request2 = EnderecoRequest.builder().cep(null).build();
		
		assertThrows(ErroResponseViaCep.class, () ->  enderecoService.executa(request));
		assertThrows(ErroResponseViaCep.class, () ->  enderecoService.executa(request2));
		
	}

}
