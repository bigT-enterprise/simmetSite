package com.bigt.simmet.models.enums;

public enum Condition {
    VeryGood("V"), Good("G"), Excellent("E"), Poor("P");

    private String shortName;

    Condition(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName(){
        return shortName;
    }

    public static Condition fromShortName(String shortName){
        switch (shortName) {
            case "V" -> {
                return Condition.VeryGood;
            }
            case "G" -> {
                return Condition.Good;
            }
            case "E" -> {
                return Condition.Excellent;
            }
            case "P" -> {
                return Condition.Poor;
            }
            default -> {
            }
            // TODO implement exception

        }
        return null;
    }
}
