package com.example.hexagonal.infrastructure.rest.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class ReviewDto @JsonCreator constructor(
	@JsonProperty("productId") var productId: String,
	@JsonProperty("review") var review: String
)