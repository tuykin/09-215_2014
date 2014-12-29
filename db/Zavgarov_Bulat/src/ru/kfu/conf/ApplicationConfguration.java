package ru.kfu.conf;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Bulat on 25.12.14.
 */
public class ApplicationConfguration {

    public static Path getStoragePath() {
        return Paths.get(System.getProperty("user.home")).resolve("Storage");
    }
}
