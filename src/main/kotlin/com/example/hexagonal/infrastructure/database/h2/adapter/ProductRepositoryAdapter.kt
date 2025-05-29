package com.example.hexagonal.infrastructure.database.h2.adapter

import com.example.hexagonal.domain.model.Product
import com.example.hexagonal.domain.port.ProductRepositoryPort
import com.example.hexagonal.infrastructure.database.h2.mapper.ProductEntityMapper
import com.example.hexagonal.infrastructure.database.h2.repository.ProductJPARepository
import org.springframework.stereotype.Component

@Component
class ProductRepositoryAdapter (private val productJpaRepository: ProductJPARepository) : ProductRepositoryPort  {

    override fun findProductByProductId(productId: String): Product? {
        return productJpaRepository.findByProductId(productId)?.let {
            productEntity -> ProductEntityMapper.fromEntityToProduct(productEntity)
        }
    }



}