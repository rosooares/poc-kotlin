
@RequestMapping("/api/corporations")
class CorporationsController {
     var corporationService: CorporationService? = null

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    @ResponseStatus(HttpStatus.CREATED)
    fun createCorporation(@Validated @RequestBody Corporation: Corporation): Corporation {
        return corporationService!!.createCorporation(Corporation)
    }

    @RequestMapping(value = "{id}", method = arrayOf(RequestMethod.PUT))
    @ResponseStatus(HttpStatus.OK)
    fun updateCorporation(@PathVariable("id") id: String, @Validated @RequestBody corporation: Corporation): Corporation {
        corporation.id = id
        return corporationService!!.updateCorporation(corporation)
    }

    @RequestMapping(value = "{id}", method = arrayOf(RequestMethod.DELETE))
    @ResponseStatus(HttpStatus.OK)
    fun deleteCorporation(@PathVariable("id") id: String?) {
        corporationService!!.deleteCorporation(id)
    }

    @RequestMapping(value = "{id}", method = arrayOf(RequestMethod.GET))
    fun getCorporation(@PathVariable("id") id: String?): Corporation {
        return corporationService!!.searchCorporationByNumber(id)
    }

    @RequestMapping(value = "{document}", method = arrayOf(RequestMethod.GET))
    fun getCorporation(@PathVariable("document") id: String?): Corporation {
        return corporationService!!.searchCorporationByDocument(document)
    }
}