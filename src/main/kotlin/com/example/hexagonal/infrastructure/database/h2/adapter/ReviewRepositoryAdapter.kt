package com.example.hexagonal.infrastructure.database.h2.adapter

import com.example.hexagonal.domain.model.Review
import com.example.hexagonal.domain.port.ReviewRepositoryPort
import com.example.hexagonal.infrastructure.database.h2.mapper.ReviewEntityMapper
import com.example.hexagonal.infrastructure.database.h2.repository.ReviewJPARepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ReviewRepositoryAdapter(
	private val reviewJpaRepository: ReviewJPARepository
) : ReviewRepositoryPort {
	
	val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)
	
	override fun createReview(review: Review) {
		try {
			reviewJpaRepository.save(ReviewEntityMapper.fromReviewToEntity(review))
		} catch (_: Exception) {
			logger.error("ReviewRepositoryAdapter.createReview # The review ${review} couldn't be saved.")
		}
	}
	
}