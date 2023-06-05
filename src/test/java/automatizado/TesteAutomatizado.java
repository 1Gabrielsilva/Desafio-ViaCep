package automatizado;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.busca.enderecov2.exception.ErroResponseViaCep;
import br.com.busca.enderecov2.request.EnderecoRequest;
import br.com.busca.enderecov2.response.ResponseFinal;
import br.com.busca.enderecov2.service.EnderecoService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TesteAutomatizado {
	
	private EnderecoService enderecoService;
	private ResponseFinal responseFinal;
	
	@Given("Que a minha aplicação esta inicializada")
	public void validaServicoBuscaEndereco() {
		enderecoService = new EnderecoService();
	}
	
	@When("Eu pesquiso o cep {string}")
	public void buscaCep(String cep) {
		EnderecoRequest enderecoRequest = EnderecoRequest.builder().cep(cep).build();
		responseFinal = enderecoService.executa(enderecoRequest);
	}
	
	@Then("Eu encontro o frete")
	public void encontroValorFrete() {
		assertTrue(responseFinal.toString().contains("frete"));
		assertTrue(!responseFinal.equals(null));
	}
	
	@Then("Eu recebo um CEP inválido")
	public void cepInvalidoErro() {
		EnderecoRequest enderecoRequest = EnderecoRequest.builder().cep("").build();
		assertThrows(ErroResponseViaCep.class, () ->  enderecoService.executa(enderecoRequest));

	}
	
	@Then("Busca de um frete dado um cep inexistente")
	public void validaErro2() {
		EnderecoRequest enderecoRequest = EnderecoRequest.builder().cep("80001970").build();
		assertThrows(NullPointerException.class, () ->  enderecoService.executa(enderecoRequest));
	}

}
