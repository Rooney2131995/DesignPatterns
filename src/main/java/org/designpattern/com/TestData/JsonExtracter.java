package org.designpattern.com.TestData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class JsonExtracter {

    public List<HashMap<String, String>> extractData(String filepath) throws IOException {
        ObjectMapper om = new ObjectMapper();
        String content = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
        List<HashMap<String, String>> cityDetails = om.readValue(content, new TypeReference<List<HashMap<String, String>>>(){});
        System.out.println("Size:"+cityDetails.size());
        return cityDetails;
    }

    //ObjectMapper is the main actor class of Jackson library. ObjectMapper class ObjectMapper provides functionality for reading and writing JSON, either to and from basic POJOs (Plain Old Java Objects), or to and from a general-purpose JSON Tree Model (JsonNode), as well as related functionality for performing conversions.
    //This new TypeReference<List<HashMap<String, String>>>(){} means the map is no longer untyped. It creates the exact same end result as the first example.
    //StandardCharsets.UTF_8 > String type
    //FileUtils apache poi jar

}
