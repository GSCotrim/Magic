INSERT INTO cards (id, name, neutral_mana_cost, colored_mana_cost, color_indicator, type, sub_type, text_box, power, toughness, loyalty, illustration_credit) VALUES
  (123, 'Test From Database', 111, 222, 'Black', 'Batata', 'Frita', 'Text Box Aqui', 9002, 3, 4, 'Gi');

INSERT INTO cards (id, name, neutral_mana_cost, colored_mana_cost, color_indicator, type, sub_type, text_box, power, toughness, loyalty, illustration_credit) VALUES
  (1, 'Negate', 1, 1, 'Blue', 'Instant', '-', 'Counter target noncreature spell.', 0, 0, 0, 'Magali Villeneuve');

INSERT INTO cards (id, name, neutral_mana_cost, colored_mana_cost, color_indicator, type, sub_type, text_box, power, toughness, loyalty, illustration_credit) VALUES
  (2, 'Mountain', 0, 0, 'Red', 'Basic Land', 'Mountain', '-', 0, 0, 0, 'Noah Bradley');

INSERT INTO cards (id, name, neutral_mana_cost, colored_mana_cost, color_indicator, type, sub_type, text_box, power, toughness, loyalty, illustration_credit) VALUES
  (3, 'Ajanis Pridemate', 1, 1, 'White', 'Creature', 'Cat Soldier', 'Whenever you gain life, put a +1/+1 counter on Ajanis Pridemate.', 2, 2, 0, 'Sidharth Chaturvedi');

INSERT INTO cards (id, name, neutral_mana_cost, colored_mana_cost, color_indicator, type, sub_type, text_box, power, toughness, loyalty, illustration_credit) VALUES
  (4, 'Ravenous Chupacabra', 2, 2, 'Black', 'Creature', 'Beast Horror', 'When Ravenous Chupacabra enters the battlefield, destroy target creature an opponent controls.', 2, 2, 0, 'Daarken');

INSERT INTO cards (id, name, neutral_mana_cost, colored_mana_cost, color_indicator, type, sub_type, text_box, power, toughness, loyalty, illustration_credit) VALUES
  (5, 'Reclamation Sage', 2, 1, 'Green', 'Creature', 'Elf Shaman', 'When Reclamation Sage enters the battlefield, you may destroy target artifact or enchantment.', 2, 1, 0, 'Christopher Moeller');

INSERT INTO decks(id, name, size, black, white, green, red, blue) VALUES (2, 'Test From Database', 5, true, false, true, false, false);

---- Já que o id e o deck_id são ambos "Auto-increment", deixo eles de fora aqui??
--INSERT INTO deckCards(id, deck_id, card_id, amount) VALUES (7, 900, 678, 55)