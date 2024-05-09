package config;


import lombok.Data;
import javax.xml.bind.annotation.XmlAttribute;

@Data
public class Parameter {
    private String paramName;
    private String paramValue;

    @XmlAttribute(name = "key")
    public String getParamName() {
        return paramName;
    }
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }
    @XmlAttribute(name = "value")
    public String getParamValue() {
        return paramValue;
    }
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }
}
