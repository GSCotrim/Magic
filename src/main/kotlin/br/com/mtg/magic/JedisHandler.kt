package br.com.mtg.magic

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

@Component
class JedisHandler {

    private val log: Logger = LoggerFactory.getLogger(CardBusiness::class.java)

    private val ONE_MINUTE_IN_MILLIS = 60 * 1000
    private val THIRTY_SECONDS_IN_MILLIS = 30 * 1000
    private val poolConfig = buildPoolConfig()
    private val jedisPool = JedisPool(poolConfig, "localhost")

    fun storingCardNameRedis(cardEntity: CardEntity) {
        val jedis = jedisPool.resource
            jedis.set("CardId:${cardEntity.id}", cardEntity.name)
    }

    fun storingDeckNameRedis(deckEntity: DeckEntity) {
        val jedis = jedisPool.resource
        jedis.set("DeckId:${deckEntity.id}", deckEntity.name)
    }

    fun getCard(cardEntity: CardEntity): String? {
        val jedis = jedisPool.resource
        return jedis.get("CardId:${cardEntity.id}")
    }

    fun getDeck(deckEntity: DeckEntity): String? {
        val jedis = jedisPool.resource
        return jedis.get("DeckId:${deckEntity.id}")
    }

    private fun buildPoolConfig(): JedisPoolConfig {
        val poolConfig = JedisPoolConfig()
        poolConfig.maxTotal = 128
        poolConfig.maxIdle = 128
        poolConfig.minIdle = 16
        poolConfig.testOnBorrow = true
        poolConfig.testOnReturn = true
        poolConfig.testWhileIdle = true
        poolConfig.minEvictableIdleTimeMillis = ONE_MINUTE_IN_MILLIS.toLong()
        poolConfig.timeBetweenEvictionRunsMillis = THIRTY_SECONDS_IN_MILLIS.toLong()
        poolConfig.numTestsPerEvictionRun = 3
        poolConfig.blockWhenExhausted = true
        return poolConfig
    }
}

