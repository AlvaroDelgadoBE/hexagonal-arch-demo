package com.example.hexagonal.domain.port

import com.example.hexagonal.domain.model.Product

interface ProductRepositoryPort {

    fun findProductByProductId(productId: String): Product?

}