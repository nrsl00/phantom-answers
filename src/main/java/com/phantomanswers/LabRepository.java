package com.phantomanswers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class LabRepository {

    public static String loadLab(int number) {

        String path = "labs/lab" + number + ".txt";

        System.out.println("Trying to load: " + path);

        ClassLoader classLoader =
                LabRepository.class.getClassLoader();

        try (InputStream inputStream =
                     classLoader.getResourceAsStream(path)) {

            if (inputStream == null) {

                System.out.println(
                        "ERROR: resource not found: " + path
                );

                return "";
            }

            String code = new String(
                    inputStream.readAllBytes(),
                    StandardCharsets.UTF_8
            );

            System.out.println(
                    "Resource loaded successfully: "
                            + code.length()
                            + " characters"
            );

            return code;

        } catch (IOException e) {

            e.printStackTrace();
            return "";
        }
    }
}