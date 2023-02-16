package com.br.vitorpadovan.run2biz.bff.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.vitorpadovan.run2biz.bff.model.Pessoa;

public interface DenuncianteRepo extends JpaRepository<Pessoa, Integer> {

	public Optional<Pessoa> findByCpf(String cpf);
}
