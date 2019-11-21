package service

import entity.Corporation
import repository.CorporationRepository

class CorporationService(val repository: CorporationRepository){
    fun createCorporation(value: Corporation): Corporation {
        value.createdAt = LocalDateTime.now()
        return repository!!.save(value)
    }

    fun updateCorporation(value: Corporation){
        val existsCorporation = repository.fetchById(value.id)
        validateUpdateCorporation(existsCorporation, value)
        value.updatedAt = LocalDateTime.now()
        return repository!!.update(value)
    }

    fun validateUpdateCorporation(
        existsCorporation: Corporation?,
        corporationToUpdate: Corporation
    ) {
        if (existsCorporation == null)
            throw Exception("Corporation not found")

        if (!existsCorporation.active && !corporationToUpdate.active)
            throw Exception("Corporation inactive cannot be updated")
    }

    fun deleteCorporation(id: String) {
        if (repository.fetchById(id)) {
          return repository!!.remove(id)
        }
        // Caso não exista deve retornar throw Exception("Corporation not found")
    }

    fun searchCorporationByNumber(id: String){
        return repository!!.fetchById(id)
    }

    fun searchCorporationByDocument(nif: String){
        return repository!!.fetchByDocument(nif)
    }
}