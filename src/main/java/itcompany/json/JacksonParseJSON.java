package itcompany.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import itcompany.model.Employee;

import java.io.File;
import java.io.IOException;

public class JacksonParseJSON {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(new File("src/main/resources/json/hierarchy.json"), Employee.class);
        System.out.println(employee);
    }
}
