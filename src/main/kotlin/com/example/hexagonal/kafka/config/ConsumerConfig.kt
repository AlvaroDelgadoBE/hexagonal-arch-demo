package com.example.hexagonal.kafka.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer

@Configuration
class ConsumerConfig(
	@Value("\${spring.kafka.bootstrapServers}")
	private val bootstrapServers: String,
	@Value("\${spring.kafka.productConsumer.key-serializer}")
	private val keySerializerClass: String,
	@Value("\${spring.kafka.productConsumer.value-serializer}")
	private val valueSerializerClass: String
) {
	
	fun consumerConfig(): Map<String, Any> {
		val properties = HashMap<String, Any>()
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keySerializerClass)
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueSerializerClass)
		return properties
	}
	
	@Bean
	fun consumerFactory(): ConsumerFactory<String, String> {
		return DefaultKafkaConsumerFactory(consumerConfig())
	}
	
	@Bean
	fun consumer(consumerFactory: ConsumerFactory<String, String>): KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> {
		val factory = ConcurrentKafkaListenerContainerFactory<String, String>()
		factory.consumerFactory = consumerFactory
		return factory;
	}
	
}