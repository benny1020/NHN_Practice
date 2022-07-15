
/**
 * 목표: 실습1 심화
 * 조건
 * 1. 색상(RGB)을 추가로 가지게 변경
 *  단 색상은 이넘으로 관리해라
 *  단, 여러가지 색깔을 가질 수 있다. 추가 삭제 가능, 중복 X
 */
enum class Color() {
    RED, GREEN, BLUE
}

fun main() {
    val product = Product("상품")
    println(product)

    // 가격, 색상을 scope function으로 설정
    // 단, 재고는 2개
    product.apply{
        price = 1234
        amount = 2
        color.add(Color.RED)
    }
    println(product)


    // 물건 1건 구매를 scope function으로 실행
    product.run {
        buy(1)
    }
    println(product)

    // 물건 현재 가치(price*amount) println()으로 출력 - scope function 활요
    product.run {
        println("물건 현재 가치 : ${price*amount}")
    }

    // 물건 1건 구매를 scope function으로 실행하고, chaining하여 물건갯구가 0이하면 "재고없음" 출력하기
    product.run {
        buy(1)
        if(amount<=0)
            println("재고없음")
    }


    println(product)


}



private data class Product(
    val name: String,
    val color: MutableSet<Color> = mutableSetOf(),
    var price: Int = 0,
    var amount: Int = 0
) {


    fun buy(amount: Int = 1) {
        this.amount -= amount
    }


    override fun toString(): String {
        return """
            상품명 : $name
            컬러  : $color
            가격  : $price
            재고  : $amount
        """.trimIndent()
    }
}