package com.epam.mjc.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Map<String, String> personalData = new HashMap<>();
        Profile profile = new Profile();
        String data;

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            while ((data = reader.readLine()) != null) {
                String[] keyValue = data.split(":");
                personalData.put(keyValue[0].trim(), keyValue[1].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        profile.setName(personalData.get("Name"));
        profile.setAge(Integer.parseInt(personalData.get("Age")));
        profile.setEmail(personalData.get("Email"));
        profile.setPhone(Long.parseLong(personalData.get("Phone")));

        return profile;
    }
}
