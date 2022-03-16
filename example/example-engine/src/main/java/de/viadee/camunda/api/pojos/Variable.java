package de.viadee.camunda.api.pojos;

public class Variable  {

    private String value;

    private String type;

    private String valueInfo;

    public Variable() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueInfo() {
        return valueInfo;
    }

    public void setValueInfo(String valueInfo) {
        this.valueInfo = valueInfo;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", valueInfo=" + valueInfo +
                '}';
    }
}
