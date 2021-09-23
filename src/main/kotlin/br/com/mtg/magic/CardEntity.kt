package br.com.mtg.magic

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
}

