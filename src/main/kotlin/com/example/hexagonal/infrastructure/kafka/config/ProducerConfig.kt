package com.example.hexagonal.infrastructure.kafka.config

import com.example.hexagonal.infrastructure.rest.dto.ReviewDto
import org.apache.kafka.clients.producer.ProducerConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class ProducerConfig(
	@Value("\${spring.kafka.bootstrapServers}")
	private val bootstrapServers: String,
	@Value("\${spring.kafka.reviewTopicProducer.key-serializer}")
	private val keySerializerClass: String,
	@Value("\${spring.kafka.reviewTopicProducer.value-serializer}")
	private val valueSerializerClass: String
) {
	
	fun producerConfig(): Map<String, Any> {
		val properties = HashMap<String, Any>()
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializerClass)
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializerClass)
		return properties
	}
	
	@Bean
	fun producerFactory(): ProducerFactory<String, ReviewDto> {
		return DefaultKafkaProducerFactory(producerConfig())
	}
	
	@Bean
	fun kafkaTemplate(producerFactory: ProducerFactory<String, ReviewDto>): KafkaTemplate<String, ReviewDto> {
		return KafkaTemplate(producerFactory)
	}
	
}