package com.example.hexagonal.infrastructure.kafka.adapter

import com.example.hexagonal.domain.model.Review
import com.example.hexagonal.domain.port.ReviewKafkaPort
import com.example.hexagonal.infrastructure.kafka.config.KafkaConfig
import com.example.hexagonal.infrastructure.rest.dto.ReviewDto
import com.example.hexagonal.infrastructure.rest.mapper.ReviewDtoMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ReviewKafkaAdapter(
	private val kafkaTemplate: KafkaTemplate<String, ReviewDto>
) : ReviewKafkaPort {
	
	override fun sendReviewCreation(review: Review): Review? {
		try {
			val reviewDto = ReviewDtoMapper.fromReviewToDto(review)
			kafkaTemplate.send(
				KafkaConfig.Companion.REVIEW_TOPIC,
				reviewDto
			)
			return review
		} catch (_: Exception) {
			return null
		}
	}
}