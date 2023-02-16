package com.br.vitorpadovan.run2biz.bff.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDto {

	private String logradouro;

	private String bairro;

	private String cidade;

	private String estado;

	private String pais;

	private String cep;
}
