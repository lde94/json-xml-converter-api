package org.example.jsonxmlconverterapi.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.jsonxmlconverterapi.Services.FetchJsonToXmlService;
import org.example.jsonxmlconverterapi.Services.JsonToXmlService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convert")
@Tag(name = "JSON Transformer", description = "Endpoints that transforms JSON to XML format")
public class JsonToXmlController {

    private final JsonToXmlService jsonToXmlService;
    private final FetchJsonToXmlService fetchJsonToXmlService;

    public JsonToXmlController(JsonToXmlService jsonToXmlService, FetchJsonToXmlService fetchJsonToXmlService) {
        this.jsonToXmlService = jsonToXmlService;
        this.fetchJsonToXmlService = fetchJsonToXmlService;
    }


    @PostMapping(value = "/json-to-xml", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    @Operation(summary = "Convert JSON to XML")
    @ApiResponse(responseCode = "200", description = "Conversion successful")
    @ApiResponse(responseCode = "400", description = "Conversion failed")
    public ResponseEntity<String> convertJsonToXml(@RequestBody String json) {
        try {
            String xml = jsonToXmlService.transformJsonToXml(json);
            return ResponseEntity.ok(xml);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("<error>Conversion failed</error>");
        }
    }

    @PostMapping(value = "/fetch-json-to-xml", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    @Operation(summary = "Fetch JSON from a specific URL and convert to XML")
    @ApiResponse(responseCode = "200", description = "Conversion successful")
    @ApiResponse(responseCode = "400", description = "Conversion failed")
    public ResponseEntity<String> fetchJsonToXml(@RequestBody String url) {
        try {
            String xml = fetchJsonToXmlService.transformJsonFetchToXml(url);
            return ResponseEntity.ok(xml);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("<error>Conversion failed</error>");
        }

    }
}
