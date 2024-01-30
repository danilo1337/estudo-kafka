package com.github.danilo1337.pattern.strategy.impl;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;

import com.github.danilo1337.pattern.strategy.TopicStrategy;

public class TopicDefault implements TopicStrategy{
	
	private static final Integer PARTITION_COUNT = 1;
	
	private static final Integer REPLICA_COUNT = 1;
	
	@Override
	public NewTopic buildTopic(String name) {
		return TopicBuilder
				.name(name)
				.replicas(REPLICA_COUNT)
				.partitions(PARTITION_COUNT)
				.build();
	}

}
