package com.example.hexagonal.usecase

import com.example.hexagonal.domain.model.Product
import com.example.hexagonal.domain.model.Review
import com.example.hexagonal.infrastructure.rest.dto.ReviewDto

interface IProductInteractor {
	
	fun findProductById(productId: String): Product?
	
	fun sendReviewCreation(reviewDto: ReviewDto): Review?
	
}