package com.br.vitorpadovan.run2biz.bff.business.contracts;

import java.util.List;

import com.br.vitorpadovan.run2biz.bff.controller.contracts.request.DenunciaRequest;
import com.br.vitorpadovan.run2biz.bff.controller.contracts.response.DenunciaResponse;
import com.br.vitorpadovan.run2biz.bff.controller.exceptions.GenericException;
import com.br.vitorpadovan.run2biz.bff.model.Denuncia;

public interface DenunciaBusiness {

	DenunciaResponse salvarDenuncia(DenunciaRequest request)
			throws GenericException;

	List<Denuncia> getDenunciaPorGeoLocalizacao(double latitude, double longitude);
}
