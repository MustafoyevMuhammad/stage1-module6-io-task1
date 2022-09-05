package com.epam.mjc.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Map<String, String> personalData = new HashMap<>();
        Profile profile = new Profile();
        String data;
// 1 todo first way but not better
//          try (InputStream in = new FileInputStream("Profile.txt")) {
//                 BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//                 while ((data = reader.readLine()) != null){
//                     String[] keyValue = data.split(":");
//                     personalData.put(keyValue[0].trim(), keyValue[1].trim());
//                 }
//             } catch (FileNotFoundException e) {
//                 throw new RuntimeException(e);
//             } catch (IOException e) {
//                 throw new RuntimeException(e);
//             }


// 2 todo second way
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader("Profile.txt"))) {
            while ((data = reader.readLine()) != null){
                String[] keyValue = data.split(":");
                personalData.put(keyValue[0].trim(), keyValue[1].trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        profile.setName(personalData.get("Name"));
        profile.setAge(Integer.parseInt(personalData.get("Age")));
        profile.setEmail(personalData.get("Email"));
        profile.setPhone(Long.parseLong(personalData.get("Phone")));

        return profile;
    }
}
