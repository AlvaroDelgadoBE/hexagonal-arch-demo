package com.example.hexagonal.usecase

import com.example.hexagonal.domain.model.Product
import com.example.hexagonal.domain.port.ProductRepositoryPort
import org.springframework.stereotype.Component

@Component
class ProductInteractor(
	private val productRepository: ProductRepositoryPort,
) : IProductInteractor {
	
	override fun findProductById(productId: String): Product? {
		return productRepository.findProductByProductId(productId);
	}
	
}