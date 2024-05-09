package config;

import constant.Constants;
import enums.EnvironmentType;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EnvironmentFactory {

    private static Map<String, Map<String, String>> configMap = new HashMap<>();

    static {
        try (FileInputStream fileInputStream = new FileInputStream(Constants.getCONFIG_XML_FILE_PATH())) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Environments.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Environments environments = (Environments) jaxbUnmarshaller.unmarshal(fileInputStream);

            for (Environment environment : environments.getEnvironmentList()) {
                Map<String, String> paramMap = new HashMap<>();
                for (Parameter parameter : environment.getParameterList()) {
                    paramMap.put(parameter.getParamName(), parameter.getParamValue());
                }
                configMap.put(environment.getEnvironmentName(), paramMap);
            }
            System.out.println(configMap);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    public static String getXmlValue(EnvironmentType environmentType, String key) {
        String environment = System.getProperty(environmentType.name());
        Map<String, String> param = configMap.get(environment);
        if(Objects.nonNull(param)){
            return param.get(key);
        }
        Map<String, String> paramMap = configMap.get(environmentType.name());
        if (Objects.nonNull(paramMap)) {
            return paramMap.get(key);
        }
        throw new RuntimeException("Property name " + key + " is not found. Please check config.xml file");
    }
    public static void main(String[] args) {
        String salesUser1 = EnvironmentFactory.getXmlValue(EnvironmentType.QA, "SalesUser1");
        String salesUser1Password = EnvironmentFactory.getXmlValue(EnvironmentType.QA, "SalesUser1Password");

        System.out.println("SalesUser1 value: " + salesUser1);
        System.out.println("SalesUser1Password value: " + salesUser1Password);
    }
}
