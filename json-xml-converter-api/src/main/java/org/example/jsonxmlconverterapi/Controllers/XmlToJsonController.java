package org.example.jsonxmlconverterapi.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.jsonxmlconverterapi.Services.FetchXmlToJsonService;
import org.example.jsonxmlconverterapi.Services.XmlToJsonService;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/convert")
@Tag(name = "XML Transformer", description = "Endpoints that transform XML to JSON format")
public class XmlToJsonController {

    private final XmlToJsonService xmlToJsonService;
    private final FetchXmlToJsonService fetchXmlToJsonService;

    public XmlToJsonController(XmlToJsonService xmlToJsonService, FetchXmlToJsonService fetchXmlToJsonService) {
        this.xmlToJsonService = xmlToJsonService;
        this.fetchXmlToJsonService = fetchXmlToJsonService;
    }

    @PostMapping(value = "/xml-to-json", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Convert XML to JSON")
    @ApiResponse(responseCode = "200", description = "Conversion successful")
    @ApiResponse(responseCode = "400", description = "Conversion failed")
    public ResponseEntity<String> xmlToJson(@RequestBody String xml) {
        try {
            String json = xmlToJsonService.transformXmlToJson(xml);
            return ResponseEntity.ok(json);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("<error>Conversion failed</error>");
        }
    }

    @PostMapping(value = "/fetch-xml-to-json", consumes = MediaType.TEXT_PLAIN_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Fetch XML from a specific URL and convert to JSON")
    @ApiResponse(responseCode = "200", description = "Conversion successful")
    @ApiResponse(responseCode = "400", description = "Conversion failed")
    public ResponseEntity<String> fetchXmlToJson(@RequestBody String url) {
        try {
            String json = fetchXmlToJsonService.transformXmlFetchToJson(url);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("<error>Conversion failed</error>");
        }
    }
}
