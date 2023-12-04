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
        require(id.isNotBlank()){"ѕоле id не может быть пустым или состо€ть из пробелов"}
        require(email.value.isNotBlank()) { "јдрес электронной почты не может быть пустым или состо€ть только из пробелов." }
        require(name.isNotBlank()) { "»м€ пользовател€ не может быть пустым или состо€ть только из пробелов." }
        require(password.length >= 6) { "ѕароль должен содержать не менее 6 символов." }
    }
    /**
     * Ёти инварианты гарантируют, что адрес электронной почты и им€ пользовател€ не могут быть пустыми или состо€ть только из пробелов, а пароль должен содержать не менее 6 символов.
     */
}

class UserService {
    fun authenticate(email: EmailAddress, password: String): Boolean {
        // аутентификаци€ пользовател€
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
        // получение пользовател€ из базы данных по ID
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
