package com.br.vitorpadovan.run2biz.bff.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.vitorpadovan.run2biz.bff.model.Endereco;

public interface EnderecoRepo extends JpaRepository<Endereco, Integer> {
}
