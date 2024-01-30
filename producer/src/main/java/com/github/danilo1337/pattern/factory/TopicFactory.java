package com.github.danilo1337.pattern.factory;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.stereotype.Component;

import com.github.danilo1337.pattern.strategy.TopicStrategy;
import com.github.danilo1337.pattern.strategy.impl.TopicDefault;
import com.github.danilo1337.pattern.strategy.impl.TopicPagamento;

@Component
public class TopicFactory {

	private Map<String, TopicStrategy> strategies = new HashMap<>();

	private static final String DEFAULT_TOPIC = "DEFAULT_TOPIC";

	public TopicFactory() {
		super();

		Map<String, TopicStrategy> strategies = new HashMap<>();
		strategies.put(DEFAULT_TOPIC, new TopicDefault());
		strategies.put("pagamentos", new TopicPagamento());

		this.strategies = strategies;
	}

	public NewTopic create(String topic) {

		if (strategies.containsKey(topic)) {
			return strategies.get(topic).buildTopic(topic);
		}

		return strategies.get(DEFAULT_TOPIC).buildTopic(topic);
	}

}
