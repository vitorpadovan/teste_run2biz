package com.br.vitorpadovan.run2biz.bff.business.imp;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.vitorpadovan.run2biz.bff.business.contracts.GeolocatorBusiness;
import com.br.vitorpadovan.run2biz.bff.controller.contracts.request.mapquestapi.MapQuestRequest;
import com.br.vitorpadovan.run2biz.bff.controller.contracts.response.mapquestapi.LatLng;
import com.br.vitorpadovan.run2biz.bff.controller.contracts.response.mapquestapi.Location;
import com.br.vitorpadovan.run2biz.bff.controller.contracts.response.mapquestapi.MapResponse;
import com.br.vitorpadovan.run2biz.bff.controller.exceptions.EnderecoNaoEncontradoException;
import com.br.vitorpadovan.run2biz.bff.model.Endereco;
import com.br.vitorpadovan.run2biz.bff.model.Localizacao;
import com.br.vitorpadovan.run2biz.bff.repo.EnderecoRepo;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ImpGeolocatorBusiness implements GeolocatorBusiness {

	private EnderecoRepo enderecoRepo;

	private String url = "http://www.mapquestapi.com/geocoding/v1/reverse?key=fkck2Ir3GyxWoyyDZTtRQIBAmcvzVIAA";

	private ModelMapper map;


	public ImpGeolocatorBusiness(
			EnderecoRepo enderecoRepo) {
		super();
		this.enderecoRepo = enderecoRepo;
		this.map = new ModelMapper();
		this.gerarMapasDeModelos();
	}

	private void gerarMapasDeModelos() {
		var typeMap = map.createTypeMap(Location.class, Endereco.class);
		typeMap.addMapping(origem -> origem.getAdminArea1(), Endereco::setPais);
		typeMap.addMapping(origem -> origem.getAdminArea3(), Endereco::setEstado);
		typeMap.addMapping(origem -> origem.getAdminArea5(), Endereco::setCidade);
		typeMap.addMapping(origem -> origem.getAdminArea6(), Endereco::setBairro);
		typeMap.addMapping(origem -> origem.getStreet(), Endereco::setLogradouro);
	}

	// Verificar exception melhor
	private Endereco extrairEndereco(MapResponse response) throws EnderecoNaoEncontradoException {
		var results = response.getResults();
		if (results.size() <= 0)
			throw new EnderecoNaoEncontradoException("N??o tivemos results");
		var locations = results.get(0).getLocations();
		if (locations.size() <= 0)
			throw new EnderecoNaoEncontradoException("N??o tivemos locations");
		return map.map(locations.get(0), Endereco.class);
	}

	@Override
	public Endereco pesquisarEnderecoNoMapQuest(double latitude, double longitude) throws EnderecoNaoEncontradoException {
		RestTemplate r = new RestTemplate();
		var mapRequest = new MapQuestRequest(new Localizacao(new LatLng(latitude, longitude)));
		MapResponse mapResponse = r.postForObject(url, mapRequest, MapResponse.class);
		try {
			Endereco endereco = this.extrairEndereco(mapResponse);
			return enderecoRepo.save(endereco);
		} catch (EnderecoNaoEncontradoException ex) {
			log.error(ex.getMessage());
			throw ex;
		}
	}

	@Override
	public double calcularLatitude(double latitude, double metros) {
		double deg = 110574;
		double distancia = metros / deg;
		return latitude - distancia;
	}

	@Override
	public double calcularLongitude(double longitude, double latitude, double metros) {
		double deg = 111320 * Math.cos(latitude);
		double distancia = metros / deg;
		return longitude - distancia;
	}
}
