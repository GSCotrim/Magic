package br.com.mtg.magic

import org.springframework.boot.autoconfigure.data.redis.RedisProperties
import javax.persistence.*

@Entity
@Table(name = "cards")
data class CardEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column
    var name: String,
    @Column
    var neutralManaCost: Long,
    @Column
    var coloredManaCost: Long,
    @Column
    var colorIndicator: String,
    @Column
    var type: String,
    @Column
    var subType: String,
    @Column
    var textBox: String,
    @Column
    var power: Long,
    @Column
    var toughness: Long,
    @Column
    var loyalty: Long,
    @Column
    var illustrationCredit: String

) {
    companion object;
    constructor() : this(null,"name", 0, 0, "colorIndicator", "type", "subType", "textBox", 0, 0, 0, "illustrationCredit" )

    fun mergeFrom(otherCard: CardEntity) {
        if (name != otherCard.name) {
            name = otherCard.name
        }
        if (neutralManaCost != otherCard.neutralManaCost) {
            neutralManaCost = otherCard.neutralManaCost
        }
        if (coloredManaCost != otherCard.coloredManaCost) {
            coloredManaCost = otherCard.coloredManaCost
        }
        if (colorIndicator != otherCard.colorIndicator) {
            colorIndicator = otherCard.colorIndicator
        }
        if (type != otherCard.type) {
            type = otherCard.type
        }
        if (subType != otherCard.subType) {
            subType = otherCard.subType
        }
        if (textBox != otherCard.textBox) {
            textBox = otherCard.textBox
        }
        if (power != otherCard.power) {
            power = otherCard.power
        }
        if (toughness != otherCard.toughness) {
            toughness = otherCard.toughness
        }
        if (loyalty != otherCard.loyalty) {
            loyalty = otherCard.loyalty
        }
        if (illustrationCredit != otherCard.illustrationCredit) {
            illustrationCredit = otherCard.illustrationCredit
        }
    }
}
