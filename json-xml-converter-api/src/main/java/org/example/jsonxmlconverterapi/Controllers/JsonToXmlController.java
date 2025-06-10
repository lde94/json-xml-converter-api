package org.example.jsonxmlconverterapi.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.jsonxmlconverterapi.Services.JsonToXmlService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transform")
@Tag(name = "JSON Transformer", description = "Endpoint that transforms JSON to XML format")
public class JsonToXmlController {

    private final JsonToXmlService jsonToXmlService;

    public JsonToXmlController(JsonToXmlService jsonToXmlService) {
        this.jsonToXmlService = jsonToXmlService;
    }

    @PostMapping(value = "/json-to-xml", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> convertJsonToXml(@RequestBody String json) {
        try {
            String xml = jsonToXmlService.transformJsonToXml(json);
            return ResponseEntity.ok(xml);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("<error>Conversion failed</error>");
        }
    }
}
