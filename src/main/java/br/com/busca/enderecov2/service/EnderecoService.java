package br.com.busca.enderecov2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.busca.enderecov2.exception.ErroResponseViaCep;
import br.com.busca.enderecov2.request.EnderecoRequest;
import br.com.busca.enderecov2.response.ResponseApiViaCep;
import br.com.busca.enderecov2.response.ResponseFinal;
import br.com.busca.enderecov2.utils.RegioesFrete;

@Service
public class EnderecoService {

	public ResponseFinal executa(EnderecoRequest request) {

		if (request.getCep() == null || request.getCep().isEmpty() || request.getCep().length() > 8
				|| request.getCep().length() < 8) {
			throw new ErroResponseViaCep("CEP Inválido! tente outro endereço.");
		}

		try {

			ResponseApiViaCep responseApiViaCep = new RestTemplate()
					.getForEntity("https://viacep.com.br/ws/" + request.getCep() + "/json/", ResponseApiViaCep.class)
					.getBody();

			ResponseFinal responseFinal = new ResponseFinal(responseApiViaCep);
			responseFinal.setFrete(RegioesFrete.findFrete(responseFinal.getEstado()));

			if (responseFinal.getCep().equals(null)) {
				throw new NullPointerException();
			}

			return responseFinal;

		} catch (HttpClientErrorException.BadRequest ex) {
			throw new ErroResponseViaCep("Ocorreu um erro na busca desse CEP");
		}

	}

}
