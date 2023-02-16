package com.br.vitorpadovan.run2biz.bff.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.vitorpadovan.run2biz.bff.business.contracts.DenunciaBusiness;
import com.br.vitorpadovan.run2biz.bff.controller.contracts.request.DenunciaRequest;
import com.br.vitorpadovan.run2biz.bff.controller.exceptions.ErrorApi;
import com.br.vitorpadovan.run2biz.bff.controller.exceptions.ErrorResponse;
import com.br.vitorpadovan.run2biz.bff.controller.exceptions.GenericException;

@RestController
public class DenunciaController {

	private DenunciaBusiness business;


	public DenunciaController(
			DenunciaBusiness business) {
		super();
		this.business = business;
	}

	@PostMapping("/v1/denuncias")
	public ResponseEntity<Object> teste(@RequestBody DenunciaRequest teste) {
		try {
			return ResponseEntity.ok(business.salvarDenuncia(teste));
		} catch (GenericException ex) {
			var erroApi = ErrorApi.builder().code(ex.getBasicCode()).message(ex.getBasicMessage()).build();
			var errorResponse = ErrorResponse.builder().error(erroApi).build();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
}
