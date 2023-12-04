data class DeliveryAddress(val street: String, val city: String, val postalCode: String)
enum class OrderStatus{
    WAITING,PAID,IN_DELIVER
}


data class Order(val id: String, val products: List<Product>, val deliveryAddress: DeliveryAddress,var orderStatus: OrderStatus) {
    init {
        require(id.isNotBlank()){"ѕоле id не может быть пустым или состо€ть только из пробелов"}
        require(products.isNotEmpty()) { "«аказ должен содержать хот€ бы один продукт." }
    }
}

class OrderRepository {
    constructor() {}

    var orderArray = HashSet<Order>()

    companion object {
        lateinit var orderArray: HashSet<Order>
    }

    fun saveOrder(order: Order) {
        orderArray.add(order)
        // сохранение заказа в базе данных
    }

    fun findOrderById(id: String): Order? {
        return orderArray.find { it.id == id }
    }

    fun deleteOrder(id: String) {
        var order = orderArray.find { it.id == id }
        orderArray.remove(order)
    }
}

class OrderFactory {
    fun createOrder(id: String, products: List<Product>, deliveryAddress: DeliveryAddress,orderStatus: OrderStatus): Order {
        return Order(id, products, deliveryAddress, orderStatus)
    }
}

class DeliveryCostCalculator {
    fun calculateCost(order: Order): Double {
        var summary = 0.0
        for (product in order.products) {
            summary = summary + product.price.value
        }
        return summary
    }//подсчЄт суммы заказа
}