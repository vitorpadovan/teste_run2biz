package com.br.vitorpadovan.run2biz.bff.controller.contracts.response.mapquestapi;

import java.util.ArrayList;

import lombok.Data;

@Data
public class MapResponse {

	private Info info;

	private Options options;

	private ArrayList<ResultMapMap> results = new ArrayList<ResultMapMap>();
}
