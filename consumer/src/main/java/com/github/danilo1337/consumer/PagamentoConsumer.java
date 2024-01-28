package com.github.danilo1337.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import com.github.danilo1337.dto.PagamentoDTO;
import com.github.danilo1337.service.PagamentoService;
import com.github.danilo1337.util.LoggerUtils;
import com.google.gson.Gson;

@Configuration
@EnableKafka
public class PagamentoConsumer {
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@KafkaListener(topics = "${{spring.kafka.topic.pagamentos}}")
	public void consumerPagamentos(ConsumerRecord<String, String> record) {
        String topic = record.topic();
        int partition = record.partition();
        long offset = record.offset();
        String message = record.value();
        
        LoggerUtils.info("Offset: " + offset + " Partição: " + partition+ " Tópico: " + topic );
        
		PagamentoDTO pagamentoDTO = new Gson().fromJson(message, PagamentoDTO.class);
		
		pagamentoService.proccessarPagamento(pagamentoDTO);
	}
	
}
