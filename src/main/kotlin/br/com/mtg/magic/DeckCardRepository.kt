package br.com.mtg.magic

import org.springframework.data.repository.CrudRepository

interface DeckCardRepository: CrudRepository<DeckCardEntity, Long>

