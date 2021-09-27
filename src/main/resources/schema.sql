DROP TABLE IF EXISTS cards;

CREATE TABLE cards (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250),
    neutral_mana_cost int,
    colored_mana_cost int,
    color_indicator VARCHAR(250),
    type VARCHAR(250),
    sub_type VARCHAR(250),
    text_box VARCHAR(250),
    power int,
    toughness int,
    loyalty int,
    illustration_credit VARCHAR(250)
);

DROP TABLE IF EXISTS decks;

CREATE TABLE decks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250),
    size int
);
