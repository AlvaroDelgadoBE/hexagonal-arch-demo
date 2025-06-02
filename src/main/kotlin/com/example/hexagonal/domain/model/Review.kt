package com.example.hexagonal.domain.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Review(
	@JsonProperty("productId") var productId: String,
	@JsonProperty("review") var review: String
)
