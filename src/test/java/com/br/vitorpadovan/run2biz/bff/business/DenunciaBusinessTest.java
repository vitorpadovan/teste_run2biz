package com.br.vitorpadovan.run2biz.bff.business;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.vitorpadovan.run2biz.bff.business.contracts.DenunciaBusiness;
import com.br.vitorpadovan.run2biz.bff.business.contracts.EnderecoBusiness;
import com.br.vitorpadovan.run2biz.bff.controller.contracts.request.DenunciaRequest;
import com.br.vitorpadovan.run2biz.bff.controller.exceptions.GenericException;
import com.br.vitorpadovan.run2biz.bff.model.Endereco;
import com.br.vitorpadovan.run2biz.bff.model.dto.DenunciaDto;
import com.br.vitorpadovan.run2biz.bff.model.dto.PessoaDto;
import com.br.vitorpadovan.run2biz.bff.repo.DenunciaRepo;

@SpringBootTest
public class DenunciaBusinessTest {

	@Autowired
	private DenunciaBusiness denunciaB;

	@Mock
	private DenunciaRepo repo;

	@Mock
	private EnderecoBusiness enderecoR;


	@Test
	void naoPermiteLatitudeELongitudeErradas() {
		double latitude = 123123123;
		double longitude = 1233222;
		var pessoa = PessoaDto.builder().nome("Vitor").cpf("123456789").build();
		var denuncia = DenunciaDto.builder().titulo("asd").descricao("Descrição").build();
		when(enderecoR.encontrarEnderecoPorGeolocalizacao(latitude, longitude))
				.thenReturn(Endereco.builder().build());
		DenunciaRequest r = DenunciaRequest.builder().latitude(latitude).longitude(longitude).denuncia(denuncia)
				.denunciante(pessoa)
				.build();
		GenericException ex = assertThrows(GenericException.class, () -> denunciaB.salvarDenuncia(r));
		String expectedMessage = "Endereço não encontrado";
		String actualMessage = ex.getBasicMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void naoCadastrarMesmaDenuncia() {
		double latitude = -21.145892242644212;
		double longitude = -47.82254327496559;
		var pessoa = PessoaDto.builder().nome("Vitor").cpf("123456789").build();
		var denuncia = DenunciaDto.builder().titulo("asd").descricao("Descrição").build();
		when(enderecoR.encontrarEnderecoPorGeolocalizacao(latitude, longitude))
				.thenReturn(Endereco.builder().build());
		DenunciaRequest r = DenunciaRequest.builder().latitude(latitude).longitude(longitude).denuncia(denuncia)
				.denunciante(pessoa)
				.build();
		try {
			denunciaB.salvarDenuncia(r);
		} catch (GenericException e) {
			e.printStackTrace();
		}
		GenericException ex = assertThrows(GenericException.class, () -> denunciaB.salvarDenuncia(r));
		String expectedMessage = "Denuncia já feita";
		String actualMessage = ex.getBasicMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
}
