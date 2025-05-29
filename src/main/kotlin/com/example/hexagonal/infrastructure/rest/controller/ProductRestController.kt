package com.example.hexagonal.infrastructure.rest.controller

import com.example.hexagonal.infrastructure.rest.dto.ProductDto
import com.example.hexagonal.infrastructure.rest.mapper.ProductDtoMapper
import com.example.hexagonal.usecase.IProductInteractor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/hexagonal/products")
@RestController
class ProductRestController(private val productInteractor: IProductInteractor) {

    @GetMapping("/{productId}")
    fun findProductByProductId(@PathVariable productId: String): ProductDto? {
        return productInteractor.findProductById(productId)?.let { product ->  ProductDtoMapper.fromProductToDto(product)}
    }
    
}