package com.example.hexagonal.infrastructure.database.h2.repository

import com.example.hexagonal.infrastructure.database.h2.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductJPARepository : JpaRepository<ProductEntity, UUID> {

    fun findByProductId(productId: String): ProductEntity?

}