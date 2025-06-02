package com.example.hexagonal.infrastructure.rest.controller

import com.example.hexagonal.infrastructure.database.h2.entity.ProductEntity
import com.example.hexagonal.infrastructure.database.h2.mapper.ProductEntityMapper
import com.example.hexagonal.usecase.IProductInteractor
import com.example.hexagonal.usecase.IReviewInteractor
import org.mockito.Mockito.*
import java.math.BigDecimal
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ProductRestControllerTest {
	
	private val productInteractor: IProductInteractor = mock()
	private val reviewInteractor: IReviewInteractor = mock()
	private val productRestController = ProductRestController(productInteractor, reviewInteractor)
	
	@Test
	fun findProductByProductIdShouldReturnProductDtoIfExists() {
		val productEntity = ProductEntity(
			"productId",
			"name",
			"description",
			BigDecimal.TEN,
			"currency",
			UUID(1L, 2L)
		)
		
		`when`(productInteractor.findProductById("productId")).thenReturn(
			ProductEntityMapper.fromEntityToProduct(
				productEntity
			)
		)
		
		val productDto = productRestController.findProductByProductId(productEntity.productId)
		
		verify(productInteractor, times(1)).findProductById(productEntity.productId)
		assertNotNull(productDto)
		assertEquals(productEntity.productId, productDto.productId)
		assertEquals(productEntity.name, productDto.name)
		assertEquals(productEntity.description, productDto.description)
		assertEquals(productEntity.price, productDto.price)
		assertEquals(productEntity.currency, productDto.currency)
	}
	
}