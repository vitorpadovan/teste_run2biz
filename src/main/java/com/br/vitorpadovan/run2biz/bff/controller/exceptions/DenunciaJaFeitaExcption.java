package com.br.vitorpadovan.run2biz.bff.controller.exceptions;

public class DenunciaJaFeitaExcption extends GenericException implements BasicInfoErrors {

	public DenunciaJaFeitaExcption() {
		super();
	}

	public DenunciaJaFeitaExcption(
			String message,
			Throwable cause,
			boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DenunciaJaFeitaExcption(
			String message,
			Throwable cause) {
		super(message, cause);
	}

	public DenunciaJaFeitaExcption(
			String message) {
		super(message);
	}

	public DenunciaJaFeitaExcption(
			Throwable cause) {
		super(cause);
	}

	@Override
	public String getBasicMessage() {
		return "Denuncia já feita";
	}

	@Override
	public String getBasicCode() {
		return "03";
	}
}
