package com.example.hexagonal.usecase

import com.example.hexagonal.domain.model.Review
import com.example.hexagonal.domain.port.ReviewRepositoryPort
import com.example.hexagonal.infrastructure.kafka.config.KafkaConfig
import com.example.hexagonal.infrastructure.rest.dto.ReviewDto
import com.example.hexagonal.usecase.mapper.ReviewMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ReviewInteractor(
	private val reviewRepository: ReviewRepositoryPort,
	private val kafkaTemplate: KafkaTemplate<String, ReviewDto>
) : IReviewInteractor {
	
	val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)
	
	override fun createReview(review: Review) {
		reviewRepository.saveReview(review)
	}
	
	override fun sendReviewCreation(reviewDto: ReviewDto): Review? {
		try {
			val review = ReviewMapper.fromReviewDtoToReview(reviewDto)
			kafkaTemplate.send(
				KafkaConfig.REVIEW_TOPIC,
				reviewDto
			)
			logger.info("ReviewInteractor.sendReviewCreation # Message sent # $review")
			return review
		} catch (_: Exception) {
			return null
		}
	}
	
}