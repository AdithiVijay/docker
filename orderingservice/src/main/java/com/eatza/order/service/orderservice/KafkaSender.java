package com.eatza.order.service.orderservice;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import com.eatza.order.dto.DeliveryDto;



@Service
public class KafkaSender {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);

	@Autowired
	private KafkaTemplate<String, DeliveryDto> kafkaTemplate;

	@Value("${kafka.topic.name}")
	private String topicName;

	public void sendData(DeliveryDto deliverydto) {
		Map<String, Object> headers = new HashMap<>();
		headers.put(KafkaHeaders.TOPIC, topicName);
		kafkaTemplate.send(new GenericMessage<DeliveryDto>(deliverydto, headers));
		LOGGER.info("Data - " + deliverydto.toString() + " sent to Kafka Topic - " + topicName);
	}
}