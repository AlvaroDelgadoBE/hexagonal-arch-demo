package com.example.hexagonal.infrastructure.database.h2.adapter

import com.example.hexagonal.infrastructure.database.h2.entity.ProductEntity
import com.example.hexagonal.infrastructure.database.h2.repository.ProductJPARepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import org.junit.jupiter.api.assertNull
import org.mockito.Mockito.*
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertEquals

class ProductRepositoryAdapterTest {
	
	private var productJpaRepository: ProductJPARepository = mock()
	private var productRepositoryAdapter = ProductRepositoryAdapter(productJpaRepository)
	
	@Test
	fun findProductByProductIdShouldReturnAProductIfExists() {
		val expectedProductEntity = ProductEntity(
			"Product1",
			"Product1",
			"Description1",
			BigDecimal.ONE,
			"€", UUID(
				1L,
				2L
			)
		)
		
		`when`(productJpaRepository.findByProductId(("Product1"))).thenReturn(expectedProductEntity)
		
		val product = productRepositoryAdapter.findProductByProductId("Product1")
		
		verify(productJpaRepository, times(1)).findByProductId("Product1")
		assertNotNull(product)
		assertEquals("Product1", product.productId)
		assertEquals("Product1", product.name)
		assertEquals("Description1", product.description)
		assertEquals(BigDecimal.ONE, product.price)
	}
	
	@Test
	fun findProductByProductIdShouldReturnNullIfNotExists() {
		`when`(productJpaRepository.findByProductId(("Product1"))).thenReturn(null)
		
		val product = productRepositoryAdapter.findProductByProductId("Product1")
		
		verify(productJpaRepository).findByProductId("Product1")
		assertNull(product)
	}
	
}