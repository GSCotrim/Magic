package br.com.mtg.magic

import org.springframework.data.repository.CrudRepository

interface DeckCardEntity: CrudRepository<DeckCardEntity, Long>

