package org.FIS2021.exceptions;

public class PlantNotFoundException extends Throwable {
    private String name;
    public PlantNotFoundException(String name) {
        super(String.format("The username %s is not registered!", name));
        this.name = name;
    }

    public String getName() {

        return name;
    }
}
