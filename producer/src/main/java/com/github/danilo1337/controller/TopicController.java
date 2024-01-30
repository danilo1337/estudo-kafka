package com.github.danilo1337.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.danilo1337.dto.ResponseDTO;

@RestController
@RequestMapping("topics")
public class TopicController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@PostMapping(path = "/{topic}")
	public ResponseEntity<ResponseDTO> publicarMensagem(@RequestBody String mensagem, @PathVariable String topic) {

		kafkaTemplate.send(topic, mensagem);

		return ResponseEntity.ok(ResponseDTO.builder()
								.response("Mensagem enviada com sucesso para o tópico " + topic)
								.status(HttpStatus.OK)
								.statusCode(HttpStatus.OK.value())
								.build());
	}

}
