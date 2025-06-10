package org.example.jsonxmlconverterapi.Services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;



import org.springframework.stereotype.Service;

@Service
public class JsonToXmlService {

    public String transformJsonToXml(String jsonInput) throws JsonProcessingException {
        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode jsonNode = jsonMapper.readTree(jsonInput); // Parse JSON string

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xmlContent = xmlMapper.writeValueAsString(jsonNode);

        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xmlContent;
    }
}
