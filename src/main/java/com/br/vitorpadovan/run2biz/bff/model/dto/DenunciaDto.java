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
public class DenunciaDto {

	private String titulo;

	private String descricao;
}
