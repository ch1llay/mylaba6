package com.example.mylaba6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RW {
    public static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void write(String s, String path) {
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(path))) {
            writter.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
