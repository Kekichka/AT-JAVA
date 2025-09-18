package task5;
//Serialization-Deserialization:
//a) Make some complex models using your variant.
//b) Make it serializable.
//c) Read JSON from “input.json”
//d) and deserialize it to POJO.
//e) Then change a few fields and save it to “output.json”.
//f) Do the same for XML.
//
//Stream:
//a) Generate 10 random objects using a class from a previous task
//b) Sort it using any two fields using stream.
//c) Filter it by any two fields custom filter.
//d) Collect it to List with *main field(s).

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Task5{
    private static final String INPUT_FILE_JSON_PATH = "C:\\Users\\home\\Desktop\\AT\\atjava\\src\\main\\resources\\input.json";
    private static final String OUTPUT_FILE_JSON_PATH = "C:\\Users\\home\\Desktop\\AT\\atjava\\src\\main\\resources\\output.json";
    public static void main(String[] args) {

        String inputJson = "";

        try (Scanner scanner = new Scanner(new File(INPUT_FILE_JSON_PATH))) {
            while (scanner.hasNextLine()) {
                inputJson += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        User user = null;
        try {
            user = objectMapper.readValue(inputJson, User.class);
            System.out.println("User" + user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        user.setName("test");
        if (user.getAddress() != null) {
            user.getAddress().setStreet("test street");
            user.getAddress().setCity("test city");
        }
        saveToJson(user);
    }

    private static void saveToJson(User user) {
        ObjectMapper objectMapper = new ObjectMapper();
        try (FileWriter writer = new FileWriter(OUTPUT_FILE_JSON_PATH)) {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(writer, user);
            System.out.println(" збережено в output.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
