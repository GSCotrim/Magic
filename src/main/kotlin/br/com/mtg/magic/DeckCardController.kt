package br.com.mtg.magic

@RestController
class DeckCardController(
    @Autowired private var deckCardBusiness: DeckCardBusiness
) {

}