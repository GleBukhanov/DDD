data class EmailAddress(val value: String)
enum class CardTypes{
    DEBIT,CREDIT
}
enum class PaymentMethods{
    CARD,CASH,TRANSACTION
}

data class User(
    val id: String, val email: EmailAddress, var name: String, var password: String,
    val cardTypes: CardTypes,
    val paymentMethods: PaymentMethods
){
    init {
        require(id.isNotBlank()){"���� id �� ����� ���� ������ ��� �������� �� ��������"}
        require(email.value.isNotBlank()) { "����� ����������� ����� �� ����� ���� ������ ��� �������� ������ �� ��������." }
        require(name.isNotBlank()) { "��� ������������ �� ����� ���� ������ ��� �������� ������ �� ��������." }
        require(password.length >= 6) { "������ ������ ��������� �� ����� 6 ��������." }
    }
    /**
     * ��� ���������� �����������, ��� ����� ����������� ����� � ��� ������������ �� ����� ���� ������� ��� �������� ������ �� ��������, � ������ ������ ��������� �� ����� 6 ��������.
     */
}

class UserService {
    fun authenticate(email: EmailAddress, password: String): Boolean {
        // �������������� ������������
        return true
    }
}

class UserRepository {
    constructor(){
        userArray= HashMap<String,User>()
    }
    companion object {
        lateinit var userArray:HashMap<String,User>
    }
    fun getUserById(userId: String): User {
        // ��������� ������������ �� ���� ������ �� ID
        return User("1", EmailAddress("example@example.com"), "John Doe", "password123", CardTypes.DEBIT,PaymentMethods.CARD)
    }
    fun saveUser(user: User){
        var user= userArray.put(user.id,user)
    }
    fun updateUser(userId:String,userNew: User){
        var user=userArray.get(userId)
        if (user != null) {
            user.name=userNew.name
            user.password=userNew.password
        }
    }
    fun deleteUser(userId: String){
        userArray.remove(userId)
    }
}
class UserFactory{
    fun createUser(id: String, email: EmailAddress, name: String,  password: String,cardTypes: CardTypes,paymentMethods: PaymentMethods): User {
        return User(id,email,name,password,cardTypes, paymentMethods)
    }
}
