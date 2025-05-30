package com.example.hexagonal.kafka.config

import org.apache.kafka.clients.admin.NewTopic
import org.apache.kafka.common.config.TopicConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaConfig {
	
	companion object {
		
		const val PRODUCT_TOPIC = "productTopic"
		
	}
	
	@Bean
	fun createProductTopic(): NewTopic {
		val configs = HashMap<String, String>()
		configs.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE)
		configs.put(TopicConfig.RETENTION_MS_CONFIG, "86400000")
		configs.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824")
		configs.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012")
		
		return TopicBuilder
			.name(PRODUCT_TOPIC)
			.partitions(1)
			.replicas(1)
			.configs(configs)
			.build()
	}
	
}