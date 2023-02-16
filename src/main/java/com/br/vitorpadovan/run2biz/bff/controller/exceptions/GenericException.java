package com.br.vitorpadovan.run2biz.bff.controller.exceptions;

public class GenericException extends Exception implements BasicInfoErrors {

	public static ErrorResponse generic = ErrorResponse.builder()
			.error(ErrorApi.builder().code("01").message("Request inválido.").build()).build();


	public GenericException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenericException(
			String message,
			Throwable cause,
			boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public GenericException(
			String message,
			Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public GenericException(
			String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public GenericException(
			Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
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
