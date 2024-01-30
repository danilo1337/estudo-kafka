package com.github.danilo1337.pattern.strategy;

import org.apache.kafka.clients.admin.NewTopic;

public interface TopicStrategy {
	NewTopic buildTopic(String name);
}
