package com.example.hexagonal.infrastructure.database.h2.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "products")
class ProductEntity(
	var productId: String,
	val name: String,
	val description: String,
	val price: BigDecimal,
	val currency: String,
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	val id: UUID
)