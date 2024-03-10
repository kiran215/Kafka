package com.example.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String topic, String key, String message) {
		int partition = 0;
		if (key.equals("SOUTH")) {
			partition = 1;
		} else if (key.equals("NORTH")) {
			partition = 2;
		}
		kafkaTemplate.send(topic, partition, key, message);

	}
}
