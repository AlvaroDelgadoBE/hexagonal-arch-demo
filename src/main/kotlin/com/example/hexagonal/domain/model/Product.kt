package com.example.hexagonal.domain.model

import java.math.BigDecimal

data class Product(
     var productId: String,
     var name: String,
     var description: String,
     var price: BigDecimal,
     var currency: String
)
