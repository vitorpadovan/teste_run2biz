package com.br.vitorpadovan.run2biz.bff.business.contracts;

import com.br.vitorpadovan.run2biz.bff.model.Pessoa;

public interface PessoaBusiness {

	public Pessoa getPessoaPorCpfESalva(String nome, String cpf);
}
