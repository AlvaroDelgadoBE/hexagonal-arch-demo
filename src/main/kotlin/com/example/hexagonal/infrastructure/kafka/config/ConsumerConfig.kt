package com.example.hexagonal.infrastructure.kafka.config

import com.example.hexagonal.domain.model.Review
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer
import org.springframework.kafka.support.serializer.JsonDeserializer

@Configuration
class ConsumerConfig(
	@Value("\${spring.kafka.bootstrapServers}")
	private val bootstrapServers: String,
	@Value("\${spring.kafka.reviewTopicConsumer.key-deserializer}")
	private val keyDeserializerClass: String,
	@Value("\${spring.kafka.reviewTopicConsumer.value-deserializer}")
	private val valueDeserializerClass: String
) {
	
	fun consumerConfig(): Map<String, Any> {
		val properties = HashMap<String, Any>()
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializerClass)
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializerClass)
		properties.put(JsonDeserializer.TRUSTED_PACKAGES, "*")
		return properties
	}
	
	@Bean
	fun consumerFactory(): ConsumerFactory<String, Review> {
		return DefaultKafkaConsumerFactory(consumerConfig())
	}
	
	@Bean
	fun containerFactory(consumerFactory: ConsumerFactory<String, Review>): KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Review>> {
		val factory = ConcurrentKafkaListenerContainerFactory<String, Review>()
		factory.consumerFactory = consumerFactory
		return factory;
	}
	
}