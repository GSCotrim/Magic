INSERT INTO cards (id, name, neutral_mana_cost, colored_mana_cost, color_indicator, type, sub_type, text_box, power, toughness, loyalty, illustration_credit) VALUES
  (123, 'Test From Database', 111, 222, 'Black', 'Batata', 'Frita', 'Text Box Aqui', 9002, 3, 4, 'Gi');

INSERT INTO decks(id, name, size, black, white, green, red, blue) VALUES (2, 'Test From Database', 5, true, false, true, false, false);

INSERT INTO deckCards(id, deck_id, card_id, amount) VALUES (7, 900, 678, 55)