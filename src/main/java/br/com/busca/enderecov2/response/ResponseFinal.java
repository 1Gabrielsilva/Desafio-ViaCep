package br.com.busca.enderecov2.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResponseFinal {

	@ApiModelProperty(value = "Cep informado formatado", example = "01001-000")
	private String cep;

	@ApiModelProperty(value = "Rua do endereço", example = "Praça da Sé")
	private String rua;

	@ApiModelProperty(value = "Complemento do endereço", example = "lado ímpar")
	private String complemento;

	@ApiModelProperty(value = "Bairro do endereço", example = "Sé")
	private String bairro;

	@ApiModelProperty(value = "Cidade do endereço", example = "São Paulo")
	private String cidade;

	@ApiModelProperty(value = "Estado do endereço", example = "SP")
	private String estado;

	@ApiModelProperty(value = "Frete do endereço", example = "7.85")
	private Double frete;

	public ResponseFinal(ResponseApiViaCep responseApiViaCep) {
		this.cep = responseApiViaCep.getCep();
		this.rua = responseApiViaCep.getLogradouro();
		this.complemento = responseApiViaCep.getComplemento();
		this.bairro = responseApiViaCep.getBairro();
		this.cidade = responseApiViaCep.getLocalidade();
		this.estado = responseApiViaCep.getUf();

	}

}
