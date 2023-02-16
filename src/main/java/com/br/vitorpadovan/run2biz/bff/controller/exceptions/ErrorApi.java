package com.br.vitorpadovan.run2biz.bff.controller.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorApi {

	private String message;

	private String code;
}
