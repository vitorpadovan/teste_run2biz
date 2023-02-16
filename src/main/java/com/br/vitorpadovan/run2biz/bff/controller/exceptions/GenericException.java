package com.br.vitorpadovan.run2biz.bff.controller.exceptions;

public class GenericException extends Exception implements BasicInfoErrors {

	public static ErrorResponse generic = ErrorResponse.builder()
			.error(ErrorApi.builder().code("01").message("Request inválido.").build()).build();


	public GenericException() {
		super();
	}

	public GenericException(
			String message,
			Throwable cause,
			boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GenericException(
			String message,
			Throwable cause) {
		super(message, cause);
	}

	public GenericException(
			String message) {
		super(message);
	}

	public GenericException(
			Throwable cause) {
		super(cause);
	}

	@Override
	public String getBasicMessage() {
		return "Request inválido.";
	}

	@Override
	public String getBasicCode() {
		return "01";
	}
}
