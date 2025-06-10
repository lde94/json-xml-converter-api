package org.example.jsonxmlconverterapi.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class XmlToJsonService {

    public String transformXmlToJson(String xmlData) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        Object xmlObject = xmlMapper.readValue(xmlData, Object.class);

        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);

        return jsonMapper.writeValueAsString(xmlObject);
    }
}
