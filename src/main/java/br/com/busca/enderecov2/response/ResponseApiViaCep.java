package br.com.busca.enderecov2.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseApiViaCep {

	@ApiModelProperty(value = "Cep informado formatado", example = "01001-000")
	private String cep;

	@ApiModelProperty(value = "Logradouro do endereço", example = "Praça da Sé")
	private String logradouro;

	@ApiModelProperty(value = "Complemento do endereço", example = "lado ímpar")
	private String complemento;

	@ApiModelProperty(value = "Bairro do endereço", example = "Sé")
	private String bairro;

	@ApiModelProperty(value = "Lcalidade do endereço", example = "São Paulo")
	private String localidade;

	@ApiModelProperty(value = "Uf do endereço", example = "SP")
	private String uf;

}
