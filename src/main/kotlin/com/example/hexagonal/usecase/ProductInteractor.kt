package com.example.hexagonal.usecase

import com.example.hexagonal.domain.model.Product
import com.example.hexagonal.domain.model.Review
import com.example.hexagonal.domain.port.ProductRepositoryPort
import com.example.hexagonal.infrastructure.rest.dto.ReviewDto
import com.example.hexagonal.kafka.config.KafkaConfig
import com.example.hexagonal.usecase.mapper.ReviewMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ProductInteractor(
	private val productRepository: ProductRepositoryPort,
	private val kafkaTemplate: KafkaTemplate<String, Review>
) : IProductInteractor {
	
	override fun findProductById(productId: String): Product? {
		return productRepository.findProductByProductId(productId);
	}
	
	override fun sendReviewCreation(reviewDto: ReviewDto): Review? {
		try {
			val review = ReviewMapper.fromReviewDtoToReview(reviewDto)
			kafkaTemplate.send(
				KafkaConfig.PRODUCT_TOPIC,
				review
			)
			return review
		} catch (_: Exception) {
			return null
		}
	}
	
}