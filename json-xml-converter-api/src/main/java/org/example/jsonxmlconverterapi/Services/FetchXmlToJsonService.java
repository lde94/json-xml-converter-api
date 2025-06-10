package org.example.jsonxmlconverterapi.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.jsonxmlconverterapi.ApiClient.ApiClient;
import org.springframework.stereotype.Service;

@Service
public class FetchXmlToJsonService {
    private static final String url = "https://www.w3schools.com/xml/simple.xml";
    private static final ApiClient apiClient = new ApiClient();

    public String transformXmlFetchToJson() throws JsonProcessingException {
        String xmlResponse = apiClient.fetchData(url);

        XmlMapper xmlMapper = new XmlMapper();
        Object xmlObject = xmlMapper.readValue(xmlResponse, Object.class);

        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);

        return jsonMapper.writeValueAsString(xmlObject);
    }
}

