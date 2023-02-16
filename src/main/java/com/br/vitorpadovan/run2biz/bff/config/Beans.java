package com.br.vitorpadovan.run2biz.bff.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class Beans {

	@Bean
	public ModelMapper getModel() {
		return new ModelMapper();
	}
}
