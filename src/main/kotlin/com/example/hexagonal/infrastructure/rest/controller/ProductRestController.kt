package com.example.hexagonal.infrastructure.rest.controller

import com.example.hexagonal.infrastructure.rest.dto.ProductDto
import com.example.hexagonal.infrastructure.rest.dto.ReviewDto
import com.example.hexagonal.infrastructure.rest.mapper.ProductDtoMapper
import com.example.hexagonal.infrastructure.rest.mapper.ReviewDtoMapper
import com.example.hexagonal.usecase.IProductInteractor
import com.example.hexagonal.usecase.IReviewInteractor
import org.springframework.web.bind.annotation.*

@RequestMapping("/hexagonal/products")
@RestController
class ProductRestController(
	private val productInteractor: IProductInteractor,
	private val reviewInteractor: IReviewInteractor
) {
	
	@GetMapping("/{productId}")
	fun findProductByProductId(@PathVariable productId: String): ProductDto? {
		return productInteractor.findProductById(productId)?.let { product ->
			ProductDtoMapper.fromProductToDto(product)
		}
	}
	
	@PostMapping("/review")
	fun sendReviewCreation(@RequestBody reviewDto: ReviewDto): ReviewDto? {
		return reviewInteractor.sendReviewCreation(reviewDto)?.let { review ->
			ReviewDtoMapper.fromReviewToDto(review)
		}
	}
	
}