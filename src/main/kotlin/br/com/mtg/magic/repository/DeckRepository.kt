package br.com.mtg.magic

import org.springframework.data.repository.CrudRepository

interface DeckRepository: CrudRepository<DeckEntity, Long>
