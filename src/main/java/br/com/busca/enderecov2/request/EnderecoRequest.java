package br.com.busca.enderecov2.request;

import org.springframework.lang.Nullable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequest {

	@Nullable
	@ApiModelProperty(value = "Cep informado pelo usuario")
	private String cep;

}
