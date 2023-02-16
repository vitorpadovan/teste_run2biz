package com.br.vitorpadovan.run2biz.bff.business.imp;

import org.springframework.stereotype.Service;

import com.br.vitorpadovan.run2biz.bff.business.contracts.PessoaBusiness;
import com.br.vitorpadovan.run2biz.bff.model.Pessoa;
import com.br.vitorpadovan.run2biz.bff.repo.DenuncianteRepo;

@Service
public class ImpPessoaBusiness implements PessoaBusiness {

	private DenuncianteRepo repo;


	public ImpPessoaBusiness(
			DenuncianteRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Pessoa getPessoaPorCpfESalva(String nome, String cpf) {
		var optRetorno = repo.findByCpf(cpf);
		if (optRetorno.isPresent() && !optRetorno.isEmpty())
			return optRetorno.get();
		var denunciante = Pessoa
				.builder()//
				.nome(nome)//
				.cpf(cpf)
				.build();
		return repo.save(denunciante);
	}
}
