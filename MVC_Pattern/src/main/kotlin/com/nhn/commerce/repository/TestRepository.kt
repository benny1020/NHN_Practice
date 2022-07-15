package com.nhn.commerce.repository

import com.nhn.commerce.model.Product
import org.apache.ibatis.annotations.*

@Mapper
interface TestRepository {
    @Select("SELECT * FROM test")
    fun findTestList(): List<Int>


}
