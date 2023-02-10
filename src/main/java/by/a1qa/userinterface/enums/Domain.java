package by.a1qa.userinterface.enums;

public enum Domain {
    ORG("org"), CO_UK("co.uk"), NET("net"), GOV("gov"), DE("de"), FR("fr"),
    NL("nl"), COM("com"), BE("be"), JPG("jpg");

    private final String elementName;

    Domain(String name) {
        elementName = name;
    }

    @Override
    public String toString(){
     return elementName;
    }
}
