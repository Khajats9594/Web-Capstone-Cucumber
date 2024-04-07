package utiles;

public final class DynamicXpath {

    private DynamicXpath(){};

    public static String getXpath(String xPath, String value){
        return xPath.replace("%replaceable%",value);
    }
}
