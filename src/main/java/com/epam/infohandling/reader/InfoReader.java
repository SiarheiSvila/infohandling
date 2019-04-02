package com.epam.infohandling.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InfoReader implements IReader {
    private Logger logger = LogManager.getLogger();

    @Override
    public String read(String uri) {
        if (uri == null) {
            throw new IllegalArgumentException("It's not allow for a nul uri or empty uri value at InfoReader class, read method");
        }
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(uri))) {
            String line = reader.readLine();
            while (line != null) {
                builder.append(line);
                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            logger.log(Level.ERROR, "File not found in the specified location");
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error reading file");
        }
        return builder.toString();
    }
}
