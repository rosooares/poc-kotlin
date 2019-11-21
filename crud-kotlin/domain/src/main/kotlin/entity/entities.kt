package entity
import java.util.*

data class Corporation(val id: String,val name: String,val document: String ) {
    lateinit var contact: String
    lateinit var  phone: String
    lateinit var  email: String
    var active: Boolean = false
    lateinit var  createdAt: Date
    lateinit var  updatedAt: Date
}
