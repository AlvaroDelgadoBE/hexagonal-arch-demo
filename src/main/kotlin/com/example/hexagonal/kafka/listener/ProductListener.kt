package com.example.hexagonal.kafka.listener

import com.example.hexagonal.kafka.config.KafkaConfig
import com.example.hexagonal.usecase.ProductInteractor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.KafkaListener

@Configuration
class ProductListener(private val productInteractor: ProductInteractor) {
	
	val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)
	
	@KafkaListener(topics = [KafkaConfig.PRODUCT_TOPIC], groupId = "productGroup")
	fun productTopicListener(message: String) {
		logger.info("ProductListener # Message received # $message")
	}
	
}