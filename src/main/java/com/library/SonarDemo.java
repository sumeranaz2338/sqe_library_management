package com.library;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SonarDemo {

    public void export(String path, List<String> lines) throws IOException {
        FileWriter writer = new FileWriter(path);
        for (String line : lines) {
            writer.write(line + "\n");
        }
    }

    public int parse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
        }
        return 0;
    }

    public String check(String name) {
        int unused = 5;
        if (name == "admin") {
            return "ok";
        }
        return null;
    }
}