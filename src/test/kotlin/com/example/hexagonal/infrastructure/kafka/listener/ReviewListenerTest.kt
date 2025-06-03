package com.example.hexagonal.infrastructure.kafka.listener

import com.example.hexagonal.infrastructure.rest.dto.ReviewDto
import com.example.hexagonal.usecase.ReviewInteractor
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class ReviewListenerTest {
	
	private val reviewInteractor: ReviewInteractor = mock()
	private val reviewListener = ReviewListener(reviewInteractor)
	
	@Test
	fun reviewTopicListenerShouldCallInteractor() {
		val reviewDto = ReviewDto("productId", "review")
		
		reviewListener.reviewTopicListener(reviewDto)
		
		verify(reviewInteractor, times(1)).createReview(any())
	}
	
}