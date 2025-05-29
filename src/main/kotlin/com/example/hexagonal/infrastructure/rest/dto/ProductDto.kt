package com.example.hexagonal.infrastructure.rest.dto

import java.math.BigDecimal

data class ProductDto (
     var productId: String,
     var name: String,
     var description: String,
     var price: BigDecimal,
     var currency: String
)