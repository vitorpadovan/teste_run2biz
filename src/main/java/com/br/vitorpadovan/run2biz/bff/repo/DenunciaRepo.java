package com.br.vitorpadovan.run2biz.bff.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.vitorpadovan.run2biz.bff.model.Denuncia;

public interface DenunciaRepo extends JpaRepository<Denuncia, Integer> {

	@Query(
		"SELECT d FROM Denuncia d where d.latitude between :menorLatitude and :maiorLatitude and d.longitude between :menorLogitude and :maiorLongitude"
	)
	List<Denuncia> findByLatitudeLongitude(@Param("menorLatitude") double menorLatitude,
			@Param("maiorLatitude") double maiorLatitude, @Param("menorLogitude") double menorLogitude,
			@Param("maiorLongitude") double maiorLongitude);
}
