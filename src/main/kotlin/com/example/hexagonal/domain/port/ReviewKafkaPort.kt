package com.example.hexagonal.domain.port

import com.example.hexagonal.domain.model.Review

interface ReviewKafkaPort {
	
	fun sendReviewCreation(review: Review): Review?
	
}