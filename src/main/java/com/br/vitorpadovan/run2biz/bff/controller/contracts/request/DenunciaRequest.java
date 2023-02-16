package com.br.vitorpadovan.run2biz.bff.controller.contracts.request;

import com.br.vitorpadovan.run2biz.bff.model.dto.DenunciaDto;
import com.br.vitorpadovan.run2biz.bff.model.dto.PessoaDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DenunciaRequest {

	private double latitude;

	private double longitude;

	private PessoaDto denunciante;

	private DenunciaDto denuncia;
}
