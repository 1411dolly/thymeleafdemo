package com.thymeleaf.example.enums;

public enum Competency {
    JVM("JVM"),
    MEAN("MEAN"),
    DEVOPS("DevOps"),
    QA("QA");
    String value;
    Competency(String competency) {
        value = competency;
    }
    public String getValue() {
        return value;
    }
}
