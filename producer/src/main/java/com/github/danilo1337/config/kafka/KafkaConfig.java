package com.github.danilo1337.config.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import lombok.RequiredArgsConstructor;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	
	private static final Integer PARTITION_COUNT = 4;
	
	private static final Integer REPLICA_COUNT = 1;
	
	@Value("${spring.kafka.topic.pagamentos}")
	private String topicPagamento;

    @Bean
    public ProducerFactory<String, String> producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerProps());
	}

	private Map<String, Object> producerProps() {

		Map<String, Object> props = new HashMap<>();

		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


		return props;
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
		return new KafkaTemplate<>(producerFactory);
	}
	
	private NewTopic buildTopic(String name) {
		return TopicBuilder
					.name(name)
					.replicas(REPLICA_COUNT)
					.partitions(PARTITION_COUNT)
					.build();
	}
	
	@Bean
	public NewTopic startPagamento() {
		return buildTopic(topicPagamento);
	}

}
