package com.example.hexagonal.infrastructure.rest.mapper

import com.example.hexagonal.domain.model.Review
import com.example.hexagonal.infrastructure.rest.dto.ReviewDto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import kotlin.test.assertEquals

private const val PRODUCT_ID = "productId"
private const val REVIEW = "review"

class ReviewDtoMapperTest {
	
	@Test
	fun fromReviewToDtoShouldMapAllFields() {
		val givenReview =
			Review(
				PRODUCT_ID,
				REVIEW
			)
		
		val reviewConverted = ReviewDtoMapper.fromReviewToDto(givenReview)
		
		assertNotNull(reviewConverted)
		assertEquals(PRODUCT_ID, reviewConverted.productId)
		assertEquals(REVIEW, reviewConverted.review)
	}
	
	@Test
	fun fromDtoToReviewShouldMapAllFields() {
		val givenReview =
			ReviewDto(
				PRODUCT_ID,
				REVIEW
			)
		
		val reviewConverted = ReviewDtoMapper.fromDtoToReview(givenReview)
		
		assertNotNull(reviewConverted)
		assertEquals(PRODUCT_ID, reviewConverted.productId)
		assertEquals(REVIEW, reviewConverted.review)
	}
	
}