# JSON/XML Converter API

## Beskrivning
Detta API:et är byggt för att ta emot JSON eller XML formaterad data i respektive endpoints för att konverteras.
Så konvertering från XML till JSON och vise versa. Detta kan göras både men direkt inmatning av data i en body
eller genom hämtad data från en url.

### Förutsättningar
- Docker installerat (För att köra genom container)
- Java 21

### Installation och körning
- Klona projektet till din dator.
- Exekvera projektet genom din IDE eller genom Docker container.
- Gå till localhost:8080/swagger-ui/index.html för att hantera API:et via Swagger.

## Komma igång
- Med programmet körande, navigera till Requests.http i root-mappen för projektet och pröva på endpointsen
med förberedd data för att få lite exempel.
- Gå till Swagger som beskrivet ovan och pröva på Endpointsen där.

### Docker
- Navigera till projekt-mappen med din CLI.
- Bygg Docker-image genom att skriva följande i din CLI:
  docker build -t json-xml-converter .

- När containern är färdigbyggd, kör den genom att skriva följande i din CLI:
  docker run -p 8080:8080 json-xml-converter

## API Dokumentation
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

## API Endpoints
### POST /api/convert/json-to-xml
- Konverterar JSON till XML.
- Exempel Request:
````json
{
"name": "John",
"age": 30
}
````
- Exempel Respons:
```xml
<response>
  <name>John</name>
  <age>30</age>
</response>
```

### POST /api/convert/xml-to-json
- Konverterar XML till JSON.
- Exempel Request:
```xml
<book>
  <title>Bröderna Lejonhjärta</title>
  <author>Astrid Lindgren</author>
  <year>1973</year>
</book>
```

- Exempel Respons:
````json
{
"title": "Bröderna Lejonhjärta",
"author": "Astrid Lindgren",
"year": 1973
}
````

### POST /api/convert/fetch-json-to-xml
- Hämtar JSON data från en url och konverterar till XML.
- Exempel Request:

https://example.com/data.json

- Exmpel Respons:
```xml
<response>
  <name>John</name>
  <age>30</age>
</response>
```

### POST /api/convert/fetch-xml-to-json
- Hämtar XML data från en url och konverterar till JSON.
- Exempel Request:

https://example.com/data.xml

- Exmpel Respons:
```json
{
  "name": "John",
  "age": 30
}
```
## Testning
Mycket av testningen har gjorts främst genom swagger. Annars se requests.http för färdiga test-requests.


## Reflektion
Utvecklingen av API:et var mer givande än vad jag förväntade mig eftersom det verkade ändå vara en rätt liten uppgift.
Känner att jag överskattar lite hur mycket av utvecklandet ligger i benmärgen och inser att från mitt håll behöver
betydligt mer övning för att det ska sitta. Den allmäna strukturen av services och controllers förstår man men det var en del
extra reflektion om hur många jag behöver av varje. Gjorde först en controller för varje service men beslutade att bara ha tv
controllers, en för respektive datatyp. Fick kolla tillbaka en hel del på tidigare material och uppgifter för att
komma igång. Men trots det så är jag nöjd med slutresultatet även om det tog mig lite mer tid än väntat.
Uppgiften i sig var väldigt bra då den täcker en rätt bred mängd kunskap även om uppgiften i sig inte är så stor.
Man får gå igenom allt från REST genom Springboot, Swagger för dokumentation och testning, Data-transformering ända till dockerisering
och körning. Alla delar känner jag är otroligt relevanta för en integrationsutvecklare!

- Ludvig Ekstam
