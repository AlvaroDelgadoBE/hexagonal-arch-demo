package com.example.hexagonal.infrastructure.database.h2.mapper

import com.example.hexagonal.infrastructure.database.h2.entity.ProductEntity
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertEquals

private const val PRODUCT_ID = "productId"
private const val NAME = "name"
private const val DESCRIPTION = "description"
private const val CURRENCY = "currency"

class ProductEntityMapperTest {
	
	@Test
	fun fromEntityToProductShouldMapAllFields() {
		val givenProductEntity =
			ProductEntity(
				PRODUCT_ID,
				NAME,
				DESCRIPTION,
				BigDecimal.TEN,
				CURRENCY,
				UUID(1L, 2L)
			)
		
		val productConverted = ProductEntityMapper.fromEntityToProduct(givenProductEntity)
		
		assertEquals(PRODUCT_ID, productConverted.productId)
		assertEquals(NAME, productConverted.name)
		assertEquals(DESCRIPTION, productConverted.description)
		assertEquals(BigDecimal.TEN, productConverted.price)
		assertEquals(CURRENCY, productConverted.currency)
	}
	
}