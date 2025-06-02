package com.example.hexagonal.infrastructure.database.h2.mapper

import com.example.hexagonal.domain.model.Review
import com.example.hexagonal.infrastructure.database.h2.entity.ReviewEntity

object ReviewEntityMapper {
	
	fun fromReviewToEntity(review: Review): ReviewEntity {
		return ReviewEntity(
			review.productId,
			review.review,
			null
		)
	}
	
}