package com.example.hexagonal.usecase

import com.example.hexagonal.domain.model.Product

interface IProductInteractor {
	
	fun findProductById(productId: String): Product?
	
}