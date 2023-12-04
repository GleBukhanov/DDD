import java.util.*

class OrderService(
    private val orderRepository: OrderRepository,
    private val deliveryCostCalculator: DeliveryCostCalculator
) {

    fun createOrder(products: List<Product>, deliveryAddress: DeliveryAddress,orderStatus: OrderStatus): Order {
        val orderFactory = OrderFactory()
        val order = orderFactory.createOrder(UUID.randomUUID().toString(), products, deliveryAddress,OrderStatus.IN_DELIVER )
        val deliveryCost = deliveryCostCalculator.calculateCost(order)
        // ��������� �����-�� �������������� ��������, ��������, ������� ����� ��������� ������
        orderRepository.saveOrder(order)
        return order
    }

}