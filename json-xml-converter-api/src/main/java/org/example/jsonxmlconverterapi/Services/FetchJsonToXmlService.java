package org.example.jsonxmlconverterapi.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.jsonxmlconverterapi.ApiClient.ApiClient;
import org.springframework.stereotype.Service;

@Service
public class FetchJsonToXmlService {

    private static final ApiClient apiClient = new ApiClient();

    public String transformJsonFetchToXml(String url) throws JsonProcessingException {

        String jsonResponse = apiClient.fetchData(url);

        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode jsonNode = jsonMapper.readTree(jsonResponse); // Parse JSON

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Convert JSON node to XML string
        String xmlContent = xmlMapper.writeValueAsString(jsonNode);

        // Optionally add XML declaration
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xmlContent;
        }
}

