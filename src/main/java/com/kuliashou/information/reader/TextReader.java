package com.kuliashou.information.reader;

import com.kuliashou.information.exception.TextReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextReader {

    private static Logger logger = LogManager.getLogger();

    public static String readText(String filePath) throws TextReaderException {

        if (filePath == null || filePath.isEmpty() || !new File(filePath).exists()) {
            throw new TextReaderException("Wrong path or file doesn't exist!");
        }

        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            logger.fatal("Can't open file " + filePath);
            throw new TextReaderException("Can't open file", e);
        }

        logger.info("File has read!");
        return contentBuilder.toString();

    }
}
