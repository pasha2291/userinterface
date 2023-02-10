package by.a1qa.userinterface.config;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    private static final String CONFIG_FILE_PATH = "src/test/resources/testdata/config.json";
    private static final String AVATAR_PATH = "/avatar_path";
    private static final String INTEREST_QUANTITY = "/interest_quantity";
    private static final String URL = "/url";
    private static ISettingsFile environment;

    private ConfigManager() {
    }

    static {
        try {
            environment = new JsonSettingsFile(new File(CONFIG_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getURL(){
        return environment.getValue(URL).toString();
    }

    public static String getAvatarPath() {
        return environment.getValue(AVATAR_PATH).toString();
    }

    public static int getInterestQuantity() {
        return Integer.parseInt(environment.getValue(INTEREST_QUANTITY).toString());
    }
}
