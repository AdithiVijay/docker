package com.eatza.order.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.eatza.order.dto.DeliveryDto;

@Configuration
public class KafkaProducerConfig {

	@Value("${kafka.boot.server}")
	private String kafkaServer;

	@Bean
	public KafkaTemplate<String, DeliveryDto> kafkaTemplate() {
		return new KafkaTemplate<>(producerConfig());
	}

	@Bean
	public ProducerFactory<String, DeliveryDto> producerConfig() {
		// TODO Auto-generated method stub
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);
	}
}
