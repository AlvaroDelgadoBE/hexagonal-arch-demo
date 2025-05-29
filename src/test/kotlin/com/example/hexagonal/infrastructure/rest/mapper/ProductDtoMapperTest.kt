package com.example.hexagonal.infrastructure.rest.mapper

import com.example.hexagonal.domain.model.Product
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertEquals

private const val PRODUCT_ID = "productId"
private const val NAME = "name"
private const val DESCRIPTION = "description"
private const val CURRENCY = "currency"

class ProductDtoMapperTest {
	
	@Test
	fun fromProductToDtoShouldMapAllFields() {
		val givenProduct =
			Product(
				PRODUCT_ID,
				NAME,
				DESCRIPTION,
				BigDecimal.TEN,
				CURRENCY
			)
		
		val productDtoConverted = ProductDtoMapper.fromProductToDto(givenProduct)
		
		assertEquals(PRODUCT_ID, productDtoConverted.productId)
		assertEquals(NAME, productDtoConverted.name)
		assertEquals(DESCRIPTION, productDtoConverted.description)
		assertEquals(BigDecimal.TEN, productDtoConverted.price)
		assertEquals(CURRENCY, productDtoConverted.currency)
	}
	
}