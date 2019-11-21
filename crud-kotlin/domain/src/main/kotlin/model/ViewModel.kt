package model

data class CorporationViewModel(val id: String, val name: String, val number: String) {
    lateinit var contact: String
    lateinit var phone: String
    lateinit var email: String
    var active: Boolean = true
    var corporationAndClass: CorporationAndClassViewModel? = null
}