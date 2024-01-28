package com.github.danilo1337.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.danilo1337.dto.PagamentoDTO;
import com.github.danilo1337.entity.Pagamento;
import com.github.danilo1337.repository.PagamentoRepository;
import com.github.danilo1337.util.LoggerUtils;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository pagamentoRepository;

	public void proccessarPagamento(PagamentoDTO dto) {
		try {
//			if (BigDecimal.ZERO.compareTo(dto.getValor()) == 0) {
//				throw new Exception("não é possível processar um pagamento zerado");
//			}
			
			Pagamento pagamento = new Pagamento();
			
			BeanUtils.copyProperties(dto, pagamento);
			
			pagamentoRepository.save(pagamento);
			
			LoggerUtils.info("Pagamento processado");
			
		} catch (Exception e) {
			LoggerUtils.warn(e.getMessage());
		}
	}

}
