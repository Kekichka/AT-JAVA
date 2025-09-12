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

public class Task5 {
    private static final String INPUT_FILE_JSON_PATH = "C:\\Users\\home\\Desktop\\AT\\atjava\\src\\main\\resources\\input.json";
    private static final String OUTPUT_FILE_JSON_PATH = "C:\\Users\\home\\Desktop\\AT\\atjava\\src\\main\\resources\\output.json";
    public static void main(String[] args) {

        String inputJson = "";

        try {
            File file = new File (INPUT_FILE_JSON_PATH).getAbsoluteFile();
            Scanner scanner = new Scanner(file);

            while ( scanner.hasNextLine()){
                String line = scanner.nextLine();
                inputJson += line;
            }
            scanner.close();

        } catch (FileNotFoundException e){
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
        user.getAddress().add("test address");
        user.getAddress().remove("WA");

        try {
            objectMapper.writeValue(new File("target/car.json"), user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
