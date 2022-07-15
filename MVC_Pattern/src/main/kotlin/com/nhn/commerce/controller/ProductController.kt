package com.nhn.commerce.controller

import com.nhn.commerce.model.Product
import com.nhn.commerce.service.ProductService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class ProductController(
    private val productService: ProductService,
) {

    @GetMapping("/test")

    fun getTestList(): String {
        return "product"
    }

    @GetMapping("/product")
    fun getProductList(model: Model): String {
        model.addAttribute("productList", productService.findProductList())
        println("it is get")
        return "product"
    }

    // TODO (상품 상세 조회 기능 + Exception 처리)
    @GetMapping("/product/{productNo}")
    fun getProductDetail(model: Model,@PathVariable productNo:Int) : String? {
        println("it is get detail")
        return "redirect:/product"
    }

    // TODO (상품 추가 기능)
    @PostMapping("/product")
    fun postProduct(model: Model,@RequestParam productName:  String, @RequestParam salePrice: Int) : String {
        println("it is post")
        productService.addProduct(productName,salePrice)
        return "redirect:/product"
    }

    // TODO (상품 수정 기능 + Exception 처리)
    @PutMapping("/product")
    fun putProduct(model: Model, product: Product) :String {
        println("it is put")

        productService.updateProduct(product)
        return "redirect:/product"

    }

    // TODO (상품 삭제 기능 + Exception 처리)

    @DeleteMapping("/product/{productNo}")
    fun deleteProduct(model: Model, @PathVariable() productNo: Int) : String {
        println("it is delete")
        productService.deleteProduct(productNo.toInt())
        return "redirect:/product"
    }

}
