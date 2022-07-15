package com.nhn.commerce.model

import java.time.LocalDate
import java.time.LocalDateTime

data class Product(
    var productNo: String,
    var productName: String,
    var registerYmdt: LocalDateTime?,
    var salePrice: Int,
    var updateYmdt: LocalDateTime?
) {
    fun updateTime(){
        this.updateYmdt= LocalDateTime.now()
    }
}
