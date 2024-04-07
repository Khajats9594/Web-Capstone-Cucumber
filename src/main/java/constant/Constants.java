package constant;

public final class Constants {

    private Constants() {}

    private static final int EXPLICITWAIT = 20;
    private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
    private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";
    private static final String LOGINDATA = System.getProperty("user.dir")+"/src/test/resources/data_set/userData.json";
    private static final String REGISTRATIONDATA = System.getProperty("user.dir")+"/src/test/resources/data_set/registrationData.json";
    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }
    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }
    public static String getLoginDataFilePath(){
        return LOGINDATA;
    }
    public static String getRegistrationDataFilePath(){
        return REGISTRATIONDATA;
    }
}
