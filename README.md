# Projeto Magic 
*Ainda em desenvolvimento.*

## Resumo
Projeto web com SpringBoot para organizar cards e decks de Magic The Gathering.

### Banco de dados

Por enquanto o código roda com banco de dados em memória, utilizando o *H2 database*.

### Endpoints

#### GET Requests
É possível conferir as cartas e decks presentes nesse banco de dados, através dos *GET requests* a seguir

`\cards`: Mostrará a lista de todos os Cards do Banco de Dados.

`\cards\{cardId}`: Mostrará a carta requisitada, através de seu ID. Atualmente existem seis cartas no banco de dados, sendo uma somente um teste - ID: 123 - e cinco cartas oficiais de MTG - IDs: 1, 2, 3, 4 e 5.

`\decks`: Mostrará a lista de todos os Decks do Banco de Dados.

`\decks\{deckId}`: Mostrará o deck requisitado, através de seu ID. O único deck presente no banco de dados, no momento, tem ID "2".

Exemplo de *GET* de uma carta, feito através do software *Postman*:

```
curl --location --request GET 'http://localhost:8080/cards/123'
```

#### POST requests

Também é possível adicionar novas cartas e decks ao banco de dados, através de *POST requests* com os seguintes *endpoints*:

`\cards`; `\decks`

Exemplo de *POST* de uma carta, feito através do software *Postman*:

``` 

curl --location --request POST 'http://localhost:8080/cards' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "First POST",
"neutralManaCost": 321,
"coloredManaCost": 123,
"colorIndicator": "Green",
"type": "Cebola",
"subType": "Caramelizada",
"textBox": "text box goes here",
"power": 8,
"toughness": 1,
"loyalty": 3,
"illustrationCredit": "Ti"
}'

```

### DeckCards

*Classe ainda sendo implementada*

Tem como propósito servir de ponte entre os decks e as cartas, definindo **quais decks** possuem **quais cartas** e **quantas** instâncias de cada uma estão presentes em cada deck.