# full-text-coursework

Coursework: full-text search REST-service

Use Microsoft SQL Server

## Supported queries

* Search for a specific word or phrase (Simple Term)

Example: http://localhost:8080/fulltext/contains?word=Java

* Search for a word with a prefix (Prefix Term)

Example: http://localhost:8080/fulltext/containsprefix?word=con

* Search for inflectional forms of a specific word (Generation Term)

Example: http://localhost:8080/fulltext/containsformsof?word=question

* Search for synonyms of a specific word

Example: http://localhost:8080/fulltext/freetext?word=questions

* Search for a word near another word

Example: http://localhost:8080/fulltext/containsnear?word=java&near=SQL&dist=200

* Search for words or phrases using weighted values (Weighted Term)

Example: http://localhost:8080/fulltext/containstableweight?listsep=;&pairsep=:&list=java:0.5;sql:0.5;

1. *listsep* is separator for pairs;
2. *pairsep* is separator for pair's items;
3. *list* is list of pairs words and weights with *listsep* and *pairsep* separators.