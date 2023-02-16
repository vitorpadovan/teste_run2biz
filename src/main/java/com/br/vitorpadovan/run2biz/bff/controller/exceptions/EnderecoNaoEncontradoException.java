package com.br.vitorpadovan.run2biz.bff.controller.exceptions;

public class EnderecoNaoEncontradoException extends GenericException implements BasicInfoErrors {

	public EnderecoNaoEncontradoException() {
		super();
	}

	public EnderecoNaoEncontradoException(
			String message,
			Throwable cause,
			boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EnderecoNaoEncontradoException(
			String message,
			Throwable cause) {
		super(message, cause);
	}

	public EnderecoNaoEncontradoException(
			String message) {
		super(message);
	}

	public EnderecoNaoEncontradoException(
			Throwable cause) {
		super(cause);
	}

	@Override
	public String getBasicMessage() {
		return "Endereço não encontrado";
	}

	@Override
	public String getBasicCode() {
		return "02";
	}
}
