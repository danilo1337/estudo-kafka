package com.github.danilo1337.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO {
	
    private BigDecimal valor;
    
    private String tipoPagamento;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;
    
}
