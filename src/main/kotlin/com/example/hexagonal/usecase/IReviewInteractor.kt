package com.example.hexagonal.usecase

import com.example.hexagonal.domain.model.Review
import com.example.hexagonal.infrastructure.rest.dto.ReviewDto

interface IReviewInteractor {
	
	fun createReview(review: Review)
	
	fun sendReviewCreation(reviewDto: ReviewDto): Review?
	
}