package com.example.hexagonal.usecase.mapper

import com.example.hexagonal.domain.model.Review
import com.example.hexagonal.infrastructure.rest.dto.ReviewDto

object ReviewMapper {
	
	fun fromReviewDtoToReview(reviewDto: ReviewDto): Review {
		return Review(
			reviewDto.productId,
			reviewDto.review
		)
	}
	
}