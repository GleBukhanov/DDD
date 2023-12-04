fun main() {
    val productRepository = ProductRepository()
    val orderRepository = OrderRepository()
    val userRepository = UserRepository()
    val deliveryCostCalculator = DeliveryCostCalculator()
    val productFactory = ProductFactory()
    val orderFactory = OrderFactory()
    val userFactory = UserFactory()

    // �������� ��������
    //val product = productRepository.getProductById("1")
    val product = productFactory.createProduct("5", "Zerno", "��������", Price(500.99))


    // �������� ������������
    //val user = userRepository.getUserById("1")
    val user = userFactory.createUser("5",EmailAddress("test@te.st"),"Pal Sanych","trikota",CardTypes.DEBIT,PaymentMethods.CARD)
    // �������� ������
    val deliveryAddress = DeliveryAddress("123 Main St", "City", "12345")
    val orderService = OrderService(orderRepository, deliveryCostCalculator)
    val order = orderService.createOrder(listOf(product), deliveryAddress, OrderStatus.IN_DELIVER)

    // �������������� ������������
    val email = EmailAddress("example@example.com")
    val password = "password123"
    val userService = UserService()
    val isAuthenticated = userService.authenticate(email, password)

    // ����� �����������
    println("�������: ${product.name}, ����: ${product.price.value}")
    println("������������: ${user.name}, Email: ${user.email.value}, CardType: ${user.cardTypes.name} ")
    println("������ ����� � ID: ${order.id}, ��������� ��������: ${deliveryCostCalculator.calculateCost(order)}")
    println("������������ ����������������: $isAuthenticated")

}
