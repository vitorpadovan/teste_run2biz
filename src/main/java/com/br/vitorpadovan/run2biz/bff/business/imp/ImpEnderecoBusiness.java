package com.br.vitorpadovan.run2biz.bff.business.imp;

import org.springframework.stereotype.Service;

import com.br.vitorpadovan.run2biz.bff.business.contracts.EnderecoBusiness;
import com.br.vitorpadovan.run2biz.bff.model.Endereco;
import com.br.vitorpadovan.run2biz.bff.repo.EnderecoRepo;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ImpEnderecoBusiness implements EnderecoBusiness {

	private EnderecoRepo repo;


	public ImpEnderecoBusiness(
			EnderecoRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Endereco encontrarEnderecoPorGeolocalizacao(double latitude, double longitude) {
		return null;
	}
}
