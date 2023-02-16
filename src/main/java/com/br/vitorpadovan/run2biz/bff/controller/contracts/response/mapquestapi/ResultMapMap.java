package com.br.vitorpadovan.run2biz.bff.controller.contracts.response.mapquestapi;

import java.util.List;

import lombok.Data;

@Data
public class ResultMapMap {

	private ProvidedLocation providedLocation;

	private List<Location> locations;
}
