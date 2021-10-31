package br.com.mtg.magic

import org.springframework.data.repository.CrudRepository
import java.util.*

interface DeckCardRepository: CrudRepository<DeckCardEntity, Long>{
    fun findAllByDeckId(deckId: Long): Optional<List<DeckCardEntity>>
}

