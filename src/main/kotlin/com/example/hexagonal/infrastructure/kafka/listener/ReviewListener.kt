package com.example.hexagonal.infrastructure.kafka.listener

import com.example.hexagonal.infrastructure.kafka.config.KafkaConfig
import com.example.hexagonal.infrastructure.rest.dto.ReviewDto
import com.example.hexagonal.infrastructure.rest.mapper.ReviewDtoMapper
import com.example.hexagonal.usecase.ReviewInteractor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.KafkaListener

@Configuration
class ReviewListener(private val reviewInteractor: ReviewInteractor) {
	
	val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)
	
	@KafkaListener(topics = [KafkaConfig.REVIEW_TOPIC], groupId = "reviewGroup", containerFactory = "containerFactory")
	fun reviewTopicListener(reviewDto: ReviewDto) {
		logger.info("ReviewListener.reviewTopicListener # Message received # $reviewDto")
		reviewInteractor.createReview(ReviewDtoMapper.fromDtoToReview(reviewDto))
	}
	
}