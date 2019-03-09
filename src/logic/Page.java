package logic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Page {
    private static final String HOME = "home.html";

    public static String getHome() throws IOException {
        return new String(Files.readAllBytes(Paths.get(HOME)));
    }
}