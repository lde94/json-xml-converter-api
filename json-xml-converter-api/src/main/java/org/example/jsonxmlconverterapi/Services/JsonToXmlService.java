package org.example.jsonxmlconverterapi.Services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.jsonxmlconverterapi.ApiClient.ApiClient;


import org.springframework.stereotype.Service;

@Service
public class JsonToXmlService {

    private static final String url = "https://jsonplaceholder.typicode.com/users/1";
    private static final ApiClient apiClient = new ApiClient();

    public String transformJsonToXml() throws JsonProcessingException {
        String jsonResponse = apiClient.fetchData(url);

        ObjectMapper jsonMapper = new ObjectMapper();

        Object jsonObject = jsonMapper.convertValue(jsonResponse, Object.class);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        StringBuilder xmlOutput = new StringBuilder();
        xmlOutput.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlOutput.append("<users>");

        String xmlContent = xmlMapper.writeValueAsString(jsonObject);

        if (xmlContent.startsWith("<?xml")) {
            int endOfDeclaration = xmlContent.indexOf("?>");
            xmlContent = xmlContent.replace("<ArrayList>", "").replace("</ArrayList>", "");
        }

        xmlOutput.append(xmlContent);
        xmlOutput.append("</users>");

        return xmlOutput.toString();
    }
}
