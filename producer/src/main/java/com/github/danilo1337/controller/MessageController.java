package com.github.danilo1337.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mensagens")
public class MessageController {
	
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @PostMapping(path = "/{topico}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> enviarMensagem(
            @RequestBody String mensagem,
            @PathVariable String topico) {
    	
    	kafkaTemplate.send(topico, mensagem);
    	
        Map<String, String> response = new HashMap<>();
        response.put("response", "Mensagem enviada com sucesso para o tópico " + topico);
        
        return ResponseEntity.ok(response);
    }
}
