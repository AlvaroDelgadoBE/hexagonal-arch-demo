package com.example.hexagonal.infrastructure.kafka.adapter

import com.example.hexagonal.domain.model.Review
import com.example.hexagonal.infrastructure.rest.dto.ReviewDto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import org.junit.jupiter.api.assertNull
import org.mockito.Mockito.`when`
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.springframework.kafka.core.KafkaTemplate

class ReviewKafkaAdapterTest {
	
	val kafkaTemplate: KafkaTemplate<String, ReviewDto> = mock()
	val reviewKafkaAdapter = ReviewKafkaAdapter(kafkaTemplate)
	
	@Test
	fun sendReviewCreationShouldSendMessageToKafkaAndReturnReview() {
		val review = Review("productId", "review")
		
		val response = reviewKafkaAdapter.sendReviewCreation(review)
		
		verify(kafkaTemplate, times(1)).send(any(), any())
		assertNotNull(response)
	}
	
	@Test
	fun sendReviewCreationShouldReturnNullIfFails() {
		val review = Review("productId", "review")
		
		`when`(kafkaTemplate.send(any(), any())).thenThrow(RuntimeException())
		
		val response = reviewKafkaAdapter.sendReviewCreation(review)
		
		verify(kafkaTemplate, times(1)).send(any(), any())
		assertNull(response)
	}
	
}