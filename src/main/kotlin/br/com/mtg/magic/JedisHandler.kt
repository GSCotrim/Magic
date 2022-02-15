package br.com.mtg.magic

import redis.clients.jedis.Jedis

class JedisHandler {

    fun storingCardNameRedis(cardEntity: CardEntity) {
        val jedis = Jedis()
        jedis.set(cardEntity.id.toString(), cardEntity.name)
    }

    fun storingDeckNameRedis(deckEntity: DeckEntity) {
        val jedis = Jedis()
        jedis.set(deckEntity.id.toString(), deckEntity.name)
    }

}
