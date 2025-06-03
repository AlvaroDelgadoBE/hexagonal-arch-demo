package com.example.hexagonal.usecase

import com.example.hexagonal.domain.model.Review
import com.example.hexagonal.domain.port.ReviewKafkaPort
import com.example.hexagonal.domain.port.ReviewRepositoryPort
import com.example.hexagonal.infrastructure.rest.dto.ReviewDto
import com.example.hexagonal.infrastructure.rest.mapper.ReviewDtoMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ReviewInteractor(
	private val reviewRepository: ReviewRepositoryPort,
	private val reviewKafka: ReviewKafkaPort
) : IReviewInteractor {
	
	val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)
	
	override fun createReview(review: Review) {
		logger.info("ReviewInteractor.createReview # $review")
		reviewRepository.createReview(review)
	}
	
	override fun sendReviewCreation(reviewDto: ReviewDto): Review? {
		logger.info("ReviewInteractor.sendReviewCreation # $reviewDto")
		return reviewKafka.sendReviewCreation(ReviewDtoMapper.fromDtoToReview(reviewDto))
	}
	
}