package com.example.hexagonal.infrastructure.rest.mapper

import com.example.hexagonal.domain.model.Product
import com.example.hexagonal.infrastructure.rest.dto.ProductDto


object ProductDtoMapper {

    fun fromProductToDto(product: Product): ProductDto {
        return ProductDto(
            product.productId,
            product.name,
            product.description,
            product.price,
            product.currency
        )
    }

}