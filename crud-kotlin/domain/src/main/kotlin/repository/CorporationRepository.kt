package repository

import entity.Corporation


interface CorporationRepository {
    fun save(bean: Corporation): String
    fun update(value: Corporation): Boolean
    fun remove(corporation: String): Boolean
    fun fetchById(corporationId: String): Corporation?
    fun fetchByDocument(document: String): Corporation?
}