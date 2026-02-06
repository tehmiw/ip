package listiepackage;

import javafx.application.Application;

import java.io.FileNotFoundException;

/**
 * A launcher class to workaround classpath issues.
 */
public class Launcher {
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}
