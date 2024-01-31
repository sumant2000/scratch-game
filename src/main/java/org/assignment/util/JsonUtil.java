package org.assignment.util;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class JsonUtil {

    public static Configuration loadConfiguration(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Configuration config = gson.fromJson(reader, Configuration.class);
            System.out.println(config); // Debugging line to print the loaded configuration
            return config;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration: " + filePath, e);
        }
    }

}
