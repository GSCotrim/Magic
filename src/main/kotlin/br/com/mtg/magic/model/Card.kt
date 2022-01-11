package br.com.mtg.magic

data class Card (

        var id: Long?,
        var name: String,
        var neutralManaCost: Long,
        var coloredManaCost: Long,
        //var illustration: IDK,
        var colorIndicator: String,
        var type: String,
        var subType: String,
        //var expansionSymbol: IDK,
        var textBox: String,
        var power: Long,
        var toughness: Long,
        var loyalty: Long,
        var illustrationCredit: String
) {
    companion object {
        fun testCard(): Card {
            return Card(
                    id = 12345,
                    name = "Test Card",
                    neutralManaCost = 123,
                    coloredManaCost = 321,
                    colorIndicator = "White",
                    type = "Potato",
                    subType = "Fries",
                    textBox = "text box goes here",
                    power = 9001,
                    toughness = 1,
                    loyalty = 2,
                    illustrationCredit = "The Dev Team"
            )
        }
        fun fromEntity(entity: CardEntity): Card {
            return Card(entity.id, entity.name, entity.neutralManaCost, entity.coloredManaCost, entity.colorIndicator,
            entity.type, entity.subType, entity.textBox, entity.power, entity.toughness, entity.loyalty,
            entity.illustrationCredit)
        }
    }
    fun toEntity(): CardEntity {
        return CardEntity(
            id,
            name,
            neutralManaCost,
            coloredManaCost,
            colorIndicator,
            type,
            subType,
            textBox,
            power,
            toughness,
            loyalty,
            illustrationCredit
        )
    }
}

