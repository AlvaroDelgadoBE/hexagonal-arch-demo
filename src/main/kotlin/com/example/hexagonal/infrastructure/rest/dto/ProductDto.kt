package com.example.hexagonal.infrastructure.rest.dto

import java.math.BigDecimal

data class ProductDto (

    private var productId: String,
    private var name: String,
    private var description: String,
    private var price: BigDecimal,
    private var currency: String

)