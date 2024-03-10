package com.example.kafka.producer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

	@KafkaListener(groupId = "groupid1", topicPartitions = {
			@TopicPartition(topic = "first_topic", partitions = { "0" }) })
	public void listenMessage(ConsumerRecord<String, String> record) {

		System.out.println("listenMessage - "+record.key()+" "+"Received msg - " + record.value()+" "+record.partition());

	}
	
	@KafkaListener(groupId = "groupid1", topicPartitions = {
			@TopicPartition(topic = "first_topic", partitions = { "1","2" }) })
	public void listenMessage1(ConsumerRecord<String, String> record) {

		System.out.println("listenMessage1 - "+record.key()+" "+"Received msg - " + record.value()+" "+record.partition());

	}
}
