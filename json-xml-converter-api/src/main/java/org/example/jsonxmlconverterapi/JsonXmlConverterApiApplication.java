package org.example.jsonxmlconverterapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.jsonxmlconverterapi.ApiClient.ApiClient;
import org.example.jsonxmlconverterapi.Services.FetchJsonToXmlService;
import org.example.jsonxmlconverterapi.Services.FetchXmlToJsonService;
import org.example.jsonxmlconverterapi.Services.XmlToJsonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class JsonXmlConverterApiApplication {
    private static final String url = "https://jsonplaceholder.typicode.com/users/1";
    private static final ApiClient apiClient = new ApiClient();


    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(JsonXmlConverterApiApplication.class, args);
        String xmlData = printUserDataAsXml();
        printUserDataAsJson(xmlData);
        printXmlFetchToJson();
    }

    private static String printUserDataAsXml() {
        FetchJsonToXmlService fetchJsonToXmlService = new FetchJsonToXmlService();

        try {
            // använd transformer
            String xmlData = fetchJsonToXmlService.transformJsonFetchToXml();
            // skriv ut
            System.out.println(xmlData);
            return xmlData;
        } catch (IOException e) {
            System.err.println("Error in transforming JSON to XML: " + e.getMessage());
            return null;
        }
    }

    private static String printUserDataAsJson(String jsonResponse) {
        XmlToJsonService xmlToJsonService = new XmlToJsonService();
        if (jsonResponse == null) {
            return null;
        }

        try {
            // använd transformer
            String jsonData = xmlToJsonService.transformXmlToJson(jsonResponse);
            // skriv ut
            System.out.println(jsonData);
            return jsonData;
        } catch (IOException e) {
            System.err.println("Error in transforming XML to JSON: " + e.getMessage());
            return null;
        }

    }
    private static String printXmlFetchToJson() throws JsonProcessingException {
        FetchXmlToJsonService fetchXmlToJsonService = new FetchXmlToJsonService();
        System.out.println(fetchXmlToJsonService.transformXmlFetchToJson());
        return  fetchXmlToJsonService.transformXmlFetchToJson();
    }

}
