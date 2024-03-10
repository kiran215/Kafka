package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.producer.MessageProducer;

@RestController
public class KafkaController {

	@Autowired
	MessageProducer messageProducer;

	@Value("${kafka-topic}")
	private String kafkaTopic;

	@GetMapping("/send/{key}/{msg}")
	public String sendMessageToKafka(@PathVariable String key, @PathVariable String msg) {

		messageProducer.sendMessage(kafkaTopic, key, msg);
		return "Message sent: " + msg+" "+key;
	}
}
