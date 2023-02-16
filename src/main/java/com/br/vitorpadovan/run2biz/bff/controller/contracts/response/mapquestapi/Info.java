package com.br.vitorpadovan.run2biz.bff.controller.contracts.response.mapquestapi;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Info {

	private float statuscode;

	private Copyright copyright;

	private ArrayList<Object> messages = new ArrayList<Object>();
}
