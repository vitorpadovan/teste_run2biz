package com.br.vitorpadovan.run2biz.bff.business.contracts;

import com.br.vitorpadovan.run2biz.bff.controller.exceptions.EnderecoNaoEncontradoException;
import com.br.vitorpadovan.run2biz.bff.model.Endereco;

public interface GeolocatorBusiness {

	public Endereco pesquisarEnderecoNoMapQuest(double latitude, double longitude) throws EnderecoNaoEncontradoException;

	public double calcularLatitude(double latitude, double metros);

	public double calcularLongitude(double longitude, double latitude, double metros);
}
