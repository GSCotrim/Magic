package br.com.mtg.magic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MagicApplication

fun main(args: Array<String>) {
	runApplication<MagicApplication>(*args)
}

/*
schema.sql

DROP TABLE IF EXISTS cards;

CREATE TABLE cards (
	id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250),
    neutralManaCost int,
    coloredManaCost int,
    colorIndicator VARCHAR(250),
    type VARCHAR(250),
    subType VARCHAR(250),
    textBox VARCHAR(250),
    power int,
    toughness int,
    loyalty int,
    illustrationCredit VARCHAR(250)
);

data.sql

INSERT INTO cards (name, neutralManaCost, coloredManaCost, colorIndicator, type, subType, textBox, power, toughness, loyalty, illustrationCredit) VALUES
  ('Test From Database', 111, 222, 'Black', 'Batata', 'Frita', 'Text Box Aqui', 9002, 3, 4, 'Gi');

Quando acessar o console:

SELECT * FROM cards;

Quando for configurar o repository:
REMOVER esta linha do application.yml:
- org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
 */