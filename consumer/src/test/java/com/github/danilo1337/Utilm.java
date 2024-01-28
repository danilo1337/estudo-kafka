package com.github.danilo1337;

import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.danilo1337.dto.PagamentoDTO;
import com.github.danilo1337.util.UtilJson;
import com.google.gson.Gson;

public class Utilm {
	
	@Test
	public void asdf() {
		String m =  "\"{\\\"data\\\":\\\"2024-01-27\\\",\\\"valor\\\": 55.00,\\\"tipoPagamento\\\": \\\"PIX\\\"}\"";
				//"{\r\n    \"data\":\"2024-01-27\",\r\n    \"valor\": 55.00,\r\n    \"tipoPagamento\": \"PIX\"\r\n}";
		
		PagamentoDTO pagamntoDto = UtilJson.parseJsonToObject(m, PagamentoDTO.class); 
				//new Gson().fromJson(m, PagamentoDTO.class);
		
		System.out.println(pagamntoDto);
		
		Assertions.assertTrue(Objects.nonNull(pagamntoDto));
	}
}
