package com.nhn.commerce.repository

import com.nhn.commerce.model.Product
import org.apache.ibatis.annotations.*
import java.time.LocalDateTime

@Mapper
interface ProductRepository {
    @Select("SELECT * FROM product")
    fun findProductList(): List<Product>

    @Select("SELECT * FROM product WHERE productNo=#{productNo}")
    fun getProductDetail(productNo: Int): Product?

    @Delete("DELETE FROM product WHERE productNo=#{productNo}")
    fun deleteProduct(productNo: Int)

    @Insert("INSERT INTO product(productName, salePrice, registerYmdt, updateYmdt) VALUES(#{productName},#{salePrice},#{registerYmdt},#{updateYmdt})")
    fun addProduct(productName: String, salePrice: Int, registerYmdt: LocalDateTime, updateYmdt: LocalDateTime)

    @Update("UPDATE product SET productName=#{productName}, salePrice=#{salePrice}, updateYmdt=#{updateYmdt} WHERE productNo = #{productNo}")
    fun updateProduct(product :Product)
}
