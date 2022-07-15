package com.nhn.commerce.service

import com.nhn.commerce.model.Product
import com.nhn.commerce.repository.ProductRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class ProductService(
    private val productRepository: ProductRepository,
) {
    fun findProductList(): List<Product> = productRepository.findProductList()
    fun findProductDetail(productNo:Int) : Product? {
        return productRepository.getProductDetail(productNo)
    }
    fun deleteProduct(productNo:Int) {
        productRepository.deleteProduct(productNo)
    }
    fun addProduct(productName: String, salePrice: Int) {
        println(LocalDate.now())
        productRepository.addProduct(productName,salePrice, LocalDateTime.now(),LocalDateTime.now())
    }
    fun updateProduct(product: Product) {
        product.updateTime()
        productRepository.updateProduct(product)
    }


}
