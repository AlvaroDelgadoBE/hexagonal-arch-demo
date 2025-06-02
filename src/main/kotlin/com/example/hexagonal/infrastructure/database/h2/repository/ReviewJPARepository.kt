package com.example.hexagonal.infrastructure.database.h2.repository

import com.example.hexagonal.infrastructure.database.h2.entity.ReviewEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ReviewJPARepository : JpaRepository<ReviewEntity, UUID> {
	
	fun save(review: ReviewEntity): ReviewEntity?
	
}