package com.br.vitorpadovan.run2biz.bff.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDto {

	private String logradouro;

	private String bairro;

	private String cidade;

	private String estado;

	private String pais;

	private String cep;
}
