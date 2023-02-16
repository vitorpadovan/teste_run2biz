package com.br.vitorpadovan.run2biz.bff.controller.contracts.response;

import com.br.vitorpadovan.run2biz.bff.model.dto.DenunciaDto;
import com.br.vitorpadovan.run2biz.bff.model.dto.PessoaDto;
import com.br.vitorpadovan.run2biz.bff.model.dto.EnderecoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DenunciaResponse {

	private int id;

	private double latitude;

	private double longitude;

	private PessoaDto denunciante;

	private DenunciaDto denuncia;

	private EnderecoDto endereco;
}
