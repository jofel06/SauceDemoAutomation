package base;

import utils.ConfigReader;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EnvironmentSetup {

    private static boolean fileCreated = false;  // Ensures the file is written once

    @BeforeSuite
    public void setupEnvironmentFile() {
        if (fileCreated) return;

        try {
            File allureResults = new File("target/allure-results");
            if (!allureResults.exists()) {
                allureResults.mkdirs();
            }

            File envFile = new File("target/allure-results/environment.properties");
            PrintWriter writer = new PrintWriter(new FileWriter(envFile));

            // Dynamic values
            writer.println("Browser=" + ConfigReader.getBrowser());
            writer.println("BaseURL=" + ConfigReader.getUrl());

            // System info
            writer.println("OS=" + System.getProperty("os.name"));
            writer.println("JavaVersion=" + System.getProperty("java.version"));

            writer.close();
            fileCreated = true;
            System.out.println("Allure environment.properties dynamically created.");

        } catch (IOException e) {
            System.err.println("Failed to create environment.properties: " + e.getMessage());
        }
    }
}
