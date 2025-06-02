package com.example.hexagonal.infrastructure.database.h2.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "reviews")
class ReviewEntity(
	
	val productId: String,
	val review: String,
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	val id: UUID?

)