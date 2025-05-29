package com.example.hexagonal.infrastructure.database.h2.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "products")
class ProductEntity (

    val productId: String,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val currency: String,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID
)