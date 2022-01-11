package br.com.mtg.magic

import br.com.mtg.magic.CardEntity
import org.springframework.data.repository.CrudRepository

interface CardRepository: CrudRepository<CardEntity, Long>

