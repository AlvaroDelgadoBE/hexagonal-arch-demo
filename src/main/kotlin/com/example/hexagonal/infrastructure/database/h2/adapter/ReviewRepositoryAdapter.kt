package com.example.hexagonal.infrastructure.database.h2.adapter

import com.example.hexagonal.domain.model.Review
import com.example.hexagonal.domain.port.ReviewRepositoryPort
import com.example.hexagonal.infrastructure.database.h2.mapper.ReviewEntityMapper
import com.example.hexagonal.infrastructure.database.h2.repository.ReviewJPARepository
import org.springframework.stereotype.Component

@Component
class ReviewRepositoryAdapter(private val reviewJpaRepository: ReviewJPARepository) : ReviewRepositoryPort {
	
	override fun saveReview(review: Review) {
		reviewJpaRepository.save(ReviewEntityMapper.fromReviewToEntity(review))
	}
	
}