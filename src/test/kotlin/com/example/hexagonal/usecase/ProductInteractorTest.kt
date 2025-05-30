package com.example.hexagonal.usecase

import com.example.hexagonal.domain.model.Product
import com.example.hexagonal.domain.port.ProductRepositoryPort
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import org.mockito.Mockito.*
import org.springframework.kafka.core.KafkaTemplate
import java.math.BigDecimal
import kotlin.test.assertEquals

private const val PRODUCT_ID = "productId"
private const val NAME = "name"
private const val DESCRIPTION = "description"
private const val CURRENCY = "currency"

class ProductInteractorTest {
	
	private val productRepository: ProductRepositoryPort = mock()
	private val kafkaTemplate: KafkaTemplate<String, String> = mock()
	private val productInteractor = ProductInteractor(productRepository, kafkaTemplate)
	
	@Test
	fun findProductById() {
		val expectedProduct = Product(PRODUCT_ID, NAME, DESCRIPTION, BigDecimal.TEN, CURRENCY)
		`when`(productRepository.findProductByProductId(PRODUCT_ID)).thenReturn(expectedProduct)
		
		val product = productInteractor.findProductById(PRODUCT_ID)
		
		verify(productRepository, times(1)).findProductByProductId(PRODUCT_ID)
		assertNotNull(product)
		assertEquals(expectedProduct.productId, product.productId)
		assertEquals(expectedProduct.name, product.name)
		assertEquals(expectedProduct.description, product.description)
		assertEquals(expectedProduct.price, product.price)
		assertEquals(expectedProduct.currency, product.currency)
	}
	
}