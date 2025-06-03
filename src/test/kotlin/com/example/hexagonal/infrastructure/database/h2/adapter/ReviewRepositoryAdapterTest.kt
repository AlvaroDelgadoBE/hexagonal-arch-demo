package com.example.hexagonal.infrastructure.database.h2.adapter

import com.example.hexagonal.domain.model.Review
import com.example.hexagonal.infrastructure.database.h2.repository.ReviewJPARepository
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class ReviewRepositoryAdapterTest {
	
	val reviewJpaRepository: ReviewJPARepository = mock()
	val reviewRepositoryAdapter = ReviewRepositoryAdapter(reviewJpaRepository)
	
	@Test
	fun createReviewShouldCallAdapter() {
		val review = Review("productId", "review")
		
		reviewRepositoryAdapter.createReview(review)
		
		verify(reviewJpaRepository, times(1)).save(any())
	}
	
}