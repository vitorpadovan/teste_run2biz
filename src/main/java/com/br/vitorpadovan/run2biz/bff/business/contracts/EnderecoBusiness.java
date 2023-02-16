package com.br.vitorpadovan.run2biz.bff.business.contracts;

import com.br.vitorpadovan.run2biz.bff.model.Endereco;

public interface EnderecoBusiness {

	public Endereco encontrarEnderecoPorGeolocalizacao(double latitude, double longitude);
}
