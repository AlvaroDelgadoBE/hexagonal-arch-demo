package com.example.hexagonal.infrastructure.database.h2.mapper

import com.example.hexagonal.domain.model.Product
import com.example.hexagonal.infrastructure.database.h2.entity.ProductEntity

object ProductEntityMapper {

    fun fromEntityToProduct(productEntity: ProductEntity): Product {
        return Product(
            productEntity.productId,
            productEntity.name,
            productEntity.description,
            productEntity.price,
            productEntity.currency
        )
    }

}