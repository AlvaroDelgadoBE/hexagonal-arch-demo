package com.example.hexagonal.domain.port

import com.example.hexagonal.domain.model.Review

interface ReviewRepositoryPort {
	
	fun createReview(review: Review)
	
}