package com.br.vitorpadovan.run2biz.bff.business.imp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.br.vitorpadovan.run2biz.bff.business.contracts.DenunciaBusiness;
import com.br.vitorpadovan.run2biz.bff.business.contracts.EnderecoBusiness;
import com.br.vitorpadovan.run2biz.bff.business.contracts.GeolocatorBusiness;
import com.br.vitorpadovan.run2biz.bff.business.contracts.PessoaBusiness;
import com.br.vitorpadovan.run2biz.bff.controller.contracts.request.DenunciaRequest;
import com.br.vitorpadovan.run2biz.bff.controller.contracts.response.DenunciaResponse;
import com.br.vitorpadovan.run2biz.bff.controller.exceptions.DenunciaJaFeitaExcption;
import com.br.vitorpadovan.run2biz.bff.controller.exceptions.EnderecoNaoEncontradoException;
import com.br.vitorpadovan.run2biz.bff.controller.exceptions.GenericException;
import com.br.vitorpadovan.run2biz.bff.model.Denuncia;
import com.br.vitorpadovan.run2biz.bff.model.Endereco;
import com.br.vitorpadovan.run2biz.bff.repo.DenunciaRepo;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ImpDenunciaBusiness implements DenunciaBusiness {

	private PessoaBusiness denuncianteB;

	private EnderecoBusiness enderecoB;

	private GeolocatorBusiness geolocatorB;

	private DenunciaRepo repo;

	private ModelMapper modelMapper;

	private int metrosTolerancia = 50;

	private List<Denuncia> denunciaNasProximidades;


	public ImpDenunciaBusiness(
			PessoaBusiness denuncianteB,
			EnderecoBusiness enderecoB,
			GeolocatorBusiness geolocatorB,
			DenunciaRepo repo) {
		super();
		this.denuncianteB = denuncianteB;
		this.enderecoB = enderecoB;
		this.geolocatorB = geolocatorB;
		this.repo = repo;
		this.modelMapper = new ModelMapper();
		this.gerarMapasDeModelos();
	}

	private void gerarMapasDeModelos() {
		var denunciaMap = modelMapper.createTypeMap(DenunciaRequest.class, Denuncia.class);
		denunciaMap.addMapping(s -> s.getDenuncia().getTitulo(), Denuncia::setTitulo);
		denunciaMap.addMapping(s -> s.getDenuncia().getDescricao(), Denuncia::setDescricao);
		var denunciaResponseMap = modelMapper.createTypeMap(Denuncia.class, DenunciaResponse.class);
		denunciaResponseMap.addMapping(s -> s.getCodDenuncia(), DenunciaResponse::setId);
	}

	@Override
	public DenunciaResponse salvarDenuncia(DenunciaRequest request)
			throws GenericException {
		Denuncia d = modelMapper.map(request, Denuncia.class);
		denunciaNasProximidades = this.getDenunciaPorGeoLocalizacao(d.getLatitude(), d.getLongitude());
		log.info("Processando denuncia a denuncia {} de {} e encontramos {} denuncias próximas",
				request.getDenuncia().getTitulo(),
				request.getDenunciante().getNome(), denunciaNasProximidades.size());
		var pessoa = denuncianteB.getPessoaPorCpfESalva(request.getDenunciante().getNome(),
				request.getDenunciante().getCpf());
		d.setDenunciante(pessoa);
		if (validaDenunciaJaFeita(d))
			throw new DenunciaJaFeitaExcption("Denuncia já feita pelo CPF " + d.getDenunciante().getCpf());
		Endereco endereco = tratarEndereco(request.getLatitude(), request.getLongitude());
		d.setEndereco(endereco);
		d = repo.save(d);
		return getResponse(d);
	}

	private DenunciaResponse getResponse(Denuncia d) {
		return modelMapper.map(d, DenunciaResponse.class);
	}

	private boolean validaDenunciaJaFeita(Denuncia d) {
		log.info("Validando se a denuncia já foi feita");
		var testes = denunciaNasProximidades.stream()
				.filter(s -> s.getDenunciante().getCpf().compareTo(d.getDenunciante().getCpf()) == 0).findAny();
		if (testes.isPresent())
			return true;
		return false;
	}

	private Endereco tratarEndereco(double latitude, double longitude) throws EnderecoNaoEncontradoException {
		if (denunciaNasProximidades.size() > 0) {
			return denunciaNasProximidades.get(0).getEndereco();
		}
		return geolocatorB.pesquisarEnderecoNoMapQuest(latitude, longitude);
	}

	@Override
	public List<Denuncia> getDenunciaPorGeoLocalizacao(double latitude, double longitude) {
		var menorLat = geolocatorB.calcularLatitude(latitude, metrosTolerancia * -1);
		var maiorLat = geolocatorB.calcularLatitude(latitude, metrosTolerancia);
		if (menorLat > maiorLat) {
			var aux = maiorLat;
			maiorLat = menorLat;
			menorLat = aux;
		}
		var menorLon = geolocatorB.calcularLongitude(longitude, latitude, metrosTolerancia * -1);
		var maiorLon = geolocatorB.calcularLongitude(longitude, latitude, metrosTolerancia);
		if (menorLon > maiorLat) {
			var aux = maiorLon;
			maiorLon = menorLon;
			menorLon = aux;
		}
		return repo.findByLatitudeLongitude(menorLat, maiorLat, menorLon, maiorLon);
	}
}
