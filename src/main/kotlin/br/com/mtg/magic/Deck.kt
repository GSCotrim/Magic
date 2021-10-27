package br.com.mtg.magic

data class Deck(

        var id: Long?,
        var name: String,
        var size: Int,
        var black: Boolean,
        var white: Boolean,
        var green: Boolean,
        var red: Boolean,
        var blue: Boolean

){
    companion object{
        fun testDeck(): Deck {
            return br.com.mtg.magic.Deck(
                id = 1,
                name = "Primeiro Deck",
                size = 3,
                black = false,
                white = true,
                green = false,
                red = false,
                blue = true
            )
        }
        fun fromEntity(entity: DeckEntity): Deck {
            return br.com.mtg.magic.Deck(
                entity.id, entity.name, entity.size, entity.black, entity.white,
                entity.green, entity.red, entity.blue
            )
        }
    }
    fun toEntity(): DeckEntity {
        return DeckEntity(
            id,
            name,
            size,
            black,
            white,
            green,
            red,
            blue
        )
    }
}


