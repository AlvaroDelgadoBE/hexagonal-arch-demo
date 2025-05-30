package com.example.hexagonal.infrastructure.rest.mapper

import com.example.hexagonal.domain.model.Review
import com.example.hexagonal.infrastructure.rest.dto.ReviewDto

object ReviewDtoMapper {
	
	fun fromReviewToDto(review: Review): ReviewDto {
		return ReviewDto(
			review.productId,
			review.review
		)
	}
}