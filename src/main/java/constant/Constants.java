package constant;

import lombok.Getter;

@Getter
public final class Constants {

    private Constants() {}

    private static final int EXPLICIT_WAIT = 30;
    private static final int MAX_RETRY_ATTEMPTS = 3;
    private static final String RESOURCES_PATH = System.getProperty("user.dir")+"/src/test/resources";
    private static final String CONFIG_FILE_PATH = RESOURCES_PATH +"/config/config.properties";
    @Getter
    private static final String CONFIG_XML_FILE_PATH = RESOURCES_PATH +"/config/config.xml";
    private static final String LOGIN_DATA = System.getProperty("user.dir")+"/src/test/resources/data_set/userData.json";
    private static final String REGISTRATION_DATA = System.getProperty("user.dir")+"/src/test/resources/data_set/registrationData.json";

    public static int getMAxRetryAttempts(){
        return MAX_RETRY_ATTEMPTS;
    }
    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }
    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }
    public static String getLoginDataFilePath(){
        return LOGIN_DATA;
    }
    public static String getRegistrationDataFilePath(){
        return REGISTRATION_DATA;
    }
}
