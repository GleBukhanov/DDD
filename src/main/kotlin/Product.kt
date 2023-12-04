data class Price(val value: Double)

data class Product(val id: String, val name: String, val description: String, var price: Price) {
    init {
        require(id.isNotBlank()){"���� id �� ����� ���� ������ ��� �������� ������ �� ��������"}
        require(name.isNotBlank()) { "��� �������� �� ����� ���� ������ ��� �������� ������ �� ��������." }
        require(description.isNotBlank()) { "�������� �������� �� ����� ���� ������ ��� �������� ������ �� ��������." }
        require(price.value > 0) { "���� �������� ������ ���� ������������� ������." }
    }
    /**
     * ��� ���������� �����������, ��� ��� � �������� �������� �� ����� ���� ������� ��� �������� ������ �� ��������, � ���� ������ ���� ������������� ������.
     */
}

class ProductRepository {
    constructor(){
        productArray= HashMap<String,Product>()
    }
    companion object {
        lateinit var productArray:HashMap<String,Product>
    }

    fun getProductById(productId: String): Product? {
        var prod = productArray.get(productId)
        // ��������� �������� �� ���� ������ �� ID
        return prod
    }

    fun saveProduct(product: Product) {
        var prod = productArray.put(product.id, product)
    }

    fun updateProduct(productId: String,productNew: Product){
        var product= productArray.get(productId)
        if (product != null) {
            product.price=productNew.price
        }
    }

    fun deleteProduct(productId: String){
        productArray.remove(productId)
    }

}

class ProductFactory {
    fun createProduct(id: String, name: String, description: String, price: Price): Product {
        return Product(id, name, description, price)
    }
}