package com.example.hexagonal.usecase

import com.example.hexagonal.domain.model.Review
import com.example.hexagonal.domain.port.ReviewKafkaPort
import com.example.hexagonal.domain.port.ReviewRepositoryPort
import com.example.hexagonal.infrastructure.rest.dto.ReviewDto
import com.example.hexagonal.infrastructure.rest.mapper.ReviewDtoMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import org.mockito.Mockito.`when`
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class ReviewInteractorTest {
	
	private val reviewRepository: ReviewRepositoryPort = mock()
	private val reviewKafka: ReviewKafkaPort = mock()
	private val reviewInteractor = ReviewInteractor(reviewRepository, reviewKafka)
	
	@Test
	fun createReviewShouldCallRepository() {
		val review = Review("productId", "review")
		
		reviewInteractor.createReview(review)
		
		verify(reviewRepository, times(1)).createReview(review)
	}
	
	@Test
	fun sendReviewCreationShouldCallKafkaAndReturnReview() {
		val reviewDto = ReviewDto("productId", "review")
		
		`when`(reviewKafka.sendReviewCreation(any()))
			.thenReturn(ReviewDtoMapper.fromDtoToReview(reviewDto))
		
		val response = reviewInteractor.sendReviewCreation(reviewDto)
		
		verify(reviewKafka, times(1)).sendReviewCreation(any())
		assertNotNull(response)
	}
	
}