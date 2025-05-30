package com.example.hexagonal.kafka.listener

import com.example.hexagonal.kafka.config.KafkaConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.KafkaListener

@Configuration
class ProductListener {
	
	val logger: Logger = LoggerFactory.getLogger("ProductListener")
	
	@KafkaListener(topics = [KafkaConfig.PRODUCT_TOPIC], groupId = "productGroup")
	fun productTopicListener(message: String) {
		println("TEST")
		logger.warn("ProductListener # Message received.")
		logger.warn("Message: $message")
	}
	
}