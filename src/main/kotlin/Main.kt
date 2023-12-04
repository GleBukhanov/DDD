fun main() {
    val productRepository = ProductRepository()
    val orderRepository = OrderRepository()
    val userRepository = UserRepository()
    val deliveryCostCalculator = DeliveryCostCalculator()
    val productFactory = ProductFactory()
    val orderFactory = OrderFactory()
    val userFactory = UserFactory()

    // Создание продукта
    //val product = productRepository.getProductById("1")
    val product = productFactory.createProduct("5", "Zerno", "Кайфовая", Price(500.99))


    // Создание пользователя
    //val user = userRepository.getUserById("1")
    val user = userFactory.createUser("5",EmailAddress("test@te.st"),"Pal Sanych","trikota",CardTypes.DEBIT,PaymentMethods.CARD)
    // Создание заказа
    val deliveryAddress = DeliveryAddress("123 Main St", "City", "12345")
    val orderService = OrderService(orderRepository, deliveryCostCalculator)
    val order = orderService.createOrder(listOf(product), deliveryAddress, OrderStatus.IN_DELIVER)

    // Аутентификация пользователя
    val email = EmailAddress("example@example.com")
    val password = "password123"
    val userService = UserService()
    val isAuthenticated = userService.authenticate(email, password)

    // Вывод результатов
    println("Продукт: ${product.name}, Цена: ${product.price.value}")
    println("Пользователь: ${user.name}, Email: ${user.email.value}, CardType: ${user.cardTypes.name} ")
    println("Создан заказ с ID: ${order.id}, Стоимость доставки: ${deliveryCostCalculator.calculateCost(order)}")
    println("Пользователь аутентифицирован: $isAuthenticated")

}
