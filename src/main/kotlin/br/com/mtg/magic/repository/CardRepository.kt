package br.com.mtg.magic

import br.com.mtg.magic.CardEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface CardRepository: CrudRepository<CardEntity, Long>

